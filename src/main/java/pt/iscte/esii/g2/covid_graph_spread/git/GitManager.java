package pt.iscte.esii.g2.covid_graph_spread.git;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import pt.iscte.esii.g2.covid_graph_spread.datamodel.TableLine;
import pt.iscte.esii.g2.covid_graph_spread.generators.HTMLGenerator;

public class GitManager {
	private static String workingDir = System.getProperty("user.dir") + "/gitdata";
	private final static String vbastorepo = "https://github.com/vbasto-iscte/ESII1920.git";
	private String repo = "";
	private Git local;
	
	public GitManager() {
		this(vbastorepo);
	}
	private GitManager(String repo) {
		this.repo = repo;
		local = cloneRepo();
	}
	
	public TableLine[] getFilesInfo() {
		List<TableLine> lst = new ArrayList<TableLine>();
		try {
			for (Ref r : local.tagList().call()) {
				local.checkout().setName(r.getName()).call(); //Update the local repo with the tagged file
				File f = new File(workingDir + "/vbasto-iscte/ESII1920/covid19spreading.rdf");
				//Create a TableLine object to encapsulate all the data
				TableLine finfo = new TableLine(
						String.valueOf(f.lastModified()),
						f.getName(),
						r.getName().replace("refs/tags/", ""),
						r.getName(),
						HTMLGenerator.generateLink("Visualization", "http://visualdataweb.de/webvowl/#iri=" + generateFileURL("covid19spreading.rdf", r))
						);
				lst.add(finfo); //Add it to the list
			}
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
		return lst.toArray(new TableLine[lst.size()]); //Return that bulk of data
	}
	
	public Git cloneRepo() {
		File f = new File(workingDir + "/vbasto-iscte/ESII1920");
		if (f.exists()) deleteDirectory(f); //If this fails Git will throw an exception saying that the directory is not empty and won't clone it
		try {
			return Git.cloneRepository()
			.setURI(repo)
			.setDirectory(f)
			.call();
		} catch (GitAPIException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Function to recursively delete a directory
	private boolean deleteDirectory(File directoryToBeDeleted) {
	    File[] allContents = directoryToBeDeleted.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	            deleteDirectory(file);
	        }
	    }
	    return directoryToBeDeleted.delete();
	}
	
	//Generates the RAW file URL for a specific file and tag (or 'master' for the main branch)
	private static String generateFileURL(String file, Ref tag) {
		String tagName = tag.getName().replace("refs/tags/", "");
		String base = "https://raw.githubusercontent.com/vbasto-iscte/ESII1920/";
		return base + tagName + "/" + file;
	}
	
}
