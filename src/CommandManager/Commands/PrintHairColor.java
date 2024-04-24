package CommandManager.Commands;
import java.util.Comparator;
import java.util.List;
import App.ACommand;
import App.CollectionManager;
import App.OutputManager;
import Collections.*;
/**
 * Prints all hair colors of collection's elements, in descending order
 *
 */
public class PrintHairColor extends ACommand {
    
    public PrintHairColor(String name,String description){
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "Вывести цвет волос";
    }
    
    @Override
    public boolean execute(String[] args){
        List<Color> hairColors = CollectionManager.getHairColors();
        hairColors.sort(Comparator.reverseOrder());
        for(Color c : hairColors){
            OutputManager.print(c);
        }
        return true;
    }
}
