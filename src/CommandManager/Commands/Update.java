package CommandManager.Commands;
import java.util.Arrays;
import App.ACommand;
import App.CollectionManager;
import App.OutputManager;
import Collections.AskPerson;
import Collections.Person;
/**
 * replace person with given id,with another person 
 *
 */
public class Update extends ACommand {

    public Update(String name,String description){
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "Обновить";
    }
    
    @Override
    public boolean execute(String[] args){
        if(args.length < 5){
            OutputManager.print("Недостатотчно аргументов.");
            return false;
        }
        Integer id = null;
        try{
            id = Integer.parseInt(args[1]);
        } catch(NullPointerException e){
            OutputManager.print("Недостатотчно аргументов.");
            return false;
        } catch (NumberFormatException e){
            OutputManager.print("Должно быть число");
            return false;
        }
        Person person = CollectionManager.findPerson(String.valueOf(id));
        if(person == null) {
            OutputManager.print("Не найден файл в коллекции.");
            return false;
        }
        args = Arrays.copyOfRange(args, 1, args.length - 1);
        Person newPerson = AskPerson.generatePerson(args);
        if(newPerson == null){
            OutputManager.print("Ошибка при создании нового пользователя. Попробуйте снова!");
            return false;
        }
        CollectionManager.remove(person);
        newPerson.setPassportID(String.valueOf(id));
        CollectionManager.add(newPerson);
        return true;
    }
}
