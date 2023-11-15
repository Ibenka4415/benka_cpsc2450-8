import java.text.ParseException;

/**
 * this records the weight lifted for the user
 */
public class WeightLifting extends Exercise1 {
    private int totalWeight;

   /**
    * this is the constructers for the wheghtlifting class and the getters and setter are undernetha
    * @param name
    * @param date
    * @param duration
    * @param totalWeight
    * @throws ParseException
    */
    public WeightLifting(String name, String date, int duration, int totalWeight) throws ParseException {
        super(name, date, duration);
        this.totalWeight = totalWeight;
    }

   
    @Override
    protected String getExerciseType() {
        return "weightlifting";
    }

   
    @Override
    public double calculateCalories() {
        return (totalWeight / (double) getDuration()) * 50;
    }

    
    public int getWeight() {
        return totalWeight;
    }
}