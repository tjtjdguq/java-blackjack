package model.deck;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private final Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
        for (Denominations denom : Denominations.class.getEnumConstants()) {
            for (Suits suit : Suits.class.getEnumConstants()) {
                cards.add(new Card(denom, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public synchronized Card draw(){
        return cards.pop();
    }
}
