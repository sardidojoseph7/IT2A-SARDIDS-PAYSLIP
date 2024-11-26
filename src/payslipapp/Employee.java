
package payslipapp;

import java.util.Scanner;

 
public class Employee {
    
    
    public void addemployee(){
        
        Config conni =  new Config();
        Scanner sc = new Scanner(System.in);
       
        
        String fname = "";
        while (true) {
        System.out.print("Enter Employee First Name: ");
        fname = sc.nextLine();
         if (fname.matches("[A-Za-z]+")) {  
                break;
            } else {
                System.out.println("Invalid First Name. Please enter only letters.");
            }
        }
        
        String lname = "";
        while (true) {
        System.out.print("Enter Employee Last Name: ");
        lname = sc.nextLine();
         if (lname.matches("[A-Za-z]+")) {  
                break;
            } else {
                System.out.println("Invalid Last Name. Please enter only letters.");
            }
        }
        
        String add = "";
        while (true) {
        System.out.print("Address: ");
        add = sc.nextLine();
        if (add.matches("[A-Za-z,\\s]+")) {
                break;
            } else {
                System.out.println("Invalid address. Please enter only letters, spaces, and commas (no numbers or special symbols).");
            }
        }
        
        String num = "";
        while (true) {
        System.out.print("Contact No. (+63): ");
        num = sc.nextLine();       
        if (num.matches("\\d{10}")) { 
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a valid 10-digit contact number.");
            }
        }
        
        int age = 0;
        while (true) {
        System.out.print("Age: ");
            if (sc.hasNextInt()) {
        age = sc.nextInt();
            if (age > 0) {
            break;
            } else {
                System.out.println("Invalid age. Please enter a positive integer for age.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                sc.next(); 
            }
        }
        
        sc.nextLine();
        
        String e = "";
        while (true) {
        System.out.print("Email: ");
        e = sc.nextLine();    
            if (e.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {  
                break;
            } else {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        }
        
        String stats = "";
        while (true) {
        System.out.print("Status (single, married, widowed, divorced): ");
        stats = sc.nextLine().toLowerCase();  
            if (stats.equals("single") || stats.equals("married") || stats.equals("widowed") || stats.equals("divorced")) {
                break; 
             } else {
                System.out.println("Invalid status. Please enter one of the following: 'single', 'married', 'widowed', or 'divorced'.");
            }
        }
        
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
        boolean exit = true;

        
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
               int idem;
                while (true) {
                System.out.print("Enter Employee ID to Update: ");
                if (sc.hasNextInt()) {
                    idem = sc.nextInt();
                    if (conni.getSingleValues("SELECT Employee_ID  FROM Employee  WHERE Employee_ID = ?", idem) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Employee doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Employee ID.");
                    sc.next(); 
                }
            }
                
          
                String newadd;
                while (true) {
                    System.out.print("Enter new address: ");
                    sc.nextLine(); 
                    newadd = sc.nextLine();
                    if (newadd.matches("[A-Za-z0-9,\\s]+")) {
                        break;
                    } else {
                        System.out.println("Invalid address. Use only letters, numbers, spaces, and commas.");
                }
            }
                
                String newnum;
                while (true) {
                    System.out.print("Enter new Contact No.(+63): ");
                    newnum = sc.next();
                    if (newnum.matches("\\d{10}")) {
                        break;
                    } else {
                        System.out.println("Invalid Contact No. Please enter a 10-digit number.");
                    }
                }
                
                int newage; 
                while (true) {
                    System.out.print("Enter new Age (18-65): ");
                    if (sc.hasNextInt()) {
                    newage = sc.nextInt();
                        if (newage >= 18 && newage <= 65) {
                             break;
                        } else {
                            System.out.println("Age must be between 18 and 65.");
                        }
                        
                    } else {
                        System.out.println("Invalid input. Please enter a valid age.");
                        sc.next();
                    }
                }
                    
                 sc.nextLine(); 
               
                String newemai; 
                while (true) {
                    System.out.print("Enter new Email: ");
                    newemai = sc.nextLine();
                    if (newemai.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        break;
                    } else {
                        System.out.println("Invalid email format. Example: example@domain.com");
                    }
                }
        
                
                String newstats;
                while (true) {
                    System.out.print("Enter new Status (single, married, widowed, divorced): ");
                    newstats = sc.nextLine().trim().toLowerCase(); 
                    if (newstats.equals("single") || newstats.equals("married") || 
                    newstats.equals("widowed") || newstats.equals("divorced")) {
                         break;
                    } else {
                        System.out.println("Invalid status. Please enter one of the following: 'single', 'married', 'widowed', or 'divorced'.");
                    }
                }
                   
                
                conni.updateEmployee(sqlUPDATE, newadd, newnum, newage, newemai, newstats,idem );
                break;
            
            case 4:
                 ep.viewEmployee();
                 
                String sqlDELETE = "DELETE FROM Employee WHERE Employee_ID = ?";
               
                int idDEL;
                while (true) {
                System.out.print("Enter Employee ID to Delete: ");
                if (sc.hasNextInt()) {
                    idDEL = sc.nextInt();
                    if (conni.getSingleValues("SELECT Employee_ID  FROM Employee  WHERE Employee_ID = ?", idDEL) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Employee doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Employee ID.");
                    sc.next(); 
                }
            }
                
                
                conni.deleteEmployee(sqlDELETE, idDEL);
                
                break;
            case 5:
                do {
                        System.out.print("\nExit Selected.... type yes to continue: ");
                        String res = sc.next();

                        if (res.equalsIgnoreCase("yes")) {
                            exit = false;
                            break; 
                        } else if (res.equalsIgnoreCase("no")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid 'yes' or 'no'.");
                        }
                    } while (true); 
                    break;
            
            
        }
        
      
        }while(exit);        
        
    }
    
    
    
}
        