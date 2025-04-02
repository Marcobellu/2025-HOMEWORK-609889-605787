import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	private Labirinto labirinto;
	private Stanza vincente;
	public Stanza ingresso;
	@BeforeEach
	void setUp() throws Exception {
		this.labirinto= new Labirinto();
		this.vincente= new Stanza("Biblioteca");
		this.ingresso=new Stanza("Atrio");
	}

	@Test
	void testCreaStanza() {
		this.labirinto.creaStanze();
		assertNotNull(this.labirinto.getStanzaIngresso());
		assertEquals(this.ingresso.getNome(), this.labirinto.getStanzaIngresso().getNome());
		assertNotNull(this.labirinto.getStanzaVincente());
		assertEquals(this.vincente.getNome(), this.labirinto.getStanzaVincente().getNome());
<<<<<<< HEAD

	}
	@Test
	void testGetStanzaIngresso() {
		assertEquals(this.ingresso.getNome(),this.labirinto.getStanzaIngresso().getNome());

	}

=======
		
	}
	@Test
	void testGetStanzaIngresso() {
		assertEquals(this.ingresso.getNome(),this.labirinto.getStanzaIngresso().getNome());
		
	}
	
>>>>>>> 8aa140e92919475658dc28001d98ae5fb5ed849b
	@Test
	void testGetStanzaVincente() {
		assertEquals(this.vincente.getNome(),this.labirinto.getStanzaVincente().getNome());
	}
}