import App.*;
import CommandManager.Commands.Load;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            Invoker.setCurrMainFile(new File(args[0]));
        }
        new Load(null, null).execute(args);
        while (true) {
            String input = InputManager.ask("> ");
            if (input != null) {
                if (Validator.validateCommand(input)) {
                    Invoker.execute(input.split(" "));
                }
            }
        }
    }
}
