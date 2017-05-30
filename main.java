package f;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class main extends JFrame {

	int count = 0;
	Container contentPane;

	
	JLabel img[] = {
			new JLabel(new ImageIcon("src/f/megu.jpg")), 
			new JLabel(new ImageIcon("src/f/kanna.jpg")), 
			new JLabel(new ImageIcon("src/f/clear.jpg")) ,
			new JLabel(new ImageIcon("src/f/neko.png")),
			};
	JLabel text[] = { 
			new JLabel("<html><center>meguming<br>kawaii</center></html>"), 
			new JLabel("<html><center>I like animation<br>hehe</center></html>"),
			new JLabel("<html><center>please my score<br>byebye</center></html>"),
			new JLabel("<html><center>만점 주세용<br>헷</center></html>"), 
			};
	JLabel title[] = { 
			new JLabel("<html><center><font size='10'>meguming~</font></center></html>"),
			new JLabel("<html><center><font size='10'>Anime Gosick~</font></center></html>"),
			new JLabel("<html><center><font size='10'>Thank you~!</font></center></html>"),
			new JLabel("<html><center><font size='10'>Create by Sori~!</font></center></html>") 
			};
	JButton jbt = new JButton("secret");

	public void setting() {
		setTitle("album");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 10
				));
		setSize(900, 750);
		setVisible(true);
	}

	public void view() {

		contentPane.removeAll();
		contentPane.add(title[count]);
		contentPane.add(text[count]);
		contentPane.add(img[count]);
		contentPane.add(jbt);
		contentPane.revalidate();
		contentPane.repaint();

	}
	public void enter(){
		contentPane.removeAll();
		contentPane.add(title[3]);
		contentPane.add(text[3]);
		contentPane.add(img[3]);
		contentPane.add(jbt);
		contentPane.revalidate();
		contentPane.repaint();
	}


	class MouseHandler implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			count++;
			if (count % 3 == 1)
				view();
			else if (count % 3 == 2)
				view();
			else {
				count = 0;
				view();
			}
		}

		public void mouseEntered(MouseEvent e) {
			enter();
		}

		public void mouseExited(MouseEvent e) {
			view();
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
		}

	}

	main() {
		jbt.addMouseListener(new MouseHandler());
		setting();
		view();
	}

	public static void main(String a[]) {
		new main();
		music();
	}

	public static void music() {
		FileInputStream fis;
		String path[] = { "src/f/memory.mp3", "src/f/sss.mp3",
				"src/f/secondRun.mp3", "src/f/rainy.mp3" };
		for (String p : path) {
			try {
				int no = ((int) (Math.random() * 100)) % 4;
				fis = new FileInputStream(new File(path[no]));
				Player player = new Player(fis);
				player.play();
				player.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}
}