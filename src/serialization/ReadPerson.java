package serialization;
import Collections.Person;
import App.*;
import Parser.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
/**
 * read CSV data from file, and parse it to list of Persons
 *
 */
public class ReadPerson {

    /**
     * read data from CSV file and deserialize it.
     *
     * @param filename File with CSV data
     * @return Collection of Persons
     * @throws IOException          if error in file reading
     * @throws NullPointerException if trying to read a null file.
     */
    public static List<Person> read(File filename) throws IOException,NullPointerException{
        
        FileReader reader = new FileReader(filename);
        Scanner scan = new Scanner(reader);
        String csvData = "";
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            if(!(line == "")){
                csvData += line + "\n";
            }
        }
        
        try{
            PersonMappingStrategy strategy = new PersonMappingStrategy();
            List<Person> list = (List<Person>)(List<?>) new CsvToObject(Person.class,",",strategy).parse(csvData);
            if(!Validator.validateUniqueId(list)){
                OutputManager.print("Неуникальный Айди!");
                return null;
            }
            return list;
        } catch(Exception e){
            return null;
        }
    }
    
}
