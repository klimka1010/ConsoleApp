package CommandManager.Commands;

import App.ACommand;
import App.CollectionManager;
import App.OutputManager;
import Collections.AskPerson;
import Collections.Person;
/**
 * Command for adding new person
 */
public class Add extends ACommand {

    public Add(String name, String desc){
        this.name = name;
        this.description = desc;
    }

    @Override
    public boolean execute(String[] args){
        Person person = AskPerson.generatePerson(args);
        if(person == null){
            return false;
        }

        CollectionManager.add(person);
        OutputManager.print("Успешно добавил пользователя в коллекцию!");
        return true;
    }
}
