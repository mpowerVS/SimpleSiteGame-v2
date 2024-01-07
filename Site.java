import java.util.*;

public class Site {
    private  ArrayList<String> locationCells = new ArrayList<>();
    private  String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourSelf(String userInput) {
        String result = "MISS";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "DESTROYED";
                System.out.println("You have destroyed " + name);
            } else {
                result = "HIT";
            }
        }
        return result;
    }
}
