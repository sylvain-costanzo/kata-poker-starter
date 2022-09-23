package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * tests suite for poker hands evaluation
 * @author deadbrain
 */
public class PokerHandsTestssuite {
    private static final List<Card> fooCards= new ArrayList<>(5);
    private static Hand fooHand;

    private static final  List<Card> basicPair = new ArrayList<>(5);
    private static Hand basicPairHand;

    private static final List<Card> twoPairs = new ArrayList<>(5);
    private static Hand twoPairsHand;

    private static final List<Card> threeOfAKind = new ArrayList<>(5);
    private static Hand threeOfAKindHand;

    private static final List<Card> fourOfAKind = new ArrayList<>(5);
    private static Hand fourAKindHand;


    private static final List<Card> fullHouse = new ArrayList<>(5);
    private static Hand fullHouseHand;


    private static final List<Card> flush = new ArrayList<>(5);
    private static Hand flushHand;

    private static final List<Card> straight = new ArrayList<>(5);
    private static Hand straightHand;

    private static final List<Card> straightFlush = new ArrayList<>(5);
    private static Hand straightFlushHand;

    private static final List<Card> royalFlush = new ArrayList<>(5);
    private static Hand royalFlushHand;

    @BeforeAll
    static void setupTests(){
        fooCards.add(new Card(Rank.FIVE,Color.DIAMOND));
        fooCards.add(new Card(Rank.SEVEN,Color.DIAMOND));
        fooCards.add(new Card(Rank.SIX,Color.HEART));
        fooCards.add(new Card(Rank.EIGHT,Color.DIAMOND));
        fooCards.add(new Card(Rank.QUEEN,Color.HEART));
        fooHand=new Hand(fooCards);

        basicPair.add(new Card(Rank.QUEEN,Color.HEART));
        basicPair.add(new Card(Rank.QUEEN,Color.SPADE));
        basicPair.add(new Card(Rank.FOUR,Color.SPADE));
        basicPair.add(new Card(Rank.FIVE,Color.SPADE));
        basicPair.add(new Card(Rank.KING,Color.SPADE));
        basicPairHand=new Hand(basicPair);

        twoPairs.add(new Card(Rank.FIVE,Color.SPADE));
        twoPairs.add(new Card(Rank.FIVE,Color.HEART));
        twoPairs.add(new Card(Rank.SIX,Color.HEART));
        twoPairs.add(new Card(Rank.SIX,Color.SPADE));
        twoPairs.add(new Card(Rank.TWO,Color.TREFLE));
        twoPairsHand=new Hand(twoPairs);

        threeOfAKind.add(new Card(Rank.NINE,Color.SPADE));
        threeOfAKind.add(new Card(Rank.NINE,Color.HEART));
        threeOfAKind.add(new Card(Rank.NINE,Color.DIAMOND));
        threeOfAKind.add(new Card(Rank.FOUR,Color.SPADE));
        threeOfAKind.add(new Card(Rank.JACK,Color.TREFLE));
        threeOfAKindHand = new Hand(threeOfAKind);

        fourOfAKind.add(new Card(Rank.JACK,Color.TREFLE));
        fourOfAKind.add(new Card(Rank.JACK,Color.SPADE));
        fourOfAKind.add(new Card(Rank.JACK,Color.DIAMOND));
        fourOfAKind.add(new Card(Rank.JACK,Color.HEART));
        fourOfAKind.add(new Card(Rank.ACE,Color.TREFLE));
        fourAKindHand=new Hand(fourOfAKind);


        fullHouse.add(new Card(Rank.NINE,Color.TREFLE));
        fullHouse.add(new Card(Rank.NINE,Color.HEART));
        fullHouse.add(new Card(Rank.NINE,Color.SPADE));
        fullHouse.add(new Card(Rank.KING,Color.TREFLE));
        fullHouse.add(new Card(Rank.KING,Color.SPADE));
        fullHouseHand=new Hand(fullHouse);

        flush.add(new Card(Rank.SEVEN,Color.TREFLE));
        flush.add(new Card(Rank.EIGHT,Color.TREFLE));
        flush.add(new Card(Rank.NINE,Color.TREFLE));
        flush.add(new Card(Rank.TEN,Color.TREFLE));
        flush.add(new Card(Rank.JACK,Color.TREFLE));
        flushHand=new Hand(flush);

        straight.add(new Card(Rank.SEVEN,Color.TREFLE));
        straight.add(new Card(Rank.EIGHT,Color.DIAMOND));
        straight.add(new Card(Rank.NINE,Color.SPADE));
        straight.add(new Card(Rank.TEN,Color.TREFLE));
        straight.add(new Card(Rank.JACK,Color.HEART));
        straightHand=new Hand(straight);

        straightFlush.add(new Card(Rank.SEVEN,Color.DIAMOND));
        straightFlush.add(new Card(Rank.EIGHT,Color.DIAMOND));
        straightFlush.add(new Card(Rank.NINE,Color.DIAMOND));
        straightFlush.add(new Card(Rank.TEN,Color.DIAMOND));
        straightFlush.add(new Card(Rank.JACK,Color.DIAMOND));
        straightFlushHand=new Hand(straightFlush);

        royalFlush.add(new Card(Rank.ACE,Color.TREFLE));
        royalFlush.add(new Card(Rank.KING,Color.TREFLE));
        royalFlush.add(new Card(Rank.QUEEN,Color.TREFLE));
        royalFlush.add(new Card(Rank.JACK,Color.TREFLE));
        royalFlush.add(new Card(Rank.TEN,Color.TREFLE));
        royalFlushHand=new Hand(royalFlush);
    }

