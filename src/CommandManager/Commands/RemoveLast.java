package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
/**
 * remove last element from collection
 *
 */
public class RemoveLast extends ACommand {
    
    public RemoveLast(String name,String description){
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "Удалить последний";
    }
    
    @Override
    public boolean execute(String[] args){
        CollectionManager.removeLast();
        return true;
    }
}
