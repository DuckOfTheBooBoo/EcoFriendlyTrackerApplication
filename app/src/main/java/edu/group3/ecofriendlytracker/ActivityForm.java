package edu.group3.ecofriendlytracker;

/**
 *
 * @author altaf
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class ActivityForm extends javax.swing.JFrame {

    /**
     * Creates new form ActivityForm
     */
    public ActivityForm() {
        initComponents();
        additionalGUIConfig();
    }
    
    private void additionalGUIConfig() {
        this.setLocationRelativeTo(null); // Make frame appear on center
        numInputField = new javax.swing.JSpinner();
        numInputField.setPreferredSize(new java.awt.Dimension(70, 25));
        calcMetricPanel.add(numInputField);
        calcMetricPanel.setVisible(false);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) numInputField.getEditor();
        JTextField textField = editor.getTextField();
        
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '-') {
                    e.consume();
                }  
            }

            @Override
            public void keyPressed(KeyEvent ke) {}

            @Override
            public void keyReleased(KeyEvent ke) {}
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
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        subCatComboBox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        specificOption = new javax.swing.JLabel();
        specificOptionCbx = new javax.swing.JComboBox<>();
        calcMetricPanel = new javax.swing.JPanel();
        calcMetricLabel = new javax.swing.JLabel();
        actionContainer = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activity Form");
        setPreferredSize(null);
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(495, 256));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Category:");
        jPanel2.add(jLabel1);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Transportation", "Home-energy" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(categoryComboBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jPanel2, gridBagConstraints);

        jLabel2.setText("Sub-category:");
        jPanel3.add(jLabel2);

        subCatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        subCatComboBox.setEnabled(false);
        subCatComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCatComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(subCatComboBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jPanel3, gridBagConstraints);

        specificOption.setText("specificLabel");
        specificOption.setVisible(false);
        jPanel4.add(specificOption);

        specificOptionCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", " " }));
        specificOptionCbx.setEnabled(false);
        specificOptionCbx.setVisible(false);
        jPanel4.add(specificOptionCbx);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jPanel4, gridBagConstraints);

        calcMetricLabel.setText("CalcMetric");
        specificOption.setVisible(false);
        calcMetricPanel.add(calcMetricLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(calcMetricPanel, gridBagConstraints);

        submitBtn.setText("Submit");
        actionPanel.add(submitBtn);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        actionPanel.add(cancelBtn);

        actionContainer.add(actionPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(actionContainer, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedCategory = String.valueOf(categoryComboBox.getSelectedItem());
        String[] subCat;
        DefaultComboBoxModel<String> model;
        
        switch (selectedCategory) {
            case "Transportation":
                subCat = new String[]{"-", "Car", "Motorcycle", "Public Transportation", "Non-emission"};
                model = new DefaultComboBoxModel(subCat);
                subCatComboBox.setModel(model);
                subCatComboBox.setEnabled(true);
                
                break;
            case "Home-energy":
                subCat = new String[]{"-", "LPG Powered Stove", "Solar Panel"};
                model = new DefaultComboBoxModel(subCat);
                subCatComboBox.setModel(model);
                subCatComboBox.setEnabled(true);
                break;
            default:
                subCatComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"-"}));
                subCatComboBox.setEnabled(false);
                break;
        }
        
        pack();
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void subCatComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCatComboBoxActionPerformed
        // TODO add your handling code here:
        String subCatSelection = String.valueOf(subCatComboBox.getSelectedItem());
        DefaultComboBoxModel<String> specificModel;
        switch (subCatSelection) {
            case "Car":
                specificModel = new DefaultComboBoxModel<String>(
                        new String[] {"", "Gasoline", "Diesel", "Electric", "Hybrid"}
                );
                specificOptionCbx.setModel(specificModel);
                specificOption.setText("Fuel type:");
                break;
            
            case "Public Transportation":
                specificModel = new DefaultComboBoxModel<String>(
                        new String[] {"", "Bus", "Train"}
                );
                specificOptionCbx.setModel(specificModel);
                specificOption.setText("Transport type:");
                break;
                
            case "Motorcycle":
                specificModel = new DefaultComboBoxModel<String>(
                        new String[] {"", "Gasoline", "Electric"}
                );
                specificOptionCbx.setModel(specificModel);
                specificOption.setText("Fuel type:");
                break;
            
            case "Non-emission":
                specificModel = new DefaultComboBoxModel<String>(
                        new String[] {"", "Cycling", "Walking"}
                );
                specificOptionCbx.setModel(specificModel);
                specificOption.setText("Activity type:");
                break;
            default:
                break;
        }
        
        calcMetricLabel.setText("Distance traveled (km):");
        calcMetricPanel.setVisible(true);
        
        specificOptionCbx.setVisible(true);
        specificOption.setVisible(true);
        specificOptionCbx.setEnabled(true);
        
        pack();
    }//GEN-LAST:event_subCatComboBoxActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ActivityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivityForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivityForm().setVisible(true);
            }
        });
    }
   
    private javax.swing.JSpinner numInputField;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionContainer;
    private javax.swing.JPanel actionPanel;
    private javax.swing.JLabel calcMetricLabel;
    private javax.swing.JPanel calcMetricPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel specificOption;
    private javax.swing.JComboBox<String> specificOptionCbx;
    private javax.swing.JComboBox<String> subCatComboBox;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
