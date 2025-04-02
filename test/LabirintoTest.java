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

	}
	void testGetStanzaIngresso() {
		assertEquals(this.ingresso,this.labirinto.getStanzaIngresso());

	}
	void testGetStanzaVincente() {
		assertEquals(this.vincente,this.labirinto.getStanzaVincente());
	}
}