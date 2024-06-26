package Collections;

public abstract class AbstractField<T,S> {

    public abstract S create(String input);

    public abstract void set(T objToChange,S newValue);

    public abstract String ask();

    public abstract boolean validate(String input);

}
