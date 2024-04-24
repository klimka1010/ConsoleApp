package Parser;
public class CsvWrongDataException extends RuntimeException {

    private String message;

    public CsvWrongDataException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}

