package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
import App.OutputManager;
import Collections.Person;
/**
 * prints all elements of collection
 *
 */
public class Show extends ACommand {

    public Show(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean execute(String[] args){
        for(Person p : CollectionManager.getCollection()){
            OutputManager.print("------------------------------------");
            OutputManager.print(p);
            OutputManager.print("------------------------------------");
        }
        return true;
    }
}
