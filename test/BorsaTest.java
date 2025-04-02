import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo chiave;

	@BeforeEach
	void setUp() throws Exception {
		this.borsa=new Borsa(6);
		this.chiave=new Attrezzo("chiave",6);


	}

	@Test
	void testBorsaNonVuota() {
		this.borsa.addAttrezzo(chiave);
		assertFalse(this.borsa.isEmpty());
	}

	@Test
	void testBorsaVuota() {

		assertTrue(this.borsa.isEmpty());
	}

	@Test
	void testAddAttrezzo() {
		assertFalse(this.borsa.hasAttrezzo("chiave"));
		this.borsa.addAttrezzo(this.chiave);
		assertTrue(this.borsa.hasAttrezzo("chiave"));
	}

	@Test
	void testRemoveAttrezzo() {
		this.borsa.addAttrezzo(chiave);
		assertTrue(this.borsa.hasAttrezzo("chiave"));
		this.borsa.removeAttrezzo("chiave");
		assertFalse(this.borsa.hasAttrezzo("chiave"));
	}

}