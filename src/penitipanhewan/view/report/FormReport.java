package penitipanhewan.view.report;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import koneksi.Conn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import penitipanhewan.model.admin.Admin;

public class FormReport extends javax.swing.JFrame {
    
    private static Connection connection;
    private static final String logo = "src\\penitipanhewan\\view\\report\\logo.jpeg";
    private static final String judul = "Penitipan Hewan";
    private static final String alamat = "Jl. Harsono RM No.1, Ragunan, Kec. Ps. Minggu, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta";
    private static final String jabatan = "Admin";
    private static final String nama = "Andre Ricky";
    private static final String path = "/penitipanhewan/view/report/";

    public FormReport() {
        initComponents();
        connection = Conn.getConnection();
        if (Admin.userLogin.equals("Pemilik")) {
            btnReportHewan.setEnabled(false);
            btnReportPaket.setEnabled(false);
            btnReportPelanggan.setEnabled(false);
            btnReportMakanan.setEnabled(false);
        }
    }
    
    private void printHewan() {
        try {
            HashMap parameter = new HashMap();
            parameter.put("logo", logo);
            parameter.put("judul", judul);
            parameter.put("alamat", alamat);
            parameter.put("jabatan", jabatan);
            parameter.put("nama", nama);
            InputStream file = getClass().getResourceAsStream(path + "Hewan.jrxml");
            JasperDesign JasperDesign = JRXmlLoader.load(file);
            JasperReport JasperReport = JasperCompileManager.compileReport(JasperDesign);
            JasperPrint JasperPrint = JasperFillManager.fillReport(JasperReport, parameter, connection);
            JasperViewer.viewReport(JasperPrint, false);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void printMakanan() {
        try {
            HashMap parameter = new HashMap();
            parameter.put("logo", logo);
            parameter.put("judul", judul);
            parameter.put("alamat", alamat);
            parameter.put("jabatan", jabatan);
            parameter.put("nama", nama);
            InputStream file = getClass().getResourceAsStream(path + "Makanan.jrxml");
            JasperDesign JasperDesign = JRXmlLoader.load(file);
            JasperReport JasperReport = JasperCompileManager.compileReport(JasperDesign);
            JasperPrint JasperPrint = JasperFillManager.fillReport(JasperReport, parameter, connection);
            JasperViewer.viewReport(JasperPrint, false);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void printPaket() {
        try {
            HashMap parameter = new HashMap();
            parameter.put("logo", logo);
            parameter.put("judul", judul);
            parameter.put("alamat", alamat);
            parameter.put("jabatan", jabatan);
            parameter.put("nama", nama);
            InputStream file = getClass().getResourceAsStream(path + "Paket.jrxml");
            JasperDesign JasperDesign = JRXmlLoader.load(file);
            JasperReport JasperReport = JasperCompileManager.compileReport(JasperDesign);
            JasperPrint JasperPrint = JasperFillManager.fillReport(JasperReport, parameter, connection);
            JasperViewer.viewReport(JasperPrint, false);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void printPelanggan() {
        try {
            HashMap parameter = new HashMap();
            parameter.put("logo", logo);
            parameter.put("judul", judul);
            parameter.put("alamat", alamat);
            parameter.put("jabatan", jabatan);
            parameter.put("nama", nama);
            InputStream file = getClass().getResourceAsStream(path + "Pelanggan.jrxml");
            JasperDesign JasperDesign = JRXmlLoader.load(file);
            JasperReport JasperReport = JasperCompileManager.compileReport(JasperDesign);
            JasperPrint JasperPrint = JasperFillManager.fillReport(JasperReport, parameter, connection);
            JasperViewer.viewReport(JasperPrint, false);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void printPenitipan() {
        try {
            HashMap parameter = new HashMap();
            parameter.put("dari", dateDari.getDate());
            parameter.put("sampai", dateSampai.getDate());
            parameter.put("logo", logo);
            parameter.put("judul", judul);
            parameter.put("alamat", alamat);
            parameter.put("jabatan", jabatan);
            parameter.put("nama", nama);
            InputStream file = getClass().getResourceAsStream(path + "Penitipan.jrxml");
            JasperDesign JasperDesign = JRXmlLoader.load(file);
            JasperReport JasperReport = JasperCompileManager.compileReport(JasperDesign);
            JasperPrint JasperPrint = JasperFillManager.fillReport(JasperReport, parameter, connection);
            JasperViewer.viewReport(JasperPrint, false);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnReportHewan = new javax.swing.JButton();
        btnReportMakanan = new javax.swing.JButton();
        btnReportPenitipan = new javax.swing.JButton();
        btnReportPaket = new javax.swing.JButton();
        btnReportPelanggan = new javax.swing.JButton();
        dateDari = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateSampai = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU REPORT");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Menu Report");

        btnLogout.setBackground(new java.awt.Color(255, 0, 51));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139)
                .addComponent(btnLogout)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penitipanhewan/image/report (2).png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnReportHewan.setBackground(new java.awt.Color(51, 51, 255));
        btnReportHewan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnReportHewan.setForeground(new java.awt.Color(255, 255, 255));
        btnReportHewan.setText("Report Hewan");
        btnReportHewan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportHewanActionPerformed(evt);
            }
        });

        btnReportMakanan.setBackground(new java.awt.Color(51, 51, 255));
        btnReportMakanan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnReportMakanan.setForeground(new java.awt.Color(255, 255, 255));
        btnReportMakanan.setText("Report Makanan");
        btnReportMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportMakananActionPerformed(evt);
            }
        });

        btnReportPenitipan.setBackground(new java.awt.Color(51, 51, 255));
        btnReportPenitipan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnReportPenitipan.setForeground(new java.awt.Color(255, 255, 255));
        btnReportPenitipan.setText("Report Penitipan");
        btnReportPenitipan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportPenitipanActionPerformed(evt);
            }
        });

        btnReportPaket.setBackground(new java.awt.Color(51, 51, 255));
        btnReportPaket.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnReportPaket.setForeground(new java.awt.Color(255, 255, 255));
        btnReportPaket.setText("Report Paket");
        btnReportPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportPaketActionPerformed(evt);
            }
        });

        btnReportPelanggan.setBackground(new java.awt.Color(51, 51, 255));
        btnReportPelanggan.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnReportPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        btnReportPelanggan.setText("Report Pelanggan");
        btnReportPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportPelangganActionPerformed(evt);
            }
        });

        dateDari.setBackground(new java.awt.Color(153, 153, 153));
        dateDari.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Dari :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Sampai :");

        dateSampai.setBackground(new java.awt.Color(153, 153, 153));
        dateSampai.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateSampai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportPenitipan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReportPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportMakanan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportPaket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportHewan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dateDari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReportPenitipan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnReportHewan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReportPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReportPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReportMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(371, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(328, 328, 328))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportHewanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportHewanActionPerformed
        printHewan();
    }//GEN-LAST:event_btnReportHewanActionPerformed

    private void btnReportPenitipanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportPenitipanActionPerformed
        printPenitipan();
    }//GEN-LAST:event_btnReportPenitipanActionPerformed

    private void btnReportPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportPaketActionPerformed
        printPaket();
    }//GEN-LAST:event_btnReportPaketActionPerformed

    private void btnReportPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportPelangganActionPerformed
        printPelanggan();
    }//GEN-LAST:event_btnReportPelangganActionPerformed

    private void btnReportMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportMakananActionPerformed
        printMakanan();
    }//GEN-LAST:event_btnReportMakananActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReportHewan;
    private javax.swing.JButton btnReportMakanan;
    private javax.swing.JButton btnReportPaket;
    private javax.swing.JButton btnReportPelanggan;
    private javax.swing.JButton btnReportPenitipan;
    private com.toedter.calendar.JDateChooser dateDari;
    private com.toedter.calendar.JDateChooser dateSampai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
