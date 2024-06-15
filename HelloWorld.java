/**
 * Name: Naylene Rondon
 * 
 * Florida Tech CIS 2503
 * 8.5 Programming Assignment
 * 
 * Date Last Modified: 3/2/24
 * 
 * Purpose:
 * GUI, sign in system that allows you to take in usernames and password
 * Provides test prompts of errors and success
 */

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import java.util.*;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionListener;
import java.util.function.Consumer;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.events.HelpEvent;
import org.eclipse.swt.widgets.DateTime;

public class HelloWorld {

	protected Shell shell;
	private Text usernameField;
	private Label lblPassword;
	private Text passwordField;
	
	private ArrayList <String> username = new ArrayList<String> ();
	private ArrayList <String> password = new ArrayList<String> ();
	
	private boolean signUpOption = false;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloWorld window = new HelloWorld();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 299);
		shell.setText("SWT Application");
		
		Label errorMessage = new Label(shell, SWT.NONE);
		errorMessage.setBounds(60, 37, 313, 15);
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(86, 76, 55, 15);
		lblUsername.setText("Username:");
		
		usernameField = new Text(shell, SWT.BORDER);
		usernameField.setBounds(169, 73, 209, 21);
		
		lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(86, 126, 55, 15);
		lblPassword.setText("Password:");
		
		passwordField = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		passwordField.setBounds(169, 120, 209, 21);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLogin.setBounds(179, 181, 75, 25);
		btnLogin.setText("Login");
		
		Button btnSignUp = new Button(shell, SWT.NONE);
		btnSignUp.setBounds(292, 202, 75, 25);
		btnSignUp.setText("Sign Up");
		
		Button btnSeePassword = new Button(shell, SWT.CHECK);
		btnSeePassword.addSelectionListener(new SelectionAdapter() //Check if the checkbox is selected and hide and show password
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				btnSeePassword.getSelection();
				if(btnSeePassword.getSelection()==true)
				{
					passwordField.setEchoChar((char) 0);
				}
				else
				{
					passwordField.setEchoChar('*');
				}
			}
		});
		
		
				
		btnSeePassword.setBounds(280, 147, 93, 16);
		btnSeePassword.setText("See Password?");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(77, 107, 318, 2);
		
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) 
			{
				if(signUpOption == false)
				{
					btnLogin.setVisible(false);
					btnSignUp.setBounds(179, 181, 75, 25);
					
					if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty() )
					{
						errorMessage.setText("Error. Missing information"); //Gives error if one of the values is blank
					}
					else
					{
						username.add(usernameField.getText());
						password.add(passwordField.getText());
					}
					
					signUpOption = true;
				}
				else
				{
					btnSignUp.setBounds(292, 202, 75, 25);
					btnLogin.setVisible(true);
					signUpOption = false;
				}
				
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) 
			{
				if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty() )
				{
					errorMessage.setText("Error. Missing information"); //Gives error if one of the values is blank
				}
				else if (username.size() > 0)
				{
					for(int i = 0; i < username.size(); i++)
					{
						if (username.get(i).equals(usernameField.getText())) //Find a username
						{
							if(password.get(i).equals(passwordField.getText())) //confirm password
							{
								errorMessage.setText("Successful Login! Hello World!");
							}
							else
							{
								errorMessage.setText("Wrong password");
							}
		
						}
					}
				}
				else
				{
					errorMessage.setText("Unable to sign in");
				}
			}
		});
		
		
		

	}
}
