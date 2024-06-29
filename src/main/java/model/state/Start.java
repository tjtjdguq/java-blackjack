package model.state;

import model.deck.Card;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Start extends State {
    public Start(Card... cards) {
        super();
        if (cards == null || cards.length != 2) {
            throw new IllegalArgumentException("only two different cards can be received at start of a blackjack game");
        }
        this.cards = Arrays.stream(cards).collect(Collectors.toSet());
        if (this.cards.size() != 2) {
            throw new IllegalArgumentException("only two different cards can be received at start of a blackjack game");
        }
    }

    @Override
    public boolean isFinished() {
        return this.score() > this.BLACKJACK_SCORE;
    }

    @Override
    public State drawCard(Card card) {
//        cards.add(card);
//        int score = score();
//        if (score > this.BLACKJACK_SCORE) {
//            return new Bust();
//        }
//        if (score < this.BLACKJACK_SCORE) {
//            return new Stay();
//        }
//        return new BlackJack();
        return null;
    }
}
