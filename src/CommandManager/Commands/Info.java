package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
import App.OutputManager;
/**
 * Prints info about collection(init date, size,type)
 * @author raistlin
 */
public class Info extends ACommand {
    
    public Info(String name,String desc){
        this.name = name;
        this.description = desc;
    }
    
    @Override
    public String toString(){
        return "Info";
    }
    
    @Override
    public boolean execute(String[] args){
        OutputManager.print(CollectionManager.getType());
        OutputManager.print(CollectionManager.getInitDate());
        OutputManager.print(CollectionManager.getSize());
        return true;
    }
}
