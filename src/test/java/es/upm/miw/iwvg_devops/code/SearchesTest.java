package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

public class SearchesTest {

    @Test
    public void testFindUserIdBySomeProperFraction() {
        assertEquals(List.of("1", "2", "3", "5"),
                new Searches().findUserIdBySomeProperFraction().collect(Collectors.toList()));
    }

    @Test
    public void testFindFractionAdditionByUserId() {
        assertEquals(2,
                new Searches().findFractionAdditionByUserId("4").getNumerator());
        assertEquals(1,
                new Searches().findFractionAdditionByUserId("4").getDenominator());

        assertEquals(109,
                new Searches().findFractionAdditionByUserId("2").getNumerator());
        assertEquals(30,
                new Searches().findFractionAdditionByUserId("2").getDenominator());
    }

    @Test
    public void testFindUserNameBySomeImproperFraction() {
        assertEquals(List.of("Oscar", "Ana", "Oscar", "Antonio", "Paula"),
                new Searches().findUserNameBySomeImproperFraction().collect(Collectors.toList()));
    }

    @Test
    public void testFindFractionSubtractionByUserName() {
        assertEquals(11,
                new Searches().findFractionSubtractionByUserName("Ana").getNumerator());
        assertEquals(30,
                new Searches().findFractionSubtractionByUserName("Ana").getDenominator());

        assertEquals(-3,
                new Searches().findFractionSubtractionByUserName("Oscar").getNumerator());
        assertEquals(1,
                new Searches().findFractionSubtractionByUserName("Oscar").getDenominator());

        assertEquals(0,
                new Searches().findFractionSubtractionByUserName("Antonio").getNumerator());
        assertEquals(0,
                new Searches().findFractionSubtractionByUserName("Antonio").getDenominator());
    }

}
