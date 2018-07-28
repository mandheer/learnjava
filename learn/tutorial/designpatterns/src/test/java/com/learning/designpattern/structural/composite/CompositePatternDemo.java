package com.learning.designpattern.structural.composite;

public class CompositePatternDemo {

    public static void main(String[] args){
        Employee CEO = new Employee("John", "CEO", 30_000);
        Employee headSales = new Employee("Robert", "Head Sales", 20_000);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20_000);
        Employee clerk1= new Employee("Laura","Marketing",10_000);
        Employee clerk2= new Employee("Bob","Marketing",10_000);

        Employee salesExecutive1 = new Employee("Richard","Sales",10_000);
        Employee salesExecutive2 = new Employee("Rob","Sales",10_000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //print all employees of the organisation
        System.out.println(CEO);

        for (Employee headEmployee: CEO.getSubordinates()){
            System.out.println(headEmployee);
            for(Employee employee:headEmployee.getSubordinates()){
                System.out.println(employee);
            }
        }
    }
}
