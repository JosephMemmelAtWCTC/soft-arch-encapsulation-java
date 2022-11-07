package edu.wctc.part4;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;

public class Company {

	private String companyName;
	private List<HiringStaff> hiringStaff = new ArrayList<HiringStaff>();

	public Company(String companyName){
		if(companyName == null || companyName.isBlank()){
			throw new IllegalArgumentException("Company name can't be empty or null!");
		}
	}

	public void assignHiringPersonal(HiringStaff hiringMember){
		if(hiringMember == null ){
			throw new IllegalArgumentException("Employee cannot be null!");
		}
		for(HiringStaff staff: hiringStaff){
			if(staff.getFirstName().equals(hiringMember.getFirstName()) && staff.getLastName().equals(hiringMember.getLastName())){
				throw new IllegalArgumentException("Employee already added to staffing!");
			}
		}
		this.hiringStaff.add(hiringMember);
	}

	public HiringStaff getHiringPersonalByName(String firstAndLastName) throws NoSuchObjectException {
		if(firstAndLastName == null){
			throw new IllegalArgumentException("Can't find an employee that is null!");
		}
		String firstName, lastName;
		try{
			firstName = firstAndLastName.substring(0,firstAndLastName.indexOf(' '));
			lastName = firstAndLastName.substring(firstAndLastName.indexOf(' ')+1);
			if(lastName.indexOf(' ') != -1){
				throw new IllegalArgumentException("Name cannot have more than one space!");
			}
		}catch(IndexOutOfBoundsException error){
			throw new IllegalArgumentException("Name needs to be separated by a space!");
		}

		for(HiringStaff staff: hiringStaff){
			if(staff.getFirstName().equals(firstName) && staff.getLastName().equals(lastName)){
				return staff;
			}
		}
		throw new NoSuchObjectException("Employee by that name not found.");
	}

}
