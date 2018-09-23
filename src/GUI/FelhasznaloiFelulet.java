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
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import Places.Account;
import Places.Place;
import Places.PlaceData;

/**
* <h1>Felhasználói Felület</h1>
* A felhasználói felület osztálya.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class FelhasznaloiFelulet extends JPanel implements ActionListener, MouseListener {
	private JTextArea ja = new JTextArea();
	private JButton kijelentkezes = new JButton("Kijelentkezés");
	private JTable jt;
	private PlaceData data;
	private Home home;
	private Account ezaFelhasznalo = new Account();
	private JTextField keresesMezo = new JTextField();
	private JTextField keresesMezo2 = new JTextField();
	private JTextField keresesMezo3 = new JTextField();
	private JButton ok = new JButton("OK");
	
	/**
	 * A komponensek iniciílizálása. Felépítjük a kinézetét a felhasználói felületnek. A három String a táblázatban lévõ keresés 3 faktorára szolgál. Nincs keresés: "". 
	 * @param search A keresés elsõ faktora. 
	 * @param search2 A keresés második faktora. 
	 * @param search3 A keresés harmadik faktora. 
	 */
	private void initComponents(String search, String search2, String search3) {
		this.setLayout(null);
		
		JLabel leiras = new JLabel("A helyek a jobb oldalon találhatóak.");
		JLabel leiras2 = new JLabel("Kattintson duplán az adott soron a részletekhez!");
		JLabel kereses = new JLabel("Keresés");
		JLabel tulajdonosUdv = new JLabel("Üdvözlöm " + ezaFelhasznalo.getName() + "!");
		tulajdonosUdv.setBounds(65, 40, 400, 40);
		tulajdonosUdv.setFont(tulajdonosUdv.getFont().deriveFont(26.0f));
		add(tulajdonosUdv);
		
		JLabel email = new JLabel(ezaFelhasznalo.getEmail());
		email.setBounds(65, 80, 220, 30);
		add(email);
		
		leiras.setBounds(65, 120, 300, 20);
		leiras2.setBounds(65, 140, 300, 20);
		add(leiras);
		add(leiras2);
		
		kijelentkezes.addActionListener(this);
		kijelentkezes.setBounds(65, 180, 160, 30);
		add(kijelentkezes);	
		
		kereses.setBounds(65, 250, 200, 30);
		kereses.setFont(kereses.getFont().deriveFont(22.0f));
		keresesMezo.setBounds(65, 280, 250, 30);
		keresesMezo2.setBounds(65, 320, 250, 30);
		keresesMezo3.setBounds(65, 360, 250, 30);
		add(kereses);
		add(keresesMezo);
		add(keresesMezo2);
		add(keresesMezo3);
		
		ok.setBounds(65, 400, 160, 30);
		add(ok);
		ok.addActionListener(this);		
		
		jt = new JTable(data.search(search).search(search2).search(search3));
		jt.setRowSorter(new TableRowSorter<>(data.search(search).search(search2).search(search3)));
		jt.setFillsViewportHeight(true);
		JScrollPane jsp = new JScrollPane(jt);
		jt.addMouseListener(this);

		jsp.setBounds(450, 40, 700, 550);
		add(jsp, BorderLayout.CENTER);
		
		addMouseListener(this);		
	}
	
	/**
	 * A Felhasználói felület konstruktora. 
	 * Meg kell adnunk az accountot akinek a felületét meg akarjuk nyitni és a 3 keresési faktort. Nincs keresés: "". 
	 * A komponensek inicializálása külön függvényben (initComponents()), ami ebben a konstruktorban van meghívva.
	 * @param acc A felhasználói fiók, amelyen keresztül el akarjuk érni a felületet.
	 * @param search A keresés elsõ faktora. 
	 * @param search2 A keresés második faktora. 
	 * @param search3 A keresés harmadik faktora. 
	 */
	public FelhasznaloiFelulet(Account acc, String search, String search2, String search3) {
		
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
		
		initComponents(search, search2, search3);
		
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	/**
	 * Az actionPerformed(ActionEvent e) függvény felüldefiniálása. A 'Kijelentkezés', az 'OK', és a 'Keresés' gombokra való kattintáshoz szükséges.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Kijelentkezés")) {
			home.Start();
		}
		if(e.getActionCommand().equals("OK")) {
			home.fFelulet(ezaFelhasznalo, keresesMezo.getText(), keresesMezo2.getText(), keresesMezo3.getText());
		}
		if(e.getActionCommand().equals("Keresés")) {
			home.fFelulet(ezaFelhasznalo, "", "", "");
		}
	}

	/**
	 * A mouseClicked(MouseEvent e) függvény felüldefiniálása. A táblázat egy során való dupla kattintás megvalósításához használjuk. 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt.getSelectedRow();
		if(e.getClickCount() == 2 ) {	
			String data = jt.getModel().getValueAt(row, 0).toString();			
			if(!data.equals("hiba"))
				home.PlInfo(data, ezaFelhasznalo);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub		
	}	
}
