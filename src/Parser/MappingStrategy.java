package Parser;
import java.util.List;
public interface MappingStrategy {

    public String[] getHeader();
    public Object fillObject(String[] lines);
    public List<String> getObject(Object obj);
}
