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
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;


public class ActivityForm extends javax.swing.JFrame {
    private boolean addOpVisible = false;
    private Form form;
    private Integer activityId = null;
    
    /**
     * Creates new empty ActivityForm (CREATE)
     */
    public ActivityForm() {
        initComponents();
        additionalGUIConfig();
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        form = new Form();
    }
    
    /**
     * Creates new form with already existing data from activity (UPDATE)
     * @param activityId Id of activity in database
     * @param activityForm A Form instance that contains activity's data
     */
    public ActivityForm(int activityId, Form activityForm) {
        initComponents();
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        this.form = activityForm;
        this.activityId = activityId;
        additionalGUIConfig();
        populateGUIFromForm();
    }
    
    public void populateGUIFromForm() {
        if(!this.form.category.isEmpty()) {
//            categoryComboBox.setSelectedItem(form.category);
            setupCategoryField(form.category);
        }
        
        if(!this.form.subCategory.isEmpty()) {
            setupSubCategoryField(form.category, form.subCategory);
        }
        
        if(!this.form.specific.isEmpty()) {
            setupSpecificField(form.subCategory, form.specific);
        }
        
        if(!this.form.additionalOption.isEmpty()) {
            setupAdditionalOption(form.additionalOption);
        }
        
        if(this.form.calcMetric > 0.0) {
            numInputField.setValue(form.calcMetric);
        }
    }
    
