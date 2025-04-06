// Important Java packages
import org.code.theater.*;
import org.code.media.*;
import java.util.*;

public class Car {
  //Instance Variables
  private int weight;
  private int power;
  private int ET;
  private int TrapSpeed;
  private double stepSize;
  private String decal;

  /**
  * Constructor for the Car class, contains details pertaining to weight, power, and quarter mile trap speeds and Elapsed Times.
  * 
  * @param weight The weight of the car in pounds
  * @param power The power of the car measured in horsepower
  * @param decal The filename for the image representing the car
  * @return Creates a new car class and uses given inputs to calculate ET, TrapSpeed, and stepSize
  */
  
  public Car(int weight, int power, String decal) {
    this.weight = weight;
    this.power = power;
    this.decal = decal;
    ET = getET(weight, power);
    TrapSpeed = getSpeed(weight, power);
    stepSize = calcStepSize(ET);
  }

  /**
  * Private method that uses a formula to calculate a car's Elapsed Time in the Quarter Mile using its weight and power
  * 
  * @param weight The weight of the car in pounds
  * @param power The power of the car measured in horsepower
  * @return Integer value representing how many seconds it will take for the car to go a quarter mile.
  */

  private int getET (int weight, int power) {
    double w = (double) weight;
    double p = (double) power;

    return (int) (6.290 * Math.pow(w/p, 0.33));
  }

  /**
  * Private method that uses a formula to calculate a car's Trap Speed in the Quarter Mile using its weight and power
  * 
  * @param weight The weight of the car in pounds
  * @param power The power of the car measured in horsepower
  * @return Integer value representing the car's final speed (in MPH) at the end of the quarter mile. 
  */
  
  private int getSpeed (int weight, int power) {
    double w = (double) weight;
    double p = (double) power;

    return (int) (224.0 * Math.pow(p/w, 0.33));
  }

  /**
  * Private method that calculates how far the car will have to move per second in order to finish the Quarter Mile in it's calculated ET
  * 
  * @param ET The Elapsed Time of the car in the quarter mile
  * @return How big of a step it will need to take per second to travel the quarter mile (Total travel of 370 on the x axis in the theater) in its calcualted ET
  */

  private double calcStepSize(int ET) {
    return (370 / ET);
  }

  /**
  * Method that returns the stepSize of the car
  * 
  * @return The instance variable of step size for the car
  */
  public int getStepSize() {
    return (int) stepSize;
  }

  /**
  * Method that returns the decal of the car
  * 
  * @return String of the filename for the decal
  */
  public String getDecal() {
    return decal;
  }

  /**
  * Method that returns the Elapsed Time of the Car
  * 
  * @return The instance variable of the ET for the car
  */
  public int retET() {
    return ET;
  }

  /**
  * Method that returns the Trap Speed of the car
  * 
  * @return The instance variable of the TrapSpeed for the car
  */

  public int retTrap() {
    return TrapSpeed;
  }
}