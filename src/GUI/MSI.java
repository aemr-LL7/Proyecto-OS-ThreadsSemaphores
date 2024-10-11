/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JFrame;

/**
 *
 * @author andre
 */
public class MSI extends javax.swing.JFrame {

    /**
     * Creates new form MSI
     */
    public MSI() {
        initComponents();
         // properties gui
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("MSI Module");
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
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        penaltyPM = new javax.swing.JTextField();
        statusPM = new javax.swing.JTextField();
        infractionPM = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        statusDirector = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        totalProfitMSI = new javax.swing.JTextField();
        bruteProfitMSI = new javax.swing.JTextField();
        costsMSI = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        decreaseMOBO2 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        increaseMOBO2 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        decreaseCPU2 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        increaseCPU2 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        decreaseRAM2 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        increaseRAM2 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        decreasePSU2 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        increasePSU2 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        decreaseGPU2 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        increaseGPU2 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        saveConfigBtn1 = new javax.swing.JLabel();
        maxCapacityMSI = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        MOBO_QTY = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        RAM_QTY = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        PSU_QTY = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        GPU_QTY = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        CPU_QTY = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(39, 157, 39));
        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(45, 45, 45, 45));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI.Assets/msi_icon.png"))); // NOI18N
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 50));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 1200, 70));

        jPanel2.setBackground(new java.awt.Color(51, 88, 137));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(222, 222, 242));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel8.setText("DIRECTOR");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 250, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel10.setText("Penalizacion ($):");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel13.setText("Estado:");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, -1));

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel14.setText("Faltas:");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, -1));

        penaltyPM.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        penaltyPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        penaltyPM.setText("0");
        jPanel10.add(penaltyPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 90, -1));

        statusPM.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        statusPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusPM.setText("(En espera)");
        jPanel10.add(statusPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, -1));

        infractionPM.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        infractionPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        infractionPM.setText("0");
        jPanel10.add(infractionPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 150, -1));

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel16.setText("Estado:");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, -1));

        statusDirector.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        statusDirector.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusDirector.setText("0");
        jPanel10.add(statusDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 150, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel18.setText("Ganancia neta: ");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, -1));

        jLabel19.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel19.setText("Costos operativos:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, -1));

        jLabel20.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel20.setText("Ganancia bruta:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, -1));

        totalProfitMSI.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        totalProfitMSI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalProfitMSI.setText("0");
        jPanel4.add(totalProfitMSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 150, -1));

        bruteProfitMSI.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        bruteProfitMSI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bruteProfitMSI.setText("0");
        jPanel4.add(bruteProfitMSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 150, -1));

        costsMSI.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        costsMSI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        costsMSI.setText("0");
        jPanel4.add(costsMSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 150, -1));

        jLabel21.setFont(new java.awt.Font("HP Simplified", 3, 19)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("COSTOS DE PRODUCCIÓN / GANANCIAS");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 310, -1));

        jPanel10.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 410, 460));

        jLabel17.setFont(new java.awt.Font("HP Simplified", 3, 19)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Estado del PROJECT MANAGER");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, -1));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 710, 320));

        jPanel12.setBackground(new java.awt.Color(222, 222, 242));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("HP Simplified", 1, 18)); // NOI18N
        jLabel11.setText("Micro-Star International");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, -1));

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jLabel12.setText("Máximo:");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        jPanel18.setBackground(new java.awt.Color(109, 86, 164));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Trabajador Placa Base:");
        jPanel18.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        decreaseMOBO2.setBackground(new java.awt.Color(214, 125, 178));
        decreaseMOBO2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        decreaseMOBO2.setForeground(new java.awt.Color(255, 255, 255));
        decreaseMOBO2.setText("-");
        decreaseMOBO2.setBorder(null);
        decreaseMOBO2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel18.add(decreaseMOBO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 30, 20));

        jTextField7.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField7.setFocusable(false);
        jPanel18.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 30, -1));

        increaseMOBO2.setBackground(new java.awt.Color(214, 125, 178));
        increaseMOBO2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        increaseMOBO2.setForeground(new java.awt.Color(255, 255, 255));
        increaseMOBO2.setText("+");
        increaseMOBO2.setBorder(null);
        increaseMOBO2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel18.add(increaseMOBO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 20));

        jPanel12.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 350, 40));

        jPanel19.setBackground(new java.awt.Color(109, 86, 164));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Trabajador CPU:");
        jPanel19.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        decreaseCPU2.setBackground(new java.awt.Color(214, 125, 178));
        decreaseCPU2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        decreaseCPU2.setForeground(new java.awt.Color(255, 255, 255));
        decreaseCPU2.setText("-");
        decreaseCPU2.setBorder(null);
        decreaseCPU2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel19.add(decreaseCPU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 30, 20));

        jTextField8.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");
        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField8.setFocusable(false);
        jPanel19.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 30, -1));

        increaseCPU2.setBackground(new java.awt.Color(214, 125, 178));
        increaseCPU2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        increaseCPU2.setForeground(new java.awt.Color(255, 255, 255));
        increaseCPU2.setText("+");
        increaseCPU2.setBorder(null);
        increaseCPU2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel19.add(increaseCPU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 20));

        jPanel12.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 350, 40));

        jPanel20.setBackground(new java.awt.Color(109, 86, 164));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Trabajador RAM:");
        jPanel20.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        decreaseRAM2.setBackground(new java.awt.Color(214, 125, 178));
        decreaseRAM2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        decreaseRAM2.setForeground(new java.awt.Color(255, 255, 255));
        decreaseRAM2.setText("-");
        decreaseRAM2.setBorder(null);
        decreaseRAM2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel20.add(decreaseRAM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 30, 20));

        jTextField9.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");
        jTextField9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField9.setFocusable(false);
        jPanel20.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 30, -1));

        increaseRAM2.setBackground(new java.awt.Color(214, 125, 178));
        increaseRAM2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        increaseRAM2.setForeground(new java.awt.Color(255, 255, 255));
        increaseRAM2.setText("+");
        increaseRAM2.setBorder(null);
        increaseRAM2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel20.add(increaseRAM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 20));

        jPanel12.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 350, 40));

        jPanel21.setBackground(new java.awt.Color(109, 86, 164));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Trabajador Fuente:");
        jPanel21.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        decreasePSU2.setBackground(new java.awt.Color(214, 125, 178));
        decreasePSU2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        decreasePSU2.setForeground(new java.awt.Color(255, 255, 255));
        decreasePSU2.setText("-");
        decreasePSU2.setBorder(null);
        decreasePSU2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel21.add(decreasePSU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 30, 20));

        jTextField10.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("0");
        jTextField10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField10.setFocusable(false);
        jPanel21.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 30, -1));

        increasePSU2.setBackground(new java.awt.Color(214, 125, 178));
        increasePSU2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        increasePSU2.setForeground(new java.awt.Color(255, 255, 255));
        increasePSU2.setText("+");
        increasePSU2.setBorder(null);
        increasePSU2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel21.add(increasePSU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 20));

        jPanel12.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 350, 40));

        jPanel22.setBackground(new java.awt.Color(109, 86, 164));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Trabajador Gráfica:");
        jPanel22.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        decreaseGPU2.setBackground(new java.awt.Color(214, 125, 178));
        decreaseGPU2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        decreaseGPU2.setForeground(new java.awt.Color(255, 255, 255));
        decreaseGPU2.setText("-");
        decreaseGPU2.setBorder(null);
        decreaseGPU2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel22.add(decreaseGPU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 30, 20));

        jTextField11.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("0");
        jTextField11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField11.setFocusable(false);
        jPanel22.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 30, -1));

        increaseGPU2.setBackground(new java.awt.Color(214, 125, 178));
        increaseGPU2.setFont(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        increaseGPU2.setForeground(new java.awt.Color(255, 255, 255));
        increaseGPU2.setText("+");
        increaseGPU2.setBorder(null);
        increaseGPU2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel22.add(increaseGPU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 20));

        jPanel12.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 350, 40));

        jPanel23.setBackground(new java.awt.Color(122, 122, 220));
        jPanel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(45, 45, 45, 45));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveConfigBtn1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        saveConfigBtn1.setForeground(new java.awt.Color(255, 255, 255));
        saveConfigBtn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveConfigBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI.Assets/ribbon_icon.png"))); // NOI18N
        saveConfigBtn1.setText(" Guardar");
        saveConfigBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveConfigBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveConfigBtn1MouseClicked(evt);
            }
        });
        jPanel23.add(saveConfigBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        jPanel12.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 180, 50));

        maxCapacityMSI.setBackground(new java.awt.Color(222, 222, 242));
        maxCapacityMSI.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        maxCapacityMSI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        maxCapacityMSI.setText("0");
        jPanel12.add(maxCapacityMSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, -1));

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 380, 460));

        jPanel5.setBackground(new java.awt.Color(143, 126, 169));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(109, 86, 164));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Placa Base:");
        jPanel24.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        MOBO_QTY.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        MOBO_QTY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MOBO_QTY.setText("0");
        jPanel24.add(MOBO_QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, -1));

        jPanel5.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 280, 40));

        jPanel26.setBackground(new java.awt.Color(109, 86, 164));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("RAM:");
        jPanel26.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        RAM_QTY.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        RAM_QTY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RAM_QTY.setText("0");
        jPanel26.add(RAM_QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, -1));

        jPanel5.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 260, 40));

        jPanel27.setBackground(new java.awt.Color(109, 86, 164));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Fuente:");
        jPanel27.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        PSU_QTY.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        PSU_QTY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PSU_QTY.setText("0");
        jPanel27.add(PSU_QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, -1));

        jPanel5.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 280, 40));

        jPanel28.setBackground(new java.awt.Color(109, 86, 164));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Tarjeta Gráfica");
        jPanel28.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        GPU_QTY.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        GPU_QTY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GPU_QTY.setText("0");
        jPanel28.add(GPU_QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 110, -1));

        jPanel5.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 280, 40));

        jLabel32.setFont(new java.awt.Font("HP Simplified", 3, 19)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("DISPONIBILIDAD ACTUAL");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 210, -1));

        jPanel29.setBackground(new java.awt.Color(109, 86, 164));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("CPU:");
        jPanel29.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        CPU_QTY.setFont(new java.awt.Font("HP Simplified", 1, 13)); // NOI18N
        CPU_QTY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CPU_QTY.setText("0");
        jPanel29.add(CPU_QTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, -1));

        jPanel5.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 260, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 710, 260));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1200, 650));

        jPanel3.setBackground(new java.awt.Color(63, 63, 140));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI.Assets/parenthesis_icon.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jPanel6.setBackground(new java.awt.Color(121, 121, 176));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(45, 45, 45, 45));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI.Assets/settings_icon.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 60, 60));

        jPanel9.setBackground(new java.awt.Color(121, 121, 176));
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(45, 45, 45, 45));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI.Assets/chart_icon.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 60));

        jPanel7.setBackground(new java.awt.Color(124, 100, 145));
        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(45, 45, 45, 45));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI.Assets/hp32_icon.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 60));

        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI.Assets/exit_icon.png"))); // NOI18N
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });
        jPanel3.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 60, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Parameters params = new Parameters();
        params.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Home goBackHome = new Home();
        goBackHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Dashboard dashboard = Dashboard.getDashBoardInstance();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HP goHP = new HP();
        goHP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void saveConfigBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveConfigBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_saveConfigBtn1MouseClicked

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
            java.util.logging.Logger.getLogger(MSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MSI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPU_QTY;
    private javax.swing.JTextField GPU_QTY;
    private javax.swing.JTextField MOBO_QTY;
    private javax.swing.JTextField PSU_QTY;
    private javax.swing.JTextField RAM_QTY;
    private javax.swing.JTextField bruteProfitMSI;
    private javax.swing.JTextField costsMSI;
    private javax.swing.JButton decreaseCPU2;
    private javax.swing.JButton decreaseGPU2;
    private javax.swing.JButton decreaseMOBO2;
    private javax.swing.JButton decreasePSU2;
    private javax.swing.JButton decreaseRAM2;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JButton increaseCPU2;
    private javax.swing.JButton increaseGPU2;
    private javax.swing.JButton increaseMOBO2;
    private javax.swing.JButton increasePSU2;
    private javax.swing.JButton increaseRAM2;
    private javax.swing.JTextField infractionPM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField maxCapacityMSI;
    private javax.swing.JTextField penaltyPM;
    private javax.swing.JLabel saveConfigBtn1;
    private javax.swing.JTextField statusDirector;
    private javax.swing.JTextField statusPM;
    private javax.swing.JTextField totalProfitMSI;
    // End of variables declaration//GEN-END:variables
}
