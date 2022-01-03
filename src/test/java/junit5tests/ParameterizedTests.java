package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Objects;

public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {77, 88, 99})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"fisrtString", "secondString"})
    void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel", "bucky,barnes"})
    void csvSource_StringString(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,21,false", "bucky,61,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve, rogers'", "winter soldier,'bucky, barnes'"})
    void csvSource_StringWithComa(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"},
            numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String unit, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty +
                ", unit = " + unit + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv",
            numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_SpecifiedDelimiterWithEmptyAndNullValues(String name, double price, int qty, String unit, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty +
                ", unit = " + unit + ", provider = " + provider);
    }

}
