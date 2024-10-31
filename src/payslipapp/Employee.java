
package payslipapp;

import java.util.Scanner;

 
public class Employee {
    
    
    public void addemployee(){
        
        Config conni =  new Config();
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter Employee First Name: ");
        String fname = sc.next();
        System.out.print("Enter Employee Last Name: ");
        String lname = sc.next();
        System.out.print("Address: ");
        String add = sc.next();
        System.out.print("Contact No. : ");
        String num = sc.next();       
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Email: ");
        String e = sc.next();    
         System.out.print("Status: ");
        String stats = sc.next();
        
        String sqlAdd = "INSERT INTO Employee (First_Name, Last_Name, Address, Contact_No, Age, Email, Status) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?)";
        
        conni.addEmployee(sqlAdd, fname, lname, add, num, age, e, stats);
        
            }
    public void viewEmployee(){
       
        String view = "SELECT * FROM Employee";
        
        String[] headers = {"ID", "First Name", "Last Name", "Address", "Contact No. ", "Age","Email","Status"};
        String[] columns = {"Employee_ID", "First_Name", "Last_Name", "Address", "Contact_No", "Age", "Email", "Status"};
       
       
         Config conni =  new Config();
        conni.viewdEmployee(view, headers,columns);
        
        
    }
    
    public void mainEmployee(){
        
        Employee ep = new Employee();
         Config conni =  new Config();
        Scanner sc = new Scanner(System.in);

        String res;
        do{
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");


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
                ep.addemployee();
                break;
            case 2:
                ep.viewEmployee();
                break;
            case 3:
                ep.viewEmployee();
                String sqlUPDATE  = "UPDATE Employee SET Address = ?,  Contact_No = ?,  Age = ?,  Email = ?, Status = ? WHERE Employee_ID = ? ";
                System.out.print("Enter Employeed ID to update: ");
                int idUP = sc.nextInt();
                
                System.out.print("Enter new address: ");
                String newadd = sc.next();
                System.out.print("Enter new Contact No.: ");
                String newnum = sc.next();
                System.out.print("Enter new Age: ");
                int newage = sc.nextInt();
                System.out.print("Enter new Email: ");
                String newemai = sc.next();
                System.out.print("Enter new Status: ");
                String newstats = sc.next();
                
                conni.updateEmployee(sqlUPDATE, newadd, newnum, newage, newemai, newstats,idUP );
                break;
            case 4:
                 ep.viewEmployee();
                String sqlDELETE = "DELETE FROM Employee WHERE Employee_ID = ?";
                System.out.print("Enter Employee ID to delete: ");
                int idDEL  = sc.nextInt();
                conni.deleteEmployee(sqlDELETE, idDEL);
                
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
