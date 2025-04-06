// Important Packages
import org.code.theater.*;
import org.code.media.*;
import java.util.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Creates RaceRunenr object
    RaceRunner TheRace = new RaceRunner();

    // User can use this to edit team names
    ArrayList<String> Teams = new ArrayList<String>();
    Teams.add("Green Bean");
    Teams.add("Red Rock");

    // User can use this to edit the friendly and foe cars
    Car ArmansViper = new Car(3444, 3500, "UrCar.png");
    Car EnemyZR1 = new Car(3560, 755, "FoeCar.png");

    // Instantiates the first and second race objects using given information above
    Race firstRace = new Race(Teams, ArmansViper, "drag.png");
    TwoCarRace secondRace = new TwoCarRace(Teams, ArmansViper, "drag.png", EnemyZR1);

    // Calls the drawRace method to get the scene ready
    TheRace.drawRace(firstRace, secondRace);

    // Starts the theater to play the race
    Theater.playScenes(TheRace);
  }
}