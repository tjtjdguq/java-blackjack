package model.state;

import model.deck.Card;

public class DealerStarted extends Started {
    private final int LIMIT_OF_DEALER_SCORE_TO_HIT = 17;

    public DealerStarted(Card... cards) {
        super(cards);
    }

    @Override
    public void hit(Card card) {
        cardsInHand.receiveCard(card);
        if (cardsInHand.isBlackJack()) {
            isFinished = true;
            return;
        }
        if (cardsInHand.isBust()) {
            isFinished = true;
            return;
        }
        if (cardsInHand.score() > LIMIT_OF_DEALER_SCORE_TO_HIT) {
            isFinished = true;
            return;
        }

    }

    public void printFirstCard() {
        System.out.println(cardsInHand.getFirstCard());
    }
}
