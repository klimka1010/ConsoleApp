package Collections;

import App.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Birthday field of Person.
 *
 */
class Birthday extends AbstractField<Person, LocalDate>{
    
    @Override
    public void set(Person p, LocalDate b){
        p.setBirthday(b.atStartOfDay());
    }
    
    @Override
    public boolean validate(String input){
        return Validator.validateBirthday(input);
    }
    
    @Override
    public String ask(){
        return InputManager.ask("Введите ДР: ");
    }
    
    @Override
    public LocalDate create(String input){
        return LocalDate.parse(input, DateTimeFormatter.ISO_DATE);
    }
    
    @Override
    public String toString(){
        return "ДР";
    }
    
}