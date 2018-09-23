package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Places.AccType;
import Places.Account;
import Places.Address;
import Places.Contact;
import Places.MyTime;
import Places.Opening;
import Places.Place;
import Places.PlaceRegister;
import Places.PlaceType;

/**
* <h1>Hely létrehozása</h1>
* Ez az osztály hozza létre a helyek létrehozására szükséges adatlapot, és egyéb szükséges mûveleteket.
* <p>
*
* @author  Csordás Márk
* @version 1.0
* @since   2017-10-15
*/

public class CreatePlace extends JPanel implements ActionListener{
	private Home home;
	private JTextField nevtf = new JTextField(20);
	private JTextField ziptf = new JTextField(20);
	private JTextField citytf = new JTextField(20);	
	private JTextField streettf = new JTextField(20);	
	private JTextField hnumbertf = new JTextField(20);	
	private JTextField teltf = new JTextField(20);	
	private JTextField emailtf = new JTextField(20);	
	private JTextField webtf = new JTextField(20);	
	private JTextField hetfotf = new JTextField(8); 
	private JTextField hetfotf2 = new JTextField(8);	
	private JTextField keddtf = new JTextField(8);
	private JTextField keddtf2 = new JTextField(8); 
	private JTextField szerdatf = new JTextField(8);
	private JTextField szerdatf2 = new JTextField(8);
	private JTextField csutortoktf = new JTextField(8);	
	private JTextField csutortoktf2 = new JTextField(8);	 
	private JTextField pentektf = new JTextField(8);	
	private JTextField pentektf2 = new JTextField(8);
	private JTextField szombattf = new JTextField(8);
	private JTextField szombattf2 = new JTextField(8);	
	private JTextField vasarnaptf = new JTextField(8);	
	private JTextField vasarnaptf2 = new JTextField(8);	
	private JComboBox<Object> tipus;		
	private JButton vissza = new JButton("Vissza");
	private JButton add = new JButton("Hozzáad");	
	private Account creator = new Account();
	
