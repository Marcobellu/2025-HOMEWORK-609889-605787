package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	public Giocatore giocatore;
	public Labirinto labirinto;

	private boolean finita;
	private Stanza stanzaCorrente;


	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.giocatore.partita= this;
		this.finita = false;
		this.stanzaCorrente = this.labirinto.getStanzaIngresso(); 
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


}