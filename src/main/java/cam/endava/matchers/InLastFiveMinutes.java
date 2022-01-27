package cam.endava.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.time.LocalDateTime;

public class InLastFiveMinutes extends TypeSafeMatcher<LocalDateTime> {


    @Override
    protected boolean matchesSafely(LocalDateTime actual) {
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
        return actual.isAfter(fiveMinutesAgo) && actual.isBefore(LocalDateTime.now());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("date is not in last five minutes");
    }

    public static InLastFiveMinutes inLastFiveMinutes(){
        return new InLastFiveMinutes();
    }

}
