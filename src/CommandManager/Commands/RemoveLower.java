package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
import Collections.AskPerson;
import Collections.Person;
import java.util.ArrayList;
/**
 * removes all collection's elements, that are less than the given one.
 *
 */
public class RemoveLower extends ACommand {
    
    public RemoveLower(String name,String description){
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "Удалить младший";
    }


    @Override
    public boolean execute(String[] args){
        Person person = AskPerson.generatePerson(args);
        if (person == null){
            return false;
        }
        ArrayList<Person> removeList = new ArrayList<Person>();
        
        for(Person p : CollectionManager.getCollection()){
            if(p.compareTo(person) < 0){
                removeList.add(p);
            }
        }
        CollectionManager.remove(removeList);
        return true;
    }
}
