package CommandManager.Commands;

import java.util.ArrayList;
import App.CollectionManager;
import App.OutputManager;
import Collections.*;
import App.ACommand;
/**
 * Adds an element,if it's greater than the max one.
 * @author raistlin
 */
public class AddIfMax extends ACommand {
    
    public AddIfMax(String name,String desc){
        this.name = name;
        this.description = desc;
    }
    
    @Override
    public String toString(){
        return "AddIfMax";
    }
    
    @Override
    public boolean execute(String[] args){
        Person person = AskPerson.generatePerson(args);
        if(person == null){
            return false;
        }
        ArrayList<Person> collection = CollectionManager.getCollection();
        if(person.compareTo(collection.get(collection.size() - 1)) > 0){
            CollectionManager.add(person);
            OutputManager.print("Добавляю элемент в коллекцию...");
        } else {
            OutputManager.print("Элемент меньше, чем максимальный элемент коллекции.");
        }
        return true;
    }

}
