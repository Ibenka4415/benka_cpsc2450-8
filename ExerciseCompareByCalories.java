
import java.util.Comparator;
/**
 * this is how we sort by calories burned
 */
public class ExerciseCompareByCalories implements Comparator<Exercise1> {
    @Override
    public int compare(Exercise1 one, Exercise1 two) {
        double cal1 = one.calculateCalories();
        double cal2 = two.calculateCalories();

        if (cal1 < cal2) {
            return -1;
        } else if (cal1 == cal2) {
            return 0;
        } else {
            return 1;
        }
    }
}

	
	
	

