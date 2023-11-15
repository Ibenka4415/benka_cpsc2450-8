import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * this wrights to the screen so the user can see
 */
public class ExerciseWriter {
	public static void tabulateSummary(List<Exercise1> exercises) {
      
        for (Exercise1 exercise : exercises) {
            System.out.println(exercise.toString());
        }
    }
/**
 * this wrights to the file for the user
 * @param filename
 * @param exercises
 */
	public static void writeToFile(String filename, List<Exercise1> exercises) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Exercise1 exercise : exercises) {
                writer.write(exercise.toString());
                writer.newLine();
            }
            System.out.println("Exercises were successfully Tracked");
        } catch (IOException e) {
            System.out.println("Exercises were not Tracked to file: " + e.getMessage());
        }
	}
	
	
}
