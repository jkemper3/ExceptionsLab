/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab0;

/**
 *
 * @author jkemper3
 */
public class HireDateException extends IllegalArgumentException{
      private static String message =
            "Sorry, value entered is out of range";
    
    public HireDateException(){
        super(message);
    }
    
     public HireDateException(String msg){
     super(message);
     }
     
      public HireDateException(String msg, Throwable cause){
           super(message,cause);
      }
      
       public HireDateException(Throwable cause){
           super(cause);
      }
       
       public String getMessage(){
           
           return message;
       }
}

