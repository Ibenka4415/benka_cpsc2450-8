import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This abstract class represents an exercise with basic properties like name, date, duration, and comments.
 * It also provides methods for calculating calories and comparing exercises based on their dates.
 */
public abstract class Exercise1 implements Comparable<Exercise1> {
    private String name;
    private Date date;
    private int duration;
    private String comment;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Constructs an Exercise object with the specified name, date string, and duration.
     *
     * @param name       The name of the exercise.
     * @param dateString A string representing the date of the exercise in "dd/MM/yyyy" format.
     * @param duration   The duration of the exercise in minutes.
     * @throws ParseException If the date string is not in the correct format.
     */
    public Exercise1(String name, String dateString, int duration) throws ParseException {
        this.name = name;
        this.date = formatter.parse(dateString);
        this.duration = duration;
        this.comment = "";
    }
/**
 * these are all the setters and all the getters down below
 * @return
 */
    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    protected abstract String getExerciseType();

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public abstract double calculateCalories();
    /**
     * Compares two exercises based on their dates.
     * @param other The other exercise to compare to.
     * @return A negative integer, zero, or a positive integer if this exercise is before, equal to, or after the specified exercise.
     */
    @Override
    public int compareTo(Exercise1 other) {
        return this.date.compareTo(other.date);
    }
    /**
     * Returns a formatted string representation of the exercise.
     * @return A formatted string with exercise type, name, date, and calculated calories.
     */
    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %.2f ", getExerciseType(), getName(), formatter.format(getDate()), calculateCalories());
    }
}
