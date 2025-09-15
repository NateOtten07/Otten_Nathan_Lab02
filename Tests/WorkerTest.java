import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    private Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker("123456", "Jimmy", "Bob", "Mr.", 1990, 20.0);
    }

    @Test
    void testGetAndSetHourlyRate() {
        assertEquals(20.0, worker.getHourlyRate());

        worker.setHourlyRate(25.0);
        assertEquals(25.0, worker.getHourlyRate());
    }

    @Test
    void testCalculateWeeklyPay_NoOvertime() {
        double weeklyPay = worker.calculateWeeklyPay(40);
        assertEquals(800.0, weeklyPay, 0.01, "40 hours @ $20/hr should be $800");
    }

    @Test
    void testCalculateWeeklyPay_WithOvertime() {
        double weeklyPay = worker.calculateWeeklyPay(50);
        assertEquals(1100.0, weeklyPay, 0.01, "50 hours should be $1100 total");
    }

    @Test
    void testToCSV() {
        worker.calculateWeeklyPay(40); // ensures pay fields are updated
        String csv = worker.toCSV();
        assertTrue(csv.contains("hourlyRate=20.0"), "CSV should contain hourlyRate");
    }

    @Test
    void testToJSON() {
        worker.calculateWeeklyPay(40);
        String json = worker.toJSON();
        assertTrue(json.contains("\"HourlyRate\":20.0"), "JSON should contain hourlyRate");
        assertTrue(json.contains("\"TotalPay\":800.0"), "JSON should contain totalPay");
    }

    @Test
    void testToXML() {
        worker.calculateWeeklyPay(50);
        String xml = worker.toXML();
        assertTrue(xml.contains("<hourlyRate>20.0</hourlyRate>"));
        assertTrue(xml.contains("<totalPay>1100.0</totalPay>"));
    }
}
