package CommandManager.Commands;

import App.ACommand;
import App.Invoker;
import App.OutputManager;

import java.util.Set;
/**
 * Prints all available commands and their descriptions.
 * @author raistlin
 */
public class Help extends ACommand {

    public Help(String name, String description){
        this.name = name;
        this.description = description;
    }


    @Override
    public boolean execute(String[] args){
        Set<String> commandSet = Invoker.getCommands().keySet();
        for(String key : commandSet){
            OutputManager.print(key + " - " + Invoker.getCommands().get(key).getDescription());
        }
        return true;
    }


}
