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
        Fraction fraction = new Fraction();
        fraction.setNumerator(fractionList.get(0).get(0).getNumerator());
        fraction.setDenominator(fractionList.get(0).get(0).getDenominator());
        for (int i = 0; i < fractionList.get(0).size() - 1; i++) {
            fraction = fraction.add(fractionList.get(0).get(i + 1));
        }
        if (fraction.getNumerator() == 0 & fraction.getDenominator() != 0) {
            fraction.setDenominator(0);
        }
        return fraction;
    }

    public Stream<String> findUserNameBySomeImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isImproper))
                .map(User::getName);
        //FixMe: Added modification to fulfil issue#14(github)
    }

    public Fraction findFractionSubtractionByUserName(String name) {
        List<List<Fraction>> fractionList = new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .map(User::getFractions).collect(Collectors.toList());
        Fraction fraction = new Fraction();
        fraction.setNumerator(fractionList.get(0).get(0).getNumerator());
        fraction.setDenominator(fractionList.get(0).get(0).getDenominator());
        for (int i = 1; i < fractionList.get(0).size(); i++) {
            fractionList.get(0).get(i).setNumerator(-fractionList.get(0).get(i).getNumerator());
        }
        for (int i = 0; i < fractionList.get(0).size() - 1; i++) {
            fraction = fraction.add(fractionList.get(0).get(i + 1));
        }
        if (fraction.getNumerator() == 0 & fraction.getDenominator() != 0) {
            fraction.setDenominator(0);
        }
        return fraction;
    }
}
