package model;

import model.deck.Card;
import model.state.PlayerStarted;
import model.state.Started;

public class Player {
    public final String name;

    private Started started;
    private int bet;

    public Player(String name,Card...cards) {
        this.name = name;
        started=new PlayerStarted(cards);
    }

    public void setBet(int bet){
        this.bet=bet;
    }


}