	/**
	 * Létrehozza a hely hozzááadásához szükséges felületet (gombok, textfieldek stb).
	 * @param acc A felhasználói fiók, amelyen keresztül el akarjuk érni a felületet.
	 */
	public CreatePlace(Account acc){
		JLabel nevl = new JLabel("Név: ");
		JLabel zipl = new JLabel("Irányítószám: ");
		JLabel cityl = new JLabel("Város: ");
		JLabel streetl = new JLabel("Utca/tér: ");
		JLabel hnumberl = new JLabel("Házszám: ");
		JLabel tell = new JLabel("Telefonszám: ");
		JLabel emaill = new JLabel("E-Mail: ");
		JLabel webl = new JLabel("Web: ");
		JLabel nyitvatartas = new JLabel("Nyitvatartás:");
		JLabel vonalh = new JLabel(" - ");
		JLabel hetfol = new JLabel("Hétfõ: ");
		JLabel vonalk = new JLabel(" - ");
		JLabel keddl = new JLabel("Kedd: ");
		JLabel vonalsze = new JLabel(" - ");
		JLabel szerdal = new JLabel("Szerda: ");
		JLabel vonalcs = new JLabel(" - ");
		JLabel csutortokl = new JLabel("Csütörtök: ");
		JLabel vonalp = new JLabel(" - ");
		JLabel pentekl = new JLabel("Péntek: ");
		JLabel vonalszo = new JLabel(" - ");
		JLabel szombatl = new JLabel("Szombat: ");
		JLabel vonalv = new JLabel(" - ");
		JLabel vasarnapl = new JLabel("Vasárnap: ");
		JLabel tipusl = new JLabel("Típus: ");
		JLabel title = new JLabel("Új hely hozzáadása...");
		
		setLayout(null);
		
		creator = acc;
		
		Object[] o = new Object[7];
		{
			o[0] = "BOLT"; o[1] = "KÖZTERÜLET"; o[2] = "INTÉZMÉNY"; o[3] = "ÉTTEREM";
			o[4] = "SZÁLLÁS"; o[5] = "SZÓRAKOZÁS"; o[6] = "BEVÁSÁRLÓKÖZPONT";
		}
		tipus = new JComboBox<>(o); //Legördülõ lista

		title.setBounds(200, 15, 500, 50);
		title.setFont(title.getFont().deriveFont(24.0f));
		add(title);
		
		add(nevl);
		nevl.setBounds(200, 80, 100, 20);
		
		add(nevtf);	
		nevtf.setBounds(300, 80, 200, 20);
				
		add(zipl);
		zipl.setBounds(200, 120, 100, 20);
		add(ziptf);
		ziptf.setBounds(300, 120, 200, 20);
		add(cityl);
		cityl.setBounds(200, 160, 100, 20);
		add(citytf);
		citytf.setBounds(300, 160, 200, 20);

		add(streetl);
		streetl.setBounds(200, 200, 100, 20);
		add(streettf);
		streettf.setBounds(300, 200, 200, 20);
		add(hnumberl);
		hnumberl.setBounds(200, 240, 100, 20);
		add(hnumbertf);
		hnumbertf.setBounds(300, 240, 200, 20);

		add(tell);
		tell.setBounds(200, 280, 100, 20);
		add(teltf);
		teltf.setBounds(300, 280, 200, 20);

		add(emaill);
		emaill.setBounds(200, 320, 100, 20);
		add(emailtf);
		emailtf.setBounds(300, 320, 200, 20);

		add(webl);
		webl.setBounds(200, 360, 100, 20);
		add(webtf);
		webtf.setBounds(300, 360, 200, 20);

		add(nyitvatartas);	
		nyitvatartas.setBounds(750, 80, 200, 20);
		
		add(hetfol);	
		add(hetfotf);		
		add(vonalh);		
		add(hetfotf2);
		hetfol.setBounds(650, 120, 100, 20);
		hetfotf.setBounds(730, 120, 50, 20);
		vonalh.setBounds(780, 120, 20, 20);
		hetfotf2.setBounds(790, 120, 50, 20);

		add(keddl);
		add(keddtf);
		add(vonalk);		
		add(keddtf2);
		keddl.setBounds(650, 160, 100, 20);
		keddtf.setBounds(730, 160, 50, 20);
		vonalk.setBounds(780, 160, 20, 20);
		keddtf2.setBounds(790, 160, 50, 20);
	
		add(szerdal);
		add(szerdatf);
		add(vonalsze);		
		add(szerdatf2);
		szerdal.setBounds(650, 200, 100, 20);
		szerdatf.setBounds(730, 200, 50, 20);
		vonalsze.setBounds(780, 200, 20, 20);
		szerdatf2.setBounds(790, 200, 50, 20);

		add(csutortokl);
		add(csutortoktf);
		add(vonalcs);		
		add(csutortoktf2);
		csutortokl.setBounds(650, 240, 100, 20);
		csutortoktf.setBounds(730, 240, 50, 20);
		vonalcs.setBounds(780, 240, 20, 20);
		csutortoktf2.setBounds(790, 240, 50, 20);

		add(pentekl);
		add(pentektf);
		add(vonalp);		
		add(pentektf2);
		pentekl.setBounds(650, 280, 100, 20);
		pentektf.setBounds(730, 280, 50, 20);
		vonalp.setBounds(780, 280, 20, 20);
		pentektf2.setBounds(790, 280, 50, 20);

		add(szombatl);
		add(szombattf);
		add(vonalszo);		
		add(szombattf2);
		szombatl.setBounds(650, 320, 100, 20);
		szombattf.setBounds(730, 320, 50, 20);
		vonalszo.setBounds(780, 320, 20, 20);
		szombattf2.setBounds(790, 320, 50, 20);

		add(vasarnapl);
		add(vasarnaptf);
		add(vonalv);		
		add(vasarnaptf2);
		vasarnapl.setBounds(650, 360, 100, 20);
		vasarnaptf.setBounds(730, 360, 50, 20);
		vonalv.setBounds(780, 360, 20, 20);
		vasarnaptf2.setBounds(790, 360, 50, 20);
	
		add(tipusl);
		add(tipus);
		tipusl.setBounds(430, 400, 200, 30);
		tipus.setBounds(500, 400, 140, 30);
		
		add.addActionListener(this);
		add.setBounds(500, 450, 140, 40);
		add(add);
		
		vissza.addActionListener(this);
		vissza.setBounds(500, 510, 140, 30);
		add(vissza);

	}
	
