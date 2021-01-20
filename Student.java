package L4;

import java.util.Scanner;
import java.util.*;
import java.io.IOException;

public class Student{
    private String program;
    private String year;
    private String grade;
    private String programInfo ;
    private String [] temp;
    private String delimiter = "[ ]+";
    private String lastName ;

        public  void  initialize(){
            int yearCheck =0;
        boolean gradeCheck = true;
        int check =0;
        int check2 =0;
        Scanner scannerObj2 = new Scanner(System.in);
        Scanner scannerObj3 = new Scanner(System.in);
        Scanner scannerObj4 = new Scanner(System.in);
        do{
        System.out.println("Enter Student Program and Year");
            programInfo = scannerObj2.nextLine();
            temp = programInfo.split(delimiter);
            // checking for whether there is 1 element or 2 
            if(temp.length >=2){
                program = temp[0];
                setprogram(program);
                year = temp[1];
                // if 1 then do the error checks
                if (year.matches("[0-9,-]+")){
                    check =1;
                    yearCheck = Integer.parseInt(year);
                    //  if(yearChecker(yearCheck) == false){
                    //      throw new Exception("input year = 0-99");
                    //  }
             if(yearCheck < 0){
             System.out.println("Enter valid year");
             }else{
                 check =1;
             }
                }else {
                    System.out.println("Enter Year properly after program");
                }
                // set after doing error checks
                setyear(year);
            }else if (temp.length == 1){
                program = programInfo;
                setprogram(program);
                year = "0";
                setyear(year);
                if(programInfo.isEmpty() == true){
                    check =0;
                }else{
                check =1;
                }
                // checking for only one input as in 1 element in array
            }
        }while(check != 1);
        
            System.out.println("Enter Average grade, or leave blank");
            grade = scannerObj3.nextLine();
            String grade1 = grade;
            try {
                Double num = Double.parseDouble(grade);
            } catch (NumberFormatException e) {
                gradeCheck = false;
            }
            if(gradeCheck){
            grade = grade1;
            setgrade(grade);
            }else{
                grade = "0";
                setgrade(grade);
            }
            int check3 = 0;
            do{
                System.out.println("Enter student last name");
                lastName = scannerObj4.nextLine();
                if(lastName.length() > 0){
                    check3 =1;
                }
            }while(check3 != 1);
    }
    Student (String program,String year,String grade,String lastName) throws Exception{
        //initialize();
        // int yearCheck = Integer.parseInt(year);
        // if(yearChecker(yearCheck) == false){
        //     throw new Exception("Rejected : input year can only be = 0-99");
        // }
        // int grade1 = Integer.parseInt(grade);
        // if(yearChecker(grade1) == false){
        //     throw new Exception("Rejected : Grade can only be equal to vaules 0-99");
        // }
         setprogram(program);
         setyear(year);
         setgrade(grade);
         setlastName(lastName);
        // a constructor
    }
    Student (String num) throws Exception{
        //  int yearCheck = Integer.parseInt(year);
        //  if(yearChecker(yearCheck) == false){
        //      throw new Exception("\n Rejected : input year = 0-99 \n");
        //  }
        //  int grade1 = Integer.parseInt(grade);
        //  if(yearChecker(grade1) == false){
        //      throw new Exception("\n Rejected : Grade can only be equal to vaules 0-99 \n");
        //  }
    }
    Student(){
        
    }
    public boolean yearChecker(int year){

    if (year >0 && year < 100 )
       return true;
    
       return false;

       }
      
       
    public void setprogram( String program) {
        this.program = program;
    }
    public void setyear( String year){
        this.year = year;
    }
    public void setgrade( String grade){
        this.grade = grade;
    }
    public void setlastName( String lastName){
        this.lastName = lastName;
    }
    public String getprogram (){
        return program;
    }
    public String getyear(){
        return year;
    }
    
    public String getgrade(){
        return grade;
    }
    
    public String getlastName(){
        return lastName;
    }

    public String toString(){
        return "\n" + "Program:"+program + "\n" + "Year:"+ year + "\n" + "Average Grade:" + grade + toString1();
    }
    public String toString1(){
        return "\n" + "lastName : " + lastName + "\n";
    }
}
