package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollMain {
	Scanner SC = new Scanner(System.in);

    public enum Ioservice {CONSALE_IO, FILE_IO, DB_IO, REST_IO}

    private List<PayrollDetails> employeePayrollList;

    public PayrollMain() {
        this.employeePayrollList = new ArrayList<PayrollDetails>();
    }

    public PayrollMain(List<PayrollDetails> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<PayrollDetails> employeePayrollList = new ArrayList<PayrollDetails>();
        PayrollMain employeePayrollService = new PayrollMain(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }

    public void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id:");
        int employeeId = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name:");
        String employeeName = consoleInputReader.next();
        System.out.println("Enter Employee Salary:");
        double employeeSalary = consoleInputReader.nextDouble();
        employeePayrollList.add(new PayrollDetails(employeeId, employeeName, employeeSalary));
    }

    public void writeEmployeePayrollData() {
        System.out.println("\nWriting Employee Payroll Roaster to Cansole\n" + employeePayrollList);
    }
}

