package Collections;
import App.*;
import java.util.ArrayList;
/**
 * id field of person
 *
 */
public class Id extends AbstractField<Person, Integer> {
    
    @Override
    public void set(Person p, Integer id){
        p.setPassportID(String.valueOf(id));
    }
    
    @Override
    public boolean validate(String input){
        return false;
    }
    
    @Override
    public String ask(){
        return "";
    }
    
    @Override
    public Integer create(String Uselessinput){
        ArrayList<Person> collection = CollectionManager.getCollection();
        if(collection.size() == 0){
            return 1;
        }
        return Integer.valueOf(collection.get(collection.size() - 1).getPassportID() + 1);
    }
    
    @Override
    public String toString(){
        return "Дата создания";
    }
}
