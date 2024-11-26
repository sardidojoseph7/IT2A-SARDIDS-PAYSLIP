package payslipapp;

import java.util.Scanner;


public class PaySlipApp {

    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        do{
            System.out.println("");
        System.out.println(" -------------------------------");   
        System.out.println(" | 1. Employee                 |");
        System.out.println(" | 2. Department               |");
        System.out.println(" | 3. Attendance Slip          |");
        System.out.println(" | 4. Payslip                  |");
        System.out.println(" | 5. Exit the application     |");
        System.out.println(" -------------------------------"); 
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
                Employee em = new Employee();
               em.mainEmployee();
                break;
            case 2:
                Department dp = new Department();
                dp.mainDepartment();
                break;
            case 3:
                AttendanceSlip as = new AttendanceSlip();
           as.mainAttendanceSlip();
                break;
            case 4:
                PaySlip ps = new PaySlip();
                ps.mainPaySlip();              
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
