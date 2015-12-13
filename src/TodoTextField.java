import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;
// Custom TextField Class
public class TodoTextField extends JTextField implements ActionListener {
	//PRIVATE INSTANCE VARIABLES
	private JLabel _messageLabel;
	
	// CONSTRUCTOR +++++++++++++++++++++++++++++++++++++
	public TodoTextField(JPanel todoPanel, int row, JLabel messageLabel) {
		this._messageLabel = messageLabel;
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.gridx = 0;
		constraints.gridy = row;
		todoPanel.add(this, constraints);
		this.setColumns(10);
		this.addActionListener(this);
	}

	public void removeEventHandler() {
		this.removeActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this._messageLabel.setText(this.getText());
	}

}
