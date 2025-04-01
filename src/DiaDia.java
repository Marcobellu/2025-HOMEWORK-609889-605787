

import java.util.Scanner;

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
	//private Attrezzo attrezzo;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

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
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
/*	private void Prendi(String nomeAttrezzo) {
        Stanza stanzaCorrente = this.partita.labirinto.getStanzaCorrente();
        Borsa borsa = this.partita.giocatore.getBorsa();
        
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
        if (attrezzo != null) {
            if (borsa.hasAttrezzo(attrezzo.getNome())) {
                stanzaCorrente.removeAttrezzo(nomeAttrezzo);
                System.out.println("Hai preso: " + nomeAttrezzo);
            } else {
                System.out.println("La borsa è piena! Non puoi prendere questo attrezzo.");
            }
        } else {
            System.out.println("Attrezzo non presente nella stanza.");
        }
    }*/
private void posa(String oggetto) {
	if(oggetto==null) {
		System.out.println("cosa vuoi lasciare");
		return;
	}
	Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
	if(attrezzo==null) {
		System.out.println("l'attrezzo cercato non e' presente nella borsa");
		return;
	}
	if(partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
		System.out.println("l'attrezzo è stato aggiunto nella stanza");
		partita.getGiocatore().getBorsa().removeAttrezzo(oggetto);
	}
	else
		System.out.println("la stanza è piena, l'attrezzo non può essere aggiunto");
	System.out.println(partita.getStanzaCorrente().toString());
}

private void prendi(String oggetto) {
	if(oggetto==null) {
		System.out.println("cosa vuoi prendere dalla stanza?");
		return;
	}
	if (partita.getStanzaCorrente() == null) {
        System.out.println("Errore: la stanza corrente è null!");
        return;
    }
	Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(oggetto);
	if(attrezzo==null) {
		System.out.println("l'attrezzo cercato non è nella stanza");
		return;
	}
	if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
		partita.getStanzaCorrente().removeAttrezzo(oggetto);
		System.out.println("attrezzo aggiunto alla borsa");
	}
	else {
		if(!partita.getGiocatore().getBorsa().isEmpty()) 
			System.out.println("la borsa è piena, non puoi aggiugere altro");
		else
			System.out.println("la borsa è troppo pesante, non puoi aggiungere altri attrezzi");
	}
	System.out.println(partita.getGiocatore().getBorsa().toString());
}
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			System.out.println("Dove vuoi andare ?");
			return;
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			
			//int cfu = this.partita.giocatore.getCfu();
			//if(cfu>0) {
			partita.giocatore.setCfu(partita.giocatore.getCfu()-1);
			this.partita.setStanzaCorrente(prossimaStanza);
			//System.out.println(partita.getStanzaCorrente().getDescrizione());
			//this.partita.giocatore.toString();
			//} else {
				//System.out.println("non hai abbastanza cfu!!!");
			//}
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}