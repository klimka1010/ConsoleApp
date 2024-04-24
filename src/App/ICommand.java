package App;
import java.io.IOException;
public interface ICommand {

    public boolean execute(String[] args) throws IOException;
}
