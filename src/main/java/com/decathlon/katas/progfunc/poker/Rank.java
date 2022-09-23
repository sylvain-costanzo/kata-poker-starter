package com.decathlon.katas.progfunc.poker;

import lombok.Getter;

/**
 * Rank of any card
 * @author deadbrain
 */
@Getter
public enum Rank {
    ACE(1,14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    final int min;
    final int max;
    Rank(int value) {
        min=value;
        max=value;
    }

    Rank(int min, int max) {
        this.min=min;
        this.max=max;
    }

}
