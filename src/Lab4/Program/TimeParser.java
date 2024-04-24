package Lab4.Program;

/**
 * implements a method parseTimeToMinutes(String time), that
 * takes a String representing a given time (e.g., 5:30 PM) and attempts to parse it and return the
 * number of minutes past midnight that the specified time represents.
 */
public class TimeParser {
    private int MINS_PER_HR = 60;
    private int MAX_HRS = 23;
    private int MAX_MINS = 59;
    public int parseTimeToMinutes(String time){
        // Normalize the input (trim whitespace and make lower case)
        time = time.trim().toLowerCase();
        int firstColon = time.indexOf(':');
        if (firstColon == -1) {
            return -1;
        }
        // Interpret everything up to the first colon as the hour
        int hours = Integer.valueOf(time.substring(0, firstColon));
        // Interpret everything between the two colons as the minute
        int minutes = Integer.valueOf(time.substring(firstColon+1, firstColon +3));
        //Interpret the two characters after the second colon as the seconds
        if (time.contains("pm")) {
            hours += 12;
        }
        if (minutes > MAX_MINS)
        {
            hours += 1;
            minutes = minutes - MINS_PER_HR;
        }
        if(hours > MAX_HRS)
        {
            hours = hours - 24;
        }
        //Calculate number of minutes since midnight
        return (hours * MINS_PER_HR) + minutes;
    }
}
