package payslipapp;

import java.util.Scanner;

public class PaySlip {

    public void addPayslip() {
        Config conni = new Config();
        Scanner sc = new Scanner(System.in);

        System.out.println(" - Employee List - ");
        Employee em = new Employee();
        em.viewEmployee();
        System.out.println(" - Department List - ");
        Department dp = new Department();
        dp.viewDepartment();
        System.out.println(" - Attendance Slip List - ");
        AttendanceSlip as = new AttendanceSlip();
        as.viewAttendanceSlip();

       int emid;
                while (true) {
                System.out.print("Enter Employee ID: ");
                if (sc.hasNextInt()) {
                    emid = sc.nextInt();
                    if (conni.getSingleValues("SELECT Employee_ID  FROM Employee  WHERE Employee_ID = ?", emid) != 0) {
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
                
       
          int att;
                while (true) {
                System.out.print("Enter Attendance Slip ID: ");
                if (sc.hasNextInt()) {
                    att = sc.nextInt();
                    if (conni.getSingleValues("SELECT AttendanceSlip_ID  FROM AttendanceSlip  WHERE AttendanceSlip_ID = ?", att) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Attendance Slip doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Attendance Slip ID.");
                    sc.next(); 
                }
            }


        String basic = "SELECT Basic_Salary FROM Department WHERE Department_ID = ?";
        double sala = conni.getSingleValues(basic, depid);
        String nodays = "SELECT No_of_Working_Days FROM AttendanceSlip WHERE AttendanceSlip_ID = ?";
        double noday = conni.getSingleValues(nodays, att);

        System.out.println("----------------------------------------------------------");
        double salary = noday * sala;
        System.out.println("Total Salary: " + salary);

        String de = "SELECT Late_Deduction FROM Department WHERE Department_ID = ?";
        double ded = conni.getSingleValues(de, depid);
        String late = "SELECT No_of_Late_Days FROM AttendanceSlip WHERE AttendanceSlip_ID = ?";
        double la = conni.getSingleValues(late, att);

        double LateDeduction = ded * la;

        System.out.println("Total Late Deduction: " + LateDeduction);

        String abs = "SELECT Absent_Deduction FROM Department WHERE Department_ID = ?";
        double absent = conni.getSingleValues(abs, depid);
        String abs1 = "SELECT No_of_Absences FROM AttendanceSlip WHERE AttendanceSlip_ID = ?";
        double absent2 = conni.getSingleValues(abs1, att);

        double AbsentDeduction = absent * absent2;

        String loan = "SELECT Loan FROM AttendanceSlip WHERE AttendanceSlip_ID = ?";
        double loans = conni.getSingleValues(loan, att);

        double loan1 = loans;

        System.out.println("Total Absent Deduction: " + AbsentDeduction);
        System.out.println("Total Loan: " + loan1);

        System.out.println("------------------------------------------------------------");
        double totalFinalSalary = salary - LateDeduction - AbsentDeduction;
        System.out.println("");
        System.out.println("Total Final Salary: " + totalFinalSalary);

        String sqlADD = "INSERT INTO PaySlip (Employee_ID, Department_ID, AttendanceSlip_ID, Late_Deductions, Absent_Deductions, Loans, Final_Salary) VALUES (?,?,?,?,?,?,?)";
        conni.addEmployee(sqlADD, emid, depid, att, LateDeduction, AbsentDeduction, loan1, totalFinalSalary);
    }

    public void viewPayslip() {
        String sql = "SELECT PaySlip.PaySlip_ID, Employee.First_Name, Employee.Last_Name, " +
                     "PaySlip.AttendanceSlip_ID AS PaySlip_Attendance_ID, " +
                     "Department.Department_Name, Department.Department_Head, " +
                     "PaySlip.Late_Deductions, PaySlip.Absent_Deductions, PaySlip.Loans, PaySlip.Final_Salary " +
                     "FROM PaySlip " +
                     "LEFT JOIN Employee ON Employee.Employee_ID = PaySlip.Employee_ID " +
                     "LEFT JOIN Department ON Department.Department_ID = PaySlip.Department_ID " +
                     "LEFT JOIN AttendanceSlip ON AttendanceSlip.AttendanceSlip_ID = PaySlip.AttendanceSlip_ID";

        String[] header = {"PaySlip ID", "First Name", "Last Name", "Attendance Slip ID", "Department Name", "Department Head", "Late Deductions", "Absent Deduction", "Loan", "Final Salary"};
        String[] column = {"PaySlip_ID", "First_Name", "Last_Name", "PaySlip_Attendance_ID", "Department_Name", "Department_Head", "Late_Deductions", "Absent_Deductions", "Loans", "Final_Salary"};

        Config conni = new Config();
        conni.viewdEmployee(sql, header, column);
    }
    
    
    public void mainPaySlip(){
        
        PaySlip ps = new PaySlip();
       
        Scanner sc = new Scanner(System.in);
        String res;
        do{
            System.out.println("");
            System.out.println("1. Release Payslip");
            System.out.println("2. View Payslip");
            System.out.println("3. Logout");
        int choice;
            while (true) {
                System.out.println("");
                System.out.print("Enter choice: ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 3) {
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
                    ps.addPayslip();
                    break;
                case 2:
                    ps.viewPayslip();
                   break;
                case 3:
                    System.out.println("Exiting.....");
                    break;
         
                
            }
            System.out.println("");
            System.out.print("Do you want to continue? Yes or No: ");
            res = sc.next();
    }while(res.equalsIgnoreCase("yes"));
        
        
    }
}
