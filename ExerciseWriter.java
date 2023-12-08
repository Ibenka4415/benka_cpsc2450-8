import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/**
 * this wrights to the screen so the user can see
 */
public class ExerciseWriter {
	
/**
 * this wrights to the file for the user
 * @param f
 * @param runWalk
 * @return 
 */
	public static boolean writeToFile(File f, ArrayList<RunWalk> runWalk) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            for (Exercise1 exercise : runWalk) {
                writer.write(exercise.toString());
                writer.newLine();
            }
            System.out.println("Exercises were successfully Tracked");
        } catch (IOException e) {
            System.out.println("Exercises were not Tracked to file: " + e.getMessage());
        }
		return false;
	}
	
	
}
