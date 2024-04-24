package serialization;
import App.OutputManager;
import Collections.Person;
import Parser.MappingStrategy;
import Parser.ObjectToCsv;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * Write collection to CSV format and save to file.(serialization)
 *
 */
public class WritePerson {
    /**
     * Serialize and write
     * @param list collection of Persons
     * @param filename Name of a file,where we'll save our CSV data
     * @return true, if no exceptions encountered
     * @throws IOException if error in file reading
     */
    public static Boolean write(ArrayList<Person> list, File filename) throws IOException{
        
        PrintWriter file = new PrintWriter(filename);
        
        try{
            PersonMappingStrategy mappingStrategy = new PersonMappingStrategy();
            ObjectToCsv csvParser = new ObjectToCsv((Class) Person.class,",", (MappingStrategy) mappingStrategy);
            String csvData = csvParser.convert((List<Object>)(List<?>)list);
            file.write(csvData);
            file.close();
            return true;
        
        } catch(Exception e){
            OutputManager.print(e.getMessage());
            file.close();
            return false;
        } 
    }
}
