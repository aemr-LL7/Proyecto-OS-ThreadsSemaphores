/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkingClasses;

import GUI.Home;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author andre
 */
public class ChartManager {

    private final Home homeInstance = Home.getHomeInstance();
    private XYSeries SERIES_HP;
    private XYSeries SERIES_MSI;
    private XYSeriesCollection DATASET;
    private JFreeChart XY_LINES;
    private Timer updateTime;

    public ChartManager() {
        // Inicia tabla de valores
        this.initSeries();
        // Crear el gráfico
        this.createChart();
        // Temporizador que actualiza segun pase los dias
        this.startUpdateTimer();
    }

    private void initSeries() {
        SERIES_HP = new XYSeries("Hewlett-Packard");
        SERIES_MSI = new XYSeries("Micro-Star International");
        DATASET = new XYSeriesCollection();
        DATASET.addSeries(SERIES_HP);
        DATASET.addSeries(SERIES_MSI);
    }

    /**
     * Crea el gráfico XY Line usando JFreeChart y configura la apariencia.
     */
    private void createChart() {
        this.XY_LINES = ChartFactory.createXYLineChart(
                "Tiempo vs Utilidad", // Titulo del grafico
                "Tiempo", // Etiqueta eje X
                "Utilidad", // Etiqueta eje Y
                this.DATASET, // Dataset
                PlotOrientation.VERTICAL,
                true, // Mostrar leyenda
                true, // Generar tooltips
                false // URLs
        );

        this.customizeLookChart();
    }

    private void customizeLookChart() {
        XYPlot plot = this.XY_LINES.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
    }

    private void startUpdateTimer() {
        int delay = homeInstance.getDuration();
        this.updateTime = new Timer(delay, e -> this.updateChartData());
        this.updateTime.start();
    }

    public void updateChartData() {
        // Se obtienen las nuevas ganancias (más recientes de las factories)
        double hpProfit = Home.getFactory0();
        double msiProfit = Home.getFactory0();
        int newTimePoint = this.SERIES_HP.getItemCount() + 1;

        this.SERIES_HP.addOrUpdate(newTimePoint, hpProfit);
        this.SERIES_MSI.addOrUpdate(newTimePoint, msiProfit);
    }

    public ChartPanel getChartPanel() {
        return new ChartPanel(this.XY_LINES);
    }

    public void stopUpdateTimer() {
        if (this.updateTime != null) {
            this.updateTime.stop();
        }
    }
}
