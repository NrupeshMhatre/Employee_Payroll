package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollMain {
	public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    public static final Scanner SC = new Scanner(System.in);
    private List<PayrollDetails> employeeList;

    public PayrollMain() {
        this.employeeList = new ArrayList<PayrollDetails>();
    }

    public PayrollMain(List<PayrollDetails> employeeList) {
        this.employeeList = employeeList;
    }

    public void readEmployeeData() {
        System.out.println("Enter employee id:");
        int employeeId = SC.nextInt();
        System.out.println("Enter employee name:");
        SC.nextLine();
        String employeeName = SC.nextLine();
        System.out.println("Enter employee salary:");
        double employeeSalary = SC.nextDouble();
        PayrollDetails newEmployee = new PayrollDetails(employeeId, employeeName, employeeSalary);
        employeeList.add(newEmployee);
    }

    public void writeEmployeeDdate(IOService ioType) {
        if (ioType.equals(IOService.CONSOLE_IO)) {
            for (PayrollDetails o : employeeList)
                System.out.println(o.toString());
        } else if (ioType.equals(IOService.FILE_IO)) {
            new EmpIOService().writeData(employeeList);
        }
    }

    public long countEnteries(IOService ioType) {
        if (ioType.equals(IOService.FILE_IO))
            return new EmpIOService().countEntries();
        return 0;
    }

    public void printEmployeePayrollData() {
        new EmpIOService().printEmployeePayrolls();
    }
}

