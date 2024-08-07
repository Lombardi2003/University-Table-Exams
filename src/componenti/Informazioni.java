package componenti;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaccia.MyTable;
/**
 * La classe Informazione che contiene i metodi per visualizzare un esame semplice o composto,
 * estende la classe JButton in modo che quando si attiva il bottone viene preso il metodo per
 * cui si è schiacciato il bottone
 */
public class Informazioni extends JButton {
    /**
     * Costruttore della classe Informazioni
     *
     * @param s per il nome del bottone
     */
	public Informazioni(String s) {
		super(s);
	}
    /**
     * Metodo per la visualizzazione di un esame con voto semplice
     *
     * @param dati per visualizzare nei dati della tabella l'esame scelto
     * @param a per indicare quale esame della lista visualizzare
     */
	public void votoSemplice(MyTable dati,int a){
		//Nuova Finestra
      	JFrame f2 = new JFrame();
      	f2.setLocationRelativeTo(null);
      	f2.setTitle("Modifica Esame");
      	f2.setSize(500, 200);
        //Nuovo Panello
       	JPanel p2 = new JPanel();
    	p2.setLayout(new GridBagLayout ()); 
    	p2.setLayout(new GridBagLayout ()); 
		GridBagConstraints c2 = new GridBagConstraints();
		
        gestione.Esame es= dati.data.get(a);
    	String n = es.getNome();
        String c = es.getCognome();
        String m = es.getMateria();
        String cf = String.valueOf(es.getCfu());
        String v = String.valueOf(es.getVoto());
        boolean lod = es.getLode();
        String l;
        if(lod==true) {
        	l = "SI";
        }
        else {
        	l = "NO";
        }
        //Componenti
        // Nome
        JLabel nome_etichetta = new JLabel("Nome: ");
        JLabel nome = new JLabel(n);
        //Cognome
        JLabel cognome_etichetta = new JLabel("Cognome: ");
        JLabel cognome = new JLabel(c);
        //Materia
        JLabel materia_etichetta = new JLabel("Materia: ");
        JLabel materia = new JLabel(m);
        //CFU
        JLabel cfu_etichetta = new JLabel("CFU: ");
        JLabel cfu = new JLabel(cf);
        //Voto
        JLabel voto_etichetta = new JLabel("Voto: ");
        JLabel voto = new JLabel(v);
        //Lode
        JLabel lode_etichetta = new JLabel("Lode: ");
        JLabel lode = new JLabel(l);
        
        // Aggiunta dei componenti al pannello
        c2.gridx = 0; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome,c2);
        c2.gridx = 0; // Colonna 2
        c2.gridy = 1; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome_etichetta,c2);
        c2.gridx = 1; // Colonna 2
        c2.gridy = 1; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome,c2);
        c2.gridx = 0; // Colonna 4
        c2.gridy = 2; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia_etichetta,c2);
        c2.gridx = 1; // Colonna 4
        c2.gridy = 2; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia,c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 3; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 3; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu,c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 4; // Riga 1
        c2.gridwidth = 1;
        p2.add(voto_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 4; // Riga 1
        c2.gridwidth = 1;
        p2.add(voto,c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 5; // Riga 1
        c2.gridwidth = 1;
        p2.add(lode_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 5; // Riga 1
        c2.gridwidth = 1;
        p2.add(lode,c2);
        JButton a2 = new JButton("Chiudi finestra informazioni");
    	a2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f2.dispose(); // Chiudi la finestra
            }
    	});
    	c2.gridx = 0; // Colonna 0
        c2.gridy = 7; // Riga 1
        c2.gridwidth = 2;
        p2.add(a2, c2); // Aggiungi il pulsante alla finestra
        f2.add(p2);
        f2.setVisible(true); // Rendi visibile la finestra
	}
    /**
     * Metodo per la visualizzazione di un esame con voto composto
     *
     * @param dati per visualizzare nei dati della tabella l'esame scelto
     * @param a per indicare quale esame della lista visualizzare
     */
	public void votoComposto(MyTable dati, int a){
		//Nuova Finestra
      	JFrame f2 = new JFrame();
      	f2.setLocationRelativeTo(null);
      	f2.setTitle("Modifica Esame");
      	f2.setSize(500, 200);
        //Nuovo Panello
       	JPanel p2 = new JPanel();
    	p2.setLayout(new GridBagLayout ()); 
    	p2.setLayout(new GridBagLayout ()); 
		GridBagConstraints c2 = new GridBagConstraints();
		
        gestione.Esame es= dati.data.get(a);
    	String n = es.getNome();
        String c = es.getCognome();
        String m = es.getMateria();
        String cf = String.valueOf(es.getCfu());
        int dim = es.getDimensione();
        int[] voti =  es.getIntermedi();
        int[] pesi =  es.getPesi();
        boolean lod = es.getLode();
        String l;
        if(lod==true) {
        	l = "SI";
        }
        else {
        	l = "NO";
        }
        //Componenti
        // Nome
        JLabel nome_etichetta = new JLabel("Nome: ");
        JLabel nome = new JLabel(n);
        //Cognome
        JLabel cognome_etichetta = new JLabel("Cognome: ");
        JLabel cognome = new JLabel(c);
        //Materia
        JLabel materia_etichetta = new JLabel("Materia: ");
        JLabel materia = new JLabel(m);
        //CFU
        JLabel cfu_etichetta = new JLabel("CFU: ");
        JLabel cfu = new JLabel(cf);
        //Voto
        JLabel voto_etichetta = new JLabel("Voti intermedi: ");
        JLabel pesi_etichetta = new JLabel("Pesi intermedi: ");
        //Lode
        JLabel lode_etichetta = new JLabel("Lode: ");
        JLabel lode = new JLabel(l);
        
        // Aggiunta dei componenti al pannello
        c2.gridx = 0; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome,c2);
        c2.gridx = 0; // Colonna 2
        c2.gridy = 1; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome_etichetta,c2);
        c2.gridx = 1; // Colonna 2
        c2.gridy = 1; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome,c2);
        c2.gridx = 0; // Colonna 4
        c2.gridy = 2; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia_etichetta,c2);
        c2.gridx = 1; // Colonna 4
        c2.gridy = 2; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia,c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 3; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 3; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu,c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 4; // Riga 1
        c2.gridwidth = 1;
        p2.add(voto_etichetta,c2);		
        for(int i=0;i<dim;i++) {
        	c2.gridx ++;
        	p2.add(new JLabel(String.valueOf(voti[i])+" "),c2);
        }
        c2.gridx = 0; // Colonna 0
        c2.gridy = 5; // Riga 1
        c2.gridwidth = 1;
        p2.add(pesi_etichetta,c2);
        for(int i=0;i<dim;i++) {
        	c2.gridx ++;
        	p2.add(new JLabel(String.valueOf(pesi[i])+"% "),c2);
        }
        c2.gridx = 0; // Colonna 0
        c2.gridy = 6;// Riga 1
        c2.gridwidth = 1;
        p2.add(lode_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 6; // Riga 1
        c2.gridwidth = 1;
        p2.add(lode,c2);
        JButton a2 = new JButton("Chiudi finestra informazioni");
    	a2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	f2.dispose(); // Chiudi la finestra
            }
    	});
    	c2.gridx = 0; // Colonna 0
        c2.gridy = 7; // Riga 1
        c2.gridwidth = 2;
        p2.add(a2, c2); // Aggiungi il pulsante alla finestra
        f2.add(p2);
        f2.setVisible(true); // Rendi visibile la finestra
	}
}
