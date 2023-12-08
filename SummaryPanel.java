import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class SummaryPanel extends JPanel {
	private ArrayList<RunWalk> runWalk;
	private JTextArea tarSummary;
	private JLabel iblSummary;
	/**
	 * this makes the summary GUI on the right side
	 */
	public void setupGUI() {
		setLayout(new BorderLayout());
		iblSummary = new JLabel("Exercise Summary");
		add(iblSummary,BorderLayout.NORTH);
		tarSummary = new JTextArea(10,30);
		tarSummary.setEditable(false);
		add(tarSummary,BorderLayout.CENTER);
		
	}
	public void setSummaryLabel(String text) {
		iblSummary.setText(text);
	}
	public SummaryPanel(ArrayList<RunWalk> runWalk) {
		this.runWalk = runWalk;
		setupGUI();
	}
	/**
	 * this is how you add mutible work outs
	 */
	public void updateList() {
		tarSummary.setText("");
		String text = "";
		for (RunWalk c : runWalk) {
			text =text + c + "\n";
		}
		tarSummary.setText(text);
	}
}
