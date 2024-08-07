/**
 *
 *
 */
package interfaccia;

import java.awt.BorderLayout;
import java.io.File;
import java.util.concurrent.*;
import java.lang.Exception;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * La classe Window è la classe di avvio dell'applicazione. Inizializza l'interfaccia utente e gestisce
 * l'autosalvataggio periodico dei dati degli esami in un file temporaneo.
 */

public class Window {
    /**
     * Punto di ingresso dell'applicazione.
     * @param args  gli argomenti della riga di comando (non utilizzati).
     */
	public static void main(String[] args) {
	    /*
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }*/

		MyFrame f = new MyFrame("Tabelle Esami");	//crea un nuovo JFrame invisibile
		f.setVisible(true);							//mostra visibile il JFrame
		
		// Thread per l'autosalvataggio
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try{
                // Esegue l'autosalvataggio
                f.salva(new File("temporaneo.txt"));
                f.setAutosave("Salvato");
            } catch (Exception e) {
            }
        };

        // Esegui il task ogni minuto con un ritardo iniziale di 1 secondo
        scheduler.scheduleAtFixedRate(task, 20, 20, TimeUnit.SECONDS);
	}
}