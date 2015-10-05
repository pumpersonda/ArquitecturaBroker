package Broker;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Created by André on 24/09/2015.
 */
public class Pastel implements Grafica{
    JFrame ventana;
    private final DefaultCategoryDataset datosGraficables = new DefaultCategoryDataset();

    public Pastel() {
        ventana = new JFrame();
        ventana.setSize(new Dimension(300,300));
        ventana.pack();
        JFreeChart graficoBarras = ChartFactory.createBarChart(
                "Votaciones Actuales", //Título de la gráfica
                "Participantes", //leyenda Eje horizontal
                "Votos", //leyenda Eje vertical
                datosGraficables, //datos
                PlotOrientation.VERTICAL, //orientación
                true, //incluir leyendas
                true, //mostrar tooltips
                true);
        graficoBarras.setBackgroundPaint(Color.LIGHT_GRAY);
        CategoryPlot plot = (CategoryPlot) graficoBarras.getPlot();
        plot.setBackgroundPaint(Color.WHITE); //fondo del grafico
        plot.setDomainGridlinesVisible(true);//lineas de rangos, visibles
        plot.setRangeGridlinePaint(Color.BLACK);//color de las lineas de rangos
        ChartPanel panelGrafica = new ChartPanel(graficoBarras);
        ventana.setContentPane(panelGrafica);
        ventana.setVisible(true);

    }


    public void getGrafica(String datos){
        System.out.println(datos);
    }

    @Override
    public void agregarVotos() {

    }

    @Override
    public void eliminarVotos() {

    }

    @Override
    public void agregarParticipantes(String data) {


            datosGraficables.addValue(0,"Candidatos",data);

    }
}
