import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;
	private Stanza vincente;

<<<<<<< HEAD

	@BeforeEach
	void setUp() throws Exception {
		this.partita=new Partita();
		this.vincente=this.partita.getLabirinto().getStanzaVincente();
=======
	
	@BeforeEach
	void setUp() throws Exception {
	this.partita=new Partita();
	this.vincente=this.partita.getLabirinto().getStanzaVincente();
>>>>>>> 8aa140e92919475658dc28001d98ae5fb5ed849b
	}

	@Test
	void testNuovaPartitaNon_Finita() {
		assertFalse(this.partita.isFinita());
<<<<<<< HEAD

=======
	
>>>>>>> 8aa140e92919475658dc28001d98ae5fb5ed849b
	}
	@Test
	void testPartitaVinta() {
		this.partita.setStanzaCorrente(this.vincente);
		assertTrue(partita.vinta());
<<<<<<< HEAD

=======
		
>>>>>>> 8aa140e92919475658dc28001d98ae5fb5ed849b
	}

}