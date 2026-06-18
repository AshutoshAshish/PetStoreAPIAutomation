package api.payloads;

import java.util.List;

public class Pet {
	
	int id;
	PetCategory category;
	String name;
	List<String> photoUrls;
	List<PetTags> tags;
	String status;
	//String[] status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCategory getCategory() {
		return category;
	}
	public void setCategory(PetCategory category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<PetTags> getTags() {
		return tags;
	}
	public void setTags(List<PetTags> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
