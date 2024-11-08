
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
                    System.out.println("Invalid input. Please enter a integer Department ID.");
                    sc.next(); 
                }
            }

       
                
       System.out.print("No of. Working Days: ");
       int days = sc.nextInt();
       System.out.print("No. of Late Days: ");
       int late = sc.nextInt();
       System.out.print("No. of Absences: ");
       int absent = sc.nextInt();
       System.out.print("Loan: ");
       double loan = sc.nextDouble();
       
       
       
       
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

                    System.out.print("Enter new no of working days: ");
                    int nework = sc.nextInt();
                    System.out.print("Enter new no of Later Days: ");
                    int newlate = sc.nextInt();
                    System.out.print("Enter new Absences: ");
                    int newab = sc.nextInt();
                    System.out.print("Enter  new Loan: ");
                    double newloan = sc.nextDouble();
                    
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
