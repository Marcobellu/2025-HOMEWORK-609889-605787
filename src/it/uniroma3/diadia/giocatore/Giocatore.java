package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella i cfu del giocatore
 *
 * @author  Marco Bellumori, Asia Achilli
 * @see Partita
 * @version da definire
 */
public class Giocatore {
	private int cfu;
	public Borsa borsa;
	public Partita partita;
	static final private int CFU_INIZIALI = 6;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa= new Borsa();

	}
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
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