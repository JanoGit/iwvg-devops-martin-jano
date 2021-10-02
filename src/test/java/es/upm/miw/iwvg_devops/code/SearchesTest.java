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

}
