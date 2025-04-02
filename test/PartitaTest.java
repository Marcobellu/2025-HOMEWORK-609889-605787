import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;
	private Stanza vincente;

	
	@BeforeEach
	void setUp() throws Exception {
	this.partita=new Partita();
	this.vincente=this.partita.getLabirinto().getStanzaVincente();
	}

	@Test
	void testNuovaPartitaNon_Finita() {
		assertFalse(this.partita.isFinita());
	
	}
	@Test
	void testPartitaVinta() {
		this.partita.setStanzaCorrente(this.vincente);
		assertTrue(partita.vinta());
		
	}

}