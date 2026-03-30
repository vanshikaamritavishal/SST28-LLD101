package services;

import models.PricingRule;
import models.Seat;
import models.Show;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class PricingService {
    public double calculatePrice(Show show, List<Seat> seats) {
        double base = show.getMovie().getBasePrice();
        List<PricingRule> appliedRules = new ArrayList<>();
        double multiplier = 1.0;

        if (show.getStartTime().getDayOfWeek() == DayOfWeek.SATURDAY ||
                show.getStartTime().getDayOfWeek() == DayOfWeek.SUNDAY) {
            appliedRules.add(new PricingRule("Weekend Surge", 1.2));
            multiplier *= 1.2;
        }

        int hour = show.getStartTime().getHour();
        if (hour >= 18 && hour <= 23) {
            appliedRules.add(new PricingRule("Prime Time", 1.3));
            multiplier *= 1.3;
        }

        return base * seats.size() * multiplier;
    }
}