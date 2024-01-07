import java.util.*;

public class SiteGame {

    private GameHelper helper = new GameHelper();
    private ArrayList<Site> siteList = new ArrayList<Site>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        Site one = new Site();
        one.setName("facebook.com");
        Site two = new Site();
        two.setName("instagram.com");
        Site three = new Site();
        three.setName("youtube.com");
        siteList.add(one);
        siteList.add(two);
        siteList.add(three);

        System.out.println("Your task is to destroy 3 sites");
        System.out.println("facebook.com, instagram.com, youtube.com");
        System.out.println("Available cells are [0-6] and [a-g]");

        for(Site siteToSet : siteList){
            ArrayList<String> newLocation = helper.placeSite(3);
            siteToSet.setLocationCells(newLocation);
        }
    }

    private  void startPlaying(){
        while(!siteList.isEmpty()){
            String userGuess = helper.getUserInput("Enter the cell: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private  void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "MISS";

        for(Site siteToTest : siteList){
            result = siteToTest.checkYourSelf(userGuess);
            if(result.equals("HIT")){
                break;
            }
            if(result.equals("DESTROYED")){
                siteList.remove(siteToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private  void finishGame(){
        System.out.println("All sites have been destroyed!");
        System.out.println("You used " + numOfGuesses + " guesses!");
    }

    public static void main(String[] args) {

        SiteGame game = new SiteGame();
        game.setUpGame();
        game.startPlaying();
    }
}