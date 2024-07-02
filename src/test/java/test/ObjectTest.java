package test;

import model.Player;
import model.deck.Card;
import model.deck.Deck;
import model.deck.Denominations;
import model.deck.Suits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.EmptyStackException;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ObjectTest {

    @Test
    @DisplayName("덱은 4개의 suits와 13개의 denomination 조합으로 총 52개의 카드를 가진다.")
    void test1() {
        //given 덱 생성 후 52개의 카드를 뽑는다.
        Deck deck = new Deck();
        IntStream.rangeClosed(1, 52).forEach((num) -> deck.draw());

        //then 53번째 카드를 뽑으면 예외처리한다.
        Assertions.assertThrows(EmptyStackException.class, deck::draw);
    }

    @Test
    @DisplayName("카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.")
    void test2() {
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.ACE, suit).score()).isIn(1, 11);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.TWO, suit).score()).isEqualTo(2);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.THREE, suit).score()).isEqualTo(3);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.FOUR, suit).score()).isEqualTo(4);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.FIVE, suit).score()).isEqualTo(5);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.SIX, suit).score()).isEqualTo(6);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.SEVEN, suit).score()).isEqualTo(7);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.EIGHT, suit).score()).isEqualTo(8);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.NINE, suit).score()).isEqualTo(9);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.TEN, suit).score()).isEqualTo(10);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.JACK, suit).score()).isEqualTo(10);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.QUEEN, suit).score()).isEqualTo(10);
        }
        for (Suits suit : Suits.values()) {
            assertThat(new Card(Denominations.KING, suit).score()).isEqualTo(10);
        }

    }

    @Test
    @DisplayName("사용자와 딜러는 동일한 카드를 받지 않는다.")
    void test3() {
        //given
        Card card1=new Card(Denominations.ACE,Suits.CLUBS);
        Card card2=new Card(Denominations.KING,Suits.CLUBS);

        new Player("ssh",card1,card2);

    }
}
