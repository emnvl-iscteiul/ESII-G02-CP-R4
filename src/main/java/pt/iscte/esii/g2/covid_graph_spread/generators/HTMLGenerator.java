package pt.iscte.esii.g2.covid_graph_spread.generators;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Scanner;

import pt.iscte.esii.g2.covid_graph_spread.datamodel.TableLine;

/**
 * Encapsulates methods to generate an HTML table containing the given data
 * 
 * @author Eduardo
 *
 */
public class HTMLGenerator {
	
	/**
	 * Generates the HTML snippet with all the given data in a table.
	 * 
	 * @param data Data to be parsed by the method
	 * @return A String containing the HTML snippet with the given data 
	 */
	public String generateHTML(TableLine[] data) {
		String model;
		
		try {
			model = getHtmlModel();
		} catch (FileNotFoundException | URISyntaxException e) {
			e.printStackTrace();
			return "";
		}
		
		return model.replace("%DATA%", buildTable(data));
	}
	 /**
	  * Creates the HTML table data snippet with the given data
	  * 
	  * @param data Data to be parsed by the method
	  * @return A String containing the HTML table data snippet
	  */
	private String buildTable(TableLine[] data) {
		String out = "";
		for (TableLine tl : data) {
			out += buildLine(tl.toArray());
		}
		return out;
	}
	
	/**
	 * Builds a single line of the HTML table
	 * 
	 * @param data An array of data to be inserted in each column of the line
	 * @return A String containing a single line of the HTML table
	 */
	private String buildLine(String[] data) {
		String out = "<tr>";
		for (String item : data) {
			out += "<td>" + item + "</td>";
		}
		out += "</td>";
		return out;
	}
	
	/**
	 * Looks for the resource text file containing the model for the HTML table
	 * 
	 * @return A String containing the data in the model file
	 * @throws URISyntaxException If the URI was not correctly built
	 * @throws FileNotFoundException If the file doesn't exist
	 */
	private String getHtmlModel() throws URISyntaxException, FileNotFoundException {
		InputStream res = this.getClass().getResourceAsStream("htmlmodel"); //file needs to be in the same package
		Scanner sc = new Scanner(res);
		String out = "";

		while(sc.hasNextLine()) {
			out += sc.nextLine() + "\n";
		}
		sc.close();
		
		return out;
	}
	
	/**
	 * Creates a HTML snippet for the visualization link
	 * 
	 * @param text The text to be presented in the link
	 * @param link The URL to embed in the link
	 * @return A String containing the link HTML snippet
	 */
	public static String generateLink(String text, String link) {
		return "<a target=\"_blank\" href=\"" + link + "\">" + text + "</a>";
	}

}
