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
* <h1>Regisztráció</h1>
* Ez az osztály a regisztráció lebonyolításáért felel.
* <p>
*
* @author  Csordás Márk
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
	private JButton kesz = new JButton("Kész");
	private JButton vissza = new JButton("Vissza");	
	private JLabel helytelen = new JLabel();	
	private Home home;
	
	/**
	 * A regisztráció felületet felépítõ konstruktor.
	 */
	public Regisztracio() {
		JLabel title = new JLabel("Regisztráció");
		JLabel nickL = new JLabel("Felhasználói név: ");
		JLabel passwordL = new JLabel("Jelszó: ");
		JLabel password2L = new JLabel("Jelszó újra:");
		JLabel nameL = new JLabel("Név: ");
		JLabel emailL = new JLabel("E-Mail:");
		JLabel adatvL = new JLabel("Az Általános Szerzõdési Feltételeket elfogadom! ");
		
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
			o[0] = "Természetes Személy"; o[1] = "Cég Tulajdonos";
		}		
		tipusCB = new JComboBox<>(o);
		tipusCB.setBounds(115, 300, 200, 20);	
		add(tipusCB);
	}
	
	/**
	 * Felhasználói fiókot létrehozó függvény.
	 * @return acc Visszaadja a felhasználói fiókot, amelyet létrehoz a kitölött mezõk alapján.
	 */
	public Account createAccount(){
		Account acc;
		AccType tipus;
		if (tipusCB.getSelectedItem().toString() == "Természetes Személy")
			tipus = AccType.TERMESZETES;
		else
			tipus = AccType.TULAJDONOS;
		acc = new Account(nickTf.getText(), passwordPf.getText(), nameTf.getText(),
				emailTf.getText(), tipus);		
		return acc;
	}

	/**
	 * Az actionPerformed(ActionEvent e) felüldefiniálása, a felületen található gombokhoz.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Kész")) {
			if (adatvCh.isSelected() == false){
				helytelen.setText("Az ÁSzF elfogadása kötelezõ!");
			} else if (nickTf.getText().trim().isEmpty() || passwordPf.getText().trim().isEmpty() 
					|| nameTf.getText().trim().isEmpty() || emailTf.getText().trim().isEmpty()){
				helytelen.setText("Minden mezõ kitöltése kötelezõ!");
			} else if(!passwordPf.getText().equals(password2Pf.getText())) {
				helytelen.setText("A két jelszó nem egyezik!");
			//} else if(nickTf.getText() == létezésVizsgálófüggvény()){				
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