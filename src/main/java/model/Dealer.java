package model;

import model.deck.Card;
import model.state.DealerStarted;
import model.state.Started;

import java.util.function.Supplier;

public class Dealer {
    private Started started;

    public Dealer(Card... cards) {
        this.started = new DealerStarted(cards);
    }

    public void print() {
        System.out.print("딜러 : ");
        started.printCard();
    }

    public void process( Card card) {
        while (!started.isFinished) {
            started.hit(card);
            System.out.print("딜러가 16이하면 한장의 카드를 더 받습니다.");
        }
    }
}
