package pt.iscte.esii.g2.covid_graph_spread.generators;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Scanner;

import pt.iscte.esii.g2.covid_graph_spread.datamodel.TableLine;

public class HTMLGenerator {
	
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
	
	private String buildTable(TableLine[] data) {
		String out = "";
		for (TableLine tl : data) {
			out += buildLine(tl.toArray());
		}
		return out;
	}
	
	private String buildLine(String[] data) {
		String out = "<tr>";
		for (String item : data) {
			out += "<td>" + item + "</td>";
		}
		out += "</td>";
		return out;
	}
	
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
	
	public static String generateLink(String text, String link) {
		return "<a target=\"_blank\" href=\"" + link + "\">" + text + "</a>";
	}

}
