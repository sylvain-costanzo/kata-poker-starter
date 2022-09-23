package com.decathlon.katas.progfunc.poker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dealer {

    public boolean containsPair(final Hand hand) {
        return hasSameRank(hand, 2);
    }

    public boolean containsThreeOfAKind(final Hand hand) {
        return hasSameRank(hand, 3);
    }

    private boolean hasSameRank(final Hand hand, final int occurence) {
        Map<Rank, List<Card>> byRank = hand.getCards().stream().collect(Collectors.groupingBy(Card::getRank));
        return byRank.values().stream().anyMatch(list -> list.size() == occurence);
    }

    public boolean containsFullHouse(final Hand hand) {
        Map<Rank, List<Card>> byRank = hand.getCards().stream().collect(Collectors.groupingBy(Card::getRank));
        return byRank.values().stream().anyMatch(list -> list.size() == 3) && byRank.values().stream().anyMatch(list -> list.size() == 2);
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


}
