package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
import App.OutputManager;
import Collections.Person;
/**
 * remove given person from the collection
 * @author raistlin
 */
public class Remove extends ACommand {
    
    public Remove(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "Удалить";
    }
    
    @Override
    public boolean execute(String[] args){
        Integer id = null;
        try{
            id = Integer.parseInt(args[1]);
        } catch(ArrayIndexOutOfBoundsException e){
            OutputManager.print("Недостаточно аргументов.");
            return false;
        }catch (NumberFormatException e){
            OutputManager.print("Должно быть число!");
            return false;
        }
        Person person = CollectionManager.findPerson(String.valueOf(id));
        if(person == null) {
            OutputManager.print("Нет такого Айди в коллекции.");
            return false;
        }
        CollectionManager.remove(person);
        return true;
    }
}
