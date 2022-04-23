package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollMain<PayrollDetails> {
	Scanner SC = new Scanner(System.in);

    public enum IOService {CONSALE_IO, FILE_IO, DB_IO, REST_IO, ioType}

    private List<PayrollDetails> employeePayrollList;

    public PayrollMain() {
        this.employeePayrollList = new employeePayrollList();
    }

    public PayrollMain(List<PayrollDetails> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<PayrollDetails> employeePayrollList = new ArrayList<>();
        PayrollMain employeePayrollService = new PayrollMain(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.ioType);
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

    public void writeEmployeePayrollData(IOService ioType) {
        if (ioType.equals(IOService.CONSALE_IO)) {
            for (PayrollDetails o : employeePayrollList)
                System.out.println(o.toString());
        } else if (ioType.equals(IOService.FILE_IO)) {
            new EmpIOService().writeData(employeePayrollList);
        }
    }

    public long countEnteries(IOService ioType) {
        if (ioType.equals(IOService.FILE_IO))
            return new EmpIOService().countEntries();
        return 0;
    }
}

