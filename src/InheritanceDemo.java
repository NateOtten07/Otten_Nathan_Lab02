import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("123456", "John", "Smith", "Mr.", 2000, 20));
        workers.add(new Worker("123457", "Jimmy", "Guy", "Mr.", 2001, 22));
        workers.add(new Worker("123458", "Bob", "Jones", "Mr.", 2002, 19));

        workers.add(new SalaryWorker("123459", "Guy", "Man", "Mr.", 1999, 20, 75000));
        workers.add(new SalaryWorker("123460", "Billy", "Beamin", "Mr.", 1998, 20, 85000));
        workers.add(new SalaryWorker("123461", "Joey", "Votto", "Mr.", 1997, 20, 90000));

        int[] weeklyHours = {40, 50, 40};


        System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s\n", "ID", "First Name", "Last Name", "Week1", "Week2", "Week3");
        System.out.println("--------------------------------------------------------------------");

        for (Worker w : workers) {
            System.out.printf("%-10s %-15s %-15s", w.getID(), w.getFirstName(), w.getLastName());

            for (int hours : weeklyHours) {
                double weeklyPay = w.calculateWeeklyPay(hours);
                System.out.printf(" $%-9.2f", weeklyPay);
            }

            System.out.println();
        }
    }
}
