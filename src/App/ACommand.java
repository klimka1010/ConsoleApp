package App;

public abstract class ACommand implements ICommand {

    protected String name;
    protected String description;

    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
}
