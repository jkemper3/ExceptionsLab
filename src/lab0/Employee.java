package lab0;

import java.util.Calendar;
import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }
// cannot be less than zero and cannot be > 15
    public void setDaysVacation(int daysVacation) throws IllegalArgumentException {
        if(daysVacation < 0 || daysVacation > 15){
            throw new EmployeeNumericRangeException();    
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }
    //cannot be null, cannot be empty
    //any character from 1 to 25
    public final void setFirstName(String firstName) throws IllegalArugumentException{
       if (firstName == null || firstName.length() > 25 ||
               firstName.length()<1){
           throw new IllegalArgumentException();
       }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }
//cannot be null, cannot be before 14 days from todays date 
// cannot be later than 5 days from today
    public void setHireDate(Date hireDate)
    throws HireDateException{
        
        if(hireDate == null){  
           throw new HireDateException("Hire date cannot be null"); 
        }
        Calendar calHireDate = Calendar.getInstance();
        calHireDate.setTime(hireDate);
        Calendar beforeDate = Calendar.getInstance();
        beforeDate.add(Calendar.DATE,-5);
        Calendar afterDate = Calendar.getInstance();
        afterDate.add(Calendar.DATE,14);
        if(calHireDate.before(beforeDate) || calHireDate.after(afterDate)){
            throw new HireDateException("Hire date cannot be before 14 days "
                    + "or after 5 days");
        }
        
        
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    // 333-33-3333
    // 333333333
    //
    public void setSsn(String ssn) {
        ssn = ssn.replaceAll("-", "");
        char [] chars = ssn.toCharArray();
        for(char c : chars){
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException();
            }
        }
        this.ssn = ssn;
    }
    
    
    
}
