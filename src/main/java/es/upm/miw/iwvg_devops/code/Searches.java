package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserIdBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                        .map(User::getId);
    }
}
