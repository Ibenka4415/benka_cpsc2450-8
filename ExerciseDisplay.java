import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
public class ExerciseDisplay extends JPanel{
	private JTextField txtX ;
	private JTextField duration;
	private JTextField txtY;
	private JTextField txtR;
	private JTextArea tarComment;
	
	/**
	 * this make the intake for the runwalk work out in the top left
	 * it takes in the user inputs
	 */
	public void setupGUI() {
		setLayout(new BorderLayout());
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new GridLayout(6,4));
		panNorth.add(new JLabel("Name"));
		txtX = new JTextField(8);
		panNorth.add(txtX);
		panNorth.add(new JLabel("Date:"));
		 duration = new JTextField(8);
		panNorth.add(duration);
		panNorth.add(new JLabel("Duration:"));
		 txtY = new JTextField(8);
		panNorth.add(txtY);
		panNorth.add(new JLabel("Distance: "));
		txtR = new JTextField(8);
		panNorth.add(txtR);
		add(panNorth,BorderLayout.NORTH);
		JPanel panComment = new JPanel();
		panComment.setLayout(new BorderLayout());
		panComment.add(new JLabel("Add Comments: "), BorderLayout.NORTH);
		tarComment = new JTextArea(5,10);
		panComment.add(tarComment,BorderLayout.CENTER);
		add(panComment,BorderLayout.CENTER);
		
	}
	public ExerciseDisplay() {
		setupGUI();
	}
	public String getName() {
		return txtX.getText();
	}
	public String getDate() {
		return duration.getText();
	}
	public Double getDuration() {
		return Double.parseDouble(txtY.getText());
	}
	public double getDistance() {
		return Double.parseDouble(txtR.getText());
	}
	public String getComment() {
		return tarComment.getText();
	}
	/**
	 * this clears the entries after they saved to summary
	 */
	public void clearEntries() {
		txtX.setText("");
		duration.setText("");
		txtY.setText("");
		txtR.setText("");
		tarComment.setText("");
	}
	/**
	 * this allows these things to be enavled or disabled
	 * @param enabledYN
	 */
	public void enableEntries(boolean enabledYN) {
		txtX.setEnabled(enabledYN);
		duration.setEnabled(enabledYN);
		txtY.setEnabled(enabledYN);
		txtR.setEnabled(enabledYN);
		tarComment.setEnabled(enabledYN);
		
	}
	
}
