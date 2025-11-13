import java.util.*;

class Employee {
    int id; String name, role; double basic, hra, da, tax, ded, net;

    Employee(int id, String name, String role, double basic) {
        this.id = id; this.name = name; this.role = role; this.basic = basic;
        calcSalary();
    }

    void calcSalary() {
        hra = 0.2 * basic; da = 0.1 * basic;
        tax = 0.1 * (basic + hra + da);
        ded = 0.05 * basic;
        net = (basic + hra + da) - (tax + ded);
    }

    void payslip() {
        System.out.println("\n--- PAYSLIP ---");
        System.out.println("ID: " + id + " | Name: " + name + " | Role: " + role);
        System.out.println("Basic: " + basic + " | Net Salary: " + net);
    }
}

public class Payroll {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Employee> emp = new HashMap<>();

    public static void main(String[] a) {
        while (true) {
            System.out.println("\n1.Add 2.View 3.Search 4.Update 5.Payslip 6.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> add();
                case 2 -> emp.values().forEach(e -> System.out.println(e.id + " " + e.name + " " + e.role + " " + e.net));
                case 3 -> search();
                case 4 -> update();
                case 5 -> payslip();
                case 6 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Invalid!");
            }
        }
    }

    static void add() {
        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Role: "); String r = sc.nextLine();
        System.out.print("Basic Salary: "); double b = sc.nextDouble();
        emp.put(id, new Employee(id, n, r, b));
        System.out.println("Added!");
    }

    static void search() {
        System.out.print("Enter ID: "); int id = sc.nextInt();
        if (emp.containsKey(id)) emp.get(id).payslip(); else System.out.println("Not found!");
    }

    static void update() {
        System.out.print("Enter ID to update: "); int id = sc.nextInt();
        if (emp.containsKey(id)) {
            sc.nextLine();
            System.out.print("New Name: "); String n = sc.nextLine();
            System.out.print("New Role: "); String r = sc.nextLine();
            System.out.print("New Basic: "); double b = sc.nextDouble();
            emp.put(id, new Employee(id, n, r, b));
            System.out.println("Updated!");
        } else System.out.println("Not found!");
    }

    static void payslip() {
        System.out.print("Enter ID: "); int id = sc.nextInt();
        if (emp.containsKey(id)) emp.get(id).payslip(); else System.out.println("Not found!");
    }
}