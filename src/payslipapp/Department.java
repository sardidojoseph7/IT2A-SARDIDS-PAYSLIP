
package payslipapp;

import java.util.Scanner;


public class Department {
    
    
    
    public void addDeparment(){
        
       Config conni =  new Config();
        Scanner sc = new Scanner(System.in);

        
       System.out.print("Enter Department Name: ");
        String dname = sc.nextLine();
        System.out.print("Department Head: ");
        String fhead = sc.nextLine();
        System.out.print("Contact Information: ");
        String info = sc.nextLine();
        System.out.print("Location: ");
        String loc = sc.nextLine();
        System.out.print("Basic Salary (Monthly) : ");
        double salary = sc.nextDouble();
        System.out.print("(LATE) Deduction Amount: ");
        double amount = sc.nextDouble();
        System.out.print("(ABSENT) Deduction Amount: ");
        double ab = sc.nextDouble();
        
        
        String sqladd = "INSERT INTO Department (Department_Name, Department_Head, Contact_Information, Location, Basic_Salary, Late_Deduction, Absent_Deduction) VALUES "
                + "(?,?,?,?,?,?,?)";
        conni.addEmployee(sqladd, dname, fhead, info, loc, salary, amount, ab);
        
    }
    public void viewDepartment(){
        
        String view = "SELECT * FROM Department";
        
        String[] headers = {"ID", "Department Name", "Department Head", "Contact Information", "Location", "Basic Salary","Late Deduction","Absent Deduction"};
        String[] columns = {"Department_ID", "Department_Name", "Department_Head", "Contact_Information", "Location", "Basic_Salary", "Late_Deduction", "Absent_Deduction"};
       Config conni =  new Config();
       conni.viewdEmployee(view, headers, columns);       
    }
    
    public void mainDepartment(){
        
        Department dp = new Department();
       Config conni =  new Config();
        Scanner sc = new Scanner(System.in);
 
        
        String res;       
        do{
        System.out.println("1. Add Department");
        System.out.println("2. View Deparment");
        System.out.println("3. Update Department");
        System.out.println("4. Delete Department");
        System.out.println("5. Exiting....");
        
        
        
         int choice;
            while (true) {
                System.out.print("Enter choice: ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }
        
            switch(choice){
                
                case 1:
                   dp.addDeparment();
                    break;
                case 2:
                    dp.viewDepartment();
                    break;
                case 3:
                   String sqlup = "UPDATE Department SET Department_Head = ?, Location = ?, Basic_Salary = ?, Late_Deduction = ?, Absent_Deduction = ? WHERE Department_ID = ?";
                    System.out.print("Enter Department ID to Update: ");
                    int idup = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    System.out.print("Enter new Department Head: ");
                    String newhead = sc.nextLine();
                    System.out.print("Enter new Location: ");
                    String newloc = sc.nextLine();
                    System.out.print("Enter new Basic Salary (Monthly) : ");
                    double newsal = sc.nextDouble();
                    System.out.print("Enter new Late Deduction: ");
                    double newlate = sc.nextDouble();
                    System.out.print("Enter new Absent Deduction: ");
                    double newabsent = sc.nextDouble();


                    
                    
                    conni.updateEmployee(sqlup, newhead, newloc, newsal, newlate, newabsent,idup);
                    break;
                
                case 4:
                    String sqldel = "DELETE FROM Department WHERE Department_ID = ? ";
                    
                    System.out.print("Enter Department ID to delete: ");
                    int idel = sc.nextInt();
                    
                    conni.deleteEmployee(sqldel, idel);
                    break;
                case 5:
                    System.out.println("Exiting.....");
                    break;
                
                
                
                
            }
            System.out.println("");
            System.out.print("Do you want to continue? Yes or No: ");
            res = sc.next();
    }while(res.equalsIgnoreCase("yes"));
        
        
    }
}
