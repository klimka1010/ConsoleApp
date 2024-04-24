package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
import Collections.Location;
import Collections.LocationField;
import Collections.Person;
/**
 * removes all persons with given location
 *
 */
public class RemoveLoc extends ACommand {
    
    public RemoveLoc(String name, String description){
        this.name = name;
        this.description = description;
    }


    @Override
    public boolean execute(String[] args){

        Location loc = new LocationField().create("");
        Person person = CollectionManager.findPerson(String.valueOf(loc));
        while(person != null){
            CollectionManager.remove(person);
            person = CollectionManager.findPerson(String.valueOf(loc));
        }
        return true;
    }
}
