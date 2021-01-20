package L4;

import java.util.Scanner;
import java.util.*;
import java.awt.ScrollPane;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class University extends JFrame {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;

    private JPanel startWin;
    private JPanel addStudent;
    private JPanel viewStudent;
    private JPanel avgStudent;
    private JTextArea viewStudentText;
    private JTextArea avgStudentText;
    private  JTextArea hashMessage;
    private JPanel starStudent;
    private JPanel fileStudent;
    private JPanel outStudent;
    private JPanel secondStudent;
    private JPanel hashStudent;
    private JTextField fileName;
    private JTextField search;
    private JTextField programinfo;
    private JTextField grade;
    private JTextField programinfo1;
    private JTextField programinfo2;
    private JTextField grade1;
    private JTextField lastname1;
    private JTextField lastname2;
    private JTextField lastname;
    private JTextField fileout1;
    private JTextField studYr;
    private JTextField isPHD;
    private JTextField supervisor;
    private JTextField school;
    private CardLayout cardLayout;
    private JPanel sectionPanel;
    private JTextArea searchTextArea;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private HashMap<String, Student> studentMap = new HashMap<String, Student>();
    private Component add;

    public static void main(String[] args) {
        University gui = new University();
        gui.setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Added something");

            // get the component at index 1 from the respective panels
            // that component will always be JtextField
            String program = programinfo.getText();
            String gr = grade.getText();
            // System.out.println(gr);
            String name = lastname.getText();
            String delimiter = "[ ]+";
            String[] temp = program.split(delimiter);
            String program1;
            String year;
            if (temp.length >= 2) {
                program1 = temp[0];
                year = temp[1];
            } else {
                program1 = program;
                year = "0";
            }
           // System.out.println(gr);
            try {
                //System.out.println("hello");
                Student stu = new Student(program1, year, gr, name);
                String mapKey = program1 + year + name;
                mapKey = mapKey.toLowerCase();
                studentList.add(stu);
                studentMap.put(mapKey, stu);

            } catch (Exception e1) {
                //System.out.println(e1.getMessage());
            }
            //System.out.println(studentList.size());
            for (int i = 0; i < studentList.size(); i++) {
                // System.out.println(studentList.get(i).toString());
            }
            // viewStudent();
            updateStudent();
            updateAvgStudent();
        }
    } // End for add listener GradButtonListener

    ////////////////////////////////////////////////////////////////////
    private class SearchButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int checker = 1;
            String programName;
            //System.out.println("Enter Student Program ");
            programName = search.getText();
            int k = 0;
            searchTextArea.setText("");
            for (k = 0; k < studentList.size(); k++) {
                if (studentList.get(k).getprogram().equalsIgnoreCase(programName)) {
                    searchTextArea.append(studentList.get(k).toString());
                    checker = 0;
                }
            }
            if (checker == 1) {
                searchTextArea.append("\n" + " No match for program entered " + "\n");
            }

        }
    } // End for search listener
      ////////////////////////////////////////////////////////////////////

    private class fileButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputFile = fileName.getText();

            //////////////////////////////////////////////////////
            // scanning in from a file
            int check = 0;
            //System.out.println("\n" + " Enter the name for the input file " + "\n");
            String input1 = inputFile;
            Scanner inputStream = null;

            try {
                inputStream = new Scanner(new FileInputStream(input1));
                File oneFile = new File(input1);
                if (oneFile.length() == 0) {
                    System.out.println("\n" + " The File trying to be opened is empty" + "\n");

                }
            } catch (FileNotFoundException e1) {
                System.out.println("File : " + input1 + " was not found" + "\n or could not be opened " + "\n");
                // System.exit(0);
            }

            while (inputStream.hasNextLine()) {
                String line = inputStream.nextLine();
                String delimiter = "[ ]+";
                String[] temp = line.split(delimiter);
                if (temp.length == 7 ) {
                    try {
                        GraduateStudent person2 = new GraduateStudent("string");
                        person2.setprogram(temp[0]);
                        person2.setyear(temp[1]);
                        person2.setgrade(temp[2]);
                        person2.setsupervisor(temp[3]);
                        person2.setstudYr(temp[4]);
                        person2.setschool(temp[5]);
                        person2.setlastName(temp[6]);
                        String key = person2.getprogram() + person2.getyear() + person2.getlastName();
                        key = key.toLowerCase();
                        if (!studentMap.containsKey(key)) {
                            studentMap.put(key, person2);
                            studentList.add(person2);
                        } else {
                            System.out.println(" there is a duplicate and it wasnt added to the list");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        System.out.println(" error1");
                    }
                } else {
                    try {
                        Student person = new Student();
                        person.setprogram(temp[0]);
                        person.setyear(temp[1]);
                        person.setgrade(temp[2]);
                        person.setlastName(temp[3]);
                        // studentList.add(person);
                        String key = person.getprogram() + person.getyear() + person.getlastName();
                        key = key.toLowerCase();
                        if (!studentMap.containsKey(key)) {
                            studentMap.put(key, person);
                            studentList.add(person);
                        } else {
                            System.out.println(" there is a duplicate and it wasnt added to the list");
                        }
                    } catch (Exception e1) {
                        System.out.println("error");
                    }
                }
            }
            //////////////////////////////////////////////////////

        }
    } // End for search listener
      ////////////////////////////////////////////////////////////////////

    private class fileOutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input2 = fileout1.getText();
            PrintWriter outputStream = null;
            try {
                for (int k = 0; k < studentList.size(); k++) {
                    outputStream = new PrintWriter(new FileOutputStream(input2, true));
                    outputStream.println(studentList.get(k).toString());
                    outputStream.close();
                }
            } catch (FileNotFoundException e1) {
                System.out.println("Error opening the file stuff.txt.");
                System.exit(0);
            }
            studentList.clear();
        }

    } // End for search listener GradButtonListener
      ////////////////////////////////////////////////////////////////////

    private class GradButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String studyYear = studYr.getText();
            //String phd = isPHD.getText();
            String supervi = supervisor.getText();
            String school1 = school.getText();

            String program = programinfo1.getText();
            String gr = grade1.getText();
            // System.out.println(gr);
            String name = lastname1.getText();
            String delimiter = "[ ]+";
            String[] temp = program.split(delimiter);
            String program1;
            String year;
            if (temp.length >= 2) {
                program1 = temp[0];
                year = temp[1];
            } else {
                program1 = program;
                year = "0";
            }
            //System.out.println(gr);
            try {
                //System.out.println("hello232");
                GraduateStudent stu = new GraduateStudent(program1, year, gr, name, studyYear, supervi, school1);
                studentList.add(stu);
                //System.out.println("student: " + stu);
                //System.out.println(studentList.size());
                String mapKey = program1 + year + name;
                mapKey = mapKey.toLowerCase();
                studentList.add(stu);
                studentMap.put(mapKey, stu);
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println(e1.getMessage());
            }
            updateStudent();
            updateAvgStudent();

        }
    } // End for search listener
      ////////////////////////////////////////////////////////////////////

    private class hashListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String program1 = programinfo2.getText();
            String last = lastname2.getText();
            search(studentMap, program1, last);
        }
    } // End for search listener
      ////////////////////////////////////////////////////////////////////

    private class quitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(-1);

        }
    } // End for search listener
      ////////////////////////////////////////////////////////////////////

    private class t1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(sectionPanel, "addStudent");
        }
    } // End for search listener
    ////////////////////////////////////////////////////////////////////

    private class t2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(sectionPanel, "secondStudent");

        }
    } // End for search listener
    ////////////////////////////////////////////////////////////////////

    private class t3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateStudent();
            cardLayout.show(sectionPanel, "viewStudent");

        }
    } // End for search listener
    ////////////////////////////////////////////////////////////////////

    private class t4Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateAvgStudent();
            cardLayout.show(sectionPanel, "avgStudent");
        }
    } // End for search listener
    ////////////////////////////////////////////////////////////////////

    private class t5Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(sectionPanel, "starStudent");

        }
    } // End for search listener
    ////////////////////////////////////////////////////////////////////

    private class t6Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(sectionPanel, "fileStudent");

        }
    } // End for search listener
    ////////////////////////////////////////////////////////////////////

    private class t7Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(sectionPanel, "outStudent");

        }
    } // End for search listener
    ////////////////////////////////////////////////////////////////////

    private class t8Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(sectionPanel, "hashStudent");

        }
    } // End for search listener

    public University() {
        // initial setup
        super("App");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // for button listing add search and quit
        startWin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        startWin.setVisible(true);
        JPanel infoJPanel = new JPanel();
        // first message
        JLabel info = new JLabel("Welcome to Student Search :");
        // second message
        JLabel info2 = new JLabel("Choose a command from the “Commands” menu for the options listed below");
        // add it to the starting window
        infoJPanel.add(info);
        infoJPanel.add(info2);
        startWin.add(infoJPanel);
        sectionPanel = new JPanel();
        cardLayout = new CardLayout();
        sectionPanel.setLayout(cardLayout);
        // set up is done
        // now menu options
        ///////////////////////////////////////////
        mainMenu();
        // for adding the student
        addStudent = new JPanel(new BorderLayout());
        addStudent();
        addStudent.setVisible(false);
        sectionPanel.add(new JPanel(), "empty Panel");
        sectionPanel.add(addStudent, "addStudent");
        // for adding the graduate student

        // show the average grade
        // avgStudent = new JPanel();
        avgStudent = new JPanel(new BorderLayout());
        avgStudent();
        avgStudent.setVisible(true);
        sectionPanel.add(avgStudent, "avgStudent");

        // show all information
        // viewStudent = new JPanel();
        viewStudent = new JPanel(new BorderLayout());
        viewStudent();
        viewStudent.setVisible(true);
        sectionPanel.add(viewStudent, "viewStudent");
        // shows all information
        secondStudent = new JPanel(new BorderLayout());
        secondStudent();
        secondStudent.setVisible(true);
        sectionPanel.add(secondStudent, "secondStudent");
        // specific
        // specific student info
        starStudent = new JPanel(new BorderLayout());
        starStudent();
        starStudent.setVisible(true);
        sectionPanel.add(starStudent, "starStudent");
        // scanning in from a file
        fileStudent = new JPanel(new BorderLayout());
        fileStudent();
        fileStudent.setVisible(true);
        sectionPanel.add(fileStudent, "fileStudent");
        // output to a file
        outStudent = new JPanel(new BorderLayout());
        outStudent();
        outStudent.setVisible(true);
        sectionPanel.add(outStudent, "outStudent");
        // hashstudent
        hashStudent = new JPanel(new BorderLayout());
        hashStudent();
        hashStudent.setVisible(true);
        sectionPanel.add(hashStudent, "hashStudent");
        add(sectionPanel, BorderLayout.CENTER);
        ///////////////////////////////////////////
        JPanel messagePanel = new JPanel();
        JTextArea displayMessage = new JTextArea(12, 55);
        displayMessage.setEditable(false);
        displayMessage.setText("(1) Enter information for a new student." + "\n"
                + "(2) Enter information for a new GraduateStudent" + "\n"
                + "(3) Show all student information with each attribute on a separate line" + "\n"
                + "(4) Print the average of the average grades for all students as well as the total number of students"
                + "\n" + "(5) Enter a specific program and show all student information for that program" + "\n"
                + "(6) Load student information from an input file." + "\n"
                + "(7)Save all student information to an output file" + "\n"
                + "(8) creating hashmaps with program, year and last name " + "\n" + "(9) End the program.");

        JScrollPane scrollContainer = new JScrollPane(displayMessage);
        messagePanel.add(scrollContainer);

        startWin.add(messagePanel);
        // pack();
        setVisible(true);
        add(startWin, BorderLayout.PAGE_START);

    }

    public void mainMenu() {

        JMenu options = new JMenu("Commands");

        JMenuItem op1 = new JMenuItem("(1)");
        op1.addActionListener(new t1Listener());
        options.add(op1);

        JMenuItem op2 = new JMenuItem("(2)");
        op2.addActionListener(new t2Listener());
        options.add(op2);

        JMenuItem op3 = new JMenuItem("(3)");
        op3.addActionListener(new t3Listener());
        options.add(op3);

        JMenuItem op4 = new JMenuItem("(4)");
        op4.addActionListener(new t4Listener());
        options.add(op4);

        JMenuItem op5 = new JMenuItem("(5)");
        op5.addActionListener(new t5Listener());
        options.add(op5);

        JMenuItem op6 = new JMenuItem("(6)");
        op6.addActionListener(new t6Listener());
        options.add(op6);

        JMenuItem op7 = new JMenuItem("(7)");
        op7.addActionListener(new t7Listener());
        options.add(op7);

        JMenuItem op8 = new JMenuItem("(8)");
        op8.addActionListener(new t8Listener());
        options.add(op8);

        JMenuItem quit = new JMenuItem("(9)");
        quit.addActionListener(new quitListener());
        options.add(quit);

        JMenuBar bar = new JMenuBar();
        bar.add(options);
        setJMenuBar(bar);

    }

    public void addStudent() {
        JPanel one = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter = new BoxLayout(one, BoxLayout.Y_AXIS);
        one.setLayout(setter);// (one,BoxLayout.PAGE_AXIS));

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // add
        JLabel mssg = new JLabel("Adding a Student");
        infoPanel.add(mssg);

        JPanel two = new JPanel();
        JLabel program = new JLabel("Program Info :");
        programinfo = new JTextField(25);
        two.add(program);
        two.add(programinfo);

        JPanel three = new JPanel();
        JLabel gr = new JLabel("grade :");
        grade = new JTextField(25);
        three.add(gr);
        three.add(grade);

        JPanel four = new JPanel();
        JLabel name = new JLabel("lastName :");
        lastname = new JTextField(25);
        four.add(name);
        four.add(lastname);

        JPanel five = new JPanel();
        JButton adder = new JButton("Add");
        adder.addActionListener(new AddButtonListener());
        five.add(adder);

        one.add(infoPanel);
        one.add(two);
        one.add(three);
        one.add(four);
        one.add(five);

        addStudent.add(one, BorderLayout.LINE_START);

    }

    public void updateStudent() {
        viewStudentText.setText("Total students: " + studentList.size());
        for (int i = 0; i < studentList.size(); i++) {
            viewStudentText.append(studentList.get(i).toString());
            //System.out.println(studentList.get(i).toString());
        }
    }

    public void viewStudent() {
        JPanel one1 = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter1 = new BoxLayout(one1, BoxLayout.PAGE_AXIS);
        one1.setLayout(setter1);// (one,BoxLayout.PAGE_AXIS));

        JPanel messagePanel = new JPanel();
        viewStudentText = new JTextArea(20, 20);
        viewStudentText.setEditable(false);

        JScrollPane scrollContainer = new JScrollPane(viewStudentText);
        // messagePanel.add(scrollContainer);

        one1.add(scrollContainer);
        // one1.setSize(100, 100);
        viewStudent.add(one1, BorderLayout.CENTER);
        // viewStudent.add(one1);

    }

    public void updateAvgStudent() {
        int a = 0;
        double avgGrade = 0;
        for (a = 0; a < studentList.size(); a++) {
            avgGrade += Double.parseDouble(studentList.get(a).getgrade());
        }
        avgStudentText.setText("");
        avgStudentText.append("\n" + "Average grades for class : " + avgGrade / a);
        avgStudentText.append("\n ");
        avgStudentText.append("Total number of students : " + a + "\n");
        // for calculating the average and print it out along with # of students

    }

    public void avgStudent() {
        JPanel one1 = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter1 = new BoxLayout(one1, BoxLayout.PAGE_AXIS);
        one1.setLayout(setter1);// (one,BoxLayout.PAGE_AXIS));

        JPanel messagePanel = new JPanel();
        avgStudentText = new JTextArea(20, 20);
        avgStudentText.setEditable(false);

        JScrollPane scrollContainer = new JScrollPane(avgStudentText);

        one1.add(scrollContainer);
        avgStudent.add(one1, BorderLayout.CENTER);

    }

    public void starStudent() {
        JPanel one1 = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter1 = new BoxLayout(one1, BoxLayout.PAGE_AXIS);
        one1.setLayout(setter1);// (one,BoxLayout.PAGE_AXIS));

        JPanel messagePanel = new JPanel();
        searchTextArea = new JTextArea(5, 10);
        searchTextArea.setEditable(false);

        JScrollPane scrollContainer = new JScrollPane(searchTextArea);

        JPanel five = new JPanel();
        JButton search1 = new JButton(" enter and search specific program");
        search1.addActionListener(new SearchButton());
        search = new JTextField(25);
        five.add(search);
        five.add(search1);

        one1.add(scrollContainer);
        one1.add(five);
        starStudent.add(one1, BorderLayout.CENTER);

    }

    public void fileStudent() {
        JPanel one = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter = new BoxLayout(one, BoxLayout.Y_AXIS);
        one.setLayout(setter);// (one,BoxLayout.PAGE_AXIS));

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // add
        JLabel mssg = new JLabel("Reading in from a file");
        infoPanel.add(mssg);

        JPanel two = new JPanel();
        JButton file1 = new JButton("Input : File name");
        file1.addActionListener(new fileButtonListener());
        fileName = new JTextField(25);
        two.add(file1);
        two.add(fileName);

        one.add(infoPanel);
        one.add(two);

        fileStudent.add(one, BorderLayout.LINE_START);
    }

    public void outStudent() {
        JPanel one = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter = new BoxLayout(one, BoxLayout.Y_AXIS);
        one.setLayout(setter);// (one,BoxLayout.PAGE_AXIS));

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // add
        JLabel mssg = new JLabel("outputting to a file");
        infoPanel.add(mssg);

        JPanel two = new JPanel();
        JButton fileout = new JButton("Output : File name");
        fileout.addActionListener(new fileOutButtonListener());
        fileout1 = new JTextField(25);
        two.add(fileout);
        two.add(fileout1);

        one.add(infoPanel);
        one.add(two);

        outStudent.add(one, BorderLayout.LINE_START);
    }

    public void secondStudent() {
        JPanel one = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter = new BoxLayout(one, BoxLayout.Y_AXIS);
        one.setLayout(setter);// (one,BoxLayout.PAGE_AXIS));

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // add
        JLabel mssg = new JLabel("Adding a Student");
        infoPanel.add(mssg);

        JPanel two = new JPanel();
        JLabel program = new JLabel("Program Info :");
        programinfo1 = new JTextField(25);
        two.add(program);
        two.add(programinfo1);

        JPanel three = new JPanel();
        JLabel gr = new JLabel("grade :");
        grade1 = new JTextField(25);
        three.add(gr);
        three.add(grade1);

        JPanel four = new JPanel();
        JLabel name = new JLabel("lastName :");
        lastname1 = new JTextField(25);
        four.add(name);
        four.add(lastname1);

        JPanel five = new JPanel();
        JButton adder = new JButton("Add");
        adder.addActionListener(new GradButtonListener());
        five.add(adder);

        JPanel six = new JPanel();
        JLabel studyYear = new JLabel("Study year :");
        studYr = new JTextField(25);
        six.add(studyYear);
        six.add(studYr);

        JPanel eight = new JPanel();
        JLabel supervisor1 = new JLabel("supervisor :");
        supervisor = new JTextField(25);
        eight.add(supervisor1);
        eight.add(supervisor);

        JPanel nine = new JPanel();
        JLabel school1 = new JLabel("school :");
        school = new JTextField(25);
        nine.add(school1);
        nine.add(school);

        one.add(infoPanel);
        one.add(two);
        one.add(three);
        one.add(four);
        one.add(six);
        //one.add(seven);
        one.add(eight);
        one.add(nine);
        one.add(five);

        secondStudent.add(one, BorderLayout.LINE_START);
    }

    public void hashStudent() {
        JPanel one = new JPanel(); // holds all textfields (everything to the left)
        BoxLayout setter = new BoxLayout(one, BoxLayout.Y_AXIS);
        one.setLayout(setter);// (one,BoxLayout.PAGE_AXIS));

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // add
        JLabel mssg = new JLabel("Search through hashmap");
        infoPanel.add(mssg);

        JPanel two = new JPanel();
        JLabel program = new JLabel("Program Info :");
        programinfo2 = new JTextField(25);
        two.add(program);
        two.add(programinfo2);

        JPanel four = new JPanel();
        JLabel name = new JLabel("lastName :");
        lastname2 = new JTextField(25);
        four.add(name);
        four.add(lastname2);

        JPanel five = new JPanel();
        JButton hasher = new JButton("search");
        hasher.addActionListener(new hashListener());
        five.add(hasher);

        JPanel messagePanel = new JPanel();
        hashMessage = new JTextArea(20, 20);
        avgStudentText.setEditable(false);

        JScrollPane scrollContainer = new JScrollPane(hashMessage);


        one.add(infoPanel);
        one.add(scrollContainer);
        one.add(two);
        one.add(four);
        one.add(five);

        hashStudent.add(one, BorderLayout.LINE_START);

    }

    public void search(HashMap<String, Student> studentMap, String program1, String last) {
        Scanner scannerObj2 = new Scanner(System.in);
        String programInfo;
        String program = "";
        String year = "";
        int check = 0;
        int yearCheck;
        String grade;
        String[] temp;
        String delimiter = "[ ]+";
        do {
            //System.out.println("Enter Student Program and Year");
            programInfo = program1;
            temp = programInfo.split(delimiter);
            // checking for whether there is 1 element or 2
            if (temp.length >= 2) {
                program = temp[0];
                year = temp[1];
                // if 1 then do the error checks
                if (year.matches("[0-9]+")) {

                    check = 1;
                    yearCheck = Integer.parseInt(year);

                    if (yearCheck < 0) {
                        System.out.println("Enter valid year");
                    } else {
                        check = 1;
                    }
                } else {
                    System.out.println("Enter Year properly after program");
                }
                // set after doing error checks
            } else if (temp.length == 1) {
                program = programInfo;
                year = "0";
                if (programInfo.isEmpty() == true) {
                    check = 0;
                } else {
                    check = 1;
                }
                // checking for only one input as in 1 element in array
            }
        } while (check != 1);

        String lastName = "";
        do {
            //System.out.println("Enter studnet last name");
            lastName = last;
            hashMessage.setText("");
        } while (lastName == null || lastName.length() <= 0);
        String key = program + year + lastName;
        key = key.toLowerCase();
        //System.out.println(key);
        //System.out.println(studentMap.keySet());
        if (studentMap.containsKey(key)) {
            //System.out.println("Getting something");
            hashMessage.append(studentMap.get(key).toString());
             }
 
     }

}