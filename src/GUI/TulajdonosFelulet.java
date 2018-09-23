package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import Places.Account;
import Places.Place;
import Places.PlaceData;
import Places.PlaceRegister;

/**
* <h1>Tulajdonosok Felülete</h1>
* A tulajdonosok felületének osztálya.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class TulajdonosFelulet extends JPanel implements ActionListener, MouseListener{
	private JTextArea ja = new JTextArea();
	private JButton kijelentkezes = new JButton("Kijelentkezés");
	private JButton letrehoz = new JButton("Új hely létrehozása");	
	private Account ezaFelhasznalo = new Account();
	private PlaceData data;
	private JTable jt;
	private Home home;
	private PlaceRegister plc = new PlaceRegister();
	
	/**
	 * A tulajdonosok felületét létrehozo konstruktor. Meg kell adni egy fiókot, akinek a fiókjába belépünk.
	 * @param acc  A felhasználói fiók, amelyen keresztül el akarjuk érni a felületet.
	 */
	public TulajdonosFelulet(Account acc) {
		JLabel email;
		JLabel tulajdonosUdv;
		JLabel leiras = new JLabel("Az ön helyei a jobb oldalon találhatóak.");
		JLabel leiras2 = new JLabel("A törléshez kattintson duplán a helyén.");
		ezaFelhasznalo = acc;
		
		try {
			ja.setText(acc.toString());
			data = new PlaceData();
			File f = new File("Places");
			if(f.exists()){
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));				
				data.setPlaces((ArrayList<Place>)ois.readObject());
				ois.close();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		this.setLayout(null);
		tulajdonosUdv = new JLabel("Üdvözlöm " + ezaFelhasznalo.getName() + "!");
		tulajdonosUdv.setBounds(65, 40, 400, 40);
		tulajdonosUdv.setFont(tulajdonosUdv.getFont().deriveFont(26.0f));
		add(tulajdonosUdv);
		
		email = new JLabel(ezaFelhasznalo.getEmail());
		email.setBounds(65, 70, 220, 30);
		add(email);
		
		leiras.setBounds(65, 110, 300, 20);
		leiras2.setBounds(65, 130, 300, 20);
		add(leiras); 
		add(leiras2);
		
		letrehoz.addActionListener(this);
		letrehoz.setBounds(65, 160, 160, 30);
		add(letrehoz);
		
		kijelentkezes.addActionListener(this);
		kijelentkezes.setBounds(65, 200, 160, 30);
		add(kijelentkezes);
		
		jt = new JTable(data.searchAccount(ezaFelhasznalo.getName()));
		jt.setFillsViewportHeight(true);
		JScrollPane jsp = new JScrollPane(jt);
		jt.addMouseListener(this);

		jsp.setBounds(450, 40, 700, 550);
		add(jsp, BorderLayout.CENTER);
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	/**
	 * Az actionPerformed(ActionEvent e) felüldefiniálása, a felületen található gombokhoz.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Kijelentkezés")) {
			home.Start();
		}
		if(e.getActionCommand().equals("Új hely létrehozása")) {
			home.cPlace(ezaFelhasznalo);
		}
	}
	
	/**
	 * A mouseClicked(MouseEvent e) függvény felüldefiniálása.
	 * A táblázat sorain duplán kattintva eltávolíthatja a tulajdonos a saját helyeit.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt.getSelectedRow();
		if(e.getClickCount() == 2 ) {	
			plc.load("Places");
			String helyneve = jt.getModel().getValueAt(row, 0).toString();
			if(helyneve.equals("Hiba")) {
				plc.delete(plc.search(helyneve));
				plc.save("Places");
				home.tFelulet(ezaFelhasznalo);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
