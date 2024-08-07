package gestione;
/**
 * La classe Esame è la classe figlia di Esame_Generico degli esami, cioè è quella che specifica i principali componenti
 * che deve avere l'esame, con anche gli esami intermedi
 */
public class Esame extends Esame_Generico{
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
    /** L'attributo che contiene il numero degli esami intermedi */
	int dim;
    /** La lista dei voti delle prove intermedie */
	int intermedi[];
    /** La lista dei pesi delle prove intermedie */
    int pesi[];

    /**
     * Costruttore di default
     */
	public Esame() {
		nome = null;
		cognome = null;
		materia = null;
		voto = 0;
		cfu = 0;
        lode = false;
	}
    /**
     * Costruttore della Esame
     *
     * @param nome per il nome
     * @param cognome per il cognome
     * @param materia per la materia
     * @param cfu per i crediti dell'esame
     * @param voto per il voto
     * @param lode per la lode
     */
	public Esame(String nome, String cognome, String materia, int cfu, int voto, boolean lode) {
		setNome(nome);
		setCognome(cognome);
		setMateria(materia);
		setCfu(cfu);
		setVoto(voto);
		setLode(lode);
		dim = 0;
		intermedi = null;
		pesi = null;
	}
    /**
     * Secondo Costruttore della Esame
     *
     * @param nome per il nome
     * @param cognome per il cognome
     * @param materia per la materia
     * @param cfu per i crediti dell'esame
     * @param voto per il voto
     * @param lode per la lode
     * @param dim per il numero delle orove intermedie
     * @param intermedi per la lista dei voti intermedi
     * @param pesi per la lista dei pesi dei voti intermedi
     */
	public Esame(String nome, String cognome, String materia, int cfu, int voto, boolean lode, int dim, int intermedi[], int pesi[]) {
		setNome(nome);
		setCognome(cognome);
		setMateria(materia);
		setCfu(cfu);
		setVoto(voto);
		setLode(lode);
		this.dim = dim;
		this.intermedi = new int[this.dim];
		this.pesi = new int[this.dim];
		this.intermedi = intermedi;
		this.pesi = pesi;
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
    /**
     * Metodo per il ritorno del numero delle prove intermedie
     */
    public int getDimensione() {
        return dim;
    }
    /**
     * Metodo per la modifica del numero delle prove intermedie
     *
     * @param dim per il numero delle prove intermedie
     */
    public void setDimensione(int dim) {
        this.dim = dim;
    }
    /**
     * Metodo per il ritorno della lista dei voti delle prove intermedie
     */
    public int[] getIntermedi() {
        return intermedi;
    }
    /**
     * Metodo per la modifica della lista dei voti delle prove intermedie
     *
     * @param dim per il numero delle prove intermedie
     */
    public void setIntermedi(int dim) {
        this.dim = dim;
    }
    /**
     * Metodo per il ritorno della lista dei pesi delle prove intermedie
     */
    public int[] getPesi() {
        return pesi;
    }
    /**
     * Metodo per la modifica della lista dei pesi delle prove intermedie
     *
     * @param dim per il numero delle prove intermedie
     */
    public void setPesi(int dim) {
        this.dim = dim;
    }
}