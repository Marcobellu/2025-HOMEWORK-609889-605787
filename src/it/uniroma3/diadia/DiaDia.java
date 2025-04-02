package it.uniroma3.diadia;


//import java.util.Scanner;   NON NE HO PIU' BISOGNO

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io=io;
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) {
			io.mostraMessaggio("inserisci un comando");
			return false;
		}
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		if(this.partita.isFinita()) {


			if (this.partita.vinta()) {
				io.mostraMessaggio("Hai vinto!");
			} else if (this.partita.giocatore.getCfu() == 0) {
				io.mostraMessaggio("Hai esaurito i CFU, partita finita!");
			}
			return true;
		}else
			return false;
	}   

	// implementazioni dei comandi dell'utente:



	/**
	 * Prende un attrezzo dalla borsa e lo lascia nella stanza
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo che si vuole posare
	 * @return true se l'attrezzo è stato posato, false altrimenti
	 */
	private void posa(String oggetto) {
		if(oggetto==null) {
			io.mostraMessaggio("cosa vuoi lasciare");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
		if(attrezzo==null) {
			io.mostraMessaggio("l'attrezzo cercato non e' presente nella borsa");
			return;
		}
		if(partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
			io.mostraMessaggio("l'attrezzo è stato aggiunto nella stanza");
			partita.getGiocatore().getBorsa().removeAttrezzo(oggetto);
		}
		else
			io.mostraMessaggio("la stanza è piena, l'attrezzo non può essere aggiunto");
		io.mostraMessaggio(partita.getStanzaCorrente().toString());
	}

	/**
	 * Prende un attrezzo da una stanza e lo mette nella borsa
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo che si vuole prendere
	 * @return true se l'attrezzo è stato preso, false altrimenti
	 */
	private void prendi(String oggetto) {
		if(oggetto==null) {
			io.mostraMessaggio("cosa vuoi prendere dalla stanza?");
			return;
		}
		if (partita.getStanzaCorrente() == null) {
			io.mostraMessaggio("Errore: la stanza corrente è null!");
			return;
		}
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(oggetto);
		if(attrezzo==null) {
			io.mostraMessaggio("l'attrezzo cercato non è nella stanza");
			return;
		}
		if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
			partita.getStanzaCorrente().removeAttrezzo(oggetto);
			io.mostraMessaggio("attrezzo aggiunto alla borsa");
		}
		else {
			if(!partita.getGiocatore().getBorsa().isEmpty()) 
				io.mostraMessaggio("la borsa è piena, non puoi aggiugere altro");
			else
				io.mostraMessaggio("la borsa è troppo pesante, non puoi aggiungere altri attrezzi");
		}
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}

		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {

			//int cfu = this.partita.giocatore.getCfu();
			if(partita.giocatore.getCfu()>0) {
				partita.giocatore.setCfu(partita.giocatore.getCfu()-1);
				this.partita.setStanzaCorrente(prossimaStanza);
				//System.out.println(partita.getStanzaCorrente().getDescrizione());
				//System.out.print(this.partita.giocatore.toString());
			} else {
				io.mostraMessaggio("non hai abbastanza cfu!!!");
			}
			//System.out.println(partita.getStanzaCorrente().getDescrizione());
			io.mostraMessaggio(this.partita.giocatore.toString());
		}


	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}