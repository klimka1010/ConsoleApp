package Collections;
import App.*;
/**
 * location field of person
 *
 */
public class LocationField extends AbstractField<Person, Location>{

    private Long newX = null;
    private Integer newY = null;
    private int stoppedOn = 0;
    

    @Override
    public boolean validate(String input){
        return false;
    }

    @Override
    public void set(Person objToChange, Location newValue) {

    }

    @Override
    public String ask(){
        this.stoppedOn = 0;
        return "";
    }
    
    @Override
    public Location create(String input){
        switch (this.stoppedOn) {
            case 0: {
                String x = InputManager.ask("Введите координату Х: ");
                if(Validator.validateLocX(x)){
                    newX = Long.parseLong(x);
                } else{
                    return null;
                }
                this.stoppedOn += 1;
            }
            case 1: {
                String y = InputManager.ask("Введите координату Y: ");
                if(Validator.validateLocY(y)){
                    newY = Integer.parseInt(y);
                } else{
                    return null;
                }
                this.stoppedOn += 1;
                break;
            }
            default: return null;
        }
        
        
        String name = InputManager.ask("Введите название местоположения: ");
        if(name == ""){
            name = null;
        }
        Location loc = new Location(newX, newY, name);
        if(Validator.validateLoc(loc)){
            return loc;
        }
        return null;
    }



    @Override
    public String toString(){
        return "Местоположение";
    }
    
}