package model.deck;

import java.util.Objects;

public class Card {

    private final Suits suit;
    private final Denominations denomination;

    public Card(Denominations denomination, Suits suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public boolean isAce() {
        return Denominations.ACE.equals(denomination);
    }

    public int score() {
        return denomination.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && denomination == card.denomination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, denomination);
    }

    @Override
    public String toString() {
        return  suit +""+ denomination ;
    }
}
