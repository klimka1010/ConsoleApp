package CommandManager.Commands;
import App.ACommand;
import App.CollectionManager;
import App.OutputManager;
import Collections.Person;
/**
 * Counts all persons with given height
 * @author raistlin
 */
public class CountWeight extends ACommand {
    
    public CountWeight(String name, String desc){
        this.name = name;
        this.description = desc;
    }
    
    @Override
    public String toString(){
        return "Счет веса";
    }
    
    @Override
    public boolean execute(String[] args){
        if(args.length < 2){
            OutputManager.print("Недостаточно аргументов");
            return false;
        }
        int count = 0;
        for(Person p : CollectionManager.getCollection()){
            if(p.getWeight() == 0){
                ++count;
            }
        }
        OutputManager.print(count);
        return true;
    }
}
