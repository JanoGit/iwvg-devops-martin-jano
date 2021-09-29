package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    void testConstructors() {
        User user = new User();
        assertNotEquals(null, user.getFractions());
        assertEquals(0, user.getFractions().size());
        assertNull(user.getId());
    }

    @Test
    void testConstructorWithParameters() {
        List<Fraction> fractionList = new ArrayList<Fraction>();
        User user = new User("1", "Jano", "Martin", fractionList);
        assertEquals("1", user.getId());
        assertEquals("Jano", user.getName());
        assertEquals("Martin", user.getFamilyName());
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testSetterAndFullNameAndInitialsMethods() {
        User user = new User();
        user.setName("Jano");
        assertEquals("Jano", user.getName());
        user.setFamilyName("Martin");
        assertEquals("Martin", user.getFamilyName());
        assertEquals("Jano Martin", user.fullName());
        assertEquals("J.", user.initials());
    }

    @Test
    void testFractionsMethods() {
        Fraction fractionForTest = new Fraction();
        List<Fraction> fractionList = new ArrayList<Fraction>(List.of(fractionForTest));
        User user = new User();
        int unexpectedFractionSize = user.getFractions().size();
        user.setFractions(fractionList);
        assertNotEquals(unexpectedFractionSize, user.getFractions().size());

        unexpectedFractionSize = user.getFractions().size();
        user.addFraction(fractionForTest);
        assertNotEquals(unexpectedFractionSize, user.getFractions().size());
    }

}
