import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static int regularWorkingHours = 120;

    static double HourlyRate(String empStatus) {
        double hourlyRate = 0;
        if (Objects.equals(empStatus, "entry level")) {
            hourlyRate = 850.0 / 8;
        } else if (Objects.equals(empStatus, "managerial level")){
            hourlyRate = 1150.0 / 8;
        }
        return hourlyRate;
    }

    static double Basic (int totalWorkingHours, double ratePerHour){
        if ( totalWorkingHours > regularWorkingHours )
            return (regularWorkingHours * ratePerHour);
        else
            return (totalWorkingHours * ratePerHour);
    }

    static double OvertimePay(int totalHoursWork, double ratePerHour){
        double overtimePay = 0;
        if (totalHoursWork > regularWorkingHours) {
          overtimePay = ((1.5 * ratePerHour) * (totalHoursWork - regularWorkingHours));
          overtimePay *= .10;
        }
            return overtimePay;
    }

    public static void main (String[] args) {
        int hoursWork, absences, totalWorkHours;
        int SSS = 500, PhilHealth = 300, pagIbig = 350;
        double basicSalary, finalSalary, deduction, grossIncome,bonus = 0,  ratePerHour, otPay;
        double tax = 0.10;
        String employeeStatus = "";

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter total hours work: ");
        hoursWork = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter employee status: ");
        employeeStatus = scan.nextLine();
        System.out.print("Enter absent: ");
        absences = scan.nextInt();
        scan.close();

        totalWorkHours =hoursWork - absences;
        ratePerHour =  HourlyRate(employeeStatus);
        otPay =  OvertimePay(totalWorkHours,ratePerHour);
        basicSalary = Basic(totalWorkHours, ratePerHour);
        grossIncome = basicSalary + otPay;
        deduction =   SSS + PhilHealth + pagIbig  + (grossIncome * tax);

        if(absences == 0) {
            bonus  = grossIncome * 0.2;
            finalSalary = (grossIncome - deduction) + bonus;
        } else {
            finalSalary = grossIncome - deduction;
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Employee's Position:  " + employeeStatus);
        System.out.println("Gross Salary:  " + grossIncome);
        System.out.println("Absent:  " + absences);
        System.out.println("Bonus:  " + bonus);
        System.out.println("Deduction:  -" + deduction);
        System.out.println("final Salary:  " + finalSalary);

    }
}
