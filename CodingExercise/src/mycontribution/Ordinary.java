package mycontribution;

public class Ordinary extends Account {

    public Ordinary(Contributor contributor, String accountType) {
        super(contributor, accountType);
    }

    @Override
    public double getContributionRate() {
        return 0.06;
    }
}
