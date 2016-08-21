/**
 * Created by ScorpionOrange on 2016/06/11.
 */
public class ParamTest {
    public static void main(String[] args){
        /*
         * Test 1: Methods can not modify numeric parameters.
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);

        /*
         * Test 2: Methods can change the state of object parameters.
         */
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Herry",50000);
        System.out.println("Before: salary = " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary = " + harry.getSalary());

        /*
         * Test 3: Methods cannot attach new object to object parameters.
         */
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice",70000);
        Employee b = new Employee("Bob",60000);
        System.out.println("Before: a = " + a.getName());
        System.out.println("Before: b = " + b.getName());
        swap(a, b);
        System.out.println("After: a = " + a.getName());
        System.out.println("After: b = " + b.getName());
    }

    //Method that do not works
    public static void tripleValue(double x){
        x = 3 * x;
        System.out.println("End of method: x = " + x);
    }

    //Method that might works
    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.out.println("End of method: salary = " + x.getSalary());
    }

    public static void swap(Employee x, Employee y){
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x = " + x.getName());
        System.out.println("End of method: y = " + y.getName());
    }
}

//simplified Employee class
class Employee {
    private String name;
    private double salary;

    public Employee(String aname, double asalary){
        name = aname;
        salary = asalary;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public void raiseSalary(double byPercent){
        salary = salary * (1 + byPercent / 100);
    }
}
