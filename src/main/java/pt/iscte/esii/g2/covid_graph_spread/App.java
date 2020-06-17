package pt.iscte.esii.g2.covid_graph_spread;

import pt.iscte.esii.g2.covid_graph_spread.generators.HTMLGenerator;
import pt.iscte.esii.g2.covid_graph_spread.git.GitManager;

public class App 
{
	// Application output should be an HTML snippet to integrate into the PHP page
    public static void main( String[] args )
    {
    	HTMLGenerator html = new HTMLGenerator();
    	GitManager gm = new GitManager();
    	System.out.println(html.generateHTML(gm.getFilesInfo()));
    }
}
