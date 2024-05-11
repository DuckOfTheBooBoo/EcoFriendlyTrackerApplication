package edu.group3.ecofriendlytracker;


import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;


/**
 *
 * @author noval
 */
public class Dashboard extends javax.swing.JFrame {
    
    private Activity[] activities = null;
    private LocalDate selectedDate = LocalDate.now();
    private Integer selectedRow = null;
    private JFreeChart weeklyChart;
    private JFreeChart dailyChart;
    
    private DatabasesConnection dBInstance;
    
    /**
     * Creates new form dashboard
     */
    public Dashboard(DatabasesConnection dBInstance) {
        this.dBInstance = dBInstance;
        initComponents();
        additionalInitComponents();
        chartSetup(false, true);
        updateTable();
    }
    
    public void onActivityFormClosed(boolean status) {
        if(status) {
            chartSetup(true, true);
            updateTable();
        }
    }
    
    private void additionalInitComponents() {
        // Disable multi row selection
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add table event listener
        ListSelectionModel selectionModel = jTable1.getSelectionModel();
        
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                selectedRow = jTable1.getSelectedRow();
                
                if(selectedRow != -1) {
                    editActivitybtn.setEnabled(true);
                    deleteActivityBtn.setEnabled(true);
                }
            }
        });
    }
    
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(int i = 0; i < activities.length; i++) {
         // Construct specific type if additionalOption is not null
            Activity activity = activities[i];
            String specificCategory = activity.specificCategory();
            String metric = "";

            if(activity.category().contains("Transportation")) {
                metric = " (km)";
            } else if (activity.specificCategory().contains("LPG")) {
                metric = " (seconds)";
            } else {
                metric = " (kWh)";
            }

            Object[] rowData = {activity.category(), activity.subCategory(), specificCategory, activity.calcMetric() + metric, activity.emissionTotal()};

            model.addRow(rowData);
        }

        var week = DateHelper.getDaysOfWeek(selectedDate);
        var startWeek = week.get(0).toString();
        var endWeek = week.get(6).toString();

        weeksLabel.setText(startWeek + " - " + endWeek);
        dailyTitle.setText(selectedDate.toString());
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        WeeklyPanel = new javax.swing.JPanel();
        weeklyChartPanel = new javax.swing.JPanel();
        WeeksTitlePanel = new javax.swing.JPanel();
        weeksLabel = new javax.swing.JLabel();
        ActionButtonPanel = new javax.swing.JPanel();
        PreviousWeeksbtn = new javax.swing.JButton();
        NextWeeksbtn = new javax.swing.JButton();
        DailyPanel = new javax.swing.JPanel();
        dailyChartPanel = new javax.swing.JPanel();
        DailyTitlePanel = new javax.swing.JPanel();
        dailyTitle = new javax.swing.JLabel();
        NextDaysPanel = new javax.swing.JPanel();
        PreviousDaybtn = new javax.swing.JButton();
        NextDaybtn = new javax.swing.JButton();
        ActivityPanel = new javax.swing.JPanel();
        ActivityTable = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ActionBtn = new javax.swing.JPanel();
        AddNewActivitybtn = new javax.swing.JButton();
        editActivitybtn = new javax.swing.JButton();
        deleteActivityBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        MainPanel.setLayout(new javax.swing.BoxLayout(MainPanel, javax.swing.BoxLayout.LINE_AXIS));

        WeeklyPanel.setLayout(new javax.swing.BoxLayout(WeeklyPanel, javax.swing.BoxLayout.Y_AXIS));

        weeklyChartPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        weeklyChartPanel.setLayout(new java.awt.BorderLayout(10, 10));
        WeeklyPanel.add(weeklyChartPanel);

        WeeksTitlePanel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        weeksLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        weeksLabel.setText("7 March - 14 March");
        WeeksTitlePanel.add(weeksLabel);

        WeeklyPanel.add(WeeksTitlePanel);

        PreviousWeeksbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PreviousWeeksbtn.setText("Previous Week");
        PreviousWeeksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousWeeksbtnActionPerformed(evt);
            }
        });
        ActionButtonPanel.add(PreviousWeeksbtn);

        NextWeeksbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NextWeeksbtn.setText("Next Week");
        NextWeeksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextWeeksbtnActionPerformed(evt);
            }
        });
        ActionButtonPanel.add(NextWeeksbtn);

        WeeklyPanel.add(ActionButtonPanel);

        TabbedPane.addTab("Weekly", WeeklyPanel);

        dailyChartPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dailyChartPanel.setLayout(new java.awt.BorderLayout(10, 10));

        dailyTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        dailyTitle.setText("7 March");
        DailyTitlePanel.add(dailyTitle);

        NextDaysPanel.setLayout(new javax.swing.BoxLayout(NextDaysPanel, javax.swing.BoxLayout.LINE_AXIS));

        PreviousDaybtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PreviousDaybtn.setText("Previous Day");
        PreviousDaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousDaybtnActionPerformed(evt);
            }
        });
        NextDaysPanel.add(PreviousDaybtn);

        NextDaybtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NextDaybtn.setText("Next Day");
        NextDaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextDaybtnActionPerformed(evt);
            }
        });
        NextDaysPanel.add(NextDaybtn);

        javax.swing.GroupLayout DailyPanelLayout = new javax.swing.GroupLayout(DailyPanel);
        DailyPanel.setLayout(DailyPanelLayout);
        DailyPanelLayout.setHorizontalGroup(
            DailyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dailyChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DailyPanelLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(DailyTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
            .addGroup(DailyPanelLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(NextDaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DailyPanelLayout.setVerticalGroup(
            DailyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DailyPanelLayout.createSequentialGroup()
                .addComponent(dailyChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(DailyTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NextDaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Daily", DailyPanel);

        ActivityPanel.setLayout(new javax.swing.BoxLayout(ActivityPanel, javax.swing.BoxLayout.LINE_AXIS));

        ActivityTable.setLayout(new javax.swing.BoxLayout(ActivityTable, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Activity List");
        ActivityTable.add(jLabel1);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Category", "Sub-Category", "Specific Type", "Calculation Metric", "Emission Total (kgCO2e)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(95);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(95);
            jTable1.getColumnModel().getColumn(1).setMinWidth(216);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(216);
            jTable1.getColumnModel().getColumn(2).setMinWidth(241);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(241);
            jTable1.getColumnModel().getColumn(3).setMinWidth(113);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(113);
            jTable1.getColumnModel().getColumn(4).setMinWidth(186);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(186);
        }

        ActivityTable.add(jScrollPane1);

        ActionBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 30));

        AddNewActivitybtn.setBackground(new java.awt.Color(51, 255, 0));
        AddNewActivitybtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddNewActivitybtn.setText("Add new activity");
        AddNewActivitybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewActivitybtnActionPerformed(evt);
            }
        });
        ActionBtn.add(AddNewActivitybtn);

        editActivitybtn.setBackground(new java.awt.Color(255, 204, 0));
        editActivitybtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editActivitybtn.setText("Edit activity");
        editActivitybtn.setEnabled(false);
        editActivitybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActivitybtnActionPerformed(evt);
            }
        });
        ActionBtn.add(editActivitybtn);

        deleteActivityBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteActivityBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteActivityBtn.setText("Delete activity");
        deleteActivityBtn.setEnabled(false);
        deleteActivityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActivityBtnActionPerformed(evt);
            }
        });
        ActionBtn.add(deleteActivityBtn);

        ActivityTable.add(ActionBtn);

        ActivityPanel.add(ActivityTable);

        javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ActivityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addComponent(TabbedPane)
                        .addContainerGap())
                    .addComponent(ActivityPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        MainPanel.add(DashboardPanel);

        getContentPane().add(MainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextWeeksbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextWeeksbtnActionPerformed
        // TODO add your handling code here:
        this.selectedDate = DateHelper.getMondayFromNextWeek(selectedDate);
        chartSetup(true, true);
        updateTable();
    }//GEN-LAST:event_NextWeeksbtnActionPerformed

    private void PreviousWeeksbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousWeeksbtnActionPerformed
        // TODO add your handling code here:
        this.selectedDate = DateHelper.getSundayFromPreviousWeek(selectedDate);
        chartSetup(true, true);
        updateTable();
    }//GEN-LAST:event_PreviousWeeksbtnActionPerformed

    
    private void PreviousDaybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousDaybtnActionPerformed
        // TODO add your handling code here:
        this.selectedDate = this.selectedDate.minusDays(1);
        chartSetup(true, true);
        updateTable();
    }//GEN-LAST:event_PreviousDaybtnActionPerformed

    private void AddNewActivitybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewActivitybtnActionPerformed
        // TODO add your handling code here:
       new ActivityForm(this.dBInstance, this).setVisible(true);
    }//GEN-LAST:event_AddNewActivitybtnActionPerformed

    private void editActivitybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActivitybtnActionPerformed
        // TODO add your handling code here:
        // Get activity
        Activity selectedActivity = this.activities[selectedRow];
        Form activityForm = ActivityHelper.activityToForm(selectedActivity);
        
        new ActivityForm(this.dBInstance, this, selectedActivity.id(), activityForm).setVisible(true);
    }//GEN-LAST:event_editActivitybtnActionPerformed

    private void deleteActivityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActivityBtnActionPerformed
        // TODO add your handling code here:
        Activity selectedActivity = this.activities[selectedRow];
        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the activity?", "Confirmation Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(reply == JOptionPane.YES_OPTION) {
            boolean isSuccessful = this.dBInstance.deleteActivity(selectedActivity.id());
            
            if(isSuccessful) {
                JOptionPane.showMessageDialog(this, "Successfully deleted the activity", "Status Dialog", JOptionPane.INFORMATION_MESSAGE);
                chartSetup(true, true);
                updateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to deleted the activity", "Status Dialog", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteActivityBtnActionPerformed

    private void NextDaybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextDaybtnActionPerformed
        // TODO add your handling code here:
        this.selectedDate = this.selectedDate.plusDays(1);
        chartSetup(true, true);
        updateTable();
    }//GEN-LAST:event_NextDaybtnActionPerformed
    
    
    private void getActivitiesWeek(LocalDate currentDate) {
        activities = this.dBInstance.getActivitiesAWeek(currentDate);
    }
    
    private void chartSetup(boolean isUpdate, boolean isDoRefetch) {
        if(isDoRefetch) {
            this.getActivitiesWeek(selectedDate);
        }
        
        DefaultPieDataset weeklyDataset = DatasetFactory.weeklyChartDataset(activities);
        DefaultCategoryDataset dailyDataset = DatasetFactory.dailyChartDataset(activities, selectedDate);
        
        if(isUpdate) {
            ((PiePlot) weeklyChart.getPlot()).setDataset(weeklyDataset);
            ((CategoryPlot) dailyChart.getPlot()).setDataset(dailyDataset);
        } else {
            weeklyChart = ChartFactory.createPieChart("Weekly data", weeklyDataset);
            dailyChart = ChartFactory.createBarChart("Daily Report", "Daily emission produced", "kgCO2e", dailyDataset);

            PiePlot weeklyPlot = (PiePlot) weeklyChart.getPlot();
            CategoryPlot dailyPLot = (CategoryPlot) dailyChart.getPlot();

            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            weeklyPlot.setLabelGenerator(gen);

            ChartPanel chartpanel = new ChartPanel(weeklyChart);
            weeklyChartPanel.add(chartpanel, BorderLayout.CENTER);

            ChartPanel dailyPanel = new ChartPanel (dailyChart);
            dailyChartPanel.add(dailyPanel, BorderLayout.CENTER);                       
        }
        
    };
    
    
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                System.out.println("Setting up database connection");
                DatabasesConnection dbConnection = new DatabasesConnection();
                
                try {
                    dbConnection.connect();
                    System.out.println("Database connection established.");
                    
                    if(dbConnection.connection != null) {
                        new Dashboard(dbConnection).setVisible(true);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(1);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ActionBtn;
    private javax.swing.JPanel ActionButtonPanel;
    private javax.swing.JPanel ActivityPanel;
    private javax.swing.JPanel ActivityTable;
    private javax.swing.JButton AddNewActivitybtn;
    private javax.swing.JPanel DailyPanel;
    private javax.swing.JPanel DailyTitlePanel;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton NextDaybtn;
    private javax.swing.JPanel NextDaysPanel;
    private javax.swing.JButton NextWeeksbtn;
    private javax.swing.JButton PreviousDaybtn;
    private javax.swing.JButton PreviousWeeksbtn;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JPanel WeeklyPanel;
    private javax.swing.JPanel WeeksTitlePanel;
    private javax.swing.JPanel dailyChartPanel;
    private javax.swing.JLabel dailyTitle;
    private javax.swing.JButton deleteActivityBtn;
    private javax.swing.JButton editActivitybtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel weeklyChartPanel;
    private javax.swing.JLabel weeksLabel;
    // End of variables declaration//GEN-END:variables

}
