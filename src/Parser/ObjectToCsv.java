package Parser;
import java.util.List;
public class ObjectToCsv {

    private final Class targetClass;
    private String separator = ",";
    private MappingStrategy strategy;

    public ObjectToCsv(Class clazz, String separator2, MappingStrategy mappingStrategy) throws CsvNotEnoughtArgsException {
        if (clazz == null) {
            throw new CsvNotEnoughtArgsException("Необходимо указать целевой класс!");
        } else if (mappingStrategy == null) {
            throw new CsvNotEnoughtArgsException("Необходимо указать стратегию отображения!");
        }

        this.targetClass = clazz;
        this.separator = separator2;
        this.strategy = mappingStrategy;
    }


    public String convert(List<Object> list) throws CsvWrongStructureException {
        String result = "";
        for (Object obj : list) {
            result += this.convert(obj) + "\n";
        }
        return result;
    }

    private String convert(Object obj) throws CsvWrongStructureException {
        String result = "\"";
        List<String> data = (List<String>) this.strategy.getObject(obj);
        for (String filedValue : data) {
            result += filedValue + "\"" + separator + "\"";
        }

        return result.substring(0, result.length() - 2);
    }


    public Class getTargetClass() {
        return this.targetClass;
    }

    public MappingStrategy getMappingStrategy() {
        return this.strategy;
    }

    public String getSeparator() {
        return this.separator;
    }

}