    private void additionalGUIConfig() {
        GridBagConstraints gridBagConstraints;
        this.setLocationRelativeTo(null); // Make frame appear on center
        numInputField = new javax.swing.JSpinner();
        
        // JSpinner OnValue changed event listener
        numInputField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                Object target = ((JSpinner) ce.getSource()).getValue();
                numInputFieldListener(target.toString());
            } 
        });
        
        numInputField.setPreferredSize(new java.awt.Dimension(70, 25));
        
        // Place JSpinner inside GridBag X1 Y4
        calcMetricPanel.add(numInputField);

        
        calcMetricLabel.setVisible(false);
        calcDetailPanel.setVisible(false);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) numInputField.getEditor();
        JTextField textField = editor.getTextField();
        
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '-' && e.getKeyChar() != '.') {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    numInputFieldListener(textField.getText().toString());
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {}
        });
        
        if(this.activityId != null) {
            actionBtn.setText("Update");
            this.setTitle("Update Activity Form");
        }
        
        pack();
    }
    
    private void setupCategoryField(String selectedCategory) {
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Transportation", "Home-energy" }));
        
        if (selectedCategory != null) {
            categoryComboBox.setSelectedItem(selectedCategory);
        }
    }
    
    private void setupSubCategoryField(String selectedCategory, String selectedSubCat) {
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
                subCat = new String[]{"-", "Natural gas or propane consumption", "Renewable energy"};
                model = new DefaultComboBoxModel(subCat);
                subCatComboBox.setModel(model);
                subCatComboBox.setEnabled(true);
                break;
            default:
                subCatComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"-"}));
                subCatComboBox.setEnabled(false);
                break;
        }
        
        if (selectedSubCat != null) {
            subCatComboBox.setSelectedItem(selectedSubCat);
        }
        
        pack();
    }
    
    private void setupSpecificField(String selectedSubCat, String specific) {
        DefaultComboBoxModel<String> specificModel;
        switch (selectedSubCat) {
            // Transportation
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
            
            // Home-energy
            case "Natural gas or propane consumption":
                specificModel = new DefaultComboBoxModel<String>(
                        new String[] {"", "LPG powered stove", "Diesel generator set"}
                );
                specificOptionCbx.setModel(specificModel);
                specificOption.setText("Activity:");
                break;
            
            case "Renewable energy":
                specificModel = new DefaultComboBoxModel<String>(
                        new String[] {"", "Solar Panel"}
                );
                specificOptionCbx.setModel(specificModel);
                specificOption.setText("Type:");
                break;
            default:
                break;
        }
        
        specificOptionCbx.setVisible(true);
        specificOption.setVisible(true);
        specificOptionCbx.setEnabled(true);
        
        if(specific != null) {
            specificOptionCbx.setSelectedItem(specific);
        }
        
        pack();
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
        catLabel = new javax.swing.JLabel();
        subCatLabel = new javax.swing.JLabel();
        specificOption = new javax.swing.JLabel();
        calcMetricLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        calcDetailPanel = new javax.swing.JPanel();
        calcDetailLabel = new javax.swing.JLabel();
        actionContainer = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        actionBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();
        subCatComboBox = new javax.swing.JComboBox<>();
        specificOptionCbx = new javax.swing.JComboBox<>();
        addOpLabel = new javax.swing.JLabel();
        addOpCbx = new javax.swing.JComboBox<>();
        calcMetricPanel = new javax.swing.JPanel();

        jScrollPane1.setViewportView(jTextPane1);

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activity Form");
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(495, 256));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        catLabel.setText("Category:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(catLabel, gridBagConstraints);

        subCatLabel.setText("Sub-category:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(subCatLabel, gridBagConstraints);

        specificOption.setText("specificLabel");
        specificOption.setVisible(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(specificOption, gridBagConstraints);

        calcMetricLabel.setText("CalcMetric");
        specificOption.setVisible(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(calcMetricLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jSeparator1, gridBagConstraints);

        calcDetailPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        calcDetailLabel.setText("Calculation Details");
        calcDetailPanel.add(calcDetailLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(calcDetailPanel, gridBagConstraints);

        actionBtn.setText("Submit");
        actionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBtnActionPerformed(evt);
            }
        });
        actionPanel.add(actionBtn);

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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        jPanel1.add(actionContainer, gridBagConstraints);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Transportation", "Home-energy" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(categoryComboBox, gridBagConstraints);

        subCatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        subCatComboBox.setEnabled(false);
        subCatComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCatComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(subCatComboBox, gridBagConstraints);

        specificOptionCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", " " }));
        specificOptionCbx.setEnabled(false);
        specificOptionCbx.setVisible(false);
        specificOptionCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specificOptionCbxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(specificOptionCbx, gridBagConstraints);

        addOpLabel.setText("addOpLabel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(addOpLabel, gridBagConstraints);
        addOpLabel.setVisible(false);

        addOpCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        addOpCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOpCbxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(addOpCbx, gridBagConstraints);
        addOpCbx.setVisible(false);

        calcMetricPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(calcMetricPanel, gridBagConstraints);
        calcMetricPanel.setVisible(false);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
        if (addOpVisible) {
            hideAddOpComponents();
        }
        
        String selectedCategory = String.valueOf(categoryComboBox.getSelectedItem());
        form.category = selectedCategory;
        
        if (!form.subCategory.isEmpty()) {
            setupSubCategoryField(form.category, form.subCategory);
        } else {
            setupSubCategoryField(form.category, null);
        } 
    }//GEN-LAST:event_categoryComboBoxActionPerformed
    
    private void numInputFieldListener(String stringValue) {
        double value = -0;
        
        try {
            value = Double.valueOf(stringValue);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Invalid Calculation Metric", JOptionPane.ERROR_MESSAGE);
        }
        
        form.calcMetric = value;
        if (form.validate()) {
            String emissionKey = Emission.formIdParser(form);
            double emission = Emission.getEmissionAmount(emissionKey);
            double emissionTotal = Math.round((emission * form.calcMetric) * 10000) / 10000.0;
            form.emissionTotal = emissionTotal;
            String equation = String.format(
                    "%s * %s = %s kgCO2e",
                    emission, form.calcMetric, emissionTotal
            );

            System.out.println(equation);

            calcDetailLabel.setText(equation);
            calcDetailLabel.setVisible(true);
            calcDetailPanel.setVisible(true);
            pack();
        }
    }
    
    private void subCatComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCatComboBoxActionPerformed
        // TODO add your handling code here:
        if (addOpVisible) {
            hideAddOpComponents();
        }
        
        String subCatSelection = String.valueOf(subCatComboBox.getSelectedItem());
        form.subCategory = subCatSelection;
        
        setupSpecificField(subCatSelection, null);
    }//GEN-LAST:event_subCatComboBoxActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed
    
    private void setupCalcMetricField(String specificOptionSelected) {
        if (String.valueOf(categoryComboBox.getSelectedItem()).equals("Transportation")) {
            calcMetricLabel.setText("Distance Traveled (km):");
            calcMetricLabel.setVisible(true);
            calcMetricPanel.setVisible(true);
        } else {
            switch (specificOptionSelected) {
                case "LPG powered stove":
                    
                    // Show additional option components
                    setupAdditionalOption(null);
                    break;
                case "Solar Panel":
                case "Diesel generator set":
                    calcMetricLabel.setText("Kilo-watt per hour (kWh):");
                    calcMetricLabel.setVisible(true);
                    calcMetricPanel.setVisible(true);
                    break;
                default:
                    break;
            }
        }
        pack();
    }
    
    private void setupAdditionalOption(String selectedAddOption) {
        addOpLabel.setText("Temperature:");
        addOpCbx.setModel(new DefaultComboBoxModel<String>(
                new String[] {"", "Low temperature", "Medium temperature", "High temperature"}
        ));
        showAddOpComponents();

        calcMetricLabel.setText("Cooking duration (s):");
        calcMetricLabel.setVisible(true);
        calcMetricPanel.setVisible(true);
        addOpVisible = true;
        
        if(selectedAddOption != null) {
            addOpCbx.setSelectedItem(selectedAddOption);
        }
    }
    
    private void specificOptionCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specificOptionCbxActionPerformed
        // TODO add your handling code here:
        if (addOpVisible) {
            hideAddOpComponents();
        }
        
        String specificOptionSelection = String.valueOf(specificOptionCbx.getSelectedItem());
        form.specific = specificOptionSelection;
        
        setupCalcMetricField(specificOptionSelection);
    }//GEN-LAST:event_specificOptionCbxActionPerformed

    private void actionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBtnActionPerformed
        // TODO add your handling code here:
        form.print();
        if(!form.validate()) {
            JOptionPane.showMessageDialog(this, "Please fill the form correctly.", "Invalid Form", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Insert form data into database
    }//GEN-LAST:event_actionBtnActionPerformed

    private void addOpCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOpCbxActionPerformed
        // TODO add your handling code here:
        form.additionalOption = addOpCbx.getSelectedItem().toString();
    }//GEN-LAST:event_addOpCbxActionPerformed

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
    
    private void showAddOpComponents() {
        addOpLabel.setVisible(true);
        addOpCbx.setVisible(true);
        addOpVisible = true;
    }
    
    private void hideAddOpComponents() {
        addOpLabel.setVisible(false);
        addOpCbx.setVisible(false);
        addOpVisible = false;
    }
    
    private javax.swing.JSpinner numInputField;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionBtn;
    private javax.swing.JPanel actionContainer;
    private javax.swing.JPanel actionPanel;
    private javax.swing.JComboBox<String> addOpCbx;
    private javax.swing.JLabel addOpLabel;
    private javax.swing.JLabel calcDetailLabel;
    private javax.swing.JPanel calcDetailPanel;
    private javax.swing.JLabel calcMetricLabel;
    private javax.swing.JPanel calcMetricPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel catLabel;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel specificOption;
    private javax.swing.JComboBox<String> specificOptionCbx;
    private javax.swing.JComboBox<String> subCatComboBox;
    private javax.swing.JLabel subCatLabel;
    // End of variables declaration//GEN-END:variables
}
