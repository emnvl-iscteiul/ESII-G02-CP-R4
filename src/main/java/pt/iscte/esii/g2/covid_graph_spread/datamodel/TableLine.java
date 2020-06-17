package pt.iscte.esii.g2.covid_graph_spread.datamodel;

public class TableLine {

	private final String fileTimestamp;
	private final String fileName;
	private final String tag;
	private final String tagDescription;
	private final String link;
	
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
	
	public String[] toArray() {
		return new String[]{fileTimestamp, fileName, tag, tagDescription, link};
	}
	
}
