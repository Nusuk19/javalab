package TestDerivative;

import Derivative.Derivative;
import Insurance.InsuranceObligations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestDerivative {
    private Derivative derivative;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
    }

    @Test
    public void testAddContracts() {
        InsuranceObligations contract = new InsuranceObligations("Policy123", "AP",1000, 0.1);
        derivative.addContracts(contract);
        List<InsuranceObligations> contracts = derivative.getContracts();
        assertTrue(contracts.contains(contract));
    }

    @Test
    public void testCalculateTotalCost() {
        InsuranceObligations contract1 = new InsuranceObligations("Policy123", "AP", 1000, 0.1);
        InsuranceObligations contract2 = new InsuranceObligations("Policy456", "AP", 2000, 0.2);
        derivative.addContracts(contract1);
        derivative.addContracts(contract2);


        double totalCost = derivative.CalculateTotalCost();

        assertEquals(500.0, totalCost, 0.01);
    }

    @Test
    public void testSortByRiskLevel() {
        InsuranceObligations contract1 = new InsuranceObligations("Policy123","AP", 1000, 0.1);
        InsuranceObligations contract2 = new InsuranceObligations("Policy456", "AP",2000, 0.2);
        derivative.addContracts(contract1);
        derivative.addContracts(contract2);
        derivative.sortByRiskLevel();
        List<InsuranceObligations> contracts = derivative.getContracts();
        assertEquals(contract2, contracts.get(0));
    }

    @Test
    public void testFindContractsInRiskRange() {
        InsuranceObligations contract1 = new InsuranceObligations("Policy123", "AP",1000, 0.1);
        InsuranceObligations contract2 = new InsuranceObligations("Policy456", "AP",2000, 0.2);
        InsuranceObligations contract3 = new InsuranceObligations("Policy789", "AP",1500, 0.15);
        derivative.addContracts(contract1);
        derivative.addContracts(contract2);
        derivative.addContracts(contract3);
        List<InsuranceObligations> result = derivative.findContractsInRiskRange(0.1, 0.15);
        assertEquals(2, result.size());
    }

    @Test
    public void testRemoveContractByPolicyNumber() {
        InsuranceObligations contract1 = new InsuranceObligations("Policy123", "AP",1000, 0.1);
        InsuranceObligations contract2 = new InsuranceObligations("Policy456", "AP",2000, 0.2);
        derivative.addContracts(contract1);
        derivative.addContracts(contract2);
        assertTrue(derivative.removeContractByPolicyNumber("Policy123"));
        assertFalse(derivative.removeContractByPolicyNumber("NonExistentPolicy"));
    }
}
