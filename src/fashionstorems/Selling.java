/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fashionstorems;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Selling extends javax.swing.JFrame {

    public Selling() {
        initComponents();
        selectSeller();
        getCat();
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;

    public void selectSeller() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fashionstore", "root", "akp000000");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM productt");
            ProdTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    int prid,newQty;
    
    
    public void update(){
        newQty = AvailQty - Integer.parseInt(ProdQty.getText());
         try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fashionstore", "root", "akp000000");
                String Query = "Update productt set ProdQty=" + newQty + "" + " where ProdId=" + prid;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                selectSeller();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
     private void getCat() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fashionstore", "root", "akp000000");
            St = Con.createStatement();
            String Query = "SELECT * FROM categoryt";
            Rs = St.executeQuery(Query);
            while(Rs.next()){
                String myCat = Rs.getString("CatName");
                ProdCat.addItem(myCat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BillId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ProdName = new javax.swing.JTextField();
        ProdQty = new javax.swing.JTextField();
        ProdCat = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();
        PrintBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillText = new javax.swing.JTextArea();
        GrdTLbl = new javax.swing.JLabel();
        RefreshBtn1 = new javax.swing.JButton();
        Close = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));

        jLabel2.setFont(new java.awt.Font("Courier 10 Pitch", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Billing Point");

        BillId.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        BillId.setForeground(new java.awt.Color(255, 51, 0));

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("BILL-ID");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("NAME");

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("QUANTITY");

        ProdName.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        ProdName.setForeground(new java.awt.Color(255, 51, 0));
        ProdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdNameActionPerformed(evt);
            }
        });

        ProdQty.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        ProdQty.setForeground(new java.awt.Color(255, 51, 0));
        ProdQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdQtyActionPerformed(evt);
            }
        });

        ProdCat.setFont(new java.awt.Font("Cantarell", 1, 17)); // NOI18N
        ProdCat.setForeground(new java.awt.Color(255, 51, 0));
        ProdCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ProdCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProdCatItemStateChanged(evt);
            }
        });
        ProdCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProdCatMousePressed(evt);
            }
        });
        ProdCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdCatActionPerformed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(255, 51, 0));
        AddBtn.setFont(new java.awt.Font("Cantarell", 1, 21)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add To Bill");
        AddBtn.setBorder(null);
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddBtnMousePressed(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        PrintBtn.setBackground(new java.awt.Color(255, 51, 0));
        PrintBtn.setFont(new java.awt.Font("Cantarell", 1, 21)); // NOI18N
        PrintBtn.setForeground(new java.awt.Color(255, 255, 255));
        PrintBtn.setText("Print");
        PrintBtn.setBorder(null);
        PrintBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrintBtnMousePressed(evt);
            }
        });
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setBackground(new java.awt.Color(255, 51, 0));
        RefreshBtn.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        RefreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        RefreshBtn.setText("Refresh");
        RefreshBtn.setBorder(null);
        RefreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RefreshBtnMousePressed(evt);
            }
        });
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(255, 51, 0));
        ClearBtn.setFont(new java.awt.Font("Cantarell", 1, 21)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("Clear");
        ClearBtn.setBorder(null);
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ClearBtnMousePressed(evt);
            }
        });
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        ProdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE", "CATEGORY"
            }
        ));
        ProdTable.setRowHeight(25);
        ProdTable.setSelectionBackground(new java.awt.Color(255, 51, 0));
        ProdTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ProdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProdTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(ProdTable);

        jLabel4.setFont(new java.awt.Font("Courier 10 Pitch", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Product List");

        BillText.setColumns(20);
        BillText.setRows(5);
        jScrollPane2.setViewportView(BillText);

        GrdTLbl.setFont(new java.awt.Font("Segoe UI Emoji", 1, 20)); // NOI18N
        GrdTLbl.setForeground(new java.awt.Color(255, 51, 0));
        GrdTLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GrdTLbl.setText("Rs");

        RefreshBtn1.setBackground(new java.awt.Color(255, 51, 0));
        RefreshBtn1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        RefreshBtn1.setForeground(new java.awt.Color(255, 255, 255));
        RefreshBtn1.setText("Filter");
        RefreshBtn1.setBorder(null);
        RefreshBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RefreshBtn1MousePressed(evt);
            }
        });
        RefreshBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ProdQty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BillId, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ProdCat, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(RefreshBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RefreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(GrdTLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BillId))
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrdTLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrintBtn)
                .addGap(14, 14, 14))
        );

        Close.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        Close.setForeground(new java.awt.Color(255, 255, 255));
        Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Close.setText("X");
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cantarell", 3, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("LOGOUT");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Close)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
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

    private void ProdCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdCatActionPerformed
    int i = 0;
    private void AddBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMousePressed
        if (ProdQty.getText().isEmpty() || ProdName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else if(AvailQty <= Integer.parseInt(ProdQty.getText())){
                JOptionPane.showMessageDialog(this, "Not Enough in Stock");
        }
        else 
        {
            i++;
            ProdTot = Uprice * Double.valueOf(ProdQty.getText());
            GrdTot = GrdTot + ProdTot;
            if (i == 1) {
                BillText.setText(BillText.getText() + "\t            ***** DENIM SELECTION *****\n\n" + " NUM     PRODUCT       PRICE     QUANTITY      TOTAL\n"+" "+ i +"            " + ProdName.getText() + "            "+Uprice + "         "+ProdQty.getText() + "              " + ProdTot + "\n");
            }else{
                BillText.setText(BillText.getText() +" "+ i +"            " + ProdName.getText() + "            "+Uprice + "        "+ProdQty.getText() + "              " + ProdTot + "\n");
            }
            GrdTLbl.setText("Rs  -  " + GrdTot+"/-");
            update();
        }
    }//GEN-LAST:event_AddBtnMousePressed

    private void PrintBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBtnMousePressed
        try{
            BillText.print();
        }catch(PrinterException e){
            
        }
    }//GEN-LAST:event_PrintBtnMousePressed

    private void RefreshBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshBtnMousePressed
        selectSeller();
    }//GEN-LAST:event_RefreshBtnMousePressed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void ClearBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMousePressed
        BillId.setText("");
        //ProdPrice.setText("");
        ProdQty.setText("");
        ProdName.setText("");
    }//GEN-LAST:event_ClearBtnMousePressed
    Double Uprice,ProdTot = 0.0,GrdTot = 0.0;
    int AvailQty;
   
    private void ProdTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdTableMousePressed
        DefaultTableModel model = (DefaultTableModel) ProdTable.getModel();
        int MyIndex = ProdTable.getSelectedRow();
        prid = Integer.parseInt(model.getValueAt(MyIndex, 0).toString());
        AvailQty = Integer.parseInt(model.getValueAt(MyIndex, 2).toString());
        ProdName.setText(model.getValueAt(MyIndex, 1).toString());
        Uprice = Double.valueOf(model.getValueAt(MyIndex, 3).toString());
    }//GEN-LAST:event_ProdTableMousePressed
   
    private void CloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_CloseMousePressed

    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrintBtnActionPerformed

    private void ProdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdNameActionPerformed

    private void ProdQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdQtyActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MousePressed

    private void ProdCatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdCatMousePressed
        
    }//GEN-LAST:event_ProdCatMousePressed

    private void ProdCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProdCatItemStateChanged
      
    }//GEN-LAST:event_ProdCatItemStateChanged

    private void RefreshBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshBtn1MousePressed
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fashionstore", "root", "akp000000");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM productt where ProdCat='"+ProdCat.getSelectedItem().toString() + "'");
            ProdTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_RefreshBtn1MousePressed

    private void RefreshBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField BillId;
    private javax.swing.JTextArea BillText;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JLabel Close;
    private javax.swing.JLabel GrdTLbl;
    private javax.swing.JButton PrintBtn;
    private javax.swing.JComboBox<String> ProdCat;
    private javax.swing.JTextField ProdName;
    private javax.swing.JTextField ProdQty;
    private javax.swing.JTable ProdTable;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton RefreshBtn1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
