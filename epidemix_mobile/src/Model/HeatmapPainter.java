package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fatec-dsm2
 */
import Model.Localizacao;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.GeoPosition;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

public class HeatmapPainter implements Painter<JXMapViewer> {
    private final List<Localizacao> coordenadas;

    public HeatmapPainter(List<Localizacao> coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public void paint(Graphics2D g, JXMapViewer map, int width, int height) {
        for (Localizacao loc : coordenadas) {
            GeoPosition pos = new GeoPosition(loc.getLatitude(), loc.getLongitude());
            Point2D ponto = map.getTileFactory().geoToPixel(pos, map.getZoom());

            // Configurar a intensidade do ponto
            int intensidade = loc.getNivel(); // Exemplo: valor de 0.0 (baixo) a 1.0 (alto)

            // Escolher a cor com base na intensidade (de verde a vermelho)
            Color cor = getCorPorIntensidade(intensidade);
            g.setColor(cor);

            // Ajustar a transparência
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, intensidade * 0.6f));

            // Ajustar o tamanho do ponto conforme a intensidade
            int tamanho = (int) (20 * intensidade); // Tamanho básico de 20, ajustado pela intensidade
            g.fillOval((int) ponto.getX() - tamanho / 2, (int) ponto.getY() - tamanho / 2, tamanho, tamanho);
        }
    }

    private Color getCorPorIntensidade(float intensidade) {
        // Verde para baixa intensidade, vermelho para alta intensidade
        int r = (int) (intensidade * 255);
        int g = (int) ((1 - intensidade) * 255);
        return new Color(r, g, 0, 150); // 150 para transparência
    }
}

