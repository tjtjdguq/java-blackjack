package model.state;

import model.deck.Card;

public class PlayerStarted extends Started {
    public PlayerStarted(Card... cards) {
        super(cards);
    }

    @Override
    public void hit(Card card) {
        if(cardsInHand.isBlackJack()){
            isFinished=true;
            return;
        }
        if(cardsInHand.isBust()){
            isFinished=true;
            return;
        }
        cardsInHand.receiveCard(card);
    }
}
