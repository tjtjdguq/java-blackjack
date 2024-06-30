package model.state;

import model.CardsInHand;
import model.deck.Card;

import java.util.Arrays;

public abstract class Started {
    CardsInHand cardsInHand;
    boolean isFinished = false;
    public Started(Card...cards){
        cardsInHand = new CardsInHand();
        Arrays.stream(cards).forEach(card -> cardsInHand.receiveCard(card));
    }
    public abstract void hit(Card card);
}
