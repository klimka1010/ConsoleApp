package Parser;
public class CsvWrongStructureException extends RuntimeException {

    private String message;

    public CsvWrongStructureException(String s) {
    }

    public void CsvWrongDataException (String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
