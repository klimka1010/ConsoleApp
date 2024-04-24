package Collections;

import App.*;
/**
 * Height field of person.
 */
class Weight extends AbstractField<Person,Long>{
    @Override
    public void set(Person p, Long h){
        p.setWeight(h);
    }
    
    @Override
    public boolean validate(String input){
        return Validator.validateWeight(input);
    }
    
    @Override
    public String ask(){
        return InputManager.ask("Введите вес: ");
    }
    
    @Override
    public Long create(String input){
        return Long.parseLong(input);
    }
    
    @Override
    public String toString(){
        return "Вес";
    }
}