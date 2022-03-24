package mycontribution;

public class MediSave extends Account{
    public MediSave(Contributor contributor, String accountType) {
        super(contributor, accountType);
    }

    @Override
    public double getContributionRate() {
        return 0.08;
    }
}
