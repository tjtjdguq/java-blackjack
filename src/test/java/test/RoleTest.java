package test;

import model.deck.Card;
import model.deck.Denominations;
import model.deck.Suits;
import model.state.Start;
import model.state.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleTest {
    @Test
    @DisplayName("만약 보유한 카드 합이 21을 넘으면 에이스를 1로 계산한다.")
    void test1() {
        State state = new Start(new Card(Denominations.ACE, Suits.CLUBS), new Card(Denominations.ACE, Suits.HEARTS));
        assertThat(state.score()).isEqualTo(12);
    }
}
