
package payslipapp;

import java.util.Scanner;


public class Department {
    
    
    
    public void addDeparment(){
        
       Config conni =  new Config();
        Scanner sc = new Scanner(System.in);

        String dname;
        while (true) {
            System.out.print("Enter Department Name: ");
            dname = sc.nextLine();
                if (!dname.isEmpty() && dname.matches("[a-zA-Z\\s]+")) {
                     break;
         }
            System.out.println("Invalid department name. It must contain only letters and spaces.");
        }
        
        String fhead;
        while (true) {
            System.out.print("Department Head: ");
            fhead = sc.nextLine();
                if (!fhead.isEmpty() && fhead.matches("[a-zA-Z\\s]+")) {
                     break;
            }
            System.out.println("Invalid name. It must contain only letters and spaces.");
        }        
        
        String info;
        while (true) {
            System.out.print("Contact Information (+63) ");
            info = sc.nextLine();
                if (!info.isEmpty() && info.matches("\\+?[0-9\\-\\s]+") && info.length() >= 10) {
                    break;
            }
            System.out.println("Invalid contact information. It must contain at least 10 digits and only numbers, dashes, or spaces.");
        }
        
        String loc;
        while (true) {
            System.out.print("Location: ");
            loc = sc.nextLine();
                if (!loc.isEmpty() && loc.matches("\\d+(st|nd|rd|th) Floor")) {
                    break;
            }
            System.out.println("Invalid location. It must follow the format like '2nd Floor', '3rd Floor', etc.");
        }  
        
        double salary;
        while (true) {
            System.out.print("Basic Salary (Monthly) : ");
                if (sc.hasNextDouble()) {
                    salary = sc.nextDouble();
                if (salary > 0) {
                    break;
                } else {
            System.out.println("Salary must be a positive number.");
         }
                } else {
           System.out.println("Invalid input. Please enter a numeric value for salary.");
           sc.next();
            }
        }         
           
        double amount;
        while (true) {
            System.out.print("(LATE) Deduction Amount: ");
                if (sc.hasNextDouble()) {
                    amount = sc.nextDouble();
                if (amount >= 0) {
                    break;
                } else {
            System.out.println("Deduction amount cannot be negative.");
        }           
                } else {
            System.out.println("Invalid input. Please enter a numeric value.");
            sc.next(); 
            }
        }
        
        double ab;
        while (true) {
            System.out.print("(ABSENT) Deduction Amount: ");
                if (sc.hasNextDouble()) {
                    ab = sc.nextDouble();
                if (ab >= 0) {
                      break;
                } else {
            System.out.println("Deduction amount cannot be negative.");
       }    
                } else {
            System.out.println("Invalid input. Please enter a numeric value.");
            sc.next(); 
            }
        }         
        
        
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
                    dp.viewDepartment();
                   String sqlup = "UPDATE Department SET Department_Head = ?, Contact_Information = ?, Location = ?, Basic_Salary = ?, Late_Deduction = ?, Absent_Deduction = ? WHERE Department_ID = ?";
                   
                   
                   int depid;
                while (true) {
                System.out.print("Enter Deparment ID to update: ");
                if (sc.hasNextInt()) {
                    depid = sc.nextInt();
                    if (conni.getSingleValues("SELECT Department_ID FROM Department WHERE Department_ID = ?", depid) != 0) {
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Selected Department doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Department ID.");
                    sc.next(); 
                }
            }
               
                
                
                    String newhead;
                    while (true) {
                        System.out.print("Enter new Department Head: ");
                        newhead = sc.nextLine();
                        if (!newhead.isEmpty() && newhead.matches("[a-zA-Z\\s]+")) {
                             break;
                        } else {
                            System.out.println("Invalid name. It must contain only letters and spaces.");
                        }
                    }
                   
                    String newinfo;
                    while (true) {
                        System.out.print("Enter new Contact Information (+63): ");
                        newinfo = sc.nextLine();
                        if (!newinfo.isEmpty() && newinfo.matches("\\+?[0-9\\-\\s]+") && newinfo.length() >= 10) {
                                break;
                        } else {
                            System.out.println("Invalid contact information. It must contain at least 10 digits and only numbers, dashes, or spaces.");
                        }
                    }
                    
                        
       
                    
                    String newloc;
                    while (true) {
                        System.out.print("Enter new Location: ");
                        newloc = sc.nextLine();
                        if (!newloc.isEmpty() && newloc.matches("\\d+(st|nd|rd|th) Floor")) {
                            break;
                        } else {
                            System.out.println("Invalid location. It must follow the format like '2nd Floor', '3rd Floor', etc.");
                        }
                    }
                        
                    double newsal;    
                    while (true) {
                        System.out.print("Enter new Basic Salary (Monthly): ");
                        if (sc.hasNextDouble()) {
                        newsal = sc.nextDouble();
                            if (newsal > 0) {
                            sc.nextLine(); 
                                break; 
                                } else {
                                    System.out.println("Salary must be a positive number.");
                                }
                            
                        } else {
                            System.out.println("Invalid input. Please enter a numeric value for salary.");
                            sc.next(); 
                        }
                    }
                    
                    double newlate;
                    while (true) {
                        System.out.print("Enter new Late Deduction: ");
                            if (sc.hasNextDouble()) {
                            newlate = sc.nextDouble();
                                if (newlate >= 0) {
                                    sc.nextLine(); 
                                    break; 
                                } else {    
                                    System.out.println("Deduction amount cannot be negative.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a numeric value.");
                                sc.next();
                            }
                        }
                            
    
                    double newabsent;
                    while (true) {
                        System.out.print("Enter new Absent Deduction: ");
                            if (sc.hasNextDouble()) {
                            newabsent = sc.nextDouble();
                                 if (newabsent >= 0) {
                                      sc.nextLine(); 
                                      break;
                                 } else {
                                     System.out.println("Deduction amount cannot be negative.");
                                 }
                            } else {
                                 System.out.println("Invalid input. Please enter a numeric value.");
                                 sc.next();
                            }
                        }   

                    
                    
                    conni.updateEmployee(sqlup, newhead, newinfo, newloc, newsal, newlate, newabsent,depid);
                    break;
                
                case 4:
                    dp.viewDepartment();
                    
                    String sqldel = "DELETE FROM Department WHERE Department_ID = ? ";
                 int del;
                while (true) {
                System.out.print("Enter Department ID to delete: ");
                if (sc.hasNextInt()) {
                    del = sc.nextInt();
                    if (conni.getSingleValues("SELECT Department_ID  FROM Department  WHERE Department_ID = ?", del) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Department  doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer Department ID.");
                    sc.next(); 
                }
            }
                    
                    conni.deleteEmployee(sqldel, del);
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
