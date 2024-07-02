package model;

import model.deck.Card;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class CardsInHand {

    private final int BLACKJACK_SCORE = 21;

    private final int ACE_CARD_SCORE_DIFFERENCE = 10;
    private final Set<Card> cards=new HashSet<>();

    public void receiveCard(Card handedCard) {
        if(cards.contains(handedCard)) {
            throw new IllegalArgumentException("duplicate card not allowed");
        }
        cards.add(handedCard);
    }

    public boolean isBust() {
        return score() > BLACKJACK_SCORE;
    }

    public boolean isBlackJack() {
        return score() == BLACKJACK_SCORE;
    }

    public int score() {
        int totalScore = cards.stream().mapToInt(Card::score).reduce(Integer::sum).getAsInt();
        for (Card card : cards.stream().filter(Card::isAce).toList()) {
            if (totalScore > BLACKJACK_SCORE) {
                totalScore -= ACE_CARD_SCORE_DIFFERENCE;
            }
        }
        return totalScore;
    }

    @Override
    public String toString() {
        return "{" + cards + '}';
    }
}
