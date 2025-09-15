public class Worker extends Person {
    private double hourlyRate;
    private double basePay;
    private double overtimePay;
    private double hoursWorked;

    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyRate) {
        super(ID, firstName, lastName, title, YOB);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }


    public double calculateWeeklyPay(double hoursWorked) {
        this.hoursWorked = hoursWorked;
        if (hoursWorked <= 40) {
            basePay = hoursWorked * hourlyRate;
            overtimePay = 0;
        } else {
            basePay = 40 * hourlyRate;
            overtimePay = (hoursWorked - 40) * hourlyRate * 1.5;
        }
        return basePay + overtimePay;
    }

    public void displayWeeklyPay(double weeklyPay) {
        System.out.printf("%-15s %10s%n", "Title", "Amount");
        System.out.printf("%-15s %10.2f%n", "Hours Worked", hoursWorked);
        System.out.printf("%-15s %10.2f%n", "Base Pay", basePay);
        System.out.printf("%-15s %10.2f%n", "Overtime Pay", overtimePay);
        System.out.printf("%-15s %10.2f%n", "Total Pay", weeklyPay);

        System.out.println();
        System.out.println("JSON Output:");
        System.out.println(toJSON());

        System.out.println();
        System.out.println("XML Output:");
        System.out.println(toXML());
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", hourlyRate=" + hourlyRate;
    }

    @Override
    public String toJSON() {
        return "{ \"ID\":\"" + this.getID() + "\", " +
                "\"firstName\":\"" + this.getFirstName() + "\", " +
                "\"lastName\":\"" + this.getLastName() + "\", " +
                "\"title\":\"" + this.getTitle() + "\", " +
                "\"YOB\":" + this.getYOB() + ", " +
                "\"HourlyRate\":" + this.getHourlyRate() + ", " +
                "\"BasePay\":" + basePay + ", " +
                "\"OvertimePay\":" + overtimePay + ", " +
                "\"TotalPay\":" + (basePay + overtimePay) + " }";
    }

    @Override
    public String toXML() {
        return "<Worker>" +
                "<ID>" + this.getID() + "</ID>" +
                "<firstName>" + this.getFirstName() + "</firstName>" +
                "<lastName>" + this.getLastName() + "</lastName>" +
                "<title>" + this.getTitle() + "</title>" +
                "<YOB>" + this.getYOB() + "</YOB>" +
                "<hourlyRate>" + this.getHourlyRate() + "</hourlyRate>" +
                "<basePay>" + basePay + "</basePay>" +
                "<overtimePay>" + overtimePay + "</overtimePay>" +
                "<totalPay>" + (basePay + overtimePay) + "</totalPay>" +
                "</Worker>";
    }
}
