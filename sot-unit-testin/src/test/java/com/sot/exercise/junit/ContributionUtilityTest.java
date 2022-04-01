package com.sot.exercise.junit;

import com.sot.exercise.junit.Contribution;
import com.sot.exercise.junit.ContributionUtility;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ContributionUtilityTest {

    @Test
    public void getContributionListEmptyTest() {
        var contributionUtility = new ContributionUtility();
        assertEquals(
                contributionUtility
                        .getContributionList()
                        .isEmpty(), true);
    }

    @Test
    public void addOneContributionTest() {
        Contribution c = new Contribution("01-04-2022", 1000d);
        ContributionUtility cu = new ContributionUtility();
        int currSize = cu.getContributionList().size();
        cu.addContribution(c);
        int newSize = cu.getContributionList().size();
        assertEquals("Size not increased on adding new contribution", newSize, currSize + 1);

        if (newSize == currSize + 1) {
            Contribution updatedContri = cu.getContributionList().get(currSize);
            assertEquals("Contribution Date mismatch",
                    updatedContri.getContributionDate(),
                    c.getContributionDate());

            assertEquals("Contribution Amount mismatch",
                    updatedContri.getContributionAmount(),
                    c.getContributionAmount(), 0.001d);
        }

    }

    @Test
    public void addTwoContributionTest() {
        Contribution c1 = new Contribution("01-04-2022", 1000d);
        Contribution c2 = new Contribution("02-04-2022", 2000d);
        ContributionUtility cu = new ContributionUtility();
        int currSize = cu.getContributionList().size();
        cu.addContribution(c1);
        cu.addContribution(c2);
        int newSize = cu.getContributionList().size();
        assertEquals("Size not increased on adding two new contribution", newSize, currSize + 2);

        if (newSize == currSize + 2) {
            Contribution updatedContri1 = cu.getContributionList().get(currSize);
            Contribution updatedContri2 = cu.getContributionList().get(currSize + 1);
            assertEquals("Date mismatch for 1st Contribution",
                    updatedContri1.getContributionDate(),
                    c1.getContributionDate());

            assertEquals("Amount mismatch for 1st Contribution",
                    updatedContri1.getContributionAmount(),
                    c1.getContributionAmount(), 0.001d);

            assertEquals("Date mismatch for 2nd Contribution",
                    updatedContri2.getContributionDate(),
                    c2.getContributionDate());

            assertEquals("Amount mismatch for 2nd Contribution",
                    updatedContri2.getContributionAmount(),
                    c2.getContributionAmount(), 0.001d);
        }

    }

    @Test
    public void updateContributionTest() {
        Contribution c1 = new Contribution("01-04-2022", 1000d);
        Contribution c2 = new Contribution("02-04-2022", 1000d);
        ContributionUtility cu = new ContributionUtility();
        cu.addContribution(c1);
        cu.updateContribution("01-04-2022", c2);
        for(Contribution c : cu.getContributionList()){
            if(c.getContributionDate().equals(c2.getContributionDate())){
                assertSame("Contribution not Updated", c2, c);
            }
        }

    }
}

