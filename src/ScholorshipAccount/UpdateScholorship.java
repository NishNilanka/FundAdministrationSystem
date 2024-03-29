/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ScholorshipAccount;

import DBoperations.DBoperationWithFinal;
import DBoperations.DBoperations;
import Member.MemberDetails;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Thilina
 */
public class UpdateScholorship extends javax.swing.JFrame {
      float Amount;
      DBoperations DBoperation = new DBoperations();
    DBoperationWithFinal DBWithFinal = new DBoperationWithFinal();
    /**
     * Creates new form UpdateScholorship
     */
    MemberDetails member;
    public UpdateScholorship() {
        initComponents();
    }
     public void setFields(ScholorshipDetails std)
    {
        txtEmpNo.setText(new Integer(std.getEmpNo()).toString());
        member = DBWithFinal.getMemberByID(Integer.parseInt(txtEmpNo.getText()));
        txtScholorshipNo.setText(new Integer(std.getScholorshipNo()).toString());
        txtNICNo.setText(std.getNicNo());
        txtEmpFirsttName.setText(std.getFirstName());
        txtEmpLastName.setText(std.getLastName());
        txtFirstName.setText(std.getFirstName());
        txtLastName.setText(std.getLastName());
        txtEmpPrison.setText(std.getPrison());
        txtSchool.setText(std.getSchool());
        //txtGender.setText(std.getGender());
        txtDOB.setText(std.getDob());
        //txtScholorshipType.setText(std.getScholorshipType());
        txtAmount.setText(new Float(std.getAmount()).toString()); 
       
        
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtDOB = new javax.swing.JTextField();
        txtEmpNo = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSchool = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox();
        cbSholorshipType = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtEmpFirsttName = new javax.swing.JTextField();
        txtNICNo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtScholorshipNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmpLastName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmpPrison = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Scholorships");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Scholorship Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Scholorship Type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Emp No");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("DOB");

