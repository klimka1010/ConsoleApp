package App;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile extends File {

    private FileReader reader;
    private Scanner scanner;

    public ReadFile(String filename) throws IOException {
        super(filename);
        this.reader = new FileReader(filename);
        this.scanner = new Scanner(this.reader);
    }


    public String readLine() {
        if (this.scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

    public void close() {
        this.scanner.close();
        try {
            this.reader.close();
        } catch (IOException e) {
            OutputManager.print("Операция отклонена");
        }
    }
}
