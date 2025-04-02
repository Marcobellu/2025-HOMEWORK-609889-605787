import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private int cfu;
	private Borsa borsa;
	private Giocatore  giocatore;

	@BeforeEach
	void setUp() throws Exception {
		this.giocatore=new Giocatore();
		this.borsa=new Borsa();
		this.cfu=5;
<<<<<<< HEAD

=======
 
>>>>>>> 8aa140e92919475658dc28001d98ae5fb5ed849b
	}

	@Test
	void testGetBorsa() {
		this.giocatore.setBorsa(borsa);
		assertNotNull(this.giocatore.getBorsa());
<<<<<<< HEAD

	}

=======
		
	}
	
>>>>>>> 8aa140e92919475658dc28001d98ae5fb5ed849b
	@Test
	void testSetCfu() {
		this.giocatore.setCfu(5);
		assertEquals(this.cfu, this.giocatore.getCfu());
	}
}