package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import Functions.Countdown;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Geraphneface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Geraphneface frame = new Geraphneface();
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
	public Geraphneface() {		
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Geraphneface.class.getResource("/Pictures/qmark.png")));
		setTitle("Geraphne 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToThis = new JLabel("Welcome to your German-Course!!!");
		lblWelcomeToThis.setVerticalAlignment(SwingConstants.TOP);
		lblWelcomeToThis.setFont(new Font("Arial", Font.PLAIN, 20));
		lblWelcomeToThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThis.setBounds(10, 11, 414, 23);
		contentPane.add(lblWelcomeToThis);
		
		JLabel lblShortExplanation = new JLabel("Short explanation:");
		lblShortExplanation.setHorizontalAlignment(SwingConstants.CENTER);
		lblShortExplanation.setFont(new Font("Arial", Font.PLAIN, 15));
		lblShortExplanation.setBounds(153, 45, 138, 27);
		contentPane.add(lblShortExplanation);
		
		JLabel lblGeraphneIs = new JLabel("1) Geraphne is teaching you in the German language.\r\n\r\n");
		lblGeraphneIs.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGeraphneIs.setVerticalAlignment(SwingConstants.TOP);
		lblGeraphneIs.setBounds(10, 83, 414, 23);
		contentPane.add(lblGeraphneIs);
		
		JLabel lblThisApplication = new JLabel("2) This application shows you after a randomize time, a word or phrase \r\n");
		lblThisApplication.setFont(new Font("Arial", Font.PLAIN, 12));
		lblThisApplication.setVerticalAlignment(SwingConstants.TOP);
		lblThisApplication.setBounds(10, 108, 414, 23);
		contentPane.add(lblThisApplication);
		
		JLabel lblWithTheCorrect = new JLabel("    in German with the correct translation below.");
		lblWithTheCorrect.setFont(new Font("Arial", Font.PLAIN, 12));
		lblWithTheCorrect.setBounds(10, 126, 414, 24);
		contentPane.add(lblWithTheCorrect);
		
		JLabel lblHaveFun = new JLabel("Have fun!!! :-)");
		lblHaveFun.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHaveFun.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaveFun.setBounds(153, 173, 110, 14);
		contentPane.add(lblHaveFun);
		
		//Start_Button_Anfang
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				//Startfenster verschwindet
				setVisible(false);

						//Programm verschwindet im Systemtray und ist nur noch als Try-Icon sichtbar
						Image image = Toolkit.getDefaultToolkit().getImage(  
						Geraphneface.class.getResource( "/Pictures/qmark.png")); 
						 
						PopupMenu popup = new PopupMenu(); 
						MenuItem item = new MenuItem( "End" ); 
						item.addActionListener( new ActionListener() { 
						  @Override public void actionPerformed( ActionEvent e ) { 
						    System.exit(0); 
						  } 
						} ); 
						popup.add( item ); 
						 
						TrayIcon trayIcon = new TrayIcon( image, "Java-Tray ", popup ); 
						trayIcon.setImageAutoSize( true );
						
						try{
							SystemTray tray = SystemTray.getSystemTray(); 
							tray.add(trayIcon);
						}catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
						}
					
					//Countdown-Objekt instanziieren und Countdown-Methode starten
					Countdown myCountdown = new Countdown();
					myCountdown.CountdownGo();
					}
				});
		
		//Start_Button_Ende
		
		
		btnStart.setBounds(73, 198, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnEnd = new JButton("End");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnEnd.setBounds(270, 198, 89, 23);
		contentPane.add(btnEnd);
	}
}
