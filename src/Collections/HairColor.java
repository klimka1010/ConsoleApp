package Collections;
import App.*;
/**
 * HairColor field of person
 *
 */
class HairColor extends AbstractField<Person, Color>{
    
    @Override
    public void set(Person p, Color c){
        p.setHairColor(c);
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
    public Color create(String Uselessinput){
        if (!Invoker.getModeState()){
            OutputManager.print("Доступные цвета волос: \n");
            for (Color c : Color.values()){
                OutputManager.print(c);
            }
        }
        String input = InputManager.ask("Введите цвет волос: ");
        if(Validator.validateHairColor(input.toUpperCase())){
            return Color.valueOf(input.toUpperCase());
        }
        return null;
    }
    
    @Override
    public String toString(){
        return "Цвет";
    }
}