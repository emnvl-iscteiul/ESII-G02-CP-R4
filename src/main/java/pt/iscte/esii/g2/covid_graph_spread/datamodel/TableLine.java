package pt.iscte.esii.g2.covid_graph_spread.datamodel;

/**
 * Encapsulates the information of one line in the HTML table by the name of the header
 * 
 * @author Eduardo
 *
 */
public class TableLine {

	private final String fileTimestamp;
	private final String fileName;
	private final String tag;
	private final String tagDescription;
	private final String link;
	
	/**
	 * Creates a new instance of this object with the given data
	 * 
	 * @param fileTimestamp Timestamp of the file creation
	 * @param fileName Name of the file
	 * @param tag Git Tag associated to the release
	 * @param tagDescription Git Tag description
	 * @param link URL to visualize the data 
	 */
	public TableLine(String fileTimestamp, String fileName, String tag, String tagDescription, String link) {
		super();
		this.fileTimestamp = fileTimestamp;
		this.fileName = fileName;
		this.tag = tag;
		this.tagDescription = tagDescription;
		this.link = link;
	}

	public String getFileTimestamp() {
		return fileTimestamp;
	}

	public String getFileName() {
		return fileName;
	}

	public String getTag() {
		return tag;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public String getLink() {
		return link;
	}
	
	/**
	 * @return An array of String containing all the data held in this object
	 */
	public String[] toArray() {
		return new String[]{fileTimestamp, fileName, tag, tagDescription, link};
	}
	
}