    public static Stream<Hand> straightHands() {
        List<Card> list1 = Arrays.asList(new Card(Rank.ACE,Color.TREFLE),
                new Card(Rank.TWO,Color.TREFLE),
                new Card(Rank.THREE,Color.DIAMOND),
                new Card(Rank.FOUR,Color.SPADE),
                new Card(Rank.FIVE,Color.TREFLE));
        Hand hand1 = new Hand(list1);

        List<Card> list2 = Arrays.asList(new Card(Rank.TEN,Color.HEART),
                new Card(Rank.SIX,Color.TREFLE),
                new Card(Rank.NINE,Color.HEART),
                new Card(Rank.SEVEN,Color.TREFLE),
                new Card(Rank.EIGHT,Color.SPADE));
        Hand hand2 = new Hand(list2);

        return Stream.of(hand1, hand2, royalFlushHand, straightFlushHand, straightHand);
    }

    public static Stream<Hand> notStraightHands() {
        List<Card> list1 = Arrays.asList(new Card(Rank.ACE,Color.TREFLE),
                new Card(Rank.TWO,Color.TREFLE),
                new Card(Rank.THREE,Color.DIAMOND),
                new Card(Rank.KING,Color.SPADE),
                new Card(Rank.QUEEN,Color.TREFLE));
        Hand hand1 = new Hand(list1);

        return Stream.of(hand1, fooHand, basicPairHand, twoPairsHand, threeOfAKindHand, fourAKindHand, fullHouseHand);
    }

    @Test
    @DisplayName("Hand has a pair")
    void handHasPair() {
        Dealer dealer = new Dealer();
        assertTrue(dealer.containsPair(basicPairHand));
    }

    @Test
    @DisplayName("Hand has no pair")
    void handHasNoPair() {
        Dealer dealer = new Dealer();
        assertFalse(dealer.containsPair(fooHand));
    }

    @Test
    @DisplayName("Hand has three of a kind")
    void handHasThreeOfAKind() {
        Dealer dealer = new Dealer();
        assertTrue(dealer.containsThreeOfAKind(threeOfAKindHand));
    }

    @Test
    @DisplayName("Hand has not three of a kind")
    void handHasNoThreeOfAKind() {
        Dealer dealer = new Dealer();
        assertFalse(dealer.containsThreeOfAKind(fooHand));
    }

    @Test
    @DisplayName("Hand has a full house")
    void handHasFullHouse() {
        Dealer dealer = new Dealer();
        assertTrue(dealer.containsFullHouse(fullHouseHand));
    }

    @Test
    @DisplayName("Hand has not full housed")
    void handHasNoFullHouse() {
        Dealer dealer = new Dealer();
        assertFalse(dealer.containsFullHouse(fooHand));
    }

    @Test
    @DisplayName("Hand has a flush")
    void handHasFlush() {
        Dealer dealer = new Dealer();
        assertTrue(dealer.containsFlush(flushHand));
    }

    @Test
    @DisplayName("Hand has not flush")
    void handHasNoFlush() {
        Dealer dealer = new Dealer();
        assertFalse(dealer.containsFlush(fooHand));
    }

    @DisplayName("Hand has a straight")
    @ParameterizedTest
    @MethodSource("straightHands")
    void handHasStraight(final Hand hand) {
        Dealer dealer = new Dealer();
        assertTrue(dealer.containsStraight(hand));
    }

    @ParameterizedTest
    @MethodSource("notStraightHands")
    @DisplayName("Hand has not straight")
    void handHasNoStraight(final Hand hand) {
        Dealer dealer = new Dealer();
        assertFalse(dealer.containsStraight(hand));
    }


}
