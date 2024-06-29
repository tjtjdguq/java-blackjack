package model.state;

import model.deck.Card;

public abstract class Playing extends State {

    public Playing(Card card1, Card card2) {
    }

    @Override
    public State drawCard(Card card){
        return null;
    }
}
