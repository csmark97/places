package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Places.AccType;
import Places.Account;
import Places.AccountRegister;

/**
* <h1>Bejelentkez�s</h1>
* Ezen az oldalon indul el a bejelentkez�s.
* <p>
*
* @author  Csord�s M�rk
* @version 1.0
* @since   2017-10-15
*/

public class Start extends JPanel implements ActionListener {	
	private JTextField felhasznTf = new JTextField(32);
	private JPasswordField jlszPf = new JPasswordField(32);	
	private JButton regBtn = new JButton("Regisztr�ljon!");
	private JButton belepesBtn = new JButton("Bel�p�s");		
	private Home home;
	private JLabel helytelen = new JLabel();
	
	/**
	 * A Home feleleten t�rt�n� �dv�zl�s ut�n ker�l�nk erre a fel�letre. 
	 * Ez a konstruktor hozza l�tre ezt a bejelentkez�si fel�letet.
	 */
	public Start() {
		JLabel felhasznL = new JLabel("Felhasznal�i n�v: ");
		JLabel jlszL = new JLabel("Jelsz�: ");
		JLabel udvL = new JLabel("Bejelentkez�s");
		JLabel regL = new JLabel("Nincs m�g felhaszn�l�i fi�kja?");
		
		
		this.setLayout(null);
		udvL.setFont(udvL.getFont().deriveFont(32.0f));		
		udvL.setBounds(65, 40, 412, 40);
		add(udvL);	
	
		felhasznL.setBounds(65, 100, 100, 20);
		add(felhasznL);
		jlszL.setBounds(65, 140, 100, 20);
		add(jlszL);
		
		regL.setBounds(135, 220, 300, 20);
		add(regL);
		
		felhasznTf.setBounds(185, 100, 190, 20);
		add(felhasznTf);
		jlszPf.setBounds(140, 140, 235, 20);
		add(jlszPf);
		
		belepesBtn.setBounds(160, 180, 125, 20);
		belepesBtn.addActionListener(this);
		add(belepesBtn);
		regBtn.setBounds(160, 240, 125, 20);
		regBtn.addActionListener(this);
		add(regBtn);		
		
		helytelen.setBounds(108, 200, 300, 20);
		helytelen.setForeground(Color.RED);
		add(helytelen);		
	}
	
	/**
	 * Az actionPerformed(ActionEvent e) fel�ldefini�l�sa, a fel�leten tal�lhat� gombokhoz.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Regisztr�ljon!")) {
			home.Reg();
		}
		if(e.getActionCommand().equals("Bel�p�s")) {			
			Account tmpAcc = new Account(felhasznTf.getText(), jlszPf.getText());
			AccountRegister accr = new AccountRegister();
			accr.load("Accounts");
			if(accr.check(tmpAcc) == true) {
				if(accr.beenged(tmpAcc).getTipus().equals(AccType.TERMESZETES)){
					home.fFelulet(accr.beenged(tmpAcc), "", "", "");
				}
				if(accr.beenged(tmpAcc).getTipus().equals(AccType.TULAJDONOS)) {
					home.tFelulet(accr.beenged(tmpAcc));
				}
			} else {
				helytelen.setText("Helytelen felhaszn�l�n�v �s/vagy jelsz�!");
			}
		}
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}	
	
	
}
