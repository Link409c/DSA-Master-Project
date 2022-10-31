package TimeAndIntroToUnitTests;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**************************************************************************************************************
 * Time.java
 * @author Christian D Simpson
 * @version 10/27/22
 *
 * A Time object contains values for hours, minutes, and seconds using military time (hours is a value in 0
 * to 23). The operations include getters for each field, methods that increment each of the fields, a method
 * for comparing two Time objects for equality and a method that gives the string representation of the time.
 *
 * Hours, Minutes, and Seconds can never be negative. Hours can be in the range of 0-23. Minutes and Seconds
 * can be in the range of 0-59.
 *
 * Q1: No, the constructor using the computer's clock for its variables does not need the exception handling,
 *     because I am assuming the Gregorian Calendar, or Calendar classes either have their own exception
 *     handling built in, or the computer clock simply cannot generate a value outside the range of our
 *     class invariant.
 *
 * Q2: The other methods in the Time class that would need to handle illegal arguments are the setters and
 *     the increment methods.
 *************************************************************************************************************/
public class Time implements Comparable<Time>{

    //variables for the hours, minutes, and seconds
    private int hours, minutes, seconds;

    //constructors

    /**
     * default constructor uses a Gregorian Calendar Object
     * to generate values for hours, minutes, and seconds
     */
    public Time(){
        //create new Gregorian Calendar object
        GregorianCalendar g = new GregorianCalendar();
        //use getters to set each time variable
        hours = g.get(Calendar.HOUR);
        minutes = g.get(Calendar.MINUTE);
        seconds = g.get(Calendar.SECOND);
    }

    /**
     * Populated Constructor sets each parameter with user input.
     * @param anHours The hour of the time.
     * @param aMinutes The minutes of the time.
     * @param aSeconds The seconds of the time.
     */
    public Time(int anHours, int aMinutes, int aSeconds){
        if(anHours < 0){
            throw new IllegalArgumentException("Hours cannot be negative.");
        }else if(anHours > 23){
            throw new IllegalArgumentException("Hours cannot exceed 23.");
        }
        if(aMinutes < 0){
            throw new IllegalArgumentException("Minutes cannot be negative.");
        }else if(aMinutes > 59){
            throw new IllegalArgumentException("Minutes cannot exceed 59.");
        }
        if(aSeconds < 0){
            throw new IllegalArgumentException("Seconds cannot be negative.");
        }else if(aSeconds > 59){
            throw new IllegalArgumentException("Seconds cannot exceed 59.");
        }

        hours = anHours;
        minutes = aMinutes;
        seconds = aSeconds;
    }

    //getters and setters

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * toString is overridden to return the time in a clock format HH:MM:SS
     * @return Returns the hours, minutes, and seconds in a clock format.
     */
    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * Equals method is overridden to compare the time object. Within the method,
     * the passed object is cast as a Time object in order to compare its variables.
     * @param o the object to compare.
     * @return returns true if the time object variables equal the passed object variables.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours == time.hours && minutes == time.minutes && seconds == time.seconds;
    }

    /* For this step of the assignment, I realized I had
     * fixed the issues with the methods before the instructions had
     * us do the "Refactor -> Extract Method..." step, so I kept them
     * as I had them and called the methods where appropriate.
     */

    /**
     * IncrementSeconds method increments the seconds variable if under 59 seconds,
     * and calls increment minutes if needed.
     */
    public void incrementSeconds(){
        if(getSeconds() >= 0 && getSeconds() <= 58) {
            seconds++;
        }else if(getSeconds() == 59){
            setSeconds(0);
            incrementMinutes();
        }
    }

    /**
     * IncrementMinutes method increments the minutes variable if under 59 minutes,
     * and calls the increment hours method if needed.
     */
    public void incrementMinutes(){
        if(getMinutes() >= 0 && getMinutes() <= 58) {
            minutes++;
        }else if(getMinutes() == 59){
            setMinutes(0);
            incrementHours();
        }
    }

    /**
     * IncrementHours method increments the hours variable if under 23 hours,
     * and sets hours to 0 if equal to 23 hours.
     */
    public void incrementHours(){
        if(getHours() <= 22){
            hours++;
        }else if(getHours() == 23){
            setHours(0);
        }
    }

    @Override
    public int compareTo(Time o) {
        return Integer.compare(o.getHours(), getHours()) + Integer.compare(o.getMinutes(), getMinutes()
        + Integer.compare(o.getSeconds(), getSeconds()));
    }
}