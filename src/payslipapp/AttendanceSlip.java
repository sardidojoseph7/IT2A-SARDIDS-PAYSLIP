
package payslipapp;

import java.util.Scanner;


public class AttendanceSlip {
    
    
   public void addAttendanceSlip(){
       
       
       Config conni = new Config();
         Scanner sc = new Scanner(System.in);
       System.out.println("- Employee List - ");
       Employee em = new Employee();
       em.viewEmployee();
       System.out.println(" - Department List - ");
       Department  dp = new Department();
       dp.viewDepartment();
       
         int idem;
                while (true) {
                System.out.print("Enter Employee ID: ");
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
        
       
        int depid;
                while (true) {
                System.out.print("Enter Deparment ID: ");
                if (sc.hasNextInt()) {
                    depid = sc.nextInt();
                    if (conni.getSingleValues("SELECT Department_ID FROM Department WHERE Department_ID = ?", depid) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Department doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer Department ID.");
                    sc.next(); 
              }
          }

       
       int days;    
              while (true) {
              System.out.print("No of. Working Days: ");
              if (sc.hasNextInt()) {
                 days = sc.nextInt();
                 if (days >= 0 && days <= 31) {
                     break;
                 } else {
                    System.out.println("Invalid number of working days. Enter a value between 0 and 31.");
                 } 
             } else {
                    System.out.println("Invalid input. Please enter an integer value for working days.");
                    sc.next();
             }
          }
       
       int late;
              while (true) {       
              System.out.print("No. of Late Days: ");
              if (sc.hasNextInt()) {
                 late = sc.nextInt();
                 if (late >= 0 && late <= days) {
                     break;
                 } else {
                     System.out.println("Invalid number of late days. Enter a value between 0 and " + days + ".");
                 }
             } else {
                    System.out.println("Invalid input. Please enter an integer value for late days.");
                    sc.next();
             }
          }
       
       int absent;
              while (true) {
              System.out.print("No. of Absences: ");
              if (sc.hasNextInt()) {
                 absent = sc.nextInt();
                 if (absent >= 0 && (late + absent) <= days) {
                     break;
                 } else {
                     System.out.println("Invalid number of absences. Ensure total late days and absences do not exceed " + days + ".");
                 }
             } else {
                    System.out.println("Invalid input. Please enter an integer value for absences.");
                    sc.next();
             }
          }
                    
       
       double loan;
               while (true) {
               System.out.print("Loan: ");
               if (sc.hasNextDouble()) {
                  loan = sc.nextDouble();
                 if (loan >= 0) {
                     break;
                 } else {
                     System.out.println("Invalid loan amount. Loan cannot be negative.");
                 }
               } else {  
                     System.out.println("Invalid input. Please enter a valid decimal value for the loan amount.");
                     sc.next();
             }
          }
       
       
       
       
       String sqlAdd = "INSERT INTO AttendanceSlip (Employee_ID, Department_ID, No_of_Working_Days, No_of_Late_Days, No_of_Absences, Loan) VALUES (?,?,?,?,?,?)";
       
       conni.addEmployee(sqlAdd, idem, depid, days, late,absent,loan);
     
       
   }
    public void viewAttendanceSlip(){
        
        String sql = "SELECT AttendanceSlip_ID, First_Name, Department_Name , Department_Head, No_of_Working_Days, No_of_Late_Days, No_of_Absences, Loan FROM AttendanceSlip "
                + "LEFT JOIN Employee ON Employee.Employee_ID = AttendanceSlip.Employee_ID "
                + "LEFT JOIN Department ON Department.Department_ID = AttendanceSlip.Department_ID";
        
        String[] header = {"Attendance Slip ID", "Employee", "Deparment", "Department Head", "Working Days", "Late", "Absences","Loan"};
        String[] column = {"AttendanceSlip_ID", "First_Name", "Department_Name","Department_Head","No_of_Working_Days", "No_of_Late_Days", "No_of_Absences", "Loan" };
        
        Config conni = new Config();
        conni.viewdEmployee(sql, header, column);

        
    }
    
    public void mainAttendanceSlip(){
        
          Config conni = new Config();
         Scanner sc = new Scanner(System.in);
        AttendanceSlip as = new AttendanceSlip();
        
        
        String res;
        do{
        System.out.println("1. Add Attendance Slip");
        System.out.println("2. View Attendance Slip");
        System.out.println("3. Update Attendance Slip ");
        System.out.println("4. Delete Attendace Slip");
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
                   as.addAttendanceSlip();
                    break;
                case 2:
                    as.viewAttendanceSlip();
                    break;
                case 3:
                    as.viewAttendanceSlip();
                    String sqlupdate = "UPDATE AttendanceSlip SET No_of_Working_Days = ?, No_of_Late_Days = ?, No_of_Absences = ?, Loan = ? WHERE AttendanceSlip_ID = ?";
                    
                                       
                     int atid;
                while (true) {
                System.out.print("Enter Attendance Slip ID: ");
                if (sc.hasNextInt()) {
                    atid = sc.nextInt();
                    if (conni.getSingleValues("SELECT AttendanceSlip_ID  FROM AttendanceSlip  WHERE AttendanceSlip_ID = ?", atid) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Attendance Slip doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Attendance Slip ID.");
                    sc.next(); 
                }
            }

                
                    int nework;
                    while (true) {
                        System.out.print("Enter new number of Working Days: ");
                        if (sc.hasNextInt()) {
                            nework = sc.nextInt();
                            if (nework >= 0 && nework <= 31) {
                                break;
                            } else {
                                System.out.println("Invalid number of working days. Please enter a value between 0 and 31.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter an integer value for working days.");
                            sc.next(); 
                        }
                    }
                    
                    int newlate;
                    while (true) {
                        System.out.print("Enter new number of Late Days: ");
                        if (sc.hasNextInt()) {
                            newlate = sc.nextInt();
                            if (newlate >= 0 && newlate <= nework) {
                                break;
                            } else {
                                System.out.println("Invalid number of late days. Enter a value between 0 and " + nework + ".");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter an integer value for late days.");
                            sc.next(); 
                        }
                    }
                    
                    int newab;
                    while (true) {
                        System.out.print("Enter new number of Absences: ");
                        if (sc.hasNextInt()) {
                            newab = sc.nextInt();
                            if (newab >= 0 && (newlate + newab) <= nework) {
                                break;
                            } else {
                                System.out.println("Invalid number of absences. Ensure total late days and absences do not exceed " + nework + ".");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter an integer value for absences.");
                            sc.next(); 
                        }
                    }

                    double newloan;
                    while (true) {
                        System.out.print("Enter new Loan amount: ");
                        if (sc.hasNextDouble()) {
                            newloan = sc.nextDouble();
                            if (newloan >= 0) {
                                break;
                            } else {
                                System.out.println("Invalid loan amount. Loan cannot be negative.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid decimal value for the loan amount.");
                            sc.next(); 
                        }
                    }
                    
                    conni.updateEmployee(sqlupdate, nework, newlate, newab, newloan, atid);
                    
                    
                    break;
                case 4:
                    as.viewAttendanceSlip();
                    String sqldelete = "DELETE FROM AttendanceSlip WHERE AttendanceSlip_ID = ? ";      
                    
                      int del;
                while (true) {
                System.out.print("Enter Attendance Slip ID: ");
                if (sc.hasNextInt()) {
                    del = sc.nextInt();
                    if (conni.getSingleValues("SELECT AttendanceSlip_ID  FROM AttendanceSlip  WHERE AttendanceSlip_ID = ?", del) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Attendance Slip doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Attendance Slip ID.");
                    sc.next(); 
                }
            }
                
                    conni.deleteEmployee(sqldelete, del);
                    break;
                case 5:
                    System.out.println("Exiting......");
                    break;
                
            }
            System.out.println("");
            System.out.print("Do you want to continue? Yes or No: ");
            res = sc.next();
    }while(res.equalsIgnoreCase("yes"));
        
    }
    
    
    
    
    
    
    
    
    
}
