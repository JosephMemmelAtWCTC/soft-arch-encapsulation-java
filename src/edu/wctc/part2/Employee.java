package edu.wctc.part2;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *
 * 1. Not all methods need to be public
 *
 * 2. When methods need to be called in a certain order you can do this
 * by creating a parent method that calls the other, helper methods.
 *
 * 3. There is some duplicate code used that violates the D.R.Y. principle.
 * Eliminate that by encapsulating the duplicate code in a new method
 * and then call that method in place of the duplicate code.
 *
 * 4. All method parameters should be validated (except booleans).
 *
 * Review the tips in the document Encapsulation Checklist if needed.
 */
public class Employee {
    private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("M/d/yy");
    private static final short SSN_LENGTH = 14;

    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private LocalDate orientationDate;

    public Employee(String firstName, String lastName, String ssn){
        if (firstName.length() == 0 || lastName.length() == 0) {
            throw new IllegalArgumentException("Name can't have an empty part!");
        }
        ssn = ssn.replace("-","");
        this.setSsn(ssn);
        try{
            Float.parseFloat(ssn);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("SSN has to be a number!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    public void meetWithHrForBenefitAndSalaryInfo() {
        metWithHr = true;
        printUserUpdateWithDate("met with HR on"+cubeId, orientationDate);
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.
    public void meetDepartmentStaff() {
        metDeptStaff = true;
        printUserUpdateWithDate("met with dept staff on", orientationDate);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        printUserUpdateWithDate("reviewed dept policies"+cubeId, orientationDate);
    }

    // Assume this must be performed fourth. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        this.cubeId = this.getCubeId();
        this.movedIn = true;
        printUserUpdateWithDate("moved into cubicle "+cubeId, orientationDate);
    }

//=============
    private void printUserUpdateWithDate(String statement, LocalDate lclDte){
        if (statement.length() == 0) {
            throw new IllegalArgumentException("Statement cannot be empty!");
        }
        System.out.println(this.getFirstName()+" "+this.getLastName()+" "+statement+" on "+formatDate(lclDte));
    }

    private String formatDate(LocalDate lclDte){
        if(lclDte == null){
            throw new IllegalArgumentException("Date cannot be null!");
        }
        if(LocalDate.now().isBefore(lclDte)){
            throw new IllegalArgumentException("Date cannot be before today");
        }
        return FORMATTER.format(lclDte);
    }



    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if (ssn.length() == 0) {
            throw new IllegalArgumentException("SSN cannot be blank!");
        }
        if (ssn.length() != SSN_LENGTH) {
            throw new IllegalArgumentException("SSN must be "+SSN_LENGTH+" digits long!");
        }
    }

    public boolean hasMetWithHr() {
        return metWithHr;
    }

    public boolean hasMetDeptStaff() {
        return metDeptStaff;
    }

    public boolean hasReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public boolean hasMovedIn() {
        return movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public LocalDate getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(LocalDate orientationDate) {
        this.orientationDate = orientationDate;
    }
}
