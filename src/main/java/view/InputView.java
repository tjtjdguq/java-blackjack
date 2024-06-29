package view;

import java.util.Scanner;
import java.util.function.Function;

public class InputView<R> {
    private final Scanner scanner = new Scanner(System.in);

    public R getInput(Function<String, R> function, String errorMessage) {
        while (true) {
            try {
                return function.apply(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

}
