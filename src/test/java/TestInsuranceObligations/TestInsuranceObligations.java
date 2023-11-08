package TestInsuranceObligations;

import Insurance.InsuranceObligations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


public class TestInsuranceObligations {
    private InsuranceObligations obligations;

    @BeforeEach
    public void setUp() {
        obligations = new InsuranceObligations("Policy123", "AP", 1000, 0.1);
    }

    @Test
    public void testGetPolicyNumber() {
        assertEquals("Policy123", obligations.getPolicyNumber());
    }

    @Test
    public void testGetPolicyType() {
        assertEquals("AP", obligations.getPolicyType());
    }

    @Test
    public void testGetValue() {
        assertEquals(1000, obligations.getValue(), 0.01);
    }

    @Test
    public void testCalculateCost() {
        assertEquals(100.0, obligations.calculateCost(), 0.01);
    }

    @Test
    public void testGetLevelRisk() {
        assertEquals(0.1, obligations.getLevelRisk(), 0.01);
    }

    @Test
    public void testToString() {
        String expected = "InsuranceObligations{policyNumber='Policy123', policyType='AP', value=1000.0, LevelRisk=0.1}";
        assertEquals(expected, obligations.toString());
    }

    @Test
    public void testFromString() {
        String line = "InsuranceObligations{policyNumber='Policy789', policyType='LI', value=1500.0, LevelRisk=0.15}";
        InsuranceObligations parsedObligations = InsuranceObligations.fromString(line);
        assertNotNull(parsedObligations);
        assertEquals("Policy789", parsedObligations.getPolicyNumber());
        assertEquals("LI", parsedObligations.getPolicyType());
        assertEquals(1500, parsedObligations.getValue(), 0.01);
        assertEquals(0.15, parsedObligations.getLevelRisk(), 0.01);
    }
}
