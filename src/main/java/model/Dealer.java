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

    public void printFirstCard() {
        System.out.print("딜러 : ");
        ((DealerStarted) started).printFirstCard();
    }

    public void printResult() {
        System.out.print("딜러 카드 : ");
        started.printCard();
        System.out.println(" - 결과: "+started.cardsInHand.score());
    }

    public void process(Card card) {
        while (!started.isFinished) {
            started.hit(card);
            System.out.print("딜러가 16이하면 한장의 카드를 더 받습니다.");
        }
    }
}
