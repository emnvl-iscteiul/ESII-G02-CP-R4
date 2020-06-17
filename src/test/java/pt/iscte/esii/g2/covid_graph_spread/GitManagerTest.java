package pt.iscte.esii.g2.covid_graph_spread;

import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.iscte.esii.g2.covid_graph_spread.git.GitManager;

public class GitManagerTest {

	private static GitManager gm;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gm = new GitManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gm = null;
		System.gc();
	}

	@Test
	public void testGetFilesInfo() {
		assertNotEquals(0, gm.getFilesInfo().length);
	}

}
