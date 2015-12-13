import javax.swing.JLabel;

// DRIVER CLASS ++++++++++++++++++++++++++++++++
public class Program {

	// MAIN STATIC METHOD ++++++++++++++++++++++
	public static void main(String[] args) {
		try {
			
			// EXAMPLE WINDOWS LIVES AND DIES HERE ++++
			Window frame = new Window();
			frame.setVisible(true);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
