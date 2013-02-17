package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Phraseface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phraseface frame = new Phraseface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Phraseface() {
		setTitle("Geraphne 1.0 - Phrase");
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Phraseface.class.getResource("/Pictures/qmark.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(80, 11, 344, 59);
		contentPane.add(textPane);
		
		JLabel lblGerman = new JLabel("German:");
		lblGerman.setFont(new Font("Arial", Font.BOLD, 12));
		lblGerman.setBounds(10, 11, 60, 20);
		contentPane.add(lblGerman);
		
		JLabel lblEnglish = new JLabel("English:");
		lblEnglish.setFont(new Font("Arial", Font.BOLD, 12));
		lblEnglish.setBounds(10, 92, 60, 20);
		contentPane.add(lblEnglish);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(80, 92, 344, 59);
		contentPane.add(textPane_1);
	}
}
