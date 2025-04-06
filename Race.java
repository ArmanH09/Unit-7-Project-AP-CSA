// Important Packages
import org.code.theater.*;
import org.code.media.*;
import java.util.*;

public class Race {
  // Instance variables, carried over to TwoCarRace class
  private ArrayList<String> teamNames;
  private Car car1;
  private String track;

  /**
  * Constructor for the Race class, contains details pertaining to the car, track, and teamnames
  * 
  * @param teamNames The names of the teams
  * @param Car1 The first car in the race
  * @param track The string value for the filename of the track
  * @return Creates a new Race class that can be used to start a new race
  */
  public Race (ArrayList<String> teamNames, Car car1, String track) {
    this.teamNames = teamNames;
    this.car1 = car1;
    this.track = track;
  }

  /**
  * Method that returns an arrayList containing the names of teams
  * 
  * @return ArrayList of Team Names
  */
  public ArrayList<String> getNames() {
    return teamNames;
  }

  /**
  * Method that returns an arrayList containing the racer
  * 
  * @return ArrayList of Cars containing Car1
  */
  
  public ArrayList<Car> getRacers() {
    ArrayList<Car> ret = new ArrayList<Car>();
    ret.add(car1);
    return ret;
  }

  /**
  * Method that returns the track/background
  * 
  * @return String value for the filename of the track/background
  */

  public String getTrack() {
    return track;
  }
}