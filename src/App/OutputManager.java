package App;
public class OutputManager {
    public static <T> void print(T obj){

        if(obj != null){
            System.out.print("\n " + obj);
        }
    }
}
