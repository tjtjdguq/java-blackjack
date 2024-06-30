package model;

import model.deck.Deck;
import view.InputView;

import java.util.Arrays;
import java.util.List;

public class BlackJackGame {
    private final Deck deck = new Deck();
    private final Dealer dealer = new Dealer(deck.draw(),deck.draw());
    private final InputView inputView = new InputView();
    private final List<Player> players=Arrays.asList();

    public void play() {
        inputView.getInput(names -> Arrays.stream(((String) names).split(",")).forEach((name) -> players.add(new Player(name,deck.draw(),deck.draw())))
                , "wrong names input");
        for (Player player : players) {
            System.out.println(player.name + "의 배팅 금액은?");
            inputView.getInput(bet -> player.setBet(Integer.parseInt((String) bet)), "wrong bet input");
        }

    }
}
