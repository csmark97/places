package GUI;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Places.Account;

/**
* <h1>Home</h1>
* A helyek program lehetõséget ad a tulajdonosoknak a helyeit közzétenni, a felhasználóknak pedig tájékozódni ezekrõl.
* Ez az osztály ennek az alkalmazásnak a fõ osztálya.
* Itt található a main függvény, illetve ez az osztály öröklõdik a JFrame osztálytól.
* Az üdvözlõ képernyõt jeleníti meg, de minden más grafikai felület innen indul ki.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class Home extends JFrame implements ActionListener {	
	private JPanel homePanel = new JPanel();
	private JButton belepes = new JButton("Belépés");
    private Start fStart;
    private Regisztracio fReg;
    private FelhasznaloiFelulet fFelulet;
    private TulajdonosFelulet tFelulet;
    private CreatePlace placecreator;
    private PlaceInfo plinfo;    
    private JPanel currentPanel;    
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menü");  	    
    JMenuItem kilepes = new JMenuItem("Kilépés");    
    JMenu profil = new JMenu("Profil");
    JMenuItem bejelentkezes = new JMenuItem("Bejelentkezés");
    JMenuItem regisztracio = new JMenuItem("Regisztráció");
    JMenuItem kijelentkezes = new JMenuItem("Kijelentkezés");
    
    /**
     * A Home (kezõdõoldal) komponeseit építi fel.
     */
	public Home() {
		JLabel welcome = new JLabel("Üdvözöljük!");
		homePanel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Helyek");
		setSize(512,768);
		
		menuBar.add(menu);
		menu.add(kilepes);
		kilepes.addActionListener(this);
		
		menuBar.add(profil);
		profil.add(bejelentkezes);
		profil.add(regisztracio);
		profil.add(kijelentkezes);	
		kijelentkezes.setEnabled(false);
		bejelentkezes.addActionListener(this);
		kijelentkezes.addActionListener(this);
		regisztracio.addActionListener(this);
		
		this.setJMenuBar(menuBar);		

		welcome.setFont(welcome.getFont().deriveFont(46.0f));
		welcome.setBounds(125, 70, 500, 50);
		
		homePanel.add(welcome);			

		belepes.setFont(welcome.getFont().deriveFont(40.0f));
		belepes.addActionListener(this);
		belepes.setBounds(100, 200, 300, 150);
		homePanel.add(belepes);
		
		add(homePanel);	
		currentPanel = homePanel;
	}
	
	/**
	 * Az actionPerformed(ActionEvent e) függvény felüldefiniálása a felületen lévõ gombokra és menüpontokra.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Belépés") || e.getActionCommand().equals("Bejelentkezés")) {
			Start();			
		}
		if(e.getActionCommand().equals("Kilépés")){
			System.exit(0);
		}
		if(e.getActionCommand().equals("Regisztráció")) {
			Reg();
		}
		if(e.getActionCommand().equals("Kijelentkezés")) {
			Start();
		}		
	}	

	/**
	 * A start felületet indító függvény.
	 */
	public void Start() {
		setSize(512,768);
		regisztracio.setEnabled(true);
		bejelentkezes.setEnabled(true);
		kijelentkezes.setEnabled(false);
		fStart = new Start();
		fStart.setHome(this);
		add(fStart);
		fStart.setVisible(false);
		currentPanel.setVisible(false);
		add(fStart);
		fStart.setVisible(true);
		currentPanel = fStart;
	}
	
	/**
	 * A regisztráció felületét indító függvény.
	 */
	public void Reg() {
		setSize(512,768);
		regisztracio.setEnabled(true);
		bejelentkezes.setEnabled(true);
		kijelentkezes.setEnabled(false);
		fReg = new Regisztracio();
		fReg.setHome(this);
		add(fReg);
		fReg.setVisible(false);
		currentPanel.setVisible(false);
		add(fReg);
		fReg.setVisible(true);
		currentPanel = fReg;
	}
	
	/**
	 * A felhasználói felületet indító függvény.
	 * @param acc A felhasználói fiók, amelyen keresztül el akarjuk indítani a felületet.
	 * @param search A keresés elsõ faktora.
	 * @param search2 A keresés második faktora. 
	 * @param search3 A keresés harmadik faktora.
	 */
	public void fFelulet(Account acc, String search, String search2, String search3) {
		setSize(1280, 720);
		kijelentkezes.setEnabled(true);
		bejelentkezes.setEnabled(false);
		regisztracio.setEnabled(false);
		fFelulet = new FelhasznaloiFelulet(acc, search, search2, search3);
		fFelulet.setHome(this);
		add(fFelulet);
		fFelulet.setVisible(false);
		currentPanel.setVisible(false);
		add(fFelulet);
		fFelulet.setVisible(true);
		currentPanel = fFelulet;	
	}
	
	/**
	 * A tulajdonosok felületét indító függvény.
	 * @param acc A felhasználói fiók, amelyen keresztül el akarjuk indítani a felületet.
	 */
	public void tFelulet(Account acc) {
		kijelentkezes.setEnabled(true);
		bejelentkezes.setEnabled(false);
		regisztracio.setEnabled(false);
		setSize(1280, 720);
		tFelulet = new TulajdonosFelulet(acc);
		tFelulet.setHome(this);
		add(tFelulet);
		tFelulet.setVisible(false);
		currentPanel.setVisible(false);
		add(tFelulet);
		tFelulet.setVisible(true);
		currentPanel = tFelulet;	
	}
	
	/**
	 * A hely létrehozására szolgáló felületet elindító függvény.
	 * @param acc A felhasználói fiók, amelyen keresztül el akarjuk indítani a felületet.
	 */
	public void cPlace(Account acc) {
		kijelentkezes.setEnabled(false);
		bejelentkezes.setEnabled(false);
		regisztracio.setEnabled(false);
		placecreator = new CreatePlace(acc);
		placecreator.setHome(this);
		add(placecreator);
		placecreator.setVisible(false);
		currentPanel.setVisible(false);
		add(placecreator);
		placecreator.setVisible(true);
		currentPanel = placecreator;	
	}
	
	public void PlInfo(String helynev, Account acc) {
		kijelentkezes.setEnabled(true);
		bejelentkezes.setEnabled(false);
		regisztracio.setEnabled(false);
		plinfo = new PlaceInfo(helynev, acc);
		plinfo.setHome(this);
		add(plinfo);
		plinfo.setVisible(false);
		currentPanel.setVisible(false);
		add(plinfo);
		plinfo.setVisible(true);
		currentPanel = plinfo;	
	}
	
	/**
	 * A main függvény.
	 * @param args 
	 */
	public static void main(String[] args) {	    
	    Home home = new Home();				
		home.setVisible(true);
	}	
}
