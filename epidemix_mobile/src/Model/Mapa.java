/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;

/**
 *
 * @author fatec-dsm2
 */
public class Mapa extends JXMapViewer {
    //private final Image image;

    
    public void init(){
    setTileFactory(new DefaultTileFactory(new OSMTileFactoryInfo("","https://b.tile.openstreetmap.fr/hot/")));
    setAddressLocation(new GeoPosition(-24.49609687511922, -47.846299351792965));
    setZoom(20);
    
    
      
     MouseInputListener mn = new PanMouseInputListener(this);
        addMouseListener(mn);
        addMouseMotionListener(mn);
        addMouseWheelListener(new ZoomMouseWheelListenerCenter(this));
    
 


    }

   /*
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       int x = getWidth()/2 -12;
       int y = getHeight()/2 -24;
       g2.drawImage(image,x, y, null);
    }
    */
    
        
    }

