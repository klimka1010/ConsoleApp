package App;

import java.util.Scanner;

public class GetCLInput {
    public static String ask(Scanner scanner, String question) {

        OutputManager.print(question);

        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            return null;
        }
    }
}
