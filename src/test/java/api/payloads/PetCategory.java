package api.payloads;

public class PetCategory {
	
	int categoryID;
	String categoryName;
	/*
	public PetCategory(int id, String name) {
		categoryID=id;
		categoryName= name;
	}
	*/
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
