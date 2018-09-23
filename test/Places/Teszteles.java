package Places;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Teszteles {

	private Account acc;
	private Account acc2;
	private AccountRegister ar;
	private PlaceRegister pr;
	private CommentRegister cr;	
	
	@Before
	public void acc() {
		acc = new Account("a", "a", "a", "a", AccType.TERMESZETES);
		acc2 = new Account("felhasznalo1", "Jelszo123", "Teszt Felhaszn�l�","valaki@email.hu", AccType.TERMESZETES);
		ar = new AccountRegister();
		pr = new PlaceRegister();
		cr = new CommentRegister();
	}
	
	@Test
	public void testAccount() { 
		acc2.setEmail("ujemailcimem@gmail.com");
		acc2.setJlsz("EzazUjjelszavam12");
		acc2.setFelhaszn("UjFelhasznalo1");
		
		Assert.assertEquals("ujemailcimem@gmail.com", acc2.getEmail());
		Assert.assertEquals("EzazUjjelszavam12", acc2.getJlsz());
		Assert.assertEquals("UjFelhasznalo1", acc2.getFelhaszn());
		Assert.assertEquals("Term�szetes szem�ly", acc2.getTipus().toString());
	}	
	
	@Test
	public void testPlaceRegister() {		 
		pr.load("Places");		
		
		Assert.assertEquals(pr.search("Central Pizz�ria"), pr.getPlaces().get(1));	
		Assert.assertEquals(pr.searchCheck("Central Pizz�ria"), true);
	}
	
	@Test
	public void testPlaceRegister2() {
		pr.load("Nem l�tez�");
	}
	
	@Test
	public void testAccountRegister() {		 
		ar.load("Accounts");			
		Assert.assertEquals(ar.check(acc), true);
		Assert.assertEquals(ar.check(acc2), false);
	}
	
	@Test
	public void testAccountRegister2() {
		ar.load("Neml�tez�");
	}
	
	@Test
	public void testCommentRegister() {
		cr.load("Nem l�tez�");
		cr.load("Comments");
		
	}
	
	
	
	
	
	

}

