package model.deck;

public enum Suits {
    HEARTS("하트"),
    SPADES("스페이드"),
    DIAMONDS("다이아몬드"),
    CLUBS("클로바");

    private final String name;

    Suits(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
