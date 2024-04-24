package App;
import java.util.Scanner;
public class InputManager {

    private static Scanner scanner = new Scanner(System.in);

    public static String ask(String question){
        if (!Invoker.getModeState()){
            return CLAsk(question);
        }
        return askFile();
    }

    public static String CLAsk(String question){
        String input = GetCLInput.ask(scanner, question);
        if(input == null){
            reloadScanner();
            return null;
        }
        return input;
    }

    public static void reloadScanner(){
        OutputManager.print("\n");
        scanner = new Scanner(System.in);
    }

    public static String askFile(){
        return String.valueOf(Invoker.getCurrReadFile());
    }

}
