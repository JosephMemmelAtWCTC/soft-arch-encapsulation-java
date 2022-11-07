package edu.wctc.part4;

import java.rmi.NoSuchObjectException;

/**
 * This class is the startup class for the program. But together with the other
 * classes provided it is not a particularly good simulation of the real world.
 * Employees don't just hire themselves and them tell themselves to go through
 * orientation. There's usually a company and a HR person involved.
 *
 * Refer to the Employee class for further directions.
 */
public class Main {

    public static void main(String[] args) {
        Company companyInc = new Company("Company Inc.");
        companyInc.assignHiringPersonal(new HiringStaff("Hirey", "Hireson", "555-55-5555", "A101"));

        try{
            HiringStaff personHiring = companyInc.getHiringPersonalByName("Hirey Hireson");

            personHiring.setCurrentAssignment(new Employee("Prevuousman", "Employeeson", "555-55-5553"));
            personHiring.setCurrentAssignment(new Employee("Peter", "Piper", "333-33-3333"));

            personHiring.doFirstTimeOrientation();
            personHiring.printReport();
            personHiring.endCurrentAssignmentTask();


        }catch(NoSuchObjectException e){
            e.printStackTrace();
        }
    }

}
