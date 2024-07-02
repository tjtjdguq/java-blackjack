package model;

import model.deck.Card;
import model.state.PlayerStarted;
import model.state.Started;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Player {
    public final String name;

    private Started started;
    private int bet;

    public Player(String name, Card... cards) {
        this.name = name;
        started = new PlayerStarted(cards);
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void print() {
        System.out.print(this.name + "카드 : ");
        started.printCard();
    }

    public void processDecision(Supplier<String> input, Supplier<Card> drawFromDeck) {
        while (!started.isFinished && "y".equalsIgnoreCase(input.get().trim())) {
            started.hit(drawFromDeck.get());
            System.out.print(this.name + "카드 : ");
            started.printCard();
        }
    }

}
