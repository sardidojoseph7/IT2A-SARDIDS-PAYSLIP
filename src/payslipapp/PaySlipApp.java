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
                System.out.print("Are you an HR?Yes or No: ");
                        String res = sc.next();

                        if (res.equalsIgnoreCase("yes")) {

                        System.out.print("Enter HR password: ");
                        String hrPassword = sc.next();

                        final String HR_PASSWORD = "admin1234";


                        if (hrPassword.equals(HR_PASSWORD)) {
                           PaySlip ps = new PaySlip();
                           ps.mainPaySlip();
                            
                        } else {
                            System.out.println("Invalid HR password. Access denied.");
                        }
                    } else {
                        System.out.println("You do not have permission to access HR-only features.");
                    }
                break;
            case 5:
                System.out.println("Are you sure you want to Exit? Yes or No: ");
                String response = sc.next();
                if(response.equalsIgnoreCase("yes")){
                    exit = false;
                }
                break;
            
            
            
        }
        
        }while(exit);
    }
}
