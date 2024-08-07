package componenti;

import gestione.Esame;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * La classe Istogramma per la visione dell'istogramma di frequenze, estende la classe JFrame per la visione
 * dell'istogramma in una nuova finestra
 */
public class Istogramma extends JFrame {
    /** L'attributo che contiene i dati della tabella */
    private interfaccia.MyTable dati;
    /**
     * Costruttore della Istogramma
     *
     * @param d per il passaggio dei dati dellatabella
     */
    public Istogramma(interfaccia.MyTable d) {
        super();
        this.dati = d;
    }
    /**
     * Metodo mostra per rendere visibile la finestra con dentro tutto l'istogramma
     */
    public void mostra(){
        ArrayList<Esame> listaEsami = dati.data;
        CategoryDataset dataset = createDataset(listaEsami);
        String titolo = "Instogramma dei voti";
        JFreeChart barChart = ChartFactory.createBarChart(
        		titolo,
                "Voti",
                "Frequenza",
                dataset
        );
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setLowerBound(0);                                             //Imposta il valore minimo dell'asse y a 0
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());    //Imposta l'asse y per mostrare solo valori interi
        ChartPanel chartPanel = new ChartPanel(barChart);
        add(chartPanel);
        pack();
        setVisible(true);
    }
    /**
     * Metodo che restituisce i dati per la creazione dell'istogramma
     *
     * @param listaEsami per la lista degli esami
     */
    private CategoryDataset createDataset(ArrayList<Esame> listaEsami) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int voto = 18; voto <= 30; voto++) {
            dataset.addValue(0, "Frequenza", String.valueOf(voto));
        }
        for (Esame esame : listaEsami) {
            int voto = esame.getVoto();
            int frequenzaAttuale = dataset.getValue("Frequenza", String.valueOf(voto)).intValue();
            dataset.addValue(frequenzaAttuale + 1, "Frequenza", String.valueOf(voto));
        }
        return dataset;
    }
}
