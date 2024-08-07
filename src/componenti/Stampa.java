package componenti;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
/**
 * La classe Stampe per eseguire l'azione di stampa, implemanta l'interfaccia Printable che serve ad
 * aprire il menu di stampa
 */
public class Stampa implements Printable {
    /** L'attributo che contiene la tabella */
    private JTable table;
    /**
     * Costruttore della Stampa
     *
     * @param table per il passaggio della  tabella
     */
    public Stampa(JTable table) {
        this.table = table;
    }
    /**
     * Metodo per la stampa che ritorna se la pagina esiste o meno
     *
     * @param graphics per la grafica
     * @param pageIndex per l'index della stampa
     * @param pageFormat per il formato di stampa
     */
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
        	return NO_SUCH_PAGE; 		//non esiste la pagina
        }
        
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        
        // Calcola la dimensione utile per la tabella sulla pagina
        double tableWidth = pageFormat.getImageableWidth();
        double tableHeight = pageFormat.getImageableHeight();
        
        // Disegna l'intestazione della tabella
        JTableHeader tableHeader = table.getTableHeader();
        if (tableHeader != null) {
            tableHeader.setSize((int) tableWidth, tableHeader.getHeight());
            tableHeader.print(g2d);
            g2d.translate(0, tableHeader.getHeight()); // Sposta il disegno sotto l'intestazione
        }

        // Disegna la tabella
        table.setSize((int) tableWidth, (int) tableHeight);
        table.doLayout();
        table.print(g2d);

        return PAGE_EXISTS;
    }

}