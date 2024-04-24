package App;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import CommandManager.Commands.*;
public class Invoker {

    private static HashMap<String, ACommand> commands;
    private static Stack<File> mainFileStack = new Stack<File>();
    private static Stack<File> fileReadStack = new Stack<File>();

    private static boolean fromFileMode = false;


    static{
        commands = new HashMap<>();

        Exit exit = new Exit("exit","Выход");
        Help help = new Help("help", "Справка");
        Add add = new Add("add", "(add Name Weight {BirthDate}) создает новый элемент, и добавляет его в коллекцию.");
        Show show = new Show("show", "Выводит все элементы коллекции.");
        ExecuteScript execScr = new ExecuteScript("execute_script","execute_script (filename) - Выполнение строк из файла, как будто это обычный ввод CLI.");
        Save save = new Save("save", "Сохраняет коллекцию в файл.");
        Load load = new Load("load", "Загружает коллекцию из файла в коммандную строку.");
        Info info = new Info("info", "Показывает данные коллекции (тип, дата создания, размер.)");
        Update update = new Update("update", "(update id {element}) Заменяет элемент коллекции по Айди.");
        Remove remove = new Remove("remove_by_id", "(remove_by_id id) Удаляет элемент коллекции по Айди.");
        Clear clear = new Clear("clear", "Удаляет все элементы коллекции.");
        RemoveLoc removeLoc = new RemoveLoc("remove_by_location", "Удаляет все элементы коллекции по разположению.");
        RemoveLast removeLast = new RemoveLast("remove_last", "Удаляет последний элемент коллекции");
        RemoveLower removeLower = new RemoveLower("remove_lower", "remove_lower {element} - Удаляет все элементы ниже заданного значения");
        PrintHairColor printColor = new PrintHairColor("hair", "Выводит все цвета волос из коллекции (по убыванию)");
        CountWeight count = new CountWeight("count", "count [height] - Выводит номера элементов с этой (высотой).");
        AddIfMax addIf = new AddIfMax("addif", "addif [element] - Добавляет новый элемент, если он больше максимального элемента");

        commands.put(exit.getName(), exit);
        commands.put(help.getName(), help);
        commands.put(add.getName(), add);
        commands.put(show.getName(), show);
        commands.put(execScr.getName(), execScr);
        commands.put(save.getName(), save);
        commands.put(load.getName(), load);
        commands.put(info.getName(), info);
        commands.put(update.getName(), update);
        commands.put(remove.getName(), remove);
        commands.put(removeLast.getName(), removeLast);
        commands.put(clear.getName(), clear);
        commands.put(removeLoc.getName(), removeLoc);
        commands.put(removeLower.getName(), removeLower);
        commands.put(printColor.getName(), printColor);
        commands.put(count.getName(), count);
        commands.put(addIf.getName(), addIf);

    }


    public static boolean execute(String[] args) throws IOException {

        if (!(commands.containsKey(args[0].toLowerCase()))){
            OutputManager.print("Неверная команда! Введите \"help\" для списка команд");
            return false;
        }
        commands.get(args[0].toLowerCase()).execute(args);
        return true;
    }


    public static HashMap<String, ACommand> getCommands(){
        return commands;
    }

    public static boolean getModeState() {
        return fromFileMode;
    }
    public static void setModeState(Boolean fromFile){
        fromFileMode = fromFile;
    }

    public static File getCurrReadFile(){
        if(fileReadStack.empty()){
            return null;
        }
        return fileReadStack.peek();
    }
    public static void setCurrReadFile(File file){
        fileReadStack.push(file);
    }
    public static void removeCurrReadFile(){
        fileReadStack.peek();
        fileReadStack.pop();
    }

    public static void setCurrMainFile(File file) {
        fileReadStack.push(file);
    }
    public static File getCurrMainFile(){
        if (mainFileStack.empty()){
            return null;
        }
        return mainFileStack.peek();
    }
    public static File removeCurrMainFile(){
        return mainFileStack.pop();
    }

}
