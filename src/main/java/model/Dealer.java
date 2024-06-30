package model;

import model.deck.Card;
import model.state.DealerStarted;
import model.state.Started;

public class Dealer {
    private Started started;

    public Dealer(Card... cards) {
        this.started = new DealerStarted(cards);
    }
}
