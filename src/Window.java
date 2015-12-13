import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

// EXAMPLE WINDOW CLASS ++++++++++++++++++++++++++++++++++++++++++
public class Window extends JFrame implements ActionListener {
	// PRIVATE INSTANCE VARIABLES +++++++++++++++++++++++++++++++
	private JPanel _contentPane; // JPanel Container
	private JLabel _messageLabel;
	private JLabel currentGPALabel;
	private JTextField currentGPAInputbox;
	private JButton calculateGPAButton;
	private JLabel totalCreditHoursLabel;
	private JTextField totalCreditHoursInputBox;
	private JComboBox<String> courseComboBox;
	private JPanel _coursePanel;
	private JScrollPane _courseScrollPanel;
	private ArrayList<TodoTextField> _courseArrayList;
	
	private Border _redLine, _blackLine;
	
	// PUBLIC PROPERTIES +++++++++++++++++++++++++++++++++++++++++
	public JLabel getHelloLabel() {
		return this._messageLabel;
	}

	public void setMessageLabel(JLabel messageLabel) {
		this._contentPane.remove(this._messageLabel);
		this._messageLabel = messageLabel;
		this._addMessageLabel();
	}

	// CONSTRUCTOR METHOD +++++++++++++++++++++++++++++++++++++++
	public Window() {
		this._initialize();
		this._setupBorders();
		this._addUIComponents();
		
		// Register event handler for Action Listeners
		this.currentGPAInputbox.addActionListener(this);
		
		this.calculateGPAButton.addActionListener(this);
		
		this.totalCreditHoursInputBox.addActionListener(this);
		
		this.courseComboBox.addActionListener(this);
	
	}
	
	// PRIVATE METHODS +++++++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 490);
		this._contentPane = new JPanel();
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this._contentPane);
	}
	
	private void _setupBorders() {
		this._blackLine = BorderFactory.createLineBorder(Color.black);
		this._redLine = BorderFactory.createLineBorder(Color.red);
	}
	
	private void _addMessageLabel() {
		this._messageLabel.setBounds(5, 6, 225, 23);
		this._contentPane.add(this._messageLabel);
	}

	// adds all the UI Components to the Content Pane
	private void _addUIComponents() {
		// Use Absolute Layout
		this._contentPane.setLayout(null);
		
		// Hello Label
		this._messageLabel = new JLabel("New label");
		this._addMessageLabel();
		
		// Name Label
		this.currentGPALabel = new JLabel("Current GPA");
		this.currentGPALabel.setBounds(5, 35, 96, 30);
		this._contentPane.add(currentGPALabel);
		
		// Name Text Field
		this.currentGPAInputbox = new JTextField();
		this.currentGPAInputbox.setBounds(142, 35, 130, 30);
		this.currentGPAInputbox.setText("");
		this.currentGPAInputbox.setBorder(this._blackLine);
		this._contentPane.add(this.currentGPAInputbox);
		
		this.calculateGPAButton = new JButton("Click Me!");
		this.calculateGPAButton.setBounds(249, 401, 86, 29);
		this._contentPane.add(this.calculateGPAButton);
		
		this.totalCreditHoursLabel = new JLabel("Total Credit Hours");
		this.totalCreditHoursLabel.setBounds(5, 80, 125, 30);
		this._contentPane.add(this.totalCreditHoursLabel);
		
		this.totalCreditHoursInputBox = new JTextField();
		this.totalCreditHoursInputBox.setBounds(142, 80, 130, 30);
		this.totalCreditHoursInputBox.setBorder(this._blackLine);
		this._contentPane.add(this.totalCreditHoursInputBox);
		
		this.courseComboBox = new JComboBox<String>();
		this.courseComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		this.courseComboBox.setSelectedIndex(0);
		this.courseComboBox.setBounds(12, 144, 64, 30);
		this._contentPane.add(this.courseComboBox);
		
		// Container for our Todos
		this._coursePanel = new JPanel();
		
		// Add Scrollpane to contain our TodoPanel
		this._courseScrollPanel = new JScrollPane(this._coursePanel);
		_courseScrollPanel.setBounds(36, 224, 419, 152 );
		this._courseScrollPanel.setPreferredSize(new Dimension(8, 8));
		this._courseScrollPanel.setAutoscrolls(true);
		
		// Define a GridBagLayout for our use
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {171};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		//set the todoPanel to the GridBagLayout defined above
		this._coursePanel.setLayout(gridBagLayout);
		this._contentPane.add(this._courseScrollPanel);
		
		//add a default todoTextField to the todoPanel
		this._courseArrayList = new ArrayList<TodoTextField>();
		this._courseArrayList.add(new TodoTextField(this._coursePanel, 0, this._messageLabel));
		this._messageLabel.setText("1 Todo Fields");
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == this.currentGPAInputbox) {
			
			this._messageLabel.setText(this.currentGPAInputbox.getText());
		}
		
		if(event.getSource() == this.calculateGPAButton) {
			this._messageLabel.setText("goodbyeButton - clicked");
		}
		
		if(event.getSource() == this.totalCreditHoursInputBox) {
			
			try {
				int ageDifference = 46 - Integer.parseInt(this.totalCreditHoursInputBox.getText());
				this._messageLabel.setText(Integer.toString(ageDifference));
				this.totalCreditHoursInputBox.setBorder(this._blackLine);
			
				
			} catch (Exception e) {
				this._messageLabel.setText("Hey that was just wrong");
				this.totalCreditHoursInputBox.selectAll();
				this.totalCreditHoursInputBox.setBorder(this._redLine);
			}
		}
		
		if(event.getSource() == this.courseComboBox) {
			// store the selected index item
			int numTodoFields = this.courseComboBox.getSelectedIndex() + 1;
			
			//clear the todoPanel 
			this._coursePanel.removeAll();

			for (TodoTextField todoTextField : this._courseArrayList) {
				todoTextField.removeEventHandler();
			}
			
			// clear the todoArrayList
			this._courseArrayList.clear();
			
			// add the selected number of rows to the todoArrayList 
			for(int index = 0; index < numTodoFields; index++) {
				TodoTextField todoTextField = new TodoTextField(this._coursePanel, index, this._messageLabel);
				this._courseArrayList.add(todoTextField);
			}
			
			this._messageLabel.setText(numTodoFields + " Todo Fields");
			
			
			// redraw the todoPanel
			this._coursePanel.revalidate();	
			
		}
		
		
		
	}
}
