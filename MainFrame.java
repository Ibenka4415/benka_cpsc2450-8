import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.io.*;
public class MainFrame extends JFrame implements ActionListener{
	/**
	 * these private varibles are used thorught out the code to be used and the names are pretty self explanatorie
	 */
	private ArrayList<RunWalk> runWalk;
	private JMenuItem miLogin;
	private JMenuItem miLogout;
	private ExerciseDisplay cdp;
	private JButton btnAddExersise;
	/**
	 * The set up menu makes the little user bar at the top
	 * this helps the user give the option of login/log out, save exit help and about
	 */
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		JMenu mnuFile = new JMenu("File");
		mbar.add(mnuFile);
		miLogin = new JMenuItem("Log In");
		miLogin.addActionListener(this);
		miLogout = new JMenuItem("Log Out");
		miLogout.addActionListener(this);
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miExit = new JMenuItem("Exit");
		mnuFile.add(miLogin);
		mnuFile.add(miLogout);
		mnuFile.add(miSave);
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				File f;
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					f= chooser.getSelectedFile();
					if(ExerciseWriter.writeToFile(f,runWalk)) {
						JOptionPane.showMessageDialog(null,"Exercise Saved");
						
					}else {
						JOptionPane.showMessageDialog(null,"Could not save");
					}
				}
			}
		});
		mnuFile.add(miExit);
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JMenu mnuHelp = new JMenu("Help");
		mbar.add(mnuHelp);
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Exercise tracker GUI Version ");
			}
		});
		mnuHelp.add(miAbout);
		
	}
	/**
	 * this is the main gui that is made and has all the error checkers
	 * this also changes the callories burned in the summary
	 */
	public void setupGUI(){
		setBounds(100,100,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Exersise Tracker");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		cdp = new ExerciseDisplay();
		SummaryPanel sumPan = new SummaryPanel(runWalk);
		c.add(cdp,BorderLayout.WEST);
		c.add(sumPan,BorderLayout.EAST);
		JPanel panSouth = new JPanel();
		btnAddExersise = new JButton("Add Exersise");
		btnAddExersise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				double duration = 0,distance = 0,caloriesBurned;
				String name = null,date = "00/00/0000",comment;
				ArrayList<String> errors = new ArrayList<String>();
				
				try {
					date = cdp.getDate();
				}  catch (Exception ex) {
					errors.add("The date must be in dd/mm/yyyy");
				}
				try {
					duration = cdp.getDuration();
				}catch (Exception ex) {
					errors.add("The duration must be a number");
				}
				try {
					distance = cdp.getDistance();
				}catch (Exception ex) {
					errors.add("The distance must be a number");
				}
				comment = cdp.getComment();
				String errorMessage = "";
				if (errors.size() > 0) {
					for (String error: errors) {
						errorMessage = errorMessage + error + " ";
					}
					JOptionPane.showMessageDialog(null,"these errors occurred:" + errorMessage);
				}else {
					RunWalk c = null;
					try {
						c = new RunWalk(name,date,duration,distance,comment);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					runWalk.add(c);
					sumPan.updateList();
					cdp.clearEntries();
					caloriesBurned = Exercise1.getExerciseTotal(runWalk);
					sumPan.setSummaryLabel(String.format("Total Calories Burned = %.2f",caloriesBurned));
					repaint();
				}
			}
		});
		panSouth.setLayout(new FlowLayout());
		panSouth.add(btnAddExersise);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
		enableEntries(false);
	}
	/** 
	 * this sets up an array list
	 * @param runWalk
	 */
	public MainFrame(ArrayList<RunWalk> runWalk) {
		this.runWalk = runWalk;
		setupGUI();
	}
	/**
	 * this makes it so you cant use the interface intill you login
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		LoginForm dlgLogin;
		if (e.getSource()== miLogin) {
			dlgLogin = new LoginForm(this,"log in",true);
			dlgLogin.setVisible(true);
			if (dlgLogin.isLoggedIn()) {
				enableEntries(true);
				
				
			}else {
				enableEntries(false);
				
			}
		}else if (e.getSource()==miLogout) {
			enableEntries(false);
		}
	}
	public void enableEntries (boolean enableYN) {
		cdp.enableEntries(enableYN);
		btnAddExersise .setEnabled(enableYN);
	}
}
