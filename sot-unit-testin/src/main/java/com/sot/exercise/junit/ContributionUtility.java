package com.sot.exercise.junit;

import java.util.ArrayList;
import java.util.List;

public class ContributionUtility {

    private List<Contribution> contributionList = new ArrayList<>();

    public List<Contribution> getContributionList() {
        return contributionList;
    }

    public void addContribution(Contribution contribution){
        // Validate Contribution
        if(contribution.getContributionDate() == null) return;
        contributionList.add(contribution);
    }

    public  void updateContribution(String date, Contribution contribution){
        for(int i=0;i<contributionList.size();i++){
            if(contributionList.get(i).getContributionDate().equals(date)){
                contributionList.set(i, contribution);
            }
        }
    }
}
