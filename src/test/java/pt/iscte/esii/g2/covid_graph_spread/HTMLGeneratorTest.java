package pt.iscte.esii.g2.covid_graph_spread;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.iscte.esii.g2.covid_graph_spread.generators.HTMLGenerator;
import pt.iscte.esii.g2.covid_graph_spread.git.GitManager;

public class HTMLGeneratorTest {
	
	private static HTMLGenerator html;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		html = new HTMLGenerator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		html = null;
		System.gc();
	}

	@Test
	public void testGenerateHTML() {
		assertThrows(NullPointerException.class, () -> html.generateHTML(null));
		assertNotNull(html.generateHTML(new GitManager().getFilesInfo()));
	}

	@Test
	public void testGenerateLink() {
		assertNotNull(HTMLGenerator.generateLink("Some text", "http://link.link"));
	}

}
