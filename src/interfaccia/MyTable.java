package interfaccia;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.stream.Collectors;


import javax.swing.table.*;

/**
 * La classe MyTable è la classe che gestisce il modello della tabella. Estende la classe
 * AbstractTableModel che ci fornisce il dato per la JTable
 */
public class MyTable extends AbstractTableModel{
	/** La stringa contenente i nomi delle colonne della tabella */
	private String[] ColName = {"Nome", "Cognome", "Materia", "CFU", "Voto", "Lode"};
	/** La lista che contiene tutti i dati della tabella */
	public ArrayList<gestione.Esame> data = new ArrayList<gestione.Esame>();
	/** La lista che serve per il filtraggio della tabella*/
	public ArrayList<gestione.Esame> tabella = new ArrayList<gestione.Esame>();
	/** Attributo booleano che serve per la funzione che ti ritorna quando chiusa se è stata già salvata */
	public boolean mod = false;
	/** La pagina di gestione degli esami nella quale viene visualizzata la tabella che sfrutta questo modello */
	public MyFrame f;
	/**
	 * Costruttore della classe MyTable.
	 *
	 * @param esami     la lista degli esami iniziale
	 * @param f  		la finestra di gestione esami associata al gestore degli esami
	 */
	public MyTable(ArrayList<gestione.Esame> esami,MyFrame f) {
		this.f=f;
		data = tabella = esami;
		addTableModelListener(e -> {
            calcolaMediaPesata();
            setModificato(true);
            f.setAutosave("Non salvato");
        });
	}
	/**
	 * Metodo per il ritorno del numero delle colonne
	 */
	public int getColumnCount() { 					//restituisce il numero di colonne
		return ColName.length; 
	}
	/**
	 * Metodo per il ritorno del numero delle righe
	 */
	public int getRowCount() {						//restituisce il numero di righe 
		return data.size();
	}
	/**
	 * Metodo per il ritorno l'oggetto che viene visualizzata dentro la tabella
	 *
	 * @param col 	per il numero di colonne
	 * @param row 	per il numero di righe
	 */
	public Object getValueAt(int row, int col) {	//da i valori alla tabella
        gestione.Esame e = data.get(row);
        switch (col) {
            case 0:
                return e.getNome();
            case 1:
                return e.getCognome();
            case 2:
                return e.getMateria();
			case 3:
				return e.getCfu();
			case 4: 
				return e.getVoto();
			case 5: 
				if(e.getLode()==true) {
					return "SI";
				}
				else {
					return "NO";
				}
			default: 
				return null;
		}
	}
	/**
	 * Metodo per il setteggio dell'oggetto che viene visualizzata dentro la tabella
	 *
	 * @param col 	per il numero di colonne
	 * @param row 	per il numero di righe
	 */
	public void setValueAt(Object value, int row, int col) {	//inserisce dentro l'array i valori
        gestione.Esame e = data.get(row);
        switch (col) {
            case 0:
                e.setNome((String) value);
                break;
            case 1:
                e.setCognome((String) value);
                break;
            case 2:
                e.setMateria((String) value);
                break;
        }
        fireTableCellUpdated(row, col);
    }
	/**
	 * Metodo per il ritorno del nome della colonna
	 *
	 * @param col 	per il numero di colonne
	 */
	public String getColumnName(int col) {				//restituisce il nome della colonna
		return ColName[col];
	}
	/**
	 * Metodo per il ritorno che modifica se schiacciando la tabella è modificabile o meno
	 *
	 * @param col 	per il numero di colonne
	 * @param row 	per il numero di righe
	 */
	public boolean isCellEditable(int row, int col) {	//specifica se le celle sono editabili
		return false;
	}
	/**
	 * Metodo per l'inserimento di una riga dentro una tabella
	 *
	 * @param esame per l'esame da inserire nella lista
	 */
	public void addRow(gestione.Esame esame) {			//aggiunge una nuova riga alla tabella
        data.add(esame);
        tabella = data;
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
	/**
	 * Metodo per la rimozione di una riga dentro una tabella
	 *
	 * @param num per il numero dell'indice della lista
	 */
    public void removeRow(int num) {
    	data.remove(num);
    	tabella = data;
    	fireTableRowsDeleted(data.size() - 1, data.size() - 1);
    }
	/**
	 * Metodo per la modifica di una riga dentro una tabella
	 *
	 * @param num per il numero dell'indice della lista
	 * @param esame per l'esame modificato
	 */
    public void modificaRow(int num,gestione.Esame esame) {
    	data.set(num,esame);
    	tabella.set(num,esame);
     	fireTableRowsUpdated(num, data.size() - 1);
    }
	/**
	 * Metodo per il ritorno della lista degli esami
	 */
    public ArrayList<gestione.Esame> getEsami() { 
    	return data; 
    }
	/**
	 * Metodo per caricare gli esami da file
	 *
	 * @param esami per la lista di tutti gli esami
	 */
	public void caricaEsami(ArrayList<gestione.Esame> esami){
        data = esami;
        tabella = esami;
        fireTableDataChanged();
    }
	/**
	 * Metodo per il filtraggio della tabella
	 *
	 * @param scelta per quale filtro si vuole scegliere
	 * @param s per la riga da ricercare nella tabella
	 */
    public void filtro(int scelta, String s) {
		switch(scelta) {
			case 0 -> data = tabella;
			case 1 -> data = tabella.stream()
                    .filter(esame -> esame.getNome().equalsIgnoreCase(s))
                    .collect(Collectors.toCollection(ArrayList::new));
			case 2 -> data = tabella.stream()
                    .filter(esame -> esame.getCognome().equalsIgnoreCase(s))
                    .collect(Collectors.toCollection(ArrayList::new));
			case 3 -> data = tabella.stream()
                    .filter(esame -> esame.getMateria().equalsIgnoreCase(s))
                    .collect(Collectors.toCollection(ArrayList::new));
    	}
    	fireTableDataChanged();
    }
	/**
	 * Metodo per il calcolo della media pesata della tabella
	 */
    public void calcolaMediaPesata(){
        double mediaPesata = data.stream()
                .mapToDouble(esame -> esame.getVoto() * esame.getCfu())  // Moltiplica il voto per il credito
                .sum();
        double sommaCrediti = data.stream()
                .mapToDouble(gestione.Esame::getCfu)  // Estrai i crediti di ciascun esame
                .sum();
        f.setMediaVoti(sommaCrediti != 0.0 ? mediaPesata / sommaCrediti : 0.0);
    }
	/**
	 * Metodo per dire se la tabella è stata modificata o meno, viene usato per il controllo in chiusura
	 * se è stata salvata la tabella o meno
	 */
    public boolean getModificato() { 
    	return mod; 
    }
	/**
	 * Metodo per modificare se la tabella è stata modificata o meno, viene usato per il controllo in chiusura
	 * se è stata salvata la tabella o meno
	 *
	 * @param mod per modificare lo status del salvataggio della tabella
	 */
    public void setModificato(boolean mod) { 
    	this.mod = mod; 
    }
    
    // Metodo per ottenere il colore di sfondo per la selezione di una riga
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
}