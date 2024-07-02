package view;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class InputView<R> {

    public void processInput(Consumer<String> function, String inputInducedMessage) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(inputInducedMessage);
                if(scanner.hasNextLine()) {
                    function.accept(scanner.nextLine());
                }else{
                    System.out.println("scanner has no more lines.");
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getInput(String inputInducedMessage) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(inputInducedMessage);
                if(scanner.hasNextLine()) {
                    return scanner.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
