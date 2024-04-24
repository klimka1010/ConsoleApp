package Parser;
public class CsvNotEnoughtArgsException extends RuntimeException {
    private final String message;

    public CsvNotEnoughtArgsException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
