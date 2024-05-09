package edu.group3.ecofriendlytracker;


import java.awt.BorderLayout;
import java.text.DecimalFormat;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;


/**
 *
 * @author noval
 */
public class Dashboard extends javax.swing.JFrame {
    
    private Activity[] activities = {
        new Activity(1, "Transportation", "Car", "Gasoline", 5.0, 0.81941),
        new Activity(2, "Transportation", "Motorcycle", "Gasoline", 12.0, 1.39080),
        new Activity(3, "Transportation", "Public transportation", "Bus", 1.5, 0.332803),
        new Activity(4, "Transportation", "Public transportation", "Train", 39.0, 2.12940),
        new Activity(5, "Home-energy", "Natural gas or propane consumption", "Diesel powered generator set", 48, 7.50336),
        new Activity(6, "Home-energy", "Natural gas or propane consumption", "LPG Powered Stove (Medium temperature)", (5.0*60), 1.55000)            
    };
    
    /**
     * Creates new form dashboard
     */
    public Dashboard() {
        initComponents();
        additionalInit();
        ChartSetup();
    }
    
    private void additionalInit() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(int i = 0; i < activities.length; i++) {
         // Construct specific type if additionalOption is not null
            Activity activity = activities[i];
            String specificCategory = activity.specificCategory();
            
            Object[] rowData = {activity.category(), activity.subCategory(), specificCategory, activity.calcMetric(), activity.emissionTotal()};
            
            model.addRow(rowData);
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

        MainPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        DailyPanel = new javax.swing.JPanel();
        DailyChartPanel = new javax.swing.JPanel();
        DailyTitlePanel = new javax.swing.JPanel();
        DailyTitle = new javax.swing.JLabel();
        NextDaysPanel = new javax.swing.JPanel();
        PreviousDaybtn = new javax.swing.JButton();
        NextDaybtn = new javax.swing.JButton();
        WeeklyPanel = new javax.swing.JPanel();
        weeklyChartPanel = new javax.swing.JPanel();
        WeeksTitlePanel = new javax.swing.JPanel();
        WeeksLabel = new javax.swing.JLabel();
        ActionButtonPanel = new javax.swing.JPanel();
        PreviousWeeksbtn = new javax.swing.JButton();
        NextWeeksbtn = new javax.swing.JButton();
        ActivityPanel = new javax.swing.JPanel();
        ActivityTable = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ActionBtn = new javax.swing.JPanel();
        AddNewActivitybtn = new javax.swing.JButton();
        EditActivitybtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        MainPanel.setLayout(new javax.swing.BoxLayout(MainPanel, javax.swing.BoxLayout.LINE_AXIS));

        DailyChartPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DailyChartPanel.setLayout(new java.awt.BorderLayout(10, 10));

        DailyTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        DailyTitle.setText("7 March");
        DailyTitlePanel.add(DailyTitle);

        PreviousDaybtn.setText("Previous Day");
        PreviousDaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousDaybtnActionPerformed(evt);
            }
        });
        NextDaysPanel.add(PreviousDaybtn);

        NextDaybtn.setText("Next Day");
        NextDaysPanel.add(NextDaybtn);

        javax.swing.GroupLayout DailyPanelLayout = new javax.swing.GroupLayout(DailyPanel);
        DailyPanel.setLayout(DailyPanelLayout);
        DailyPanelLayout.setHorizontalGroup(
            DailyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DailyChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(DailyChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(DailyTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NextDaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Daily", DailyPanel);

        weeklyChartPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        weeklyChartPanel.setLayout(new java.awt.BorderLayout(10, 10));

        WeeksTitlePanel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        WeeksLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        WeeksLabel.setText("7 March - 14 March");
        WeeksTitlePanel.add(WeeksLabel);

        PreviousWeeksbtn.setText("Previous Weeks");
        PreviousWeeksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousWeeksbtnActionPerformed(evt);
            }
        });
        ActionButtonPanel.add(PreviousWeeksbtn);

        NextWeeksbtn.setText("Next Weeks");
        NextWeeksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextWeeksbtnActionPerformed(evt);
            }
        });
        ActionButtonPanel.add(NextWeeksbtn);

        javax.swing.GroupLayout WeeklyPanelLayout = new javax.swing.GroupLayout(WeeklyPanel);
        WeeklyPanel.setLayout(WeeklyPanelLayout);
        WeeklyPanelLayout.setHorizontalGroup(
            WeeklyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WeeklyPanelLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(WeeklyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WeeksTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActionButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
            .addComponent(weeklyChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        WeeklyPanelLayout.setVerticalGroup(
            WeeklyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WeeklyPanelLayout.createSequentialGroup()
                .addComponent(weeklyChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(WeeksTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ActionButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Weekly", WeeklyPanel);

        ActivityPanel.setLayout(new javax.swing.BoxLayout(ActivityPanel, javax.swing.BoxLayout.LINE_AXIS));

        ActivityTable.setLayout(new javax.swing.BoxLayout(ActivityTable, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
                "Category", "Sub-Category", "Specific Type", "Calculation Metric", "Emission Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        ActivityTable.add(jScrollPane1);

        ActionBtn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 30));

        AddNewActivitybtn.setText("Add new activity");
        AddNewActivitybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewActivitybtnActionPerformed(evt);
            }
        });
        ActionBtn.add(AddNewActivitybtn);

        EditActivitybtn.setText("Edit activity");
        EditActivitybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActivitybtnActionPerformed(evt);
            }
        });
        ActionBtn.add(EditActivitybtn);

        jButton1.setText("Delete activity");
        ActionBtn.add(jButton1);

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
    }//GEN-LAST:event_NextWeeksbtnActionPerformed

    private void PreviousWeeksbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousWeeksbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousWeeksbtnActionPerformed

    
    private void PreviousDaybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousDaybtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousDaybtnActionPerformed

    private void AddNewActivitybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewActivitybtnActionPerformed
        // TODO add your handling code here:
       new ActivityForm().setVisible(true);
    }//GEN-LAST:event_AddNewActivitybtnActionPerformed

    private void EditActivitybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActivitybtnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_EditActivitybtnActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    
    private void ChartSetup() {
        DefaultPieDataset weeklyDataset = DatasetFactory.weeklyChartDataset(activities);
        
        JFreeChart pieChart = ChartFactory.createPieChart("Weekly data", weeklyDataset);
        PiePlot plot = (PiePlot) pieChart.getPlot();
        
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
                
        ChartPanel chartpanel = new ChartPanel(pieChart);
        weeklyChartPanel.add(chartpanel, BorderLayout.CENTER);


        DefaultCategoryDataset dailyDataset = new DefaultCategoryDataset();
        dailyDataset.addValue(300, "Daily Report", "7 March");
        dailyDataset.addValue(200, "Daily Report", "8 March");
        dailyDataset.addValue(150, "Daily Report", "9 March");
        dailyDataset.addValue(100, "Daily Report", "10 March");

        JFreeChart Barchart = ChartFactory.createBarChart("Daily Report", "Day", "Daily Report", dailyDataset);

        ChartPanel dailypanel = new ChartPanel (Barchart);
        DailyChartPanel.add(dailypanel, BorderLayout.CENTER);
                       
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
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ActionBtn;
    private javax.swing.JPanel ActionButtonPanel;
    private javax.swing.JPanel ActivityPanel;
    private javax.swing.JPanel ActivityTable;
    private javax.swing.JButton AddNewActivitybtn;
    private javax.swing.JPanel DailyChartPanel;
    private javax.swing.JPanel DailyPanel;
    private javax.swing.JLabel DailyTitle;
    private javax.swing.JPanel DailyTitlePanel;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JButton EditActivitybtn;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton NextDaybtn;
    private javax.swing.JPanel NextDaysPanel;
    private javax.swing.JButton NextWeeksbtn;
    private javax.swing.JButton PreviousDaybtn;
    private javax.swing.JButton PreviousWeeksbtn;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JPanel WeeklyPanel;
    private javax.swing.JLabel WeeksLabel;
    private javax.swing.JPanel WeeksTitlePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel weeklyChartPanel;
    // End of variables declaration//GEN-END:variables

}