package Collections;
import App.*;
class CoordinatesField extends AbstractField<Person, Coordinates>{

    private int stoppedOn = 0;
    private Long newX = null;
    private Integer newY = null;

    
    @Override
    public boolean validate(String input){
        return false;
    }

    @Override
    public void set(Person objToChange, Coordinates newValue) {

    }

    @Override
    public String ask(){
        this.stoppedOn = 0;
        return null;
    }

    @Override
    public Coordinates create(String input){
        switch (this.stoppedOn) {
            case 0: {
                String x = InputManager.ask("Введите координату Х: ");
                if(Validator.validateCoordX(x)){
                    newX = Long.parseLong(x);
                } else{
                    return null;
                }
                this.stoppedOn += 1;
            }
            case 1: {
                String y = InputManager.ask("Введите координату Y: ");
                if(Validator.validateCoordY(y)){
                    newY = Integer.parseInt(y);
                } else{
                    return null;
                }
                this.stoppedOn += 1;
                break;
            }
            default: return null;
        }
        
        
        Coordinates coords = new Coordinates(newX,newY);
        if(Validator.validateCoords(coords)){
            return coords;
        }
        return null;
    }
    
    @Override
    public String toString(){
        return "Координаты";
    }
    
} 