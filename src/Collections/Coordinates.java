package Collections;
import Parser.CsvBind;
public class Coordinates {
    @CsvBind
    private Long cordX; //Значение поля должно быть больше -92
    
    @CsvBind
    private Integer cordY; //Поле не может быть null

    public void setX(Long x){
        this.cordX = x;
    }
    public Long getX(){
        return this.cordX;
    }

    public void setY(Integer y){
        this.cordY = y;
    }
    public Integer getY(){
        return this.cordY;
    }


    public Coordinates(Long x, Integer y){
        this.cordX = x;
        this.cordY = y;
    }


    @Override
    public String toString(){
        return "\n\t x = " + this.cordX + "\n\t y = " + this.cordY;
    }
}
