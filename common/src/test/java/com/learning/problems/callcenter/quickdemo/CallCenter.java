package com.learning.problems.callcenter.quickdemo;

import java.util.ArrayList;
import java.util.Stack;

public class CallCenter {

    static ArrayList<Employee> respondents = new ArrayList<Employee>();
    static ArrayList<Employee> managers = new ArrayList<Employee>();
    static ArrayList<Employee> directors = new ArrayList<Employee>();
    static Stack<Employee> stack = new Stack<Employee>();

    public static void main(String args[]) {
        createStaff();
        respondents.get(0).status = false;
        managers.get(0).status = false;
        directors.get(0).status = false;
        directors.get(1).status = false;
        Call c1 = new Call(0,8);
        Call c2 = new Call(1,10);
        Call c3 = new Call(2,30);
        System.out.println(handleCall(c1));
        System.out.println(handleCall(c2));
        System.out.println(handleCall(c3));



    }

    private static void createStaff() {

        for (int i = 0; i < 30; i++) {
            Employee e = new Employee(i, i, true);
            if (i < 10)
                respondents.add(e);
            else if (10 <= i && i < 20)
                managers.add(e);
            else
                directors.add(e);
        }
    }

    private static String handleCall(Call c) {
        String str = "";
        // respondents;
        for (Employee e : respondents) {
            if (e.status == true) {
                stack.add(e);
                e.status = false;
                break;
            }
        }

        if (c.hardLevel < 10)
            return str += "Respondent " + stack.peek().number
                    + " handled the call";

            // ，forward to manager
        else if (c.hardLevel >= 10 && c.hardLevel < 20) {
            for (Employee e : managers) {
                if (e.status == true) {
                    stack.pop().status = true;
                    stack.add(e);
                    e.status = false;
                    return str = "Manager " + stack.peek().number
                            + " handled the call";
                }
            }
        }
        // ，forward to director
        for (Employee e : directors) {
            if (e.status == true) {
                stack.pop().status = true;
                stack.add(e);
                e.status = false;
                return str = "Director " + stack.peek().number
                        + " handled the call";
            }
        }

        return str = "System is busy, please wait";
    }

    private static class Employee {
        int number;// 0-9 are respondents; 10-19 are managers; 20-29 are//
        //directors;
        int level;
        boolean status;

        public Employee(int num, int level, boolean status) {
            this.number = num;
            this.level = level;
            this.status = status;
        }

    }

    private static class Call {
        int caller;
        int hardLevel;

        public Call(int caller, int hardLevel) {
            this.caller = caller;
            this.hardLevel = hardLevel;
        }

    }

}
