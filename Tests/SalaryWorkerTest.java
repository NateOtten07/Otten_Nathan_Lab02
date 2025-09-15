import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {

    private SalaryWorker salaryWorker;

    @BeforeEach
    void setUp() {
        salaryWorker = new SalaryWorker("123789", "Alice", "Johnson", "Ms.", 1995, 25.0, 104000.0);
    }

    @Test
    void testGetAndSetAnnualSalary() {
        assertEquals(104000.0, salaryWorker.getAnnualSalary());

        salaryWorker.setAnnualSalary(78000.0);
        assertEquals(78000.0, salaryWorker.getAnnualSalary());
    }

    @Test
    void testCalculateWeeklyPay() {
        double expected = 104000.0 / 52.0;
        assertEquals(expected, salaryWorker.calculateWeeklyPay(40), 0.01);
        assertEquals(expected, salaryWorker.calculateWeeklyPay(60), 0.01);
        assertEquals(expected, salaryWorker.calculateWeeklyPay(0), 0.01);
    }

    @Test
    void testToCSV() {
        String csv = salaryWorker.toCSV();
        assertTrue(csv.contains("annualSalary=104000.0"), "CSV should contain annualSalary");
    }

    @Test
    void testToJSON() {
        String json = salaryWorker.toJSON();
        assertTrue(json.contains("\"AnnualSalary\":104000.0"), "JSON should contain AnnualSalary");
        assertTrue(json.contains("\"HourlyRate\":25.0"), "JSON should contain HourlyRate");
    }

    @Test
    void testToXML() {
        String xml = salaryWorker.toXML();
        assertTrue(xml.contains("<annualSalary>104000.0</annualSalary>"));
        assertTrue(xml.contains("<hourlyRate>25.0</hourlyRate>"));
    }
}
