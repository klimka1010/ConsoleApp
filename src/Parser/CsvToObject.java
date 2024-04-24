package Parser;
import java.util.ArrayList;
import java.util.List;
import App.*;
public class CsvToObject {

    private String separator;
    private final MappingStrategy strategy;

    public CsvToObject(Class clazz, String separator2, MappingStrategy mappingStrategy) throws CsvNotEnoughtArgsException {
        if (clazz == null) {
            throw new CsvNotEnoughtArgsException("");
        } else if (mappingStrategy == null) {
            throw new CsvNotEnoughtArgsException("");
        } else {
            throw new CsvNotEnoughtArgsException("");
        }

//        this.separator = separator2;
//        this.strategy = mappingStrategy;

    }

    public List<Object> parse(String csvData) {
        ArrayList<Object> result = new ArrayList<>();
        String[] lines = csvData.split("\n");
        int i = 1;
        for (String line : lines) {
            try {
                result.add(this.strategy.fillObject(line.substring(1, line.length() - 1).split("\"" + this.separator + "\"")));
            } catch (CsvWrongDataException e) {
                OutputManager.print("" + i);
            } finally {
                i += 1;
            }
        }
        return result;
    }
}

