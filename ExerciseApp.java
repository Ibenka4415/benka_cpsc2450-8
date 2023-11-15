import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ExerciseApp {
	 /**
     * Displays a welcome banner for the Exercise Tracker application.
     */
	public static void welcomeBanner() {
		System.out.println("*********************************************************************");
		System.out.printf("%44s","EXERCISE TRACKER V1.0\n");
		System.out.println("*********************************************************************");
	}
	 /**
     * Prints the menu options for the Exercise Tracker application.
     */
	public static void printMenu() {
		System.out.println("These are your choices:");
		System.out.println("1. Add an Exercise");
		System.out.println("2. Print Exercises to File");
		System.out.println("3. List sorted by Date");
		System.out.println("4. List sorted by Calories Burned");
		System.out.println("5. Exit");
		
	}
	
	/**
     * Describes the workout and prompts the user to enter the type of exercise.
     */
	    
	public static void describeWorkout() {
        System.out.println("Describe your workout:");
        System.out.print("Enter R for run/walk, W for weightlifting, or C for Rock Climbing: ");
    }
	    
	private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Exercise1> exercises = new ArrayList<>();
    /**
     * The main method of the Exercise Tracker application.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws ParseException If there is an error parsing the date.
     */
    public static void main(String[] args) throws ParseException {

        welcomeBanner();
        String choice;
        String workoutChoice;
        String workoutName = "", comments, workoutDates;
        
        do {
            printMenu();
            System.out.print("Enter the number of your choice: ");
            choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    describeWorkout();
                    workoutChoice = sc.nextLine();
                   
                   
                    Exercise1 exercise = null;
                    try {
                        if (workoutChoice.equalsIgnoreCase("r")) {
                            workoutName = "run/walk";
                            System.out.print("Enter a name for the workout:");
                            String name = sc.nextLine();
                            if (name.isEmpty()) {
                                name = workoutName; 
                            }
                            System.out.print("Enter the Date of the workout (MM/dd/yyyy):");
                            workoutDates = sc.nextLine();
                            System.out.print("How long did you work out in minutes:");
                            int duration = sc.nextInt();
                            System.out.print("Enter distance you ran or walked in miles: ");
                            double distance = sc.nextDouble();
                            sc.nextLine();
                            exercise = new RunWalk(name, workoutDates, duration, distance);
                            System.out.print("Enter a comment about the workout:");
                            comments = sc.nextLine();
                            
                            
                        } else if (workoutChoice.equalsIgnoreCase("w")) {
                        	workoutName = "WeightLifting";
                        	System.out.print("Enter a name for the workout:");
                            String name = sc.nextLine();
                            if (name.isEmpty()) {
                                name = workoutName; 
                            }
                        	System.out.print("Enter the Date of the workout (MM/dd/yyyy):");
                            workoutDates = sc.nextLine();
                            System.out.print("How long did you work out in minutes:");
                            int duration = sc.nextInt();
                        	System.out.print("Enter total weight lifted in pounds: ");
                            int totalWeight = sc.nextInt();
                            sc.nextLine();
                            exercise = new WeightLifting(name, workoutDates, duration, totalWeight);
                            System.out.print("Enter a comment about the workout:");
                            comments = sc.nextLine();
                           
                           
                        } else if (workoutChoice.equalsIgnoreCase("c")) {
                        	workoutName = "RockClimbing";
                        	System.out.print("Enter a name for the workout:");
                            String name = sc.nextLine();
                            if (name.isEmpty()) {
                                name = workoutName; 
                            }
                        	System.out.print("Enter the Date of the workout (MM/dd/yyyy):");
                            workoutDates = sc.nextLine();
                            System.out.print("How long did you work out in minutes:");
                            int duration = sc.nextInt();
                            System.out.print("Enter the height of the wall in feet: ");
                            System.out.print("Enter the height of the wall in feet: ");
                            double totalHeight = sc.nextDouble();
                            System.out.print("Enter number of times you climbed it: ");
                            int totalRepetitions = sc.nextInt();
                            sc.nextLine();
                            exercise = new RockClimbing(name, workoutDates, duration, totalHeight, totalRepetitions);
                            System.out.print("Enter a comment about the workout:");
                            comments = sc.nextLine();
                            
                          
                        } else {
                            System.out.println("Please enter a valid character");
                            describeWorkout();
                            workoutChoice = sc.nextLine();
                        }
                        if (exercise != null) {
                            exercises.add(exercise);
                            System.out.println("Exercise added successfully!\n");
                        }
                    } catch (ParseException e) {
                        System.out.println("There was an error parsing the date. Please try again.");
                    }
                
                    break;

                case "2":
                    ExerciseWriter.writeToFile("exercises.txt", exercises);
                    break;

                case "3":
                    Collections.sort(exercises);
                    System.out.println("Exercises sorted by Date:");
                    ExerciseWriter.tabulateSummary(exercises);
                    break;

                case "4":
                    Collections.sort(exercises, new ExerciseCompareByCalories());
                    System.out.println("Exercises sorted by Calories Burned:");
                    ExerciseWriter.tabulateSummary(exercises);
                    break;

                case "5":
                    System.out.println("Thanks you for using this Program!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (!choice.equals("5"));
    }
}