public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, String title, int YOB,
                        double hourlyRate, double annualSalary) {
        super(ID, firstName, lastName, title, YOB, hourlyRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52.0;
    }

    @Override
    public void displayWeeklyPay(double weeklyPay) {
        System.out.printf("%-20s %10s%n", "Title", "Amount");
        System.out.printf("%-20s %10.2f%n", "Annual Salary", annualSalary);
        System.out.printf("%-20s %10.2f%n", "Weekly Pay (1/52)", weeklyPay);

        System.out.println();
        System.out.println("JSON Output:");
        System.out.println(toJSON());

        System.out.println();
        System.out.println("XML Output:");
        System.out.println(toXML());
    }

    // Overload toCSV, toJSON, toXML (with annualSalary)
    @Override
    public String toCSV() {
        return super.toCSV() + ", annualSalary=" + annualSalary;
    }

    @Override
    public String toJSON() {
        return "{ \"ID\":\"" + this.getID() + "\", " +
                "\"firstName\":\"" + this.getFirstName() + "\", " +
                "\"lastName\":\"" + this.getLastName() + "\", " +
                "\"title\":\"" + this.getTitle() + "\", " +
                "\"YOB\":" + this.getYOB() + ", " +
                "\"HourlyRate\":" + this.getHourlyRate() + ", " +
                "\"AnnualSalary\":" + this.getAnnualSalary() + " }";
    }

    @Override
    public String toXML() {
        return "<SalaryWorker>" +
                "<ID>" + this.getID() + "</ID>" +
                "<firstName>" + this.getFirstName() + "</firstName>" +
                "<lastName>" + this.getLastName() + "</lastName>" +
                "<title>" + this.getTitle() + "</title>" +
                "<YOB>" + this.getYOB() + "</YOB>" +
                "<hourlyRate>" + this.getHourlyRate() + "</hourlyRate>" +
                "<annualSalary>" + this.getAnnualSalary() + "</annualSalary>" +
                "</SalaryWorker>";
    }
}
