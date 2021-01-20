package L4;

import java.util.Scanner;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

// public class App{
//     public static void main(String[] args) {
//     int gate = 0;
//     String input1 ;
//      String input2;
//     ArrayList <Student> studentList = new ArrayList<Student>();
//     HashMap<String,Student> studentMap = new HashMap<String,Student>();

//     int i = 0;
//     Scanner scannerObj = new Scanner(System.in);
//     Scanner scannerObj2 = new Scanner(System.in);
//     Scanner scannerObj4 = new Scanner(System.in);
//     Scanner scannerObj3 = new Scanner(System.in);
//     int options = 0;
//     // this is options for the following operations
//     while (gate != 1){
//         options =0;
//     System.out.println("(1) Enter information for a new student.");
//     System.out.println("(2) Enter information for a new GraduateStudent");
//     System.out.println("(3) Show all student information with each attribute on a separate line");
//     System.out.println("(4) Print the average of the average grades for all students as well as the total number of students");
//     System.out.println("(5) Enter a specific program and show all student information for that program");
//     System.out.println("(6) Load student information from an input file.");
//     System.out.println("(7)Save all student information to an output file");
//     System.out.println("(8) creating hashmaps with program, year and last name ");
//     System.out.println("(9) End the program.");

//     options = scannerObj.nextInt();
//         // scanning for options
//             if(options == 1){
//                 try{
//                 Student person = new Student();
//                 //person.initialize();
//                 String key = person.getprogram() + person.getyear() +person.getlastName();
//                 key = key.toLowerCase();
//                 if(!studentMap.containsKey(key)){
//                     studentMap.put(key,person);
//                     studentList.add(person);
//                 }else{
//                     System.out.println(" there is a duplicate and it wasnt added to the list");
//                 }
//             }catch (Exception e){
//                 System.out.println(e.getMessage());
//             }
//                // uses initialize method then adds to student list
//             }
//             if(options == 3){
//                 int j =0;
//                 for(j=0;j< studentList.size();j++){
//                 System.out.println(studentList.get(j).toString());
//                 }
//                 // prints out all the list
//             }
//             if(options == 2){
//                 try{
//                 GraduateStudent person = new GraduateStudent();
//                 person.initialize2();
//                 String key = person.getprogram() + person.getyear() +person.getlastName();
//                 key = key.toLowerCase();
//                 if(!studentMap.containsKey(key)){
//                     studentMap.put(key,person);
//                     studentList.add(person);
//                 }else{
//                     System.out.println(" there is a duplicate and it wasnt added to the list");
//                 }
//             }catch (Exception e){
//                 System.out.println(" Try  running  the program again with correct numbers");
//             }
//                 // uses initialize2 method then adds to student list
//             }
//             if(options == 4){
//                 int a =0;
//                 double avgGrade =0;
//                 for (a=0;a < studentList.size();a++){
//                     avgGrade += Double.parseDouble(studentList.get(a).getgrade());
//                 }
                
//                 System.out.println( "\n" + "Average grades for class : " + avgGrade/a);
//                 System.out.println("Total number of students : " + a + "\n");
//                 // for calculating the average and print it out along with # of students
//             }
//             if(options == 5){
//                 int checker =0;
//                 String programName;
//                 System.out.println("Enter Student Program ");
//                 programName = scannerObj4.nextLine();
//                 int k =0;
//                 for(k=0;k< studentList.size();k++){
//                     if(studentList.get(k).getprogram().equalsIgnoreCase(programName)){
//                 System.out.println(studentList.get(k).toString());
//                     }else{
//                         checker = 1;
//                     }
//                 }
//                 if(checker ==1){
//                     System.out.println("\n" + " No match for program entered " + "\n" );
//                 }
//                 // if the program amtches, then its printed out
//             }
//             if (options == 6){
//                 // scanning in from a file
//                 int check =0;
//                 System.out.println("\n" + " Enter the name for the input file " + "\n" );
//                 input1 = scannerObj3.nextLine();
//                 Scanner inputStream = null;
                
//                 try{
//                     inputStream = new Scanner (new FileInputStream(input1));
//                     File oneFile = new File (input1);
//                     if( oneFile.length()==0){
//                         System.out.println("\n" +" The File trying to be opened is empty" + "\n");
                        
//                     }
//                 } catch(FileNotFoundException e)
//                 {
//                     System.out.println("File : "+ input1 + " was not found"+ "\n or could not be opened " + "\n");
//                     System.exit(0);
//                 }

//                 while(inputStream.hasNextLine())
//                 {
//                     String line = inputStream.nextLine();
//                     String delimiter = "[ ]+";
//                     String [] temp = line.split(delimiter);
//                     if (temp.length == 7 ||  temp.length == 6 ){
//                         try{
//                         GraduateStudent person2 = new GraduateStudent("string");
//                         person2.setprogram(temp[0]);
//                         person2.setyear(temp[1]);
//                         person2.setgrade(temp[2]);
//                         person2.setsupervisor(temp[3]);
//                         person2.setstudYr(temp[4]);
//                         person2.setschool(temp[5]);
//                         person2.setlastName(temp[6]);
//                         String key = person2.getprogram() + person2.getyear() +person2.getlastName();
//                         key = key.toLowerCase();
//                         if(!studentMap.containsKey(key)){
//                             studentMap.put(key,person2);
//                             studentList.add(person2);
//                         }else{
//                             System.out.println(" there is a duplicate and it wasnt added to the list");
//                         }
//                         } catch(Exception e){
//                             System.out.println(" error");
//                         }
//                     }else{
//                         try{
//                         Student person = new Student("string");
//                         person.setprogram(temp[0]);
//                         person.setyear(temp[1]);
//                         person.setgrade(temp[2]);
//                         person.setlastName(temp[3]);
//                         String key = person.getprogram() + person.getyear() +person.getlastName();
//                         key = key.toLowerCase();
//                         if(!studentMap.containsKey(key)){
//                             studentMap.put(key,person);
//                             studentList.add(person);
//                         }else{
//                             System.out.println(" there is a duplicate and it wasnt added to the list");
//                         }
//                     }catch(Exception e){
//                         System.out.println(" error");
//                     }
//                     }
//                 }
            
//             }
//             if (options ==7){
//                 // outputting to the file and clearing
//                 System.out.println("\n" + " Enter the name for the output file " + "\n" );
//                 input2 = scannerObj2.nextLine();
//                 PrintWriter outputStream = null;
//                 try {
//                     for(int k=0;k< studentList.size();k++)
//                     {
//                         outputStream = new PrintWriter(new FileOutputStream(input2,true));
//                         outputStream.println(studentList.get(k).toString());
//                         outputStream.close();
//                     }
//                 } 
//                 catch (FileNotFoundException e) 
//                 {
//                 System.out.println("Error opening the file stuff.txt.");
//                 System.exit(0);
//                 }
//                 studentList.clear();
//             }

//             if (options ==8){
//                 Search.search(studentMap);
            
//             }


//             if (options ==9){
//                 System.out.println("\n" +"program has come to an end."+ "\n");
//                 gate = 1;
//                 // ends the program
//             }
//         }
//     }

// }
