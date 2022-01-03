package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisableEnabledTest {

    @Test
    @Disabled(value = "Disabled for demo of @Disabled")
    void firstTest() {
        System.out.println("First test");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled to demo @DisabledOnOS")
    void secondTest() {
        System.out.println("Second test");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "stage",
            disabledReason = "Disabled for demo of @DisabledIfSystemProperty")
    void thirdTest() {
        System.out.println("Third test");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of @DisabledIf")
    void fourthTest() {
        System.out.println("Fourth test");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    @Test
    void fifthTest() {
        System.out.println("Fifth test");
    }

}
