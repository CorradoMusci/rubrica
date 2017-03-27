package it.polito.tdp.rubrica.model;

import java.util.*;

import rubricaDB.VoceDAO;

/**
 * Insieme di tutte le voci della rubrica ed i metodi per gestire tale insieme
 * 
 * @author CorradoMusci
 *
 */

public class RubricaModel {

	private List<Voce> rubrica;

	public RubricaModel() {
	//	rubrica = new ArrayList<Voce>();
	}

	/**
	 * Aggiunge una nuova voce alla rubrica,se questa non esiste ancora. Se
	 * invece esiste,non fanulla e segnala il problema restituendo {@false}
	 * 
	 * 
	 * @param v
	 *            la nuova Voce da aggiungere
	 * @return {@code true} se la voce è stata aggiunta correttamente,
	 *         {@false} se esisteva già e quindi non è stata aggiunta
	 */

	public boolean addVoce(Voce v) {

	/*	if (rubrica.contains(v)) {
			return false;
		} else {
			rubrica.add(v);
			return true;
		}*/
		
		VoceDAO dao = new VoceDAO();
		if(dao.findVoceByNome(v.getNome()) != null)
			return false;
		
		return dao.addVoce(v);
	}

	/**
	 * Ricerca nell'intera rubrica una {@link Voce} che abbia il nome uguale a
	 * quello specificato. Se esiste,ritorna tale oggetto altrimenti
	 * ritorna{@code null}.
	 * 
	 * @param nome
	 *            il nome da ricerca
	 * @return la {@link Voce} corrispondente, oppure{@code null} se non l'ha
	 *         trovata
	 */

	public Voce findVoceByNome(String nome) {

	/*	for (Voce v : rubrica) {
			if (v.getNome().equals(nome)) {
				return v;
			}
		}
		return null;*/
		
		VoceDAO dao = new VoceDAO();
		
		Voce v = dao.findVoceByNome(nome);
		
		return v;
		
	}
	
	public static void main(String [] args){
		
		RubricaModel m = new RubricaModel () ;
		
	boolean r1 = m.addVoce(new Voce("Corrado","musci.corrado@polito.it","3233"));
	boolean r2 =	m.addVoce(new Voce("Gaspare","Sciacca.Gasp@polito.it","3422"));
	boolean r3 =	m.addVoce(new Voce("Corrado","f.qualcuno@polito.it","34532"));
   
	
	System.out.println(r1);
	System.out.println(r2);
	System.out.println(r3);
	
	Voce v1 = m.findVoceByNome("Gaspare");
	Voce v2 = m.findVoceByNome("Piero");
	
	System.out.println(v1);
	System.out.println(v2);
	}

}
