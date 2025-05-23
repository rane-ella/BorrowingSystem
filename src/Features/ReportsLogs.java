
package Features;
import javax.swing.table.DefaultTableModel;
import Classes.*;
import java.util.List;

public class ReportsLogs extends javax.swing.JFrame {

    public ReportsLogs() {
        initComponents();
        setLocationRelativeTo(null);
        displayInfoPanel.setVisible(false);
        loadReportsLogsTable();
        reportsLogsTable.removeColumn(reportsLogsTable.getColumnModel().getColumn(1));
        reportsLogsTable.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = reportsLogsTable.getSelectedRow();
                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) reportsLogsTable.getModel();
                        Object transactionId = model.getValueAt(selectedRow, 0);
                        Object borrowerIdObj = model.getValueAt(selectedRow, 1);
                        Object tableName = model.getValueAt(selectedRow, 2);
                        Object equipmentType = model.getValueAt(selectedRow, 3);
                        Object dateBorrowed = model.getValueAt(selectedRow, 4);
                        Object dateReturned = model.getValueAt(selectedRow, 5);
                        Object status = model.getValueAt(selectedRow, 6);
                        
                        // Populate the integrated display info panel.
                        idValue.setText(String.valueOf(transactionId));
                        borrowerIdValue.setText(String.valueOf(borrowerIdObj));
                        nameValue.setText(String.valueOf(tableName));
                        equipmentTypeValue.setText(String.valueOf(equipmentType));
                        dateBorrowedValue.setText(String.valueOf(dateBorrowed));
                        dateReturnValue.setText(String.valueOf(dateReturned));
                        statusValue.setText(String.valueOf(status));
                        