        txtFirstName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyTyped(evt);
            }
        });

        txtDOB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDOBActionPerformed(evt);
            }
        });
        txtDOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDOBKeyReleased(evt);
            }
        });

        txtEmpNo.setEditable(false);
        txtEmpNo.setBackground(new java.awt.Color(255, 255, 255));
        txtEmpNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmpNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpNoActionPerformed(evt);
            }
        });
        txtEmpNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpNoKeyTyped(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Amount");

        txtAmount.setEditable(false);
        txtAmount.setBackground(new java.awt.Color(255, 255, 255));
        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Last Name");

        txtLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastNameKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("School");

        txtSchool.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSchoolActionPerformed(evt);
            }
        });
        txtSchool.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSchoolKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Gender");

        cbGender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenderActionPerformed(evt);
            }
        });

        cbSholorshipType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GRADE V SCHOLORSHIP", "GCE A/L  SCHOLORSHIP" }));
        cbSholorshipType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSholorshipTypeItemStateChanged(evt);
            }
        });
        cbSholorshipType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSholorshipTypeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Emp First Name");

        txtEmpFirsttName.setEditable(false);
        txtEmpFirsttName.setBackground(new java.awt.Color(255, 255, 255));
        txtEmpFirsttName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmpFirsttName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpFirsttNameActionPerformed(evt);
            }
        });
        txtEmpFirsttName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpFirsttNameKeyTyped(evt);
            }
        });

        txtNICNo.setEditable(false);
        txtNICNo.setBackground(new java.awt.Color(255, 255, 255));
        txtNICNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNICNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNICNoMouseExited(evt);
            }
        });
        txtNICNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNICNoActionPerformed(evt);
            }
        });
        txtNICNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNICNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNICNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNICNoKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("NIC No:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Scholorship No");

        txtScholorshipNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtScholorshipNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtScholorshipNoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Emp Last Name");

        txtEmpLastName.setEditable(false);
        txtEmpLastName.setBackground(new java.awt.Color(255, 255, 255));
        txtEmpLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmpLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpLastNameActionPerformed(evt);
            }
        });
        txtEmpLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpLastNameKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Prison");

        txtEmpPrison.setEditable(false);
        txtEmpPrison.setBackground(new java.awt.Color(255, 255, 255));
        txtEmpPrison.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmpPrison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpPrisonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSholorshipType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSubmit)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDOB, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbGender, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSchool, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNICNo)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(36, 36, 36)
                        .addComponent(txtEmpPrison))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 29, Short.MAX_VALUE)
                                .addComponent(txtEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtScholorshipNo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmpFirsttName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmpLastName, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtScholorshipNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmpFirsttName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmpLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEmpPrison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNICNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtSchool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDOB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbSholorshipType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNICNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICNoKeyPressed

    }//GEN-LAST:event_txtNICNoKeyPressed

    private void txtNICNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICNoKeyReleased

    }//GEN-LAST:event_txtNICNoKeyReleased

    private void txtNICNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICNoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNICNoKeyTyped

    private void txtNICNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNICNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNICNoActionPerformed

    private void txtNICNoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNICNoMouseExited

    }//GEN-LAST:event_txtNICNoMouseExited

    private void txtEmpFirsttNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpFirsttNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpFirsttNameActionPerformed

    private void cbSholorshipTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSholorshipTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSholorshipTypeActionPerformed

    private void cbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGenderActionPerformed

    private void txtSchoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSchoolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSchoolActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        ScholorshipDetails ed = new ScholorshipDetails();

        try{
            ed.setFirstName(txtFirstName.getText());
            ed.setLastName(txtLastName.getText());
            ed.setDob(txtDOB.getText());
            ed.setSchool(txtSchool.getText());
            ed.setGender((String)cbGender.getSelectedItem());
            ed.setEmpNo(Integer.parseInt(txtEmpNo.getText()));
            //ed.setEmpLastName(txtEmpFirsttName.getText());
            ed.setScholorshipType((String)cbSholorshipType.getSelectedItem());
            ed.setAmount(Float.parseFloat(txtAmount.getText()));
            ed.setOwnerID(member.getOwnerID());
            ed.setAccountNo(member.getAccountNo());
            boolean result = DBoperation.updateScholorship(ed);
            
            if(result)
            {
                JOptionPane.showMessageDialog(this, "Waiting For Authorization");
            }
            else
            JOptionPane.showMessageDialog(this, "Error occurs while inserting");
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Member details are not valid");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtEmpNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpNoActionPerformed

    private void txtDOBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDOBKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDOBKeyReleased

    private void txtDOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDOBActionPerformed

    private void txtFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyReleased

    }//GEN-LAST:event_txtFirstNameKeyReleased

    private void txtEmpLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpLastNameActionPerformed

    private void txtEmpPrisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpPrisonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpPrisonActionPerformed

    private void txtEmpNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpNoKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        String in =txtEmpNo.getText();
        if(!Character.isDigit(c)){
           evt.consume();
           Toolkit tk = Toolkit.getDefaultToolkit();
             tk.beep();
            
    }
    }//GEN-LAST:event_txtEmpNoKeyTyped

    private void txtScholorshipNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtScholorshipNoKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        String in =txtScholorshipNo.getText();
        if(!Character.isDigit(c)){
           evt.consume();
           Toolkit tk = Toolkit.getDefaultToolkit();
             tk.beep();
            
    }
       
            
    
    }//GEN-LAST:event_txtScholorshipNoKeyTyped

    private void txtEmpFirsttNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpFirsttNameKeyTyped
        // TODO add your handling code here:
          
    }//GEN-LAST:event_txtEmpFirsttNameKeyTyped

    private void txtEmpLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpLastNameKeyTyped
        // TODO add your handling code here:
          
    }//GEN-LAST:event_txtEmpLastNameKeyTyped

    private void txtFirstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyTyped
        // TODO add your handling code here:
           char c=evt.getKeyChar();
        String in = txtFirstName.getText();
        if(c!=' '){
        if(!Character.isLetter(c)|| Character.isDigit(c)){
           evt.consume();
           Toolkit tk = Toolkit.getDefaultToolkit();
             tk.beep();}}
    }//GEN-LAST:event_txtFirstNameKeyTyped

    private void txtLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyTyped
        // TODO add your handling code here:
           char c=evt.getKeyChar();
        String in = txtLastName.getText();
        if(c!=' '){
        if(!Character.isLetter(c)|| Character.isDigit(c)){
           evt.consume();
           Toolkit tk = Toolkit.getDefaultToolkit();
             tk.beep();}}
    }//GEN-LAST:event_txtLastNameKeyTyped

    private void txtSchoolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSchoolKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        String in = txtSchool.getText();
        if(c!=' '){
        if(!Character.isLetter(c)|| Character.isDigit(c)){
           evt.consume();
           Toolkit tk = Toolkit.getDefaultToolkit();
             tk.beep();}}
    }//GEN-LAST:event_txtSchoolKeyTyped

    private void cbSholorshipTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSholorshipTypeItemStateChanged
        // TODO add your handling code here:
        
        if (cbSholorshipType.getSelectedItem().equals("GRADE V SCHOLORSHIP")){
              Amount = 10000.f;
         
        }
            else{
            Amount = 25000.f;
            
                    }
         txtAmount.setText(String.valueOf(Amount));
    }//GEN-LAST:event_cbSholorshipTypeItemStateChanged

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
            java.util.logging.Logger.getLogger(UpdateScholorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateScholorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateScholorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateScholorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateScholorship().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox cbGender;
    private javax.swing.JComboBox cbSholorshipType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmpFirsttName;
    private javax.swing.JTextField txtEmpLastName;
    private javax.swing.JTextField txtEmpNo;
    private javax.swing.JTextField txtEmpPrison;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNICNo;
    private javax.swing.JTextField txtScholorshipNo;
    private javax.swing.JTextField txtSchool;
    // End of variables declaration//GEN-END:variables
}
