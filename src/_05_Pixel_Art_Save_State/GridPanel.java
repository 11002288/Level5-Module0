package _05_Pixel_Art_Save_State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import _04_Serialization.SaveData;

public class GridPanel extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String DATA_FILE = null;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;

	// 1. Create a 2D array of pixels. Do not initialize it yet.
	Pixel[][] art;
	private Color color;

	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;

		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;

		color = Color.BLACK;
		save(GridPanel(w,h,r,c));
		setPreferredSize(new Dimension(windowWidth, windowHeight));

		// 2. Initialize the pixel array using the rows and cols variables.
		art = new Pixel[rows][cols];

		// 3. Iterate through the array and initialize each element to a new pixel.
		for (int i = 0; i < art.length; i++) {
			for (int j = 0; j < art[i].length; j++) {
				art[i][j] = new Pixel(i * pixelWidth, j * pixelHeight);

			}
		}

	}


	public void setColor(Color c) {
		color = c;
	
	}

	public void clickPixel(int mouseX, int mouseY) {
		// 5. Use the mouseX and mouseY variables to change the color
		// of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		art[mouseX / pixelWidth][mouseY / pixelHeight].color = color;
	}

	public void paintComponent(Graphics g) {
		// 4. Iterate through the array.
		// For every pixel in the list, fill in a rectangle using the pixel's color.
		// Then, use drawRect to add a grid pattern to your display.
		for (int i = 0; i < art.length; i++) {
			for (int j = 0; j < art[i].length; j++) {
				g.setColor(art[i][j].color);
				g.fillRect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);
				g.drawRect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);

			}
		}

	}
	private static void save(SaveData data) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); 
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static SaveData load() {
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); 
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (SaveData) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
