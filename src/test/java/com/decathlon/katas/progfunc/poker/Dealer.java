package com.decathlon.katas.progfunc.poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Dealer {

    private static Map<?, List<Card>> getGroupingCard(Hand hand, Function<Card, ?> groupingFunction) {
        return hand.getCards().stream().collect(Collectors.groupingBy(groupingFunction));
    }

    private static Predicate<List<Card>> getListPredicate(int size) {
        return v -> v.size() == size;
    }

    public boolean containsPair(final Hand hand) {
        return isSameRankHof(hand, 2);
    }

    public boolean containsThreeOfAKind(final Hand hand) {
        return isSameRankHof(hand, 3);
    }

    private boolean isSameRankHof(Hand hand, int size) {
        return hasSameRankHof(hand, getRank(), getListPredicate(size));
    }

    private boolean hasSameRankHof(final Hand hand, final Function<Card, ?> groupingFunction, Predicate<List<Card>> filterFunction) {
        return getGroupingCard(hand, groupingFunction).values().stream().anyMatch(filterFunction);
    }

    public boolean containsFullHouse(final Hand hand) {
        return containsFullHouseHof(hand);
    }

    public boolean containsFullHouseHof(final Hand hand) {
        return containsPair(hand) && containsThreeOfAKind(hand);
    }

    public boolean containsFlush(final Hand hand) {
        Map<Color, List<Card>> byColor = hand.getCards().stream().collect(Collectors.groupingBy(Card::getColor));
        return byColor.values().size() == 1 && byColor.values().stream().findFirst().get().size() == 5;
    }

    public boolean containsStraight(final Hand hand) {
        List<Integer> sortedByMin = hand.getCards().stream().map(c -> c.getRank().getMin()).sorted().distinct().collect(Collectors.toList());
        List<Integer> sortedByMax = hand.getCards().stream().map(c -> c.getRank().getMax()).sorted().distinct().collect(Collectors.toList());

        return (sortedByMin.size() == 5 && sortedByMin.get(4) - sortedByMin.get(0) == 4) ||
                (sortedByMax.size() == 5 && sortedByMax.get(4) - sortedByMax.get(0) == 4);
    }

    public boolean containsFlushHof(final Hand hand) {
        Collection<List<Card>> byColor = getGroupingCard(hand, Card::getColor).values();
        return byColor.size() == 1 && byColor.stream().findFirst().get().size() == 5;
    }

    public boolean test(final Hand hand, Function<Card, ?> groupingFunction, Predicate<List<Card>> filterFunction) {
        return hand.getCards().stream()
                .collect(Collectors.groupingBy(groupingFunction))
                .values()
                .stream()
                .filter(filterFunction)
                .findFirst().orElseGet(ArrayList::new).size() == 5;
    }



    private static Function<Card, Rank> getRank() {
        return Card::getRank;
    }


}
