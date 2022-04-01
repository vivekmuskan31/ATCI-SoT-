package com.sot.exercise.junit;

public class Contribution {

    private String contributionDate;
    private double contributionAmount;

    public Contribution(String contributionDate, double contributionAmount) {
        this.contributionDate = contributionDate;
        this.contributionAmount = contributionAmount;
    }

    public String getContributionDate() {
        return contributionDate;
    }

    public void setContributionDate(String contributionDate) {
        this.contributionDate = contributionDate;
    }

    public double getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(double contributionAmount) {
        this.contributionAmount = contributionAmount;
    }
}
