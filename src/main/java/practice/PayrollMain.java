package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollMain {
	 public enum IOService{
	        CONSOLE_IO, FILE_IO,
	    }

	    private List<PayrollDetails> employeePayrollList;

	    public PayrollMain() {
	        employeePayrollList = new ArrayList<>();
	    }

	    public static void main(String[] args) {
	    	PayrollMain service = new PayrollMain();

	        service.readEmployeePayrollData(IOService.CONSOLE_IO);
	        service.writeEmployeePayrollData(IOService.CONSOLE_IO);
	    }

	    public void readEmployeePayrollData(IOService ioService) {
	        if (ioService.equals(IOService.CONSOLE_IO)) {
	            Scanner consoleScn = new Scanner(System.in);
	            System.out.println("Enter the Employee Id : ");
	            int id = consoleScn.nextInt();

	            System.out.println("Enter the Employee Name : ");
	            String name = consoleScn.next();

	            System.out.println("Enter the Employee Salary : ");
	            double salary = consoleScn.nextDouble();
	            consoleScn.close();
	            employeePayrollList
	                    .add(new PayrollDetails(id, name, salary));
	        } else if(ioService.equals(IOService.FILE_IO)) {
	        	EmpIOService fileService = new EmpIOService();
	            fileService.readData();
	        }
	    }

	    public void writeEmployeePayrollData(IOService ioService) {
	        if (ioService.equals(IOService.CONSOLE_IO)) {
	            System.out.println("All Employee Payroll details : "
	                    + employeePayrollList);
	        } else if (ioService.equals(IOService.FILE_IO)) {
	        	EmpIOService fileService = new EmpIOService();
	            fileService.writeData(employeePayrollList);
	        }

	    }

	    public long countEntries(IOService ioService) {
	        long entries = 0;
	        EmpIOService fileService = new EmpIOService();
	        entries = fileService.countEntries();
	        return entries;
	    }

	    public void printData(IOService ioService) {
	        new EmpIOService().printData();
	    }
}

