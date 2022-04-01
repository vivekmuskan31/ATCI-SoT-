package mycontribution;

public class Special extends Account{
    public Special(Contributor contributor, String accountType) {
        super(contributor, accountType);
    }

    @Override
    public double getContributionRate() {
        return 0.07;
    }
}
