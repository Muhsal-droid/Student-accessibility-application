package L4;

import java.util.Scanner;
import java.util.*;

public class Search{

    public static void search(HashMap<String,Student> studentMap, String program1,String last){
       Scanner scannerObj2 = new Scanner(System.in);
       String programInfo ;
       String program="";
       String year="";
       int check = 0;
       int yearCheck ;
       String grade;
       String [] temp;
       String delimiter = "[ ]+";
        do{
            System.out.println("Enter Student Program and Year");
                programInfo = program1;
                temp = programInfo.split(delimiter);
                // checking for whether there is 1 element or 2 
                if(temp.length >=2){
                    program = temp[0];
                    year = temp[1];
                    // if 1 then do the error checks
                    if (year.matches("[0-9]+")){
                        
                        check =1;
                        yearCheck = Integer.parseInt(year);
                        
                if(yearCheck < 0){
                System.out.println("Enter valid year");
                }else{
                    check =1;
                }
                    }else {
                        System.out.println("Enter Year properly after program");
                    }
                    // set after doing error checks
                }else if (temp.length == 1){
                    program = programInfo;
                    year = "0";
                    if(programInfo.isEmpty() == true){
                        check =0;
                    }else{
                    check =1;
                    }
                    // checking for only one input as in 1 element in array
                }
            }while(check != 1);  
            
            String lastName = "";
            do{
                System.out.println("Enter studnet last name");
                lastName = last;
                
            }while(lastName == null || lastName.length() <= 0);
        
            String key  = program + year + lastName;
            key  = key.toLowerCase();
            if (studentMap.containsKey(key)){
                System.out.println(studentMap.get(key));
            }

    }
   
}