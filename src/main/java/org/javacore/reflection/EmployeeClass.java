package org.javacore.reflection;

/**
 * <p>
 * 
 * <pre>
 * 反射在继承中的案例
 * </pre>
 * </p>
 * 
 * @author taomk
 * @since 2016-8-3 11:05
 */
class Employee {
	
    private String name;
    
    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
}

public class EmployeeClass {
    public static void main(String[] args) {
        Employee employee = new Employee("Jeff");
        Employee manager = new Manager("Boss");
        System.out.println(employee.getClass().getName() + " " + employee.getName());
        System.out.println(manager.getClass().getName() + " " + manager.getName());
    }
}
