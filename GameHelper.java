import java.util.*;
import java.io.*;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int siteCount = 0;

    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0)
                return null;
        } catch (IOException e){
            System.out.println(e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeSite(int siteSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[siteSize];
        String temp = null;
        int[] coords = new int[siteSize];
        int attempts = 0;
        boolean isSuccess = false;
        int location = 0;

        siteCount++;
        int incr = 1;
        if (siteCount % 2 == 1){
            incr = gridLength;
        }

        while ((!isSuccess & attempts++ < 200)){
            location = (int) (Math.random() * gridSize);
            //System.out.println(location);
            int x = 0;
            isSuccess = true;
            while (isSuccess && x < siteSize){
                if(grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSize){
                        isSuccess = false;
                    }
                    if (x > 0  && (location % gridLength == 0)){
                        isSuccess = false;
                    }
                } else {
                    //System.out.println("using" +location);
                    isSuccess = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;

        while (x < siteSize){
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }
}
