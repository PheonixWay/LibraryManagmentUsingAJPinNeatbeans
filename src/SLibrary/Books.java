/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SLibrary;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akbal
 */
public final class Books extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Books() {
        initComponents();
        Connect();
        CategoryLoad();
        AuthorLoad();
        PublisherLoad();
        Book_load();
        
        
    }

    private static class Public {

        public Public() {
        }
    }
    
//    creating data structre for category
    public class CategoryItem{
        int id;
        String name;
        public CategoryItem(int id,String name){
            this.id=id;
            this.name=name;
        }
        @Override
        public String toString(){
            return name;
        }
    }
    
    //author data structure
    public class AuthorItem{
        int id;
        String name;
        public AuthorItem(int id,String name){
            this.id=id;
            this.name=name;
        }
        @Override
        public String toString(){
            return name;
        }
    }
    //punlisher data structere
    public class PublisherItem{
        int id;
        String name;
        public PublisherItem(int id,String name){
            this.id=id;
            this.name=name;
        }
        @Override
        public String toString(){
            return name;
        }
    }
    
    
  Connection con;
  PreparedStatement pst;
  ResultSet rs;
  
  //succesfully created the connection to the database
  public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost/slibrary","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
  
 //loading category in starting 
  public void CategoryLoad(){
        try {
            pst=con.prepareStatement("select * from category");
            rs=pst.executeQuery();
            txtcategory.removeAllItems();
            
            while(rs.next()){
                txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
  //loading author in starting
  public void AuthorLoad(){
        try {
            pst=con.prepareStatement("select * from author");
            rs=pst.executeQuery();
            txtauthor.removeAllItems();
            
            while(rs.next()){
                txtauthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  //loading Publisher in starting
  public void PublisherLoad(){
        try {
            pst=con.prepareStatement("select * from publisher");
            rs=pst.executeQuery();
            txtpublisher.removeAllItems();
            
            while(rs.next()){
                txtpublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
  //loading data to table
  public void Book_load(){
      int c;
        try {
            pst =con.prepareStatement("select b.id,b.bname,c.catname,a.name,p.name,b.content,b.pages,b.edition from books b JOIN category c On b.category=c.id JOIN author a On b.author=a.id JOIN publisher p On b.publisher=p.id");
            rs=pst.executeQuery(); 
            
            ResultSetMetaData rsd=(ResultSetMetaData) rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d= (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()){
                Vector v2;
                v2 = new Vector();
                
                for(int i=1;i<=c;i++){
                    v2.add(rs.getString("b.id"));
                    v2.add(rs.getString("b.bname"));
                    v2.add(rs.getString("c.catname"));
                    v2.add(rs.getString("a.name"));
                    v2.add(rs.getString("p.name"));
                    v2.add(rs.getString("b.content"));
                    v2.add(rs.getString("b.pages"));
                    v2.add(rs.getString("b.edition"));
                }
                d.addRow(v2);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtcontents = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcategory = new javax.swing.JComboBox();
        txtauthor = new javax.swing.JComboBox();
        txtpublisher = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnoofpages = new javax.swing.JTextField();
        txtedition = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Books");

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel3.setText("Category");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Book Name", "Category", "Author", "Publisher", "Content", "No of pages", "Edition"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel4.setText("Contents");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel5.setText("Author");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel6.setText("Publisher");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel7.setText("No of Pages");

        jLabel8.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel8.setText("Edition");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtcontents))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtnoofpages))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtpublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtauthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtedition))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtname))
                        .addGap(601, 601, 601)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcontents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnoofpages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1= (DefaultTableModel) jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        String bname=txtname.getText();
        CategoryItem citem=(CategoryItem) txtcategory.getSelectedItem();
        AuthorItem aitem=(AuthorItem) txtauthor.getSelectedItem();
        PublisherItem pitem=(PublisherItem) txtpublisher.getSelectedItem();
        
        String content=txtcontents.getText();
        String noofpages=txtnoofpages.getText();
        String edition=txtedition.getText();
        
        
        
        try {
            pst = con.prepareStatement("update books set bname=?, category=?, author=?,publisher=?,content=?,pages=?,edition=? where id=? ");
            pst.setString(1, bname);
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, content);
            pst.setString(6, noofpages);
            pst.setString(7, edition);
            pst.setInt(8, id);
            
            
            int k=pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(null,"Books Updated");
                txtname.setText("");
                txtcategory.setSelectedItem(-1);
                txtauthor.setSelectedItem(-1);
                txtpublisher.setSelectedItem(-1);
                txtnoofpages.setText("");
                txtcontents.setText("");
                txtedition.setText("");
                Book_load();
                jButton1.setEnabled(true);
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Error try again later");
            }
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String bname=txtname.getText();
        CategoryItem citem=(CategoryItem) txtcategory.getSelectedItem();
        AuthorItem aitem=(AuthorItem) txtauthor.getSelectedItem();
        PublisherItem pitem=(PublisherItem) txtpublisher.getSelectedItem();
        
        String content=txtcontents.getText();
        String noofpages=txtnoofpages.getText();
        String edition=txtedition.getText();
        
        
        try {
            pst = con.prepareStatement("insert into books(bname,category,author,publisher,content,pages,edition)values(?,?,?,?,?,?,?) ");
            pst.setString(1, bname);
            pst.setInt(2,citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5,content);
            pst.setString(6,noofpages);
            pst.setString(7,edition);
            
            int k=pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(null,"Book Added");
                txtname.setText("");
                txtcategory.setSelectedItem(-1);
                txtauthor.setSelectedItem(-1);
                txtpublisher.setSelectedItem(-1);
                txtnoofpages.setText("");
                txtcontents.setText("");
                txtedition.setText("");
                Book_load();
            
            }else{
                JOptionPane.showMessageDialog(null,"Error try again later");
            }
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1= (DefaultTableModel) jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());       
        
        txtname.setText(d1.getValueAt(selectIndex, 1).toString());
        txtcategory.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        txtauthor.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
        txtpublisher.setSelectedItem( d1.getValueAt(selectIndex, 4).toString());
        txtcontents.setText(d1.getValueAt(selectIndex, 5).toString());
        txtnoofpages.setText(d1.getValueAt(selectIndex, 6).toString());
        txtedition.setText(d1.getValueAt(selectIndex, 7).toString());
        
       
        jButton1.setEnabled(false);
     
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1= (DefaultTableModel) jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
       
        
        try {
            pst = con.prepareStatement("delete from books where id=?");
            
            pst.setInt(1, id);
            int k=pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(null,"Books Deleted");
                txtname.setText("");
                txtcategory.setSelectedItem(-1);
                txtauthor.setSelectedItem(-1);
                txtpublisher.setSelectedItem(-1);
                txtnoofpages.setText("");
                txtcontents.setText("");
                txtedition.setText("");
                Book_load();
                jButton1.setEnabled(true);
                
            }else{
                JOptionPane.showMessageDialog(null,"Error try again later");
            }
          
            
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Books().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontents;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnoofpages;
    private javax.swing.JComboBox txtpublisher;
    // End of variables declaration//GEN-END:variables

   
}
