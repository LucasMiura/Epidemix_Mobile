/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.GeoPosition;

/**
 *
 * @author Ericp
 */
class RoutePainter implements Painter<JXMapViewer> {
    private final Set<GeoPosition> waypoints;

    public RoutePainter(Set<GeoPosition> waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public void paint(Graphics2D g, JXMapViewer map, int width, int height) {
        // Ajusta as coordenadas para o sistema de coordenadas do mapa
        g = (Graphics2D) g.create();
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(2));

        // Converte GeoPositions em pontos no mapa
        List<Point2D> points = new ArrayList<>();
        for (GeoPosition waypoint : waypoints) {
            Point2D point = map.getTileFactory().geoToPixel(waypoint, map.getZoom());
            points.add(point);
        }

        // Desenha as linhas conectando os pontos
        for (int i = 0; i < points.size() - 1; i++) {
            Point2D from = points.get(i);
            Point2D to = points.get(i + 1);
            g.drawLine((int) from.getX(), (int) from.getY(), (int) to.getX(), (int) to.getY());
        }

        g.dispose();
    }
}