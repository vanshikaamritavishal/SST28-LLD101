package models;

public class PricingRule {
    private String ruleName;
    private double multiplier;

    public PricingRule(String ruleName, double multiplier) {
        this.ruleName = ruleName;
        this.multiplier = multiplier;
    }

    public String getRuleName() {
        return ruleName;
    }

    public double getMultiplier() {
        return multiplier;
    }
}