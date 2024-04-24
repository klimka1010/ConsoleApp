package Collections;
import Parser.CsvBind;
public class Location implements Comparable<Location> {
    @CsvBind
    private Long locX;
    public Long getLocX(){
        return this.locX;
    }

    @CsvBind
    private Integer locY;
    public Integer getLocY(){
        return this.locY;
    }

    @CsvBind
    private String locName; //Поле может быть null
    public String getName(){
        return this.locName;
    }

    public Location(Long x, Integer y, String name){
        this.locX = x;
        this.locY = y;
        this.locName = name;
    }
  

    /**
     * Checks if all the fields have the same value.
     * @param loc another location
     * @return 0 if OK
     */
    @Override
    public int compareTo(Location loc){
        boolean good = this.locX.compareTo(loc.locX) == 0;
        good = good && (this.locY.compareTo(loc.locY) == 0);
        try{
            good = good && (this.locName.compareTo(loc.getName()) == 0);
        }catch (NullPointerException e){
            if (!(this.locName == null && loc.getName() == null)){
                good = false;
            }
        }
        
        if(good){
            return 0;
        }
        return 1;
    }

    
    @Override
    public String toString(){
        return "\n\t x = " + locX + "\n\t y = " + locY + "\n\t name = " + locName;
    }
    
    @Override
    public int hashCode(){
        return this.getLocX().intValue() * 3 + this.getLocY().intValue() * 7 + this.getName().length() * 13;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(this.hashCode() != obj.hashCode()){
            return false;
        }
        if(!(obj instanceof Location)){
            return false;
        }
        Location obj2 = (Location) obj;
        return (this.getLocX().compareTo(obj2.getLocX()) == 0 && (this.getLocY().compareTo(obj2.getLocY()) == 0 && this.getName().compareTo(obj2.getName()) == 0));
    }
}
