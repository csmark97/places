package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Places.AccType;
import Places.Account;
import Places.AccountRegister;

/**
* <h1>Regisztr�ci�</h1>
* Ez az oszt�ly a regisztr�ci� lebonyol�t�s��rt felel.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class Regisztracio extends JPanel implements ActionListener{	
	private JTextField nickTf = new JTextField(40);
	private JPasswordField passwordPf = new JPasswordField();
	private JPasswordField password2Pf = new JPasswordField();
	private JTextField nameTf = new JTextField(40);
	private JTextField emailTf = new JTextField(40);
	private JComboBox<Object> tipusCB;
	private JCheckBox adatvCh = new JCheckBox();
	private JButton kesz = new JButton("K�sz");
	private JButton vissza = new JButton("Vissza");	
	private JLabel helytelen = new JLabel();	
	private Home home;
	
	/**
	 * A regisztr�ci� fel�letet fel�p�t� konstruktor.
	 */
	public Regisztracio() {
		JLabel title = new JLabel("Regisztr�ci�");
		JLabel nickL = new JLabel("Felhaszn�l�i n�v: ");
		JLabel passwordL = new JLabel("Jelsz�: ");
		JLabel password2L = new JLabel("Jelsz� �jra:");
		JLabel nameL = new JLabel("N�v: ");
		JLabel emailL = new JLabel("E-Mail:");
		JLabel adatvL = new JLabel("Az �ltal�nos Szerz�d�si Felt�teleket elfogadom! ");
		
		this.setLayout(null);
		title.setBounds(65, 40, 212, 40);
		title.setFont(title.getFont().deriveFont(32.0f));
		add(title);
		
		nickL.setBounds(65, 100, 100, 20);
		add(nickL);
		passwordL.setBounds(65, 140, 100, 20);
		add(passwordL);
		password2L.setBounds(65, 180, 100, 20);
		add(password2L);
		nameL.setBounds(65, 220, 100, 20);
		add(nameL);		
		emailL.setBounds(65, 260, 100, 20);
		add(emailL);
		adatvL.setBounds(65, 350, 300, 20);
		add(adatvL);

		nickTf.setBounds(185, 100, 190, 20);
		add(nickTf);
		passwordPf.setBounds(140, 140, 235, 20);
		add(passwordPf);
		password2Pf.setBounds(140, 180, 235, 20);
		add(password2Pf);
		nameTf.setBounds(140, 220, 235, 20);
		add(nameTf);		
		emailTf.setBounds(140, 260, 235, 20);
		add(emailTf);
		adatvCh.setBounds(350, 350, 20, 20);
		add(adatvCh);
		kesz.setBounds(160, 390, 100, 20);
		kesz.addActionListener(this);
		add(kesz);

		vissza.setBounds(160, 420, 100, 20);
		vissza.addActionListener(this);
		add(vissza);
		
		helytelen.setBounds(124, 320, 300, 20);
		helytelen.setForeground(Color.RED);
		add(helytelen);
		
		Object[] o = new Object[2];
		{
			o[0] = "Term�szetes Szem�ly"; o[1] = "C�g Tulajdonos";
		}		
		tipusCB = new JComboBox<>(o);
		tipusCB.setBounds(115, 300, 200, 20);	
		add(tipusCB);
	}
	
	/**
	 * Felhaszn�l�i fi�kot l�trehoz� f�ggv�ny.
	 * @return acc Visszaadja a felhaszn�l�i fi�kot, amelyet l�trehoz a kit�l�tt mez�k alapj�n.
	 */
	public Account createAccount(){
		Account acc;
		AccType tipus;
		if (tipusCB.getSelectedItem().toString() == "Term�szetes Szem�ly")
			tipus = AccType.TERMESZETES;
		else
			tipus = AccType.TULAJDONOS;
		acc = new Account(nickTf.getText(), passwordPf.getText(), nameTf.getText(),
				emailTf.getText(), tipus);		
		return acc;
	}

	/**
	 * Az actionPerformed(ActionEvent e) fel�ldefini�l�sa, a fel�leten tal�lhat� gombokhoz.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("K�sz")) {
			if (adatvCh.isSelected() == false){
				helytelen.setText("Az �SzF elfogad�sa k�telez�!");
			} else if (nickTf.getText().trim().isEmpty() || passwordPf.getText().trim().isEmpty() 
					|| nameTf.getText().trim().isEmpty() || emailTf.getText().trim().isEmpty()){
				helytelen.setText("Minden mez� kit�lt�se k�telez�!");
			} else if(!passwordPf.getText().equals(password2Pf.getText())) {
				helytelen.setText("A k�t jelsz� nem egyezik!");
			//} else if(nickTf.getText() == l�tez�sVizsg�l�f�ggv�ny()){				
			} else {
		
				AccountRegister accr = new AccountRegister();
				accr.load("Accounts");
				accr.add(createAccount());
				accr.save("Accounts");
				home.Start();
			}
		} 
		
		if(e.getActionCommand().equals("Vissza")) {
			home.Start();
		}
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
}