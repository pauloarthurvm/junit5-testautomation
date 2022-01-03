package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//This is to dont have to create static non-test methods

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    @BeforeAll
    void beforeAll() {
        System.out.println("-- This is beforeAll() method.");
    }

    @BeforeEach
    void beforeEah() {
        System.out.println("---- This is beforeEach() method.");
    }

    @AfterAll
    void afterAll() {
        System.out.println("-- This is afterAll() method.");
    }

    @AfterEach
    void afterEach() {
        System.out.println("---- This is afterEach() method.");
    }

//    accessModifier returnType nameOfMethod(params)
    @Test
    @Tag("sanity")
    void firstMethod() {
        System.out.println("First test");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("USER2374 - TC2356 - TestCase information")
    void secondMethod() {
        System.out.println("Second test");
    }

    @Test
    @Tag("acceptance")
    void thirdMethod() {
        System.out.println("Third test");
    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {77, 88, 99})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

}