	/**
	 * Létrehoz egy helyet a kitölött mezõk alapján.
	 * @return hely Visszaadja a létrehozott helyet, a kitöltött mezõk alapján.
	 */
	public Place addPlace(){
		Address cim =new Address(Integer.parseInt(ziptf.getText()), citytf.getText(), 
				streettf.getText(), Integer.parseInt(hnumbertf.getText()));
		
		Contact elerhetoseg = new Contact(cim, teltf.getText(), 
				emailtf.getText(), webtf.getText());
		
		MyTime mondayA = new MyTime();
		MyTime mondayB = new MyTime();
		MyTime tuesdayA = new MyTime();
		MyTime tuesdayB = new MyTime();
		MyTime wednesdayA = new MyTime();
		MyTime wednesdayB = new MyTime();
		MyTime thursdayA = new MyTime();
		MyTime thursdayB = new MyTime();
		MyTime fridayA = new MyTime();
		MyTime fridayB = new MyTime();
		MyTime saturdayA = new MyTime();
		MyTime saturdayB = new MyTime();
		MyTime sundayA = new MyTime();
		MyTime sundayB = new MyTime();
		
		mondayA.setIdo(hetfotf.getText());
		mondayB.setIdo(hetfotf2.getText());
		tuesdayA.setIdo(keddtf.getText());
		tuesdayB.setIdo(keddtf2.getText());
		wednesdayA.setIdo(szerdatf.getText());
		wednesdayB.setIdo(szerdatf2.getText());
		thursdayA.setIdo(csutortoktf.getText());
		thursdayB.setIdo(csutortoktf2.getText());
		fridayA.setIdo(pentektf.getText());
		fridayB.setIdo(pentektf2.getText());
		saturdayA.setIdo(szombattf.getText());
		saturdayB.setIdo(szombattf2.getText());
		sundayA.setIdo(vasarnaptf.getText());
		sundayB.setIdo(vasarnaptf2.getText());
		
		Opening nyitvatartas = new Opening(
				mondayA, mondayB, tuesdayA, tuesdayB, wednesdayA, wednesdayB, thursdayA, thursdayB,
				fridayA, fridayB, saturdayA, saturdayB, sundayA, sundayB);	
		
		PlaceType tip = PlaceType.BOLT;	
		if (tipus.getSelectedItem().toString() == "BOLT")
			tip = PlaceType.BOLT;
		else if (tipus.getSelectedItem().toString() == "KÖZTERÜLET")
			tip = PlaceType.KOZTERULET;
		else if (tipus.getSelectedItem().toString() == "INTÉZMÉNY")
			tip = PlaceType.INTEZMENY;
		else if (tipus.getSelectedItem().toString() == "ÉTTEREM")
			tip = PlaceType.ETTEREM;
		else if (tipus.getSelectedItem().toString() == "SZÁLLÁS")
			tip = PlaceType.SZALLAS;
		else if (tipus.getSelectedItem().toString() == "SZÓRAKOZÁS")
			tip = PlaceType.SZORAKOZAS;
		else if (tipus.getSelectedItem().toString() == "BEVÁSÁRLÓKÖZPONT")
			tip = PlaceType.BEVASARLOKOZPONT;
		
		
		Place hely = new Place(nevtf.getText(), elerhetoseg, nyitvatartas, tip, creator);
		return hely;
	}
	
	
	/**
	 * actionPerformed(ActionEvent e) függvény felüldefiniálása. Itt a 'Hozzáad' és a 'Vissza' gombokra van megírva.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Hozzáad")) {
            // Hozzáadás SERIALIZABLE 
			PlaceRegister plc = new PlaceRegister();
			plc.load("Places");
			plc.add(addPlace());
			plc.save("Places");
			home.tFelulet(creator);	

		}
		if(e.getActionCommand().equals("Vissza")) {
			home.tFelulet(creator);
		}
	}

	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}	
}