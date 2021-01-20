package L4;

import java.util.Scanner;
import java.util.*;
import java.io.IOException;
    
public class GraduateStudent extends Student {
    private String school;
    private String supervisor;
    private boolean isPHD;
    private String studYr;
    private String programInfo ;
    // for initializing/ storing user input
    public  void  initialize2(){
        boolean gradeCheck = true;
        int check =0;
        int check2 =0;
        Scanner scannerObj2 = new Scanner(System.in);
        Scanner scannerObj3 = new Scanner(System.in);
        Scanner scannerObj1 = new Scanner(System.in);
        do{
        System.out.println("Enter Supervisor");
            supervisor = scannerObj2.nextLine();
            if(supervisor.length() ==0){
                check =0;
                System.out.println("Supervisor field is required ! \n");
            }else{
                check =1;
            }
            // getting supervisor and making sure there is an input
        }while(check != 1);
        do{
            System.out.println("Enter 1 if PHD student and enter 0 if not");
             studYr= scannerObj2.nextLine();
             if(studYr.length() ==1 && studYr.equals("0") && isPHD(studYr)==true){
                check2 =1;
            } else if ( studYr.length() == 1 && studYr.equals("1") && isPHD(studYr)==true){
                check2 =1;
            }else {
                System.out.println("PHD field is required  to be 1 or 0 (cannot be left blank) ! \n");
            }
        } while(check2 != 1);
        System.out.println("Enter undergraduate School, or leave blank");
        school= scannerObj3.nextLine(); 
        // checks for phd and uses it to determine if the correct input and makes sure there is one
    }
    GraduateStudent (String program, String year, String grade, String lastName,String studYr,String supervisor,String school) throws Exception{
        super(program, year, grade, lastName);
        //super.initialize();
        setsupervisor( supervisor);
        setschool(school);
        int studCheck =  Integer.parseInt(studYr);
        if(yearChecker(studCheck) == false){
            throw new Exception("\n Rejected : input can only be = 0-99 \n");
        }
        setstudYr(studYr);
        // a constructor 
    }
    GraduateStudent (String num) throws Exception{
        //  int studCheck =  Integer.parseInt(studYr);
        //  if(yearChecker(studCheck) == false){
        //      throw new Exception("\n Rejected : input can only be = 0-99 \n");
        //  }
    }
    
    public boolean isPHD(String studYr){
        if (studYr.length() ==1 && (studYr.equals("0") || studYr.equals("1"))){
            return true;
        }
        return true;
    }
    public void setsupervisor( String supervisor) {
        this.supervisor = supervisor;
    }
    public void setschool( String school) {
        this.school = school;
    }
    public void setstudYr( String studYr) {
        this.studYr = studYr;
    }
    public String getsupervisor (){
        return supervisor;
    }
    public String getschool(){
        return school;
    }
    public String getstudYr(){
        return studYr;
    }
    @Override
    public String toString(){
        if (studYr.equals("1")){
        return "\n" + super.toString()+ "Supervisor : " + supervisor + "\n" + "PHD : "+ studYr + "\n" + "School : "+school + super.toString1();
        }
        return "\n" + super.toString()+ "Supervisor : " + supervisor + "\n" + "Masters : " +studYr + "\n" + "School : "+ school + super.toString1();
        
        
    }
}
