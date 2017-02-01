package test;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class Game extends Canvas {

	private static final long serialVersionUID = 1L;

	// Frame size
	static int frameWidth = 600;
	static int frameHeight = 600;

	// Ball parameters
	int ballX = 0; // initial x position
	int ballY = 0; // initial y position
	int diameter = 40; // ball size
	int speedX = 3; // ball x speed
	int speedY = 4; // ball y speed

	public static void main(String[] args) {

		JFrame frame = new JFrame("Game");
		Game game = new Game();
		frame.add(game);
		frame.setSize(new Dimension(frameWidth, frameHeight));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		while (true) {
			game.move();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			game.repaint();
		}
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		super.paint(graphics);
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setBackground(Color.GREEN);
		graphics.setColor(Color.BLUE);
		graphics.fillOval(ballX, ballY, diameter, diameter);
	}

	public void move() {
		if (ballX + speedX < 0) {
			speedX = 3;
		} else if (ballX + speedX > getWidth() - diameter) {
			speedX = -3;
		} else if (ballY + speedY < 0) {
			speedY = 4;
		} else if (ballY + speedY > getHeight() - diameter) {
			speedY = -4;
		}

		ballX += speedX;
		ballY += speedY;
	}

}