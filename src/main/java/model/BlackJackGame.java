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
                , "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        for (Player player : players) {
            inputView.processInput(bet -> player.setBet(Integer.parseInt((String) bet)), player.name + "의 배팅 금액은?");
        }
        System.out.println("딜러와 pobi, jason에게 2장의 나누었습니다.");
        dealer.printFirstCard();
        players.stream().forEach(p -> p.print());
        players.stream().forEach(p -> p.processDecision(() -> inputView.getInput(p.name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)"), () -> deck.draw()));
        dealer.process(deck.draw());

        dealer.printResult();
        players.stream().forEach(p->p.printResult());
    }

    public static void main(String[] args) {
        new BlackJackGame().play();
    }
}
