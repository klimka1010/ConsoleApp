package Collections;
import java.time.LocalDate;
/**
 * CreationDate field of Person(generated automatically)
 */
class CreationDate extends AbstractField<Person,LocalDate>{
    
    @Override
    public void set(Person p, LocalDate ld){
        p.setBirthday(ld.atStartOfDay());
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
    public LocalDate create(String Uselessinput){
        return LocalDate.now();
    }
    
    @Override
    public String toString(){
        return "Дата создания";
    }
}