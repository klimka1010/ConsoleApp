package CommandManager.Commands;
import App.ACommand;
/**
 * exit from program
 *
 */
public class Exit extends ACommand {

    public Exit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean execute(String[] args) {
        System.exit(0);
        return true;
    }

}
