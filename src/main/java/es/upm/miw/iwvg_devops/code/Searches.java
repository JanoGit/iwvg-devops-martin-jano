package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserIdBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .map(User::getId);
    }

    public Fraction findFractionAdditionByUserId(String id) {
        List<List<Fraction>> fractionList = new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .map(User::getFractions).collect(Collectors.toList());
        for (int i = 0; i < fractionList.get(0).size() - 1; i++) {
            fractionList.get(0).get(0).add(fractionList.get(0).get(i + 1));
        }
        return fractionList.get(0).get(0);
    }

    public Stream<String> findUserNameBySomeImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isImproper))
                .map(User::getName);
    }
}
