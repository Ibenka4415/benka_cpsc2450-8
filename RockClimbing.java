import java.text.ParseException;

/**
 * this down here gets the height and how many times the user clibed that day
 */
public class RockClimbing extends Exercise1 {
    private double totalHeight;
    private int totalRepetitions;

   /**
    * this down here is the constructer for the rock climbing
    * @param name
    * @param dateStr
    * @param duration
    * @param totalHeight
    * @param totalRepetitions
    * @throws ParseException
    */
    public RockClimbing(String name, String dateStr, int duration, double totalHeight, int totalRepetitions) throws ParseException {
        super(name, dateStr, duration);
        this.totalHeight = totalHeight;
        this.totalRepetitions = totalRepetitions;
    }

   
    @Override
    protected String getExerciseType() {
        return "rock climbing";
    }

    
    @Override
    public double calculateCalories() {
        return (totalHeight * totalRepetitions / (double) getDuration()) * 100;
    }

   
    public double getHeight() {
        return totalHeight;
    }

    
    public int getRepetitions() {
        return totalRepetitions;
    }
}