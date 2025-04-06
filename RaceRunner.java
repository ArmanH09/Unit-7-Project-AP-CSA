// Important Packages
import org.code.theater.*;
import org.code.media.*;
import java.util.*;

//Subclass of Scene object
public class RaceRunner extends Scene {

  /**
  * Method to draw the scene for the Race, will play a countdown and the car will cross the track and their ET and TrapSpeed will be displayed when the race is over
  * 
  * @param race Race object, Runner class will use all the information in the Race object to draw a solo race
  * @return Will draw the scene of the race.
  */
  private void startRace(Race race) {
    // Prep the scene and place down the background and cars
    clear("white");
    Car car = race.getRacers().get(0);
    int StepSize = -1 * (car.getStepSize());
    drawImage(race.getTrack(), 0, 100, 400);
    drawImage(car.getDecal(), 370, 200, 30);

    // Play the sound and wait for the race to start
    playSound("RaceStart.wav");
    pause(3);

    // Will repeat until the car crosses the finish line
    for (int i = 0; i <= car.retET(); i++) {
      // Resets and redraws scene every second with the car in its updated position
      clear("white");
      drawImage(race.getTrack(), 0, 100, 400);
      drawImage(car.getDecal(), 370 + (StepSize * i) , 200, 30);
      pause(1);
    }
    // Shows the car's ET and Trap Speed when the race is over
    drawText(race.getNames().get(0) + " Time:", 100, 20);
    drawText(car.retET() + ".00 @ " + car.retTrap() + ".00", 120, 50);
  }

  /**
  * Overloaded method to draw the scene for the Race, will play a countdown and the cars will cross the track and their ETs and TrapSpeeds will be displayed when the race is over
  * 
  * @param race TwoCarRace object, Runner class will use all the information in the Race object to draw a race with a friendly (you) and foe (enemy)
  * @return Will draw the scene of the race and will display their times.
  */

  private void startRace(TwoCarRace race) {
    // Preps the scene and places the background and cars
    clear("white");
    ArrayList<Car> OG = race.getRacers();
    ArrayList<Car> cars = retFastCarFirst(OG);
    Car fastCar = cars.get(0);
    Car slowCar = cars.get(1);
    int StepSize1 = -1 * (fastCar.getStepSize());
    int StepSize2 = -1 * (slowCar.getStepSize());
    drawImage(race.getTrack(), 0, 100, 400);
    drawImage(fastCar.getDecal(), 370, 200, 30);
    drawImage(slowCar.getDecal(), 370, 225, 30);
    // Play the sound and waits for the race to start
    playSound("RaceStart.wav");
    pause(3);
    // Will repeat until slower car finishes
    for (int i = 0; i <= slowCar.retET(); i++) {
      if (i <= fastCar.retET()) {
        // Updates the background and cars until the first car finishes
        clear("white");
        drawImage(race.getTrack(), 0, 100, 400);
        drawImage(fastCar.getDecal(), 370 + (StepSize1 * i ), 200, 30);
        drawImage(slowCar.getDecal(), 370 + (StepSize2 * i ), 225, 30);
        pause(1);
      } else if (i >  fastCar.retET()) {
        // Updates the background and cars until the last car finishes, first car will stay at the finish line
        clear("white");
        drawImage(race.getTrack(), 0, 100, 400);
        drawImage(fastCar.getDecal(), 0, 200, 30);
        drawImage(slowCar.getDecal(), 370 + (StepSize2 * i), 225, 30);
        pause(1);
      }
      
    }

    // Print out the ETs and TrapSpeeds of both teams
    drawText(race.getNames().get(0) + " Time:", 100, 20);
    drawText(fastCar.retET() + ".00 @ " + fastCar.retTrap() + ".00", 120, 50);
    drawText(race.getNames().get(1) + " Time:", 100, 350);
    drawText(slowCar.retET() + ".00 @ " + slowCar.retTrap() + ".00", 100, 375);
  }

  /**
  * Private method to sort the car objects based on ET, whichever car has the faster (lower num) ET will be put in the first element, and the slower car goes into the 2nd element
  * 
  * @param Racers arrayList of the Car objects that will be sorted
  * @return Will return an ArrayList of Cars with the first car always being faster than the second.
  */
  private ArrayList<Car> retFastCarFirst(ArrayList<Car> Racers) {
    ArrayList<Car> ret = new ArrayList<Car>();

    Car fcar = Racers.get(0);
    Car scar = Racers.get(1);

    if (fcar.retET() > scar.retET()) {
      ret.add(scar);
      ret.add(fcar);
    } else {
      ret.add(fcar);
      ret.add(scar);
    }
    
    return ret;
  }

  /**
  * Method to draw the scene for both of the Races, includes a pause between races so watchers can see who won
  * 
  * @param first Race object, will call the startRace method with the Race object to start the first race.
  * @param second TwoCarRace object, will call the startRace method with the TwoCarRace object to start the second race
  * @return Will draw both of the races with a pause inbetween to give audience time to process times, speeds, and who won.
  */
  public void drawRace(Race first, TwoCarRace second) {
    startRace(first);
    pause(3);
    startRace(second);
  }
}