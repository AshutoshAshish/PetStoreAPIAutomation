package api.payloads;

public class PetTags {
	
	int tagID;
	String tagName;
	/*
	public PetTags(int id, String name) {
		petID=id;
		petName=name;
	}
	*/
	public int getTagID() {
		return tagID;
	}
	public void setTagID(int tagID) {
		this.tagID = tagID;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
