package model;

import model.deck.Deck;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJackGame {
    private final Deck deck = new Deck();
    private final Dealer dealer = new Dealer(deck.draw(), deck.draw());
    private final InputView inputView = new InputView();
    private final List<Player> players = new ArrayList<>();

    public void play() {
        deck.shuffle();
        inputView.processInput(names -> Arrays.stream(((String) names).split(",")).forEach((name) -> players.add(new Player(name, deck.draw(), deck.draw())))
                , "이름 입력하시오");
        for (Player player : players) {
            inputView.processInput(bet -> player.setBet(Integer.parseInt((String) bet)), player.name + "의 배팅 금액은?");
        }
        dealer.print();
        players.stream().forEach(p -> p.print());
        players.stream().forEach(p -> p.processDecision(() -> inputView.getInput(p.name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)"), () -> deck.draw()));
        dealer.process(deck.draw());
    }

    public static void main(String[] args) {
        new BlackJackGame().play();
    }
}
