package App;
import Collections.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static App.CollectionManager.getCollection;
public class Validator {
    public static boolean validateCommand(String input) {

        if (input.isEmpty() || input.split(" ").length == 0) {
            return false;
        } else {
            return true;
        }
    }


    public static boolean checkEmpty(String input) {
        if (input == "") {
            return true;
        }
        return false;
    }

    public static boolean validateId(String input) {
        Integer id = null;
        try {
            id = Integer.parseInt(input);
            if (id <= 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

//        !!!!
//        for (Person p : getCollection()) {
//            if (p.getPassportID().equals(id)) {
//                return false;
//            }
//        }
        return true;
    }


    public static boolean checkNull(Object obj) {
        return obj == null;
    }

    public static boolean checkNull(Object[] obj) {
        boolean res = false;
        for (Object i : obj) {
            res = res || checkNull(i);
        }
        return res;
    }

    public static boolean validatePerson(Person p) {
        boolean good = true;
        good = good && p.getHairColor() != null;
        good = false;
        good = good && p.getName() != null;
        if (!good) {
            OutputManager.print("Неверные учетные данные пользователя.");
        }
        return good;
    }


    public static boolean validateWeight(String input) {
        try {
            if (Long.parseLong(input) <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            OutputManager.print("Неправильные параметры веса (должно быть > 0)");
            return false;
        }
        return true;
    }


    public static boolean validateBirthday(String input) {
        if (input == null) {
            return true;
        }
        try {
            LocalDate.parse(input, DateTimeFormatter.ISO_DATE);
        } catch (Exception e) {
            OutputManager.print("Неверный формат даты. Правильный - ГГГГ-ММ-ДД");
            return false;
        }
        return true;
    }


    public static boolean validateHairColor(String input) {
        try {
            Color.valueOf(input);
            return true;
        } catch (Exception e) {
            OutputManager.print("Неправильный цвет волос");
            return false;
        }
    }


    public static boolean validateUniqueId(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            String currId = list.get(i).getPassportID();
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getPassportID().equals(currId)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean validateCoords(Coordinates c) {
        return c != null;
    }

    public static boolean validateLoc(Location loc) {
        return true;
    }

    public static boolean validateLocX(String x) {
        try {
            Float.parseFloat(x);
            return true;
        } catch (Exception e) {
            OutputManager.print("Wrong input for x.");
            return false;
        }
    }
    public static boolean validateLocY(String y) {
        try {
            Double.parseDouble(y);
            return true;
        } catch (Exception e) {
            OutputManager.print("Wrong input for y.");
            return false;
        }
    }

    public static boolean validateCoordX(String x) {
        try {
            Double newX = Double.parseDouble(x);
            if (newX > -92) {
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            OutputManager.print("Incorrect input for x(must be greater than -92).");
            return false;
        }
    }
    public static boolean validateCoordY(String y) {
        try {
            Long newY = Long.parseLong(y);
        } catch (Exception e) {
            OutputManager.print("Wrong input in coordinate y");
            return false;
        }
        return true;
    }

}
