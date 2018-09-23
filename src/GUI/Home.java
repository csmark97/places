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
* A helyek program lehet�s�get ad a tulajdonosoknak a helyeit k�zz�tenni, a felhaszn�l�knak pedig t�j�koz�dni ezekr�l.
* Ez az oszt�ly ennek az alkalmaz�snak a f� oszt�lya.
* Itt tal�lhat� a main f�ggv�ny, illetve ez az oszt�ly �r�kl�dik a JFrame oszt�lyt�l.
* Az �dv�zl� k�perny�t jelen�ti meg, de minden m�s grafikai fel�let innen indul ki.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class Home extends JFrame implements ActionListener {	
	private JPanel homePanel = new JPanel();
	private JButton belepes = new JButton("Bel�p�s");
    private Start fStart;
    private Regisztracio fReg;
    private FelhasznaloiFelulet fFelulet;
    private TulajdonosFelulet tFelulet;
    private CreatePlace placecreator;
    private PlaceInfo plinfo;    
    private JPanel currentPanel;    
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Men�");  	    
    JMenuItem kilepes = new JMenuItem("Kil�p�s");    
    JMenu profil = new JMenu("Profil");
    JMenuItem bejelentkezes = new JMenuItem("Bejelentkez�s");
    JMenuItem regisztracio = new JMenuItem("Regisztr�ci�");
    JMenuItem kijelentkezes = new JMenuItem("Kijelentkez�s");
    
    /**
     * A Home (kez�d�oldal) komponeseit �p�ti fel.
     */
	public Home() {
		JLabel welcome = new JLabel("�dv�z�lj�k!");
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
	 * Az actionPerformed(ActionEvent e) f�ggv�ny fel�ldefini�l�sa a fel�leten l�v� gombokra �s men�pontokra.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Bel�p�s") || e.getActionCommand().equals("Bejelentkez�s")) {
			Start();			
		}
		if(e.getActionCommand().equals("Kil�p�s")){
			System.exit(0);
		}
		if(e.getActionCommand().equals("Regisztr�ci�")) {
			Reg();
		}
		if(e.getActionCommand().equals("Kijelentkez�s")) {
			Start();
		}		
	}	

	/**
	 * A start fel�letet ind�t� f�ggv�ny.
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
	 * A regisztr�ci� fel�let�t ind�t� f�ggv�ny.
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
	 * A felhaszn�l�i fel�letet ind�t� f�ggv�ny.
	 * @param acc A felhaszn�l�i fi�k, amelyen kereszt�l el akarjuk ind�tani a fel�letet.
	 * @param search A keres�s els� faktora.
	 * @param search2 A keres�s m�sodik faktora. 
	 * @param search3 A keres�s harmadik faktora.
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
	 * A tulajdonosok fel�let�t ind�t� f�ggv�ny.
	 * @param acc A felhaszn�l�i fi�k, amelyen kereszt�l el akarjuk ind�tani a fel�letet.
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
	 * A hely l�trehoz�s�ra szolg�l� fel�letet elind�t� f�ggv�ny.
	 * @param acc A felhaszn�l�i fi�k, amelyen kereszt�l el akarjuk ind�tani a fel�letet.
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
	 * A main f�ggv�ny.
	 * @param args 
	 */
	public static void main(String[] args) {	    
	    Home home = new Home();				
		home.setVisible(true);
	}	
}
