package _05_Pixel_Art_Save_State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridInputPanel extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	private JTextField windowWidthField;
	private JTextField windowHeightField;
	private JTextField rowsField;
	private JTextField colsField;
	private JButton submitButton;
	public JButton save;
			
	PixelArtMaker pam;
	
	public GridInputPanel(PixelArtMaker pam) {
		this.pam = pam;
		
		windowWidthField = new JTextField(5);
		windowHeightField = new JTextField(5);
		rowsField = new JTextField(5);
		colsField = new JTextField(5);
		submitButton = new JButton("Submit");
		save = new JButton("Save");
		
		add(new JLabel("screen width:"));
		add(windowWidthField);
		add(new JLabel("\tscreen height:"));
		add(windowHeightField);
		add(new JLabel("\ttotal rows:"));
		add(rowsField);
		add(new JLabel("\ttotal columns:"));
		add(colsField);
		add(submitButton);
		add(save);
		
		submitButton.addActionListener((e)->submit());
		save.addMouseListener(this);
	}
	
	private void submit() {
		boolean valid = false;
		int w = -1;
		int h = -1;
		int r = -1;
		int c = -1;
		try {
			w = Integer.parseInt(windowWidthField.getText());
			h = Integer.parseInt(windowHeightField.getText());
			r = Integer.parseInt(rowsField.getText());
			c = Integer.parseInt(colsField.getText());
			
			if(w <= 0 || h <= 0 || r <= 0 || c <= 0) {
				invalidateInput();
			}else {
				valid = true;
			}
		}catch(NumberFormatException e) {
			invalidateInput();
		}
		
		if(valid) {
			pam.submitGridData(w, h, r, c);
		}
	}
	
	private void invalidateInput() {
		JOptionPane.showMessageDialog(null, "Be sure all fields are complete with positive numbers.", "ERROR", 0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(save)) {
			try {
				FileWriter fw = new FileWriter("src/_05_Pixel_Art_Save_State/saveState.txt");
				fw.w
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
