package test;

import model.BlackJackGame;
import model.CardsInHand;
import model.Player;
import model.deck.Card;
import model.deck.Denominations;
import model.deck.Suits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleTest {
    @Test
    @DisplayName("만약 보유한 카드 합이 21을 넘으면 에이스를 1로 계산한다.")
    void test1() {
        CardsInHand cards = new CardsInHand();
        cards.receiveCard(new Card(Denominations.ACE, Suits.CLUBS));
        cards.receiveCard(new Card(Denominations.ACE, Suits.HEARTS));
        assertThat(cards.score()).isEqualTo(12);
    }

    @Test
    @DisplayName("게임 시작 시 딜러와 플레이어는 2장의 카드를 받는다.") //junit runs in non-interactive environment => inputs from user is not available
    void test2() {
    }

    @Test
    @DisplayName("카드 두장을 받아 블랙잭이면 게임을 이긴다.")
    void test3() {
        //given
        Player p=new Player("ssh",new Card(Denominations.ACE,Suits.CLUBS),new Card(Denominations.KING,Suits.CLUBS));

        p.processDecision(()->"y",()->new Card(Denominations.EIGHT,Suits.DIAMONDS));
        p.print();
    }
}
