package edu.wctc.part1;

import java.time.LocalDate;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a constructor
 * to enforce that. Review the tips in the document Encapsulation Checklist if
 * needed.
 */
public class Employee {
    public static final boolean DEFAULT_MET_WITH_HR = false;
    public static final boolean DEFAULT_MET_WITH_DEP_STAFF = false;
    public static final boolean DEFAULT_REVIEWED_DEP_POLICIES = false;
    public static final boolean DEFAULT_MOVED_IN = false;


    private String firstName; //Mandatory
    private String lastName; //Mandatory
    private String ssn; //Mandatory
    private boolean metWithHr; //OPTIONAL
    private boolean metDeptStaff; //OPTIONAL
    private boolean reviewedDeptPolicies; //OPTIONAL
    private boolean movedIn; //OPTIONAL
    private String cubeId = ""; //OPTIONAL, default is ""
    private LocalDate orientationDate; //Default is current date if not set


    /**
     * Bare minimum
     * @param firstName
     * @param lastName
     * @param ssn
     */
    public Employee(String firstName, String lastName, String ssn){
        this(firstName, lastName, ssn, DEFAULT_MET_WITH_HR, DEFAULT_MET_WITH_DEP_STAFF, DEFAULT_REVIEWED_DEP_POLICIES, DEFAULT_MOVED_IN, null, null);
    }

    /**
     * Met all reviewed set together
     * @param firstName
     * @param lastName
     * @param ssn
     */

    public Employee(String firstName, String lastName, String ssn, boolean allValuesOfMet, boolean allValuesOfReviewed, boolean movedIn) {
        this(firstName, lastName, ssn, allValuesOfMet, allValuesOfMet, allValuesOfReviewed, movedIn, null, null);
    }

    /**
     * Done all vs done none
     * @param firstName
     * @param lastName
     * @param ssn
     * @param didAllDidNone
     */
    public Employee(String firstName, String lastName, String ssn, boolean didAllDidNone) {
        this(firstName, lastName, ssn, didAllDidNone, didAllDidNone, didAllDidNone, didAllDidNone, null, null);
    }

    /**
     * Manualy set all (nullable can also be left null for defaults, used when preset constructors are not applicable)
     * @param firstName
     * @param lastName
     * @param ssn
     * @param metWithHr
     * @param metDeptStaff
     * @param reviewedDeptPolicies
     * @param movedIn
     * @param cubeId
     * @param orientationDate
     */
    public Employee(String firstName, String lastName, String ssn, boolean metWithHr, boolean metDeptStaff,
                    boolean reviewedDeptPolicies, boolean movedIn, String cubeId, LocalDate orientationDate) {
        this.firstName = firstName;//Cant be null, required
        this.lastName = lastName;//Cant be null, required
        this.ssn = ssn;//Cant be null, required
        this.metWithHr = metWithHr;//Default so always set in other constructors
        this.metDeptStaff = metDeptStaff;//Default so always set in other constructors
        this.reviewedDeptPolicies = reviewedDeptPolicies;//Default so always set in other constructors
        this.movedIn = movedIn;//Default so always set in other constructors
        if(orientationDate == null)
            this.cubeId = "";
        else
            this.cubeId = cubeId;
        if(orientationDate == null)
            this.orientationDate = java.time.LocalDate.now();
        else
            this.orientationDate = orientationDate;
    }
    public void setCubeId(String cubeId){this.cubeId = cubeId;}
}
