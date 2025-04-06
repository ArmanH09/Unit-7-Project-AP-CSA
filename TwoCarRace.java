// Important packages
import org.code.theater.*;
import org.code.media.*;
import java.util.*;

public class TwoCarRace extends Race {
  // Extra instance variables
  private Car car2;
  private ArrayList<String> teamNames;
  private Car car1;
  private String track;

  /**
  * Constructor for the TwoCarRace class, contains details pertaining to the cars, track, and teamnames, also uses Race class super constructor
  * 
  * @param teamNames The names of the teams
  * @param Car1 The first car in the race
  * @param Car2 The second car in the race
  * @param track The string value for the filename of the track
  * @return Creates a new TwoCarRace class that can be used to start a new race
  */
  public TwoCarRace(ArrayList<String> teamNames, Car car1, String track, Car car2) {
    super(teamNames, car1, track);
    this.car2 = car2;
    this.car1 = car1;

  }

  /**
  * Overriden method that adds a 2nd car object to return in the racers ArrayList
  * 
  * @return ArrayList of Cars containing car1 and car2
  */
  public ArrayList<Car> getRacers() {
    ArrayList<Car> ret = new ArrayList<Car>();
    ret.add(car1);
    ret.add(car2);
    return ret;
  }
}