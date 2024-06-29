package model;

import model.deck.Card;
import model.state.Start;
import model.state.State;

public class Player {

    private State state;

    public Player(Card card1, Card card2) {
        this.state = new Start(card1, card2);
    }
}
