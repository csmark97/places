package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Places.Account;
import Places.Comment;
import Places.CommentRegister;
import Places.Place;
import Places.PlaceRegister;

/**
* <h1>Helyek adatlapjai</h1>
* A helyek adatlapjainak osztálya.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class PlaceInfo extends JPanel implements ActionListener {
	private PlaceRegister plc = new PlaceRegister();
	private Home home = new Home();
	private Place aktualishely;
	private Account ezaFelhasznalo = new Account();
	private CommentRegister comments = new CommentRegister();	
	private JComboBox<Object> rate;
	private JButton rateButton = new JButton("Értékelem"); 
	private JTextArea ja2 = new JTextArea(); 
	private JButton hozzaszolok = new JButton("Hozzászólok");	
	private JButton vissza = new JButton("Vissza");	
	
	/**
	 * A helyek saját adatlapjait feléípitõ konstruktor.
	 * @param helyNeve A hely neve, amelynek az adatlapját látni akarjuk.
	 * @param acc A felhasználói fiók, amelyen keresztül el akarjuk érni a felületet.
	 */
	PlaceInfo(String helyNeve, Account acc) {
		JLabel helynev;
		JLabel cim;
		JLabel tipus;
		JLabel currentRating = new JLabel();
		JTextArea nyitvatartas = new JTextArea();
		JTextArea nyitvatartas2 = new JTextArea();
		JTextArea ja = new JTextArea();
		
		ezaFelhasznalo = acc;
		this.setLayout(null);
		plc.load("Places");
		comments.load("Comments");
		
		if(plc.searchCheck(helyNeve)) {
			aktualishely = plc.search(helyNeve);
		} else {
			home.fFelulet(acc, "", "", "");
		}
		
		helynev = new JLabel(aktualishely.getName());
		helynev.setBounds(65, 40, 330, 40);
		helynev.setFont(helynev.getFont().deriveFont(30.0f));
		
		cim = new JLabel(aktualishely.getCntct().getAddr().toString());
		cim.setBounds(65, 80, 200, 20);
		
		tipus = new JLabel(aktualishely.getType().toString());
		tipus.setBounds(65, 110, 350, 30);
		tipus.setFont(helynev.getFont().deriveFont(22.0f));
		
		Object[] o = new Object[6];
		o[0] = "Értékelés";		
		for (int i = 1; i < 6; i++)
			o[i] = i;
		rate = new JComboBox<>(o);
		rate.setBounds(90, 290, 100, 25);	
		
		rateButton.setBounds(90, 330, 100, 20);
		rateButton.addActionListener(this);
		
		ja.setBounds(420, 40, 780, 400);
		JScrollPane jsp = new JScrollPane(ja);

		jsp.setBounds(420, 40, 780, 400);
		add(jsp);
		ja.setEditable(false);
		ja2.setBounds(420, 480, 780, 100);
		if (comments.numberofSearchResults(aktualishely) > 0){
			ja.setText(comments.searching(aktualishely.getName()).toString());
		} else {
			ja.setText("Nincs még komment");
		}
		
		hozzaszolok.setBounds(750, 600, 120, 20);
		hozzaszolok.addActionListener(this);
		
		nyitvatartas.setText(	"Hétfõ: " + '\n' + 
								"Kedd: " + '\n' + 
								"Szerda: " + '\n' + 
								"Csütörtök: " + '\n' + 
								"Péntek: " + '\n' + 
								"Szombat: " + '\n' + 
								"Vasárnap: ");
		nyitvatartas.setBounds(65, 150, 60, 120);
		
		nyitvatartas2.setText(aktualishely.getOpening().toString());
		nyitvatartas2.setBounds(125, 150, 75, 120);
		
		currentRating.setText(String.valueOf(aktualishely.getRating()));
		currentRating.setFont(currentRating.getFont().deriveFont(130.0f));
		currentRating.setBounds(90, 300, 300, 300);
		
		vissza.setBounds(125, 600, 120, 20);
		vissza.addActionListener(this);
		
		add(helynev);
		add(cim);
		add(tipus);
		add(rate);
		add(rateButton);
		//add(ja);
		add(ja2);
		add(hozzaszolok);
		add(nyitvatartas);
		add(nyitvatartas2);
		add(currentRating);
		add(vissza);
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
		if(e.getActionCommand().equals("Vissza")) {
			home.fFelulet(ezaFelhasznalo, "", "", "");
		}
		if(e.getActionCommand().equals("Értékelem")) {
			plc.delete(aktualishely);
			aktualishely.setRating(((double)aktualishely.getCountofratings()*aktualishely.getRating()
					+ Double.parseDouble(rate.getSelectedItem().toString()))/((double)aktualishely.getCountofratings() + 1));
			aktualishely.setCountofratings(aktualishely.getCountofratings() + 1);
			plc.add(aktualishely);
			plc.save("Places");
			home.PlInfo(aktualishely.getName(), ezaFelhasznalo);
		}
		if(e.getActionCommand().equals("Hozzászólok"))  {
			if(ja2.equals("") == false) {
				Comment c = new Comment(aktualishely, ezaFelhasznalo, ja2.getText());
				comments.add(c);
				comments.save("Comments");
				home.PlInfo(aktualishely.getName(), ezaFelhasznalo);
			}			
		}	
	}	
}
