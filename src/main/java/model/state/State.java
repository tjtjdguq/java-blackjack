package model.state;

import model.deck.Card;
import model.deck.Denominations;

import java.util.Set;

public abstract class State {
    protected final int BLACKJACK_SCORE = 21;
    private final int ACE_CARD_SCORE_DIFFERENCE = Denominations.ACE.getScore() - 1;
    protected Set<Card> cards;

    public abstract boolean isFinished();


    public abstract State drawCard(Card card);

    public int score() {
        int totalScore = cards.stream().mapToInt(Card::score).reduce(Integer::sum).getAsInt();
        for (Card card : cards.stream().filter(Card::isAce).toList()) {
            if (totalScore > BLACKJACK_SCORE) {
                totalScore -= ACE_CARD_SCORE_DIFFERENCE;
            }
        }
        return totalScore;
    }
}
