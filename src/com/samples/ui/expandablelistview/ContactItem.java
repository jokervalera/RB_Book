package com.samples.ui.expandablelistview;

import com.samples.ui.expandablelistview.R.string;

public class ContactItem {
	private String name;
	private String phone;
	private int photoID;
	private String about;
	private int j;
	private int bigphoto;
    public ContactItem(String name, String phone, int photoID, String about,int j, int bigphoto) {
    	this.name = name;
    	this.phone = phone;
    	this.photoID = photoID;
    	this.about = about;
    	this.j = j;
    	this.bigphoto = bigphoto;
    } 
    
	public ContactItem(String name2, String phone2, int a14, int appName) {
	}

	public ContactItem(String name2, String phone2, int a14,
			Class<string> class1) {
		// TODO Auto-generated constructor stub
	}

	public String getName() { return name; }
	public String getPhone() { return phone; }
	public int getPhotoID() { return photoID; }
	public String getAbout() { return about; }
	public int getj() { return j; }
	public int getbigphoto() { return bigphoto; }
	
	public void setName(String val) { name = val; }
	public void setPhone(String val) { phone = val; }
	public void setPhotoID(int val) { photoID = val; }
	public void setAbout(String val) { about = val; }
	public void setj(int val) { j = val; }
	public void setbigphoto(int val) { bigphoto = val; }
	public static ContactItem selectedItem;
	
}
