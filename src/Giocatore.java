/**
 * Questa classe modella i cfu del giocatore
 *
 * @author  Marco Bellumori
 * @see Partita
 * @version da definire
 */
public class Giocatore {
	private int cfu;
	public Borsa borsa;
	public Partita partita;
	static final private int CFU_INIZIALI = 20;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa= new Borsa();
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	public String toString() {
		return this.partita.getStanzaCorrente()+"\nCfu="+this.getCfu();
	}
}
