package CommandManager.Commands;
import java.io.File;
import App.*;
import serialization.WritePerson;
import java.io.IOException;
/**
 * saves collection to Main file.
 *
 */
public class Save extends ACommand {

    public Save(String name, String description){
        this.name = name;
        this.description = description;
    }


    @Override
    public boolean execute(String[] args){
        try{
            File currFile = Invoker.getCurrMainFile();
            if(currFile == null){
                OutputManager.print("Вы должны указать файл, при запуске этой программы.");
                return false;
            }
            WritePerson.write(CollectionManager.getCollection(), currFile);
        }catch(IOException e){
            OutputManager.print("Ошибка при записи файла");
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Сохранить";
    }
}
