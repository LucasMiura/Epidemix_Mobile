/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Localizacao;
import Model.Registros;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

/**
 *
 * @author Ericp
 */
public class frmVisitante extends javax.swing.JFrame {

    /**
     * Creates new form frmVisitante
     */
   
    Registros reg = new Registros();
    public frmVisitante() {
        initComponents();
        mapa1.init();
    }
    
    public void init(){
     /*   TileFactoryInfo info = new OSMTileFactoryInfo();
    DefaultTileFactory tileFactory = new DefaultTileFactory(info);
    jXMapViewer.setTileFactory(tileFactory);
    GeoPosition geo = new GeoPosition(24.4961672,47.8462427);
    jXMapViewer.setAddressLocation(geo);
    jXMapViewer.setZoom(12); */
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapa1 = new Model.Mapa();
        toggle = new javax.swing.JToggleButton();
        epidemix_menu = new javax.swing.JLabel();
        gps_center = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toggle.setText("Desligado");
        toggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        epidemix_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/icon_epidemix_red.png"))); // NOI18N
        epidemix_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                epidemix_menuMouseClicked(evt);
            }
        });

        gps_center.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/gps_first_point.png"))); // NOI18N
        gps_center.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gps_centerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mapa1Layout = new javax.swing.GroupLayout(mapa1);
        mapa1.setLayout(mapa1Layout);
        mapa1Layout.setHorizontalGroup(
            mapa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(epidemix_menu)
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapa1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toggle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(gps_center))
        );
        mapa1Layout.setVerticalGroup(
            mapa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(epidemix_menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 546, Short.MAX_VALUE)
                .addGroup(mapa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gps_center)
                    .addComponent(toggle))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleActionPerformed
        // TODO add your handling code here:
        if (toggle.isSelected()) {
            toggle.setText("Ligado");
               List<Localizacao> listaLocalizacoes = reg.carregarLocalizacoes();

         
        // Cria waypoints a partir das localizações
        Set<Waypoint> waypoints = new HashSet<>();
        for (Localizacao loc : listaLocalizacoes) {
            GeoPosition posicao = new GeoPosition(loc.getLatitude(), loc.getLongitude());
            waypoints.add(new DefaultWaypoint(posicao));
        }
           
           
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        mapa1.setOverlayPainter(waypointPainter);
            } else {
                toggle.setText("Desligado");
                Set<Waypoint> waypoints = new HashSet<>();
                WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        mapa1.setOverlayPainter(waypointPainter);
            }
    }//GEN-LAST:event_toggleActionPerformed

    private void epidemix_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_epidemix_menuMouseClicked
        frmPopup popup = new frmPopup();
        new frmPopup().setVisible(true);
        popup.setVerificar(1);
    }//GEN-LAST:event_epidemix_menuMouseClicked

    private void gps_centerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gps_centerMouseClicked
        GeoPosition centro = new GeoPosition(-24.49609687511922, -47.846299351792965);
        mapa1.setAddressLocation(centro);
        mapa1.setZoom(4);
    }//GEN-LAST:event_gps_centerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVisitante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel epidemix_menu;
    private javax.swing.JLabel gps_center;
    private Model.Mapa mapa1;
    private javax.swing.JToggleButton toggle;
    // End of variables declaration//GEN-END:variables
}
