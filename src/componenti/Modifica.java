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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaccia.MyTable;
/**
 * La classe Modifica che contiene i metodi per modificare un esame semplice o composto,
 * estende la classe JButton in modo che quando si attiva il bottone viene preso il metodo per
 * cui si è schiacciato il bottone
 */
public class Modifica extends JButton {
    /**
     * Costruttore della classe Modifica
     *
     * @param s per il nome del bottone
     */
	public Modifica(String s) {
		super(s);
	}
    /**
     * Metodo per la modifica di un esame con voto semplice
     *
     * @param dati per modificare nei dati della tabella l'esame selezionato
     * @param a per indicare quale esame della lista da modificare
     */
	public void votoSemplice(MyTable dati,int a){
		//Nuova Finestra
      	JFrame f2 = new JFrame();
      	f2.setTitle("Modifica Esame");
      	f2.setLocationRelativeTo(null);
      	f2.setSize(500, 200);
        //Nuovo Panello
       	JPanel p2 = new JPanel();
    	p2.setLayout(new GridBagLayout ()); 
    	GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1; // Occupa 2 colonne
        c2.fill = GridBagConstraints.HORIZONTAL; // Espansione orizzontale
            
        //Componenti
        // Nome
        JLabel nome_etichetta = new JLabel("Nome: ");
        JTextField nome_testo = new JTextField();
        nome_testo.setPreferredSize(new Dimension(100,20));
        //Cognome
        JLabel cognome_etichetta = new JLabel("Cognome: ");
        JTextField cognome_testo = new JTextField();
        cognome_testo.setPreferredSize(new Dimension(100,20));
        //Materia
        JLabel materia_etichetta = new JLabel("Materia: ");
        JTextField materia_testo = new JTextField();
        materia_testo.setPreferredSize(new Dimension(100,20));
        //CFU
        JLabel cfu_etichetta = new JLabel("CFU: ");
        JComboBox cfu_combo = new JComboBox();
        for(int i=0, j=1 ; i<12 ; i++,j++) {
        	cfu_combo.addItem(j);
        }
        //Voto
        JLabel voto_etichetta = new JLabel("Voto: ");
        JComboBox voto_combo = new JComboBox();
        for(int i=0, j=18 ; i<13 ; i++,j++) {
            voto_combo.addItem(j);
        }
        //Lode
        JLabel lode_etichetta = new JLabel("Lode: ");
        JComboBox lode_combo = new JComboBox();
        lode_combo.addItem("No");
        lode_combo.addItem("Si");

        // Aggiunta dei componenti al pannello
        c2.gridx = 0; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome_etichetta,c2);
        c2.gridx = 1; // Colonna 1
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome_testo,c2);
        c2.gridx = 2; // Colonna 2
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome_etichetta,c2);
        c2.gridx = 3; // Colonna 3
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome_testo,c2);
        c2.gridx = 4; // Colonna 4
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia_etichetta,c2);
        c2.gridx = 5; // Colonna 5
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia_testo,c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu_combo,c2);
        c2.gridx = 2; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(voto_etichetta,c2);
        c2.gridx = 3; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(voto_combo,c2);
        c2.gridx = 4; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(lode_etichetta,c2);
        c2.gridx = 5; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(lode_combo,c2);

        // Aggiungi un pulsante per chiudere la finestra
    	gestione.Esame es= dati.data.get(a);
    	String nome = es.getNome();
        String cognome = es.getCognome();
        String materia = es.getMateria();
        int cfu = es.getCfu();
        int voto = es.getVoto();
        boolean lode = es.getLode();
        int l;
        if(lode==true) {
        	l = 1;
        }
        else {
        	l = 0;
        }
        nome_testo.setText(nome);
        cognome_testo.setText(cognome);
        materia_testo.setText(materia);
        cfu_combo.setSelectedIndex(cfu-1);
        voto_combo.setSelectedIndex(voto-18);
        lode_combo.setSelectedIndex(l);
    	JButton a3 = new JButton("Modifica");
    	a3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {           	
            	String nome = nome_testo.getText();
                String cognome = cognome_testo.getText();
                String materia = materia_testo.getText();
                int cfu = cfu_combo.getSelectedIndex()+1;
                int voto = voto_combo.getSelectedIndex()+18;
                int l = lode_combo.getSelectedIndex();
                boolean lode;
                if(l==1) {
                	lode = true;
                }
                else {
                	lode = false;
                }
                if(nome.equals("")){
	            	JOptionPane.showMessageDialog(null, "Errore: Il nome non è corretto");
	            }
	            else {
	            	if(cognome.equals("")) {
	            		JOptionPane.showMessageDialog(null, "Errore: Il cognome non è corretto");
	            	}
	            	else{
	            		if(materia.equals("")) {
	            			JOptionPane.showMessageDialog(null, "Errore: La materia non è corretta");
	            		}
	            		else {
	            			if(lode==true&&voto!=30) {
	            				JOptionPane.showMessageDialog(null, "Errore: La lode non è corretta");
	            			}
	            			else {
	            				dati.modificaRow(a,new gestione.Esame(nome.toUpperCase(), cognome.toUpperCase(), materia.toUpperCase(),cfu, voto, lode));
	            				f2.dispose(); // Chiudi la finestra
	            			}

	            		}
	            	}	
	            }
                
            }
    	});
    	c2.gridx = 0; // Colonna 0
        c2.gridy = 2; // Riga 1
        c2.gridwidth = 6;
        p2.add(a3, c2); // Aggiungi il pulsante alla finestra
        f2.add(p2);
        f2.setVisible(true); // Rendi visibile la finestra
	}
    /**
     * Metodo per la modifica di un esame con voto composto
     *
     * @param dati per modificare nei dati della tabella l'esame modificare
     * @param a per indicare quale esame della lista da modificare
     */
	public void votoComposto(MyTable dati, int a){
		//Nuova Finestra
      	JFrame f2 = new JFrame();
      	f2.setTitle("Aggiungi Esame");
      	f2.setLocationRelativeTo(null);
      	f2.setSize(500, 300);
        //Nuovo Panello
       	JPanel p2 = new JPanel();
    	p2.setLayout(new GridBagLayout ()); 
    	GridBagConstraints c2 = new GridBagConstraints();
    	c2.weightx = 40;
        c2.gridx = 0; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1; // Occupa 2 colonne
        c2.fill = GridBagConstraints.HORIZONTAL; // Espansione orizzontale
        //Componenti
        // Nome
        JLabel nome_etichetta = new JLabel("Nome: ");
        JTextField nome_testo = new JTextField();
        nome_testo.setPreferredSize(new Dimension(100,20));
        //Cognome
        JLabel cognome_etichetta = new JLabel("Cognome: ");
        JTextField cognome_testo = new JTextField();
        cognome_testo.setPreferredSize(new Dimension(100,20));
        //Materia
        JLabel materia_etichetta = new JLabel("Materia: ");
        JTextField materia_testo = new JTextField();
        materia_testo.setPreferredSize(new Dimension(100,20));
        //CFU
        JLabel cfu_etichetta = new JLabel("CFU: ");
        JComboBox cfu_combo = new JComboBox();
        for(int i=0, j=1 ; i<12 ; i++,j++) {
        	cfu_combo.addItem(j);
        }
        //Lode
        JLabel lode_etichetta = new JLabel("Lode per il voto finale: ");
        JComboBox lode_combo = new JComboBox();
        lode_combo.addItem("No");
        lode_combo.addItem("Si");
        
        // Aggiunta dei componenti al pannello
        c2.gridx = 0; // Colonna 0
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome_etichetta,c2);
        c2.gridx = 1; // Colonna 1
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(nome_testo,c2);
        c2.gridx = 2; // Colonna 2
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome_etichetta,c2);
        c2.gridx = 3; // Colonna 3
        c2.gridy = 0; // Riga 0
        c2.gridwidth = 1;
        p2.add(cognome_testo,c2);
        c2.gridx = 0; // Colonna 4
        c2.gridy = 1; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia_etichetta,c2);
        c2.gridx = 1; // Colonna 5
        c2.gridy = 1; // Riga 0
        c2.gridwidth = 1;
        p2.add(materia_testo,c2);
        c2.gridx = 2; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu_etichetta,c2);
        c2.gridx = 3; // Colonna 0
        c2.gridy = 1; // Riga 1
        c2.gridwidth = 1;
        p2.add(cfu_combo,c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 2; // Riga 1
        c2.gridwidth = 5;
        p2.add(new JLabel("Inserire i voti e i pesi"),c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 3; // Riga 1
        c2.gridwidth = 1;
        p2.add(new JLabel("Voti: "),c2);
        c2.gridx = 0; // Colonna 0
        c2.gridy = 4; // Riga 1
        c2.gridwidth = 1;
        p2.add(new JLabel("Pesi(%): "),c2);
        
     // Aggiungi un pulsante per chiudere la finestra
    	gestione.Esame es= dati.data.get(a);
    	String nome = es.getNome();
        String cognome = es.getCognome();
        String materia = es.getMateria();
        int cfu = es.getCfu();
        int num = es.getDimensione();
        int[] voti = es.getIntermedi();
        int[] pesi = es.getPesi();
        boolean lode = es.getLode();
        int l;
        if(lode==true) {
        	l = 1;
        }
        else {
        	l = 0;
        }
        nome_testo.setText(nome);
        cognome_testo.setText(cognome);
        materia_testo.setText(materia);
        cfu_combo.setSelectedIndex(cfu-1);
        c2.gridx = 1;
        JComboBox[] combo_voto = new JComboBox[num];
        JComboBox[] combo_pesi = new JComboBox[num];
        for (int k = 0; k < combo_voto.length; k++) {
        	combo_voto[k] = new JComboBox();
            for(int i=0, j=18 ; i<13 ; i++,j++) {
            	combo_voto[k].addItem(j);
            }
            combo_pesi[k] = new JComboBox();
            for(int i=0 ; i<101 ; i+=5) {				//Modifica percentuale inserimento
            	combo_pesi[k].addItem(i);
            }
            c2.gridy = 2; // Colonna 0
            p2.add(combo_voto[k],c2);
            c2.gridy = 3; // Colonna 0
            p2.add(combo_pesi[k],c2);
            c2.gridx++;
        }
        for(int i=0;i<num;i++) {
        	combo_voto[i].setSelectedIndex(voti[i]-18);
        	combo_pesi[i].setSelectedIndex(pesi[i]/5);
        }
        c2.gridx = 0; // Colonna 0
        c2.gridy = 5; // Riga 1
        c2.gridwidth = 1;
        p2.add(lode_etichetta,c2);
        c2.gridx = 1; // Colonna 0
        c2.gridy = 5; // Riga 1
        c2.gridwidth = 1;
        p2.add(lode_combo,c2);
        lode_combo.setSelectedIndex(l);
        for(int i=0;i<num;i++) {
        	voti[i]=combo_voto[i].getSelectedIndex()+18;
        	pesi[i]=combo_pesi[i].getSelectedIndex()*5;
        }
        // Aggiungi un pulsante per chiudere la finestra
        // Aggiungi un pulsante per chiudere la finestra
        JButton a2 = new JButton("Modifica");
        a2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
	            	String nome = nome_testo.getText();
	            	String cognome = cognome_testo.getText();
	                String materia = materia_testo.getText();
	                int cfu = cfu_combo.getSelectedIndex()+1;
	                int voti[]=new int[num];
	                int pesi[]=new int[num];
	                int l = lode_combo.getSelectedIndex();
		            boolean lode;
		            if(l==1) {
		            	lode = true;
		            }
		            else {
		                lode = false;
		            }
	                for(int i=0;i<num;i++) {
	                	voti[i]=combo_voto[i].getSelectedIndex()+18;
	                	pesi[i]=combo_pesi[i].getSelectedIndex()*5;
	                }
	                int sp=0;
	                int somma=0;
	                for(int i=0;i<num;i++) {
	                	sp+=((combo_voto[i].getSelectedIndex()+18)*((combo_pesi[i].getSelectedIndex())*5));
	                }
	                for(int i=0;i<num;i++) {
	                    somma+=combo_pesi[i].getSelectedIndex()*5;			//Modifica percentuale inserimento
	                }
	                if(somma==100) {
	                	double v = sp/somma;
	                	int voto = (int) v;
	                	if(sp/somma>=v+0.5) {
	                		voto++;
	                	}
	                	if(nome.equals("")){
	    	            	JOptionPane.showMessageDialog(null, "Errore: Il nome non è corretto");
	    	            }
	    	            else {
	    	            	if(cognome.equals("")) {
	    	            		JOptionPane.showMessageDialog(null, "Errore: Il cognome non è corretto");
	    	            	}
	    	            	else{
	    	            		if(materia.equals("")) {
	    	            			JOptionPane.showMessageDialog(null, "Errore: La materia non è corretta");
	    	            		}
	    	            		else {
	    	            			if(lode==true&&voto!=30) {
	    	            				JOptionPane.showMessageDialog(null, "Errore: La lode non è corretta");
	    	            			}
	    	            			else {
	    	            				dati.modificaRow(a,new gestione.Esame(nome.toUpperCase(), cognome.toUpperCase(), materia.toUpperCase(),cfu, voto, lode, num, voti, pesi));
	    	            				f2.dispose(); // Chiudi la finestra
	    	            			}

	    	            		}
	    	            	}	
	    	            }
	                }
	                else {
	                	JOptionPane.showMessageDialog(null, "Errore: I pesi non fanno 100%");
	                }
        	}
        });
        c2.gridx = 0; // Colonna 0
	    c2.gridy = 6; // Riga 1
	    c2.gridwidth = 6;
	    p2.add(a2, c2); // Aggiungi il pulsante alla finestra
	    f2.add(p2);
        f2.setVisible(true); // Rendi visibile la finestra
	}
}
