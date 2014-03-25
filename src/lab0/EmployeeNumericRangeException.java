

package lab0;

/**
 *
 * @author jkemper3
 */
public class EmployeeNumericRangeException extends IllegalArgumentException {
    
    private static String message =
            "Sorry, value entered is out of range";
    
    public EmployeeNumericRangeException(){
        super(message);
    }
    
     public EmployeeNumericRangeException(String msg){
     super(message);
     }
     
      public EmployeeNumericRangeException(String msg, Throwable cause){
           super(message,cause);
      }
      
       public EmployeeNumericRangeException(Throwable cause){
           super(cause);
      }
       
       public String getMessage(){
           
           return message;
       }
}
