package CommandManager.Commands;
import java.io.IOException;
import java.util.ArrayList;
import App.*;
/**
 * execute given file, as if it's a bunch of user input lines.
 */
public class ExecuteScript extends ACommand {

    private static ArrayList<String> filenames = new ArrayList<>();
    
    public ExecuteScript(String name,String desc){
        this.name = name;
        this.description = desc;
    }
    
    @Override
    public boolean execute(String[] args) throws IOException {
        
        if (args.length == 1){
            OutputManager.print("Укажите имя файла.");
            return false;
        }
        if (filenames.contains(args[1])){
            OutputManager.print("Рекурсия выполнения скрипта запрещена!");
            return false;
        }
        Invoker.setModeState(true);
        Invoker.setCurrReadFile(new ReadFile(args[1]));
        filenames.add(args[1]);
        boolean keepGoing = true;
        String line = null;
        while (keepGoing) {
            line = String.valueOf(Invoker.getCurrReadFile());
            if (line == null) {
                break;
            }
            if (Validator.validateCommand(line)) {
                Invoker.execute(line.split(" "));
            } else {
                OutputManager.print("Не найдена подходящая команда.");
                Invoker.removeCurrReadFile();
                Invoker.setModeState(false);
                return false;
            }
        }
        Invoker.removeCurrReadFile();
        Invoker.setModeState(false);
        return true;

    }

}
