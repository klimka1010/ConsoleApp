package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
/**
 * completely clears the collection
 * @author raistlin
 */
public class Clear extends ACommand {
    
    public Clear(String name, String desc){
        this.name = name;
        this.description = desc;
    }
    
    @Override
    public String toString(){
        return "Очистить";
    }
    
    @Override
    public boolean execute(String[] args){
        CollectionManager.clear();
        return true;
    }
}
