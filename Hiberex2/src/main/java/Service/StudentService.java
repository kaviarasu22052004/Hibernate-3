package Service;

import java.util.Scanner;
import Dao.DaoImplementation;
import Model.Student;

public class StudentService {

    Scanner sc;
    DaoImplementation dao;
    Student s;

    public StudentService() {
        sc = new Scanner(System.in);
        dao = new DaoImplementation();
        s = new Student();
    }

    public void saveStudent() {
        System.out.println("Enter Roll No:");
        s.setRollno(sc.nextInt());
        sc.nextLine(); // consume leftover newline

        System.out.println("Enter Name:");
        s.setName(sc.nextLine());

        System.out.println("Enter Marks:");
        s.setMarks(sc.nextDouble());

        dao.savedata(s);
        System.out.println("Student saved successfully!");
    }
    
    public void delete() {
        System.out.print("Enter Roll No to Delete: ");
        int roll = sc.nextInt(); 

        dao.removeByRoll(roll);
    }
    
    public void update() {
    	
    	 System.out.println("Enter Roll No:");
         int roll = sc.nextInt();
         sc.nextLine();

         System.out.println("Enter Name:");
         String name = sc.nextLine();

         System.out.println("Enter Marks:");
         double mark = sc.nextDouble();
         
         dao.updatebyroll(roll, name, mark);
    	
    }
    
    public void searchbyroll() {
    	
   	 System.out.println("Enter Roll No:");
     int rollno = sc.nextInt();
     sc.nextLine();
     
     dao.searchbyroll(rollno);
    }
    
    public void showdata() {
    	dao.ShowData();
    }
    
    public void searchbyname() {
    	
        System.out.println("Enter Name:");
        String sname = sc.nextLine();
        dao.searchname(sname);
        
    	
    	
    }
}




