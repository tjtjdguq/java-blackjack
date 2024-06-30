package view;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class InputView<R> {
    private final Scanner scanner = new Scanner(System.in);

    public void getInput(Consumer<String> function, String errorMessage) {
        while (true) {
            try {
                function.accept(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

}
