package Collections;
import java.time.LocalDateTime;
public class Person implements Comparable<Person> {

    private String name;                        //Поле не может быть null, Строка не может быть пустой
    private LocalDateTime birthday;             //Поле может быть null
    private float weight;                       //Значение поля должно быть больше 0
    private String passportID;                  //Длина строки не должна быть больше 36, Длина строки должна быть не меньше 6, Поле может быть null
    private Color hairColor;                    //Поле не может быть null

    public Person() {

    }

    @Override
    public int compareTo(Person p) {
        return this.getPassportID().compareTo(p.getPassportID());
    }


    @Override
    public boolean equals(Object obj) {
        if (obj.hashCode() != this.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person obj2 = (Person) obj;
        return this.compareTo(obj2) == 0 ? true : false;
    }

    @Override
    public int hashCode() {
        return this.getPassportID().hashCode();
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }


    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
    public String getPassportID() {
        return passportID;
    }


    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }
    public Color getHairColor() {
        return hairColor;
    }


}
