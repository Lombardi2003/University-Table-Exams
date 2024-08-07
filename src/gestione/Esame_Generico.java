package gestione;
/**
 * La classe Esame_Generico è padre degli esami, cioè è quella che specifica i principali componenti
 * che deve avere l'esame
 */
public class Esame_Generico {
	/** L'attributo che contiene il nome */
	public String nome;
	/** L'attributo che contiene il cognome */
	public String cognome;
	/** L'attributo che contiene il materia */
	public String materia;
	/** L'attributo che contiene il voto */
	public int voto;
	/** L'attributo che contiene i crediti */
	public int cfu;
	/** L'attributo che contiene se c'è stata la lode o meno */
	public boolean lode;
	/**
	 * Costruttore di default
	 */
	public Esame_Generico() {
		nome = null;
		cognome = null;
		materia = null;
		voto = 0;
		cfu = 0;
		lode = false;
	}
	/**
	 * Costruttore della Esame_Generico
	 *
	 * @param nome per il nome
	 * @param cognome per il cognome
	 * @param materia per la materia
	 * @param cfu per i crediti dell'esame
	 * @param voto per il voto
	 * @param lode per la lode
	 */
	public Esame_Generico(String nome, String cognome, String materia, int cfu, int voto, boolean lode) {
		setNome(nome);
		setCognome(cognome);
		setMateria(materia);
		setCfu(cfu);
		setVoto(voto);
		setLode(lode);
	}
	/**
	 * Metodo per il ritorno del nome dell'esame
	 */
		public String getNome() {
	        return nome;
	    }
	/**
	 * Metodo per la modifica del nome dell'esame
	 *
	 * @param nome per il nome dell'esame
	 */
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	/**
	 * Metodo per il ritorno del cognome dell'esame
	 */
	    public String getCognome() {
	        return cognome;
	    }
	/**
	 * Metodo per la modifica del cognome dell'esame
	 *
	 * @param cognome per il cognome dell'esame
	 */
	    public void setCognome(String cognome) {
	        this.cognome = cognome;
	    }
	/**
	 * Metodo per il ritorno del voto dell'esame
	 */
	    public int getVoto() {
	        return voto;
	    }
	/**
	 * Metodo per la modifica del voto dell'esame
	 *
	 * @param voto per il voto dell'esame
	 */
	    public void setVoto(int voto) {
	        this.voto = voto;
	    }
	/**
	 * Metodo per il ritorno della materia dell'esame
	 */
	    public String getMateria() {
	        return materia;
	    }
	/**
	 * Metodo per la modifica del materia dell'esame
	 *
	 * @param materia per la materia dell'esame
	 */
	    public void setMateria(String materia) {
	        this.materia = materia;
	    }
	/**
	 * Metodo per il ritorno dei crediti dell'esame
	 */
	    public int getCfu() {
	        return cfu;
	    }
	/**
	 * Metodo per la modifica dei crediti dell'esame
	 *
	 * @param cfu per i crediti dell'esame
	 */
	    public void setCfu(int cfu) {
	        this.cfu = cfu;
	    }
	/**
	 * Metodo per il ritorno della lode dell'esame
	 */
	    public boolean getLode() {
	        return lode;
	    }
	/**
	 * Metodo per la modifica della lode dell'esame
	 *
	 * @param lode per la lode dell'esame
	 */
	    public void setLode(boolean lode) {
	        this.lode = lode;
	    }
}
