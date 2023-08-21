package jd.movietracker.seedproviders;

import java.util.Calendar;

public class DailySeedProvider implements SeedProvider {
    public long getSeed() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTimeInMillis();
    }
}
