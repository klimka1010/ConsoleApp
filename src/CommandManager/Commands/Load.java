package CommandManager.Commands;

import App.*;
import Collections.Person;
import serialization.ReadPerson;
import java.util.List;
import java.io.IOException;
import java.util.EmptyStackException;
/**
 * loads collection from file.
 *
 */
public class Load extends ACommand {
    
    public Load(String name, String desc){
        this.name= name;
        this.description = desc;
    }
    
    @Override
    public boolean execute(String[] args){
        List<Person> newList = null;
        try{
            newList = ReadPerson.read(Invoker.getCurrMainFile());
            if(newList == null){
                OutputManager.print("Файл поврежден или содержит неверные данные.");
                return false;
            }
        } catch(IOException e) {
            OutputManager.print("Ошибка при чтении файла.");
            return false;
        } catch(EmptyStackException | NullPointerException e){
            OutputManager.print("Входной файл не указан.");
            return false;
        }
        CollectionManager.addAll(newList);
        return true;
    }
    
    @Override
    public String toString(){
        return "Загрузка";
    }
}
