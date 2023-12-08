import javax.swing.JDialog;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginForm extends JDialog{
			private boolean loggedIn;
		    private String password;
		    private String username;
		    /**
		     * this makes the login GUI for the username and password
		     * this also make sure the password and username is wright
		     */
		    public void setupGUI() {
		    	setBounds(300, 300, 300, 300);
		    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		    	Container c = getContentPane();
		    	c.setLayout(new BorderLayout());
		    	JPanel panCenter = new JPanel(new BorderLayout());
		    	JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		    	usernamePanel.add(new JLabel("Username"));
		    	panCenter.add(usernamePanel, BorderLayout.NORTH);
		    	JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		    	passwordPanel.add(new JLabel("Password"));
		    	panCenter.add(passwordPanel, BorderLayout.CENTER);
		    	JPasswordField txtUsername = new JPasswordField(10);
		    	usernamePanel.add(txtUsername);
		    	JPasswordField txtPassword = new JPasswordField(10);
		    	passwordPanel.add(txtPassword);
		    	c.add(panCenter, BorderLayout.CENTER);
		        JPanel panSouth = new JPanel();
		        JButton btnOK = new JButton("OK");
		        btnOK.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                // ADD IN THE LOGIN HANDLER HERE
		            	String enteredPassword = new String (txtPassword.getPassword());
		            	String enteredUsername = new String (txtUsername.getPassword());
		            	if (enteredPassword.equals(password)&& enteredUsername.equals(username)) {
		            		loggedIn = true;
		            		setVisible(false);
		            		
		            	}else {
		            		JOptionPane.showMessageDialog(null,"you entered the incorrect password");
		            		loggedIn = false;
		            	}
		            }
		        });
		        JButton btnCancel = new JButton("Cancel");
		        btnCancel.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                // ADD IN THE LOGIN CANCEL HANDLER HERE
		            	loggedIn = false;
		            	setVisible(false);
		            }
		        });
		        panSouth.setLayout(new FlowLayout());
		        panSouth.add(btnOK);
		        panSouth.add(btnCancel);
		        c.add(panSouth,BorderLayout.SOUTH);
		    }
		    /** 
		     * this is the constracter and what the password and username is
		     * @param owner
		     * @param title
		     * @param modal
		     */
		    public LoginForm(JFrame owner, String title, boolean modal) {
		        // FILL IN THE CONSTRUCTOR HERE
		        super(owner,title,modal);
		        setupGUI();
		        password = "donuts";
		        username = "healthy";
		        loggedIn = false;
		    }
		    public boolean isLoggedIn() {
		    		return loggedIn;
		    	}
		    }
		 