                        // Additionally, load full borrower details.
                        if (borrowerIdObj != null && !borrowerIdObj.toString().trim().isEmpty()) {
                            try {
                                int borrowerId = Integer.parseInt(borrowerIdObj.toString());
                                BorrowerMain borrowerDAO = new BorrowerMain();
                                Borrower borrower = borrowerDAO.getBorrowerById(borrowerId);
                                
                                if (borrower != null) {
                                    nameValue.setText(borrower.getName());
                                    contactValue.setText(borrower.getContact());
                                    addressValue.setText(borrower.getAddress());
                                    purposeValue.setText(borrower.getPurpose());
                                    displayInfoPanel.setVisible(true);
                                } else {
                                    nameValue.setText("N/A");
                                    contactValue.setText("N/A");
                                    addressValue.setText("N/A");
                                    purposeValue.setText("N/A");
                                }
                            } catch (NumberFormatException ex) {
                                System.err.println("Invalid borrower ID: " + borrowerIdObj);
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuOptions = new javax.swing.JPopupMenu();
        Home = new javax.swing.JMenuItem();
        ItemManagement = new javax.swing.JMenuItem();
        BorrowingRecords = new javax.swing.JMenuItem();
        ReportsLogs = new javax.swing.JMenuItem();
        Profile = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jOptions = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportsLogsTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();
        displayInfoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idValue = new javax.swing.JTextField();
        borrowerIdValue = new javax.swing.JTextField();
        equipmentTypeValue = new javax.swing.JTextField();
        dateBorrowedValue = new javax.swing.JTextField();
        dateReturnValue = new javax.swing.JTextField();
        statusValue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nameValue = new javax.swing.JTextField();
        contactValue = new javax.swing.JTextField();
        addressValue = new javax.swing.JTextField();
        purposeValue = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        Home.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Home_icon.png"))); // NOI18N
        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        MenuOptions.add(Home);

        ItemManagement.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        ItemManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/ItemManagement_icon.png"))); // NOI18N
        ItemManagement.setText("Item Management");
        ItemManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemManagementActionPerformed(evt);
            }
        });
        MenuOptions.add(ItemManagement);

        BorrowingRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BorrowingRecords_icon.png"))); // NOI18N
        BorrowingRecords.setText("Borrowing Records");
        BorrowingRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowingRecordsActionPerformed(evt);
            }
        });
        MenuOptions.add(BorrowingRecords);

        ReportsLogs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/ReportsLogs_icon.png"))); // NOI18N
        ReportsLogs.setText("Reports and Logs");
        ReportsLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsLogsActionPerformed(evt);
            }
        });
        MenuOptions.add(ReportsLogs);

        Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Profile_icon.png"))); // NOI18N
        Profile.setText("Profile");
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });
        MenuOptions.add(Profile);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jOptions.setBackground(new java.awt.Color(51, 51, 51));
        jOptions.setFont(new java.awt.Font("Imprint MT Shadow", 1, 12)); // NOI18N
        jOptions.setForeground(new java.awt.Color(255, 255, 255));
        jOptions.setText("MENU");
        jOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOptionsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTS AND LOGS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jOptions)
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jOptions)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 60));

        reportsLogsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Borrower ID", "Name", "Equipment Type", "Date Borrowed", "Date Returned", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reportsLogsTable);
        if (reportsLogsTable.getColumnModel().getColumnCount() > 0) {
            reportsLogsTable.getColumnModel().getColumn(0).setResizable(false);
            reportsLogsTable.getColumnModel().getColumn(1).setResizable(false);
            reportsLogsTable.getColumnModel().getColumn(2).setResizable(false);
            reportsLogsTable.getColumnModel().getColumn(3).setResizable(false);
            reportsLogsTable.getColumnModel().getColumn(4).setResizable(false);
            reportsLogsTable.getColumnModel().getColumn(5).setResizable(false);
            reportsLogsTable.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 690, 350));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        getContentPane().add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, -1, -1));

        displayInfoPanel.setBackground(new java.awt.Color(204, 204, 204));
        displayInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Imprint MT Shadow", 1, 18)); // NOI18N
        jLabel2.setText("Borrower's Information");
        displayInfoPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 51, -1, -1));

        jLabel3.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel3.setText("ID");
        displayInfoPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel4.setText("Borrower ID");
        displayInfoPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 298, -1, -1));

        jLabel5.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel5.setText("Equipment Type");
        displayInfoPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 326, -1, -1));

        jLabel6.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel6.setText("Date Borrowed");
        displayInfoPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 354, -1, -1));

        jLabel7.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel7.setText("Date Return");
        displayInfoPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 382, -1, -1));

        jLabel8.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel8.setText("Status");
        displayInfoPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 410, -1, -1));

        idValue.setEditable(false);
        idValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idValueActionPerformed(evt);
            }
        });
        displayInfoPanel.add(idValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 266, 195, -1));

        borrowerIdValue.setEditable(false);
        displayInfoPanel.add(borrowerIdValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 294, 195, -1));

        equipmentTypeValue.setEditable(false);
        displayInfoPanel.add(equipmentTypeValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 322, 195, -1));

        dateBorrowedValue.setEditable(false);
        displayInfoPanel.add(dateBorrowedValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 350, 195, -1));

        dateReturnValue.setEditable(false);
        displayInfoPanel.add(dateReturnValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 378, 195, -1));

        statusValue.setEditable(false);
        displayInfoPanel.add(statusValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 406, 195, -1));

        jLabel10.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel10.setText("Name");
        displayInfoPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 158, -1, -1));

        jLabel14.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel14.setText("Contact");
        displayInfoPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 186, -1, -1));

        jLabel15.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel15.setText("Address");
        displayInfoPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 214, -1, -1));

        jLabel16.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        jLabel16.setText("Purpose");
        displayInfoPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 242, -1, -1));

        nameValue.setEditable(false);
        displayInfoPanel.add(nameValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 154, 195, -1));

        contactValue.setEditable(false);
        displayInfoPanel.add(contactValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 182, 195, -1));

        addressValue.setEditable(false);
        displayInfoPanel.add(addressValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 210, 195, -1));

        purposeValue.setEditable(false);
        displayInfoPanel.add(purposeValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 238, 195, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/sheet_13824781.png"))); // NOI18N
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        displayInfoPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, 100));

        getContentPane().add(displayInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 370, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOptionsActionPerformed
        MenuOptions.show(jOptions, 0, jOptions.getHeight());
    }//GEN-LAST:event_jOptionsActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void ItemManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemManagementActionPerformed
        ItemManagement item = new ItemManagement();
        item.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ItemManagementActionPerformed

    private void BorrowingRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowingRecordsActionPerformed
        BorrowingRecords record = new BorrowingRecords();
        record.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BorrowingRecordsActionPerformed

    private void ReportsLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsLogsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportsLogsActionPerformed

    private void loadReportsLogsTable() {
    DefaultTableModel model = (DefaultTableModel) reportsLogsTable.getModel();
    model.setRowCount(0); // Clear previous rows
    
    BorrowingRecordMain recordDAO = new BorrowingRecordMain();
    List<BorrowingRecord> deletedRecords = recordDAO.getAllSoftDeletedRecords();
    
    for (BorrowingRecord record : deletedRecords) {
        model.addRow(new Object[]{
            record.getTransactionId(),
            record.getBorrowerId(),
            record.getBorrowerName(),
            record.getEquipmentType(),
            record.getDateBorrowed(),
            record.getDateReturn(),
            record.getStatus()
        });
    }
    
}
    
    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed
        Profile profile = new Profile();
        profile.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProfileActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        loadReportsLogsTable();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void idValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idValueActionPerformed

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
            java.util.logging.Logger.getLogger(ReportsLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportsLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportsLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportsLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportsLogs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenuItem BorrowingRecords;
    protected javax.swing.JMenuItem Home;
    protected javax.swing.JMenuItem ItemManagement;
    private javax.swing.JPopupMenu MenuOptions;
    protected javax.swing.JMenuItem Profile;
    protected javax.swing.JMenuItem ReportsLogs;
    private javax.swing.JTextField addressValue;
    private javax.swing.JTextField borrowerIdValue;
    private javax.swing.JTextField contactValue;
    private javax.swing.JTextField dateBorrowedValue;
    private javax.swing.JTextField dateReturnValue;
    private javax.swing.JPanel displayInfoPanel;
    private javax.swing.JTextField equipmentTypeValue;
    private javax.swing.JTextField idValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jOptions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameValue;
    private javax.swing.JTextField purposeValue;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable reportsLogsTable;
    private javax.swing.JTextField statusValue;
    // End of variables declaration//GEN-END:variables
}
