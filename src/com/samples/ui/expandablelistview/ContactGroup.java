package com.samples.ui.expandablelistview;

import java.util.ArrayList;

public class ContactGroup {
	private String name;
	private ArrayList<ContactItem> contacts;
	
	
	public ContactGroup(String name) {
		this.name = name;
		this.contacts = new ArrayList<ContactItem>();

	}
	
	public void addContact(ContactItem contactItems) { 
		contacts.add(contactItems); 
	}	
	
	
	public String getName() { 
		return name; 
	}	
	public ArrayList<ContactItem> getContactsList() { 
		return contacts; 
	}
	public ContactItem getContactItem(int position) { 
		return contacts.get(position); 
	}

}
