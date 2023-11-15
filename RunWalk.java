import java.text.ParseException;

/**
 * this sets up how much the user runs
 */
public class RunWalk extends Exercise1 {
    private double distance; 

   /**
    * this is the constrocter for the running class
    * @param name
    * @param date
    * @param duration
    * @param distance
    * @throws ParseException
    */
    public RunWalk(String name, String date, int duration, double distance) throws ParseException  {
        super(name, date, duration);
        this.distance = distance;
    }

   
    @Override
    protected String getExerciseType() {
        return "run/walk";
    }

    
    @Override
    public double calculateCalories() {
        
        return (distance / getDuration()) * 9000;
    }
}