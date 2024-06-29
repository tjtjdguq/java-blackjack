package model;

import model.deck.Deck;

import java.util.List;

public class BlackJackGame {
    private final Deck deck=new Deck();
    private final Dealer dealer=new Dealer();
    private final List<Player> players;

    public BlackJackGame(List<Player> players) {
        if(players==null||players.isEmpty()){
            throw new IllegalArgumentException("there should be at least one player");
        }
        this.players = players;
    }
}
