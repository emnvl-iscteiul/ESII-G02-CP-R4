package pt.iscte.esii.g2.covid_graph_spread;

import pt.iscte.esii.g2.covid_graph_spread.generators.HTMLGenerator;
import pt.iscte.esii.g2.covid_graph_spread.git.GitManager;

/**
 * Hello world!
 *
 */
public class App 
{
	
	// Application output should be generated here
    public static void main( String[] args )
    {
    	HTMLGenerator html = new HTMLGenerator();
    	GitManager gm = new GitManager();
    	System.out.println(html.generateHTML(gm.getFilesInfo()));
    }
}
