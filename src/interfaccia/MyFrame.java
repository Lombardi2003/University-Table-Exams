package interfaccia;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 * La classe MyFrame è la classe per la visione di tutto, è la finestra dove vediamo tutto,
 * l'interfaccia grafica che ci gestisce tutto
 */
public class MyFrame extends JFrame{

	
	
	
	/** La scritta per vedere sull'interfaccia se è stata salvata oppure no */
	public JLabel autosaveLabel;
	/** I dati della tabella che si vede sull'interfaccia */
	private MyTable dati = new MyTable(new ArrayList<>(),this);
	/** La scritta per vedere sull'interfaccia la media pesata dei voti visualizzati nella tabella */
	public JLabel MediaVoti;
	/** Il pulsante della salva */
	public JButton pulsantesalva;
	/**
	 * Costruttore della classe MyFrame.
	 *
	 * @param titolo per il nome della finestra
	 */
	public MyFrame(String titolo){
		super(titolo);					//impostare il nome dell'applicazione
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //setBackground(new Color(45, 45, 45));
		setLocation(300,200);			//impostare dove appare la finestra, le coordinate
		setSize(1000,400);				//impostare le dimensioni di questa finestra
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//impostare che l'app si chiude quando si preme il pulsante di chiusura della finestra
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if(dati.getModificato()){
                	int result = JOptionPane.showConfirmDialog(null,
                            "Le ultime modifiche effettuate non sono state salvate. \n Salvare prima di uscire?",
                            "Conferma", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION) {
                    	pulsantesalva.doClick();
                    }
                }
            }
        });
		setIconImage(new ImageIcon("C:/Users/lomba/Desktop/Università/Anno 2/Programmazione ad oggetti/Programmi/Esame/src/immagini/icona_finestra.jpg").getImage());	
		SwingUtilities.updateComponentTreeUI(this);
		JPanel main_panel = new JPanel(new BorderLayout());

		
		JPanel panel_principale = new JPanel(new BorderLayout());
		JPanel panel_sopra = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		JPanel panel_centrale = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		JPanel panel_sotto = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 10));
		
			
		JPanel panel_centro = new JPanel();
		JPanel panel_sinistra = new JPanel();
		JPanel panel_destra = new JPanel();
		panel_sinistra.setLayout(new BoxLayout(panel_sinistra, BoxLayout.Y_AXIS));
		panel_destra.setLayout(new BoxLayout(panel_destra, BoxLayout.Y_AXIS));
		panel_centro.setLayout(new BoxLayout(panel_centro, BoxLayout.Y_AXIS));
		
		//Tabella
		dati = new MyTable(new ArrayList<>(),this);					//I dati della mia tabella
		JTable tabella = new JTable(dati);  				//Creazione della mia tabella
		JScrollPane pane = new JScrollPane(tabella);		//Inserisco la barra scorrimento
		pane.setPreferredSize(new Dimension(700,200));		//Per modificare le dimensioni della tabella
		panel_centro.add(pane);											//Inserisco la mia tabella	
				
		//Componenti Sinistra
		//Pulsante Aggiungi
		componenti.Aggiunta pulsanteaggiungi = new componenti.Aggiunta("Aggiungi");	
		pulsanteaggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f3 = new JFrame();
			  	JPanel panello = new JPanel();
			  	f3.setLocationRelativeTo(null);
			  	panello.setLayout(new GridBagLayout ());
			  	GridBagConstraints cx = new GridBagConstraints();
			  	cx.gridx = 0; // Colonna 0
			  	cx.gridy = 0; // Riga 0
			  	cx.gridwidth = 2; // Occupa 3 colonne
			  	panello.add(new JLabel("Inserire numero di prove dell'esame: "),cx);
			  	JComboBox numero = new JComboBox();
			  	for(int i=0, j=1 ; i<4 ; i++,j++) {
			  	       numero.addItem(j);
			  	}
			  	cx.gridx = 0; // Colonna 0
			  	cx.gridy = 1; // Riga 0
			  	cx.gridwidth = 2; // Occupa 3 colonne
			  	panello.add(numero,cx);
			  	JButton p1 = new JButton("invia");
			    p1.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {  
			  	        f3.dispose(); // Chiudi la finestra
			  	        int num = numero.getSelectedIndex()+1;
			  	        if(num==1) {
			  	        	pulsanteaggiungi.votoSemplice(dati);
			  	        }
			  	        else {
			  	        	pulsanteaggiungi.votoComposto(dati,num);
			  	        }	  
			  	  	}
			    });
			    cx.gridx = 0; // Colonna 0
			  	cx.gridy = 2; // Riga 0
			  	cx.gridwidth = 2; // Occupa 3 colonne
			  	panello.add(p1,cx);
			  	f3.add(panello);
			    f3.setSize(300, 200);
			  	f3.setVisible(true);
			}
		});
		panel_sinistra.add(pulsanteaggiungi);
				
		//Pulsante Elimina
		JButton pulsanteelimina = new JButton("Elimina");	
		pulsanteelimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = tabella.getSelectedRow();
				if(a!=-1) {
					dati.removeRow(a);
				}
			}            
		});	
		panel_sinistra.add(Box.createVerticalStrut(10));
		panel_sinistra.add(pulsanteelimina);		
				
		//Pulsante info
		componenti.Informazioni a4 = new componenti.Informazioni("Info");	
		a4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = tabella.getSelectedRow();
				if(a!=-1) {
					gestione.Esame es= dati.data.get(a);
					if(es.getDimensione()==0) {
						a4.votoSemplice(dati,a);
					}
					else {
						a4.votoComposto(dati, a);
					}
				}
			}            
		});
		panel_sinistra.add(Box.createVerticalStrut(10));
		panel_sinistra.add(a4);	
		
		//Pulsante modifica
		componenti.Modifica a5 = new componenti.Modifica("Modifica");	
		a5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = tabella.getSelectedRow();
				if(a!=-1) {
					gestione.Esame es= dati.data.get(a);
					if(es.getDimensione()==0) {
						a5.votoSemplice(dati,a);
					}
					else {
						a5.votoComposto(dati, a);
					}
				}
			}            
		});	
		panel_sinistra.add(Box.createVerticalStrut(10));
		panel_sinistra.add(a5);

		//Filtro
		panel_sopra.add(new JLabel("Filtra per"));
		JComboBox filtro = new JComboBox();
		filtro.addItem("Nessun Filtro");
		filtro.addItem("Nome");
		filtro.addItem("Cognome");
		filtro.addItem("Materia");
		panel_sopra.add(filtro);
		JTextField filtro_testo = new JTextField();
		filtro_testo.setPreferredSize(new Dimension(100,20));
		panel_sopra.add(filtro_testo);
		JButton filtro_button = new JButton("Invia");	
		filtro_button.setPreferredSize(new Dimension(100, 30));
		filtro_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = filtro_testo.getText();
				filtro_testo.setText("");
				int scelta = filtro.getSelectedIndex();
				dati.filtro(scelta,x);
			}            
		});	
		panel_sopra.add(filtro_button);		
		
		//Secondi componenti
		//Pulsante istogramma
		JButton pulsanteistogramma = new JButton("Istogramma");	

		pulsanteistogramma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componenti.Istogramma i = new componenti.Istogramma(dati);
				i.mostra();
			}            
		});	
		panel_destra.add(pulsanteistogramma);
				
		//Pulsante stampa
		JButton pulsantestampa = new JButton("Stampa");	

		pulsantestampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Printable stampa_tabella = new componenti.Stampa(tabella);
				PrinterJob p = PrinterJob.getPrinterJob();
				p.setPrintable(stampa_tabella);
				if (p.printDialog()) {
					try {
						p.print();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				}
			}            
		});	
		panel_destra.add(Box.createVerticalStrut(10));
		panel_destra.add(pulsantestampa);
				
		//Pulsante salva
		pulsantesalva = new JButton("Salva");	
		pulsantesalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileFilter(new FileNameExtensionFilter("File di testo (*.txt)", "txt"));
					int result = fileChooser.showSaveDialog(null);
				    if (result == JFileChooser.APPROVE_OPTION) {
				    	String pathFile = fileChooser.getSelectedFile().toString();
				        if (!pathFile.matches(".*\\..+")) {
				        	pathFile += ".txt";
				        }
					    File file = new File(pathFile);
					    if (file.exists()) {
					    	int confirmResult = JOptionPane.showConfirmDialog(
					    			null,
					                "Il file " + file.getName() + " già. Vuoi sovrascriverlo?",
					                "Conferma sovrascrittura",
					                JOptionPane.YES_NO_OPTION);
					        if (confirmResult != JOptionPane.YES_OPTION) {
					            	JOptionPane.showMessageDialog(null, "Salvataggio non effettuato");
					        }	
					    }
					    try(PrintWriter writer = new PrintWriter(new FileWriter(file))) {
					    	ArrayList<gestione.Esame> esami = dati.getEsami();
					        gestione.Esame es;
					        for (int i=0 ; i<esami.size(); i++) {
					        	es = esami.get(i);
					            writer.println(es.getNome()+","+es.getCognome()+","+es.getMateria()+","+es.getCfu()+","+
					                   es.getVoto()+","+es.getLode()+","+es.getDimensione()+",");
					            if(es.getDimensione()!=0) {
					            	int[] intermedi;
					                intermedi = es.getIntermedi().clone();
					                for(int j=0;j<es.getDimensione();j++) {
					                	writer.printf(intermedi[j]+",");
					                }
					                writer.println();
					                int[] pesi = es.getPesi().clone();
					                for(int j=0;j<es.getDimensione();j++) {
					                	writer.printf(pesi[j]+",");
					                }
					                writer.println();
					            } 
					        }
					        dati.setModificato(false);
					    } catch (Exception ex) {
					    	JOptionPane.showMessageDialog(null, "Errore");
					    }
				    }
				}       
			});	
		panel_destra.add(Box.createVerticalStrut(10));
		panel_destra.add(pulsantesalva);	
		
		//Pulsante carica
		JButton pulsantecarica = new JButton("Carica");	
		pulsantecarica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser fileChooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("File di testo (*.txt)", "txt");
					fileChooser.setFileFilter(filter);
					int result = fileChooser.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						BufferedReader reader = new BufferedReader(new FileReader(file));
						ArrayList<gestione.Esame> lista = new ArrayList<>();
						String appoggio;
						while ((appoggio = reader.readLine()) != null) {
							gestione.Esame es;
						    String[] c = appoggio.split(",");
						    String nome = c[0];
						    String cognome = c[1];
						    String materia = c[2];
						    int cfu = Integer.parseInt(c[3]);
						    int voto = Integer.parseInt(c[4]);
						    boolean lode = Boolean.parseBoolean(c[5]);
						    int dim = Integer.parseInt(c[6]);
						    if(dim == 0) {
						    	es = new gestione.Esame(nome, cognome, materia, cfu, voto, lode);
						    }
						    else{
						    	appoggio = reader.readLine();
						        String[] c2 = appoggio.split(",");
						        int[] intermedi = new int[dim];
						        for(int i=0;i<dim;i++) {
						        	intermedi[i] = Integer.parseInt(c2[i]);
						        }
						        appoggio = reader.readLine();
						        String[] c3 = appoggio.split(",");
						        int[] pesi = new int[dim];
						        for(int i=0;i<dim;i++) {
						        	pesi[i] = Integer.parseInt(c3[i]);
						        }
						        es = new gestione.Esame(nome, cognome, materia, cfu, voto, lode, dim, intermedi, pesi);
						    }
						    lista.add(es);
						}
						reader.close();
						dati.caricaEsami(lista);
						dati.setModificato(false);
				}
				}catch(Exception x) {
					JOptionPane.showMessageDialog(null, x);
				}
			}
		});	
		panel_destra.add(Box.createVerticalStrut(10));
		panel_destra.add(pulsantecarica);
		
		//Media
		MediaVoti = new JLabel("Media pesata dei voti: 0");
		panel_destra.add(Box.createVerticalStrut(10));
		panel_centro.add(MediaVoti);	
		pane.setAlignmentX(Component.CENTER_ALIGNMENT);
		MediaVoti.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				
		//Agiunta dei panel al frame
		panel_centrale.add(panel_sinistra);
		panel_centrale.add(panel_centro);
		panel_centrale.add(panel_destra);
		panel_principale.add(panel_sopra,BorderLayout.NORTH);
		panel_principale.add(panel_centrale,BorderLayout.CENTER);
		
		JLabel scritta = new JLabel("Autosalvataggio: ");
		autosaveLabel = new JLabel("Non salvato");
		panel_sotto.add(scritta);
		panel_sotto.add(autosaveLabel);
		
		main_panel.add(panel_principale, BorderLayout.CENTER);
		main_panel.add(panel_sotto, BorderLayout.SOUTH);
		add(main_panel);
	}
	/**
	 * Il metodo che aggiorna la media dei voti sull'interfaccia
	 *
	 * @param mediaVoti
	 */
	public void setMediaVoti(double mediaVoti){
        MediaVoti.setText("Media pesata dei voti: " + String.format("%.2f", mediaVoti));
    }
	/**
	 * Metodo per il salvataggio della tabella utilizzato dall'autosalvataggio
	 *
	 * @param file che contriene il percorso di dove deve essere salvato il file temporaneo
	 */
    public void salva(File file) throws IOException {
    	try(PrintWriter writer = new PrintWriter(new FileWriter(file))) {
	    	ArrayList<gestione.Esame> esami = dati.getEsami();
	    	synchronized (esami) {
		        gestione.Esame es;
		        for (int i=0 ; i<esami.size(); i++) {
		        	es = esami.get(i);
		            writer.println(es.getNome()+","+es.getCognome()+","+es.getMateria()+","+es.getCfu()+","+
		                   es.getVoto()+","+es.getLode()+","+es.getDimensione()+",");
		            if(es.getDimensione()!=0) {
		            	int[] intermedi;
		                intermedi = es.getIntermedi().clone();
		                for(int j=0;j<es.getDimensione();j++) {
		                	writer.printf(intermedi[j]+",");
		                }
		                writer.println();
		                int[] pesi = es.getPesi().clone();
		                for(int j=0;j<es.getDimensione();j++) {
		                	writer.printf(pesi[j]+",");
		                }
		                writer.println();
		            } 
		        }
	    	}
        }catch (Exception ex) {
	    	JOptionPane.showMessageDialog(null, ex);
	    }
    }
	/**
	 * Metodo per modificare lo status dell'autosalvataggio, eseguito o meno
	 *
	 * @param text per il nome che si deve visualizzare nell'autosalvataggio, se eseguito oppure no
	 */
    public void setAutosave(String text){ 
    	autosaveLabel.setText(text); 
    }
}
