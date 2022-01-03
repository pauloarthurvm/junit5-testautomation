package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass {

//    accessModifier returnType nameOfMethod(params)
    @Test
    void firstMethod() {
        System.out.println("First test");
    }

    @Test
    @DisplayName("secondMethod")
    void secondMethod() {
        System.out.println("Second test");
    }

}
