package edu.wctc.part4;

import java.util.ArrayList;
import java.util.List;

public class HiringStaff extends Employee {
	String assignmentCubeID;

	Employee employeeBeingWorkedOn;
	private List<Employee> employeesTakenCareOf = new ArrayList<>();

	public HiringStaff(String firstName, String lastName, String ssn, String cubeID) {
		super(firstName, lastName, ssn);
		this.assignmentCubeID = cubeID;
	}


	public void setCurrentAssignment(Employee e){
		if(e == null){
			throw new IllegalArgumentException("You cannot provide a null employee!");
		}
		if(e != employeeBeingWorkedOn){
			if(employeeBeingWorkedOn != null){
				employeesTakenCareOf.add(employeeBeingWorkedOn);
			}
			this.employeeBeingWorkedOn = e;
		}
	}

	public void endCurrentAssignmentTask(){
		employeesTakenCareOf.add(employeeBeingWorkedOn);
		employeeBeingWorkedOn = null;
	}

	public void doFirstTimeOrientation(){
		this.employeeBeingWorkedOn.doFirstTimeOrientation(this.assignmentCubeID);
	}

	public void printReport(){
		System.out.println("~~~~~ Report on Hiring Staff Member: "+this.getFirstName()+" "+this.getLastName()+" ~~~~~");
		System.out.print("Previous employees worked with with: ");
		String previousEmployees = "";
		for (int i = 0; i < employeesTakenCareOf.size(); i++) {
			Employee previousEmployee = employeesTakenCareOf.get(i);
			previousEmployees += " "+previousEmployee.getFirstName()+" "+previousEmployee.getLastName()+",";
		}
		if(previousEmployees.length()>2){
			System.out.print(previousEmployees.substring(0,previousEmployees.length()-1));
		}
		System.out.println("\n");
		System.out.println(this.getFirstName()+" "+this.getLastName()+"'s current active assignment is '"+employeeBeingWorkedOn.getFirstName()+" "+employeeBeingWorkedOn.getLastName()+"'");

		employeeBeingWorkedOn.printReport();
	}

}
