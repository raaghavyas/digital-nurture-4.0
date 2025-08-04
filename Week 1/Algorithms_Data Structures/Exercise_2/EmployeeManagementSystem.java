/*
Employee Management System
Scenario: 
You are developing an employee management system for a company. Efficiently managing employee records is crucial.
Steps:
1.Understand Array Representation:
  Explain how arrays are represented in memory and their advantages.
2.Setup:
  Create a class Employee with attributes like employeeId, name, position, and salary.
3.Implementation:
  Use an array to store employee records.
  Implement methods to add, search, traverse, and delete employees in the array.
4.Analysis:
  Analyze the time complexity of each operation (add, search, traverse, delete).
  Discuss the limitations of arrays and when to use them.
*/

// Main.java

package EmpMangement;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(1, "Alice", "Manager", 70000));
        manager.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        manager.addEmployee(new Employee(3, "Charlie", "Analyst", 50000));

        manager.displayAllEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        Employee found = manager.searchEmployee(2);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee with ID 1...");
        manager.deleteEmployee(1);

        manager.displayAllEmployees();
    }
}

// Employee
package EmpMangement;

public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String toString() {
        return "ID: " + employeeId + ", Name: " + name +
               ", Position: " + position + ", Salary: ₹" + salary;
    }
}

// EmployeeManager
package EmpMangement;

public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
            System.out.println("Employee added: " + e);
        } else {
            System.out.println("Employee array is full. Cannot add more.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("Employee List:");
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--count] = null;
        System.out.println("Employee with ID " + employeeId + " deleted.");
    }
}
