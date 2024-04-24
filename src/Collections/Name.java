package Collections;
import App.InputManager;
public class Name extends AbstractField<Person, String> {

    @Override
    public void set(Person p, String name) {
        p.setName(name);
    }

    @Override
    public boolean validate(String input) {
        if (input != "") {
            return true;
        }
        return false;
    }


    @Override
    public String ask() {
        return InputManager.ask("Введите имя: ");
    }

    @Override
    public String create(String input){
        return input;
    }

    @Override
    public String toString(){
        return "Имя";
    }
}
