package View;

import Controller.Controller;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GameCorner extends javax.swing.JFrame {
    
    //Inisiasi Variabel
    DefaultTableCellRenderer tabel = new DefaultTableCellRenderer();
    Controller controller = new Controller();
    CardLayout mainPanel, adminPanel;
    DefaultTableModel tabelDash, tabelPengguna, tabelRental, tabelTV;
    Timer penjadwalan = new Timer();
    TimerTask refreshTabel = new TimerTask() {
        @Override
        public void run() {
            controller.refreshStatusPeminjaman();
            refreshTabelPeminjaman();
            refreshTabelOverview();
            refreshAvailableTV();
        } 
    };  
    
    public GameCorner() {
        
        // Bawaan Netbeans
        initComponents();
        
        // Center alignment tabel
        tabel.setHorizontalAlignment(JLabel.CENTER);
                
        // Insisasi model tabel
        tabelDash = (DefaultTableModel) tabelDashAdm.getModel();
        tabelPengguna = (DefaultTableModel) tabelUsrAdm.getModel();
        tabelRental = (DefaultTableModel) tabelRentalAdm.getModel();
        tabelTV = (DefaultTableModel) tabelTVAdm.getModel();
        
        // Atur gaya tabel
        JTable[] kumpulanTabel = {tabelDashAdm, tabelUsrAdm, tabelRentalAdm, tabelTVAdm};
        for(JTable tabels : kumpulanTabel) {
        tabels.getTableHeader().setBackground(Color.decode("#00717F"));
        tabels.getTableHeader().setForeground(Color.white);
        tabels.getTableHeader().setFont(new java.awt.Font("Poppins SemiBold", 0, 10));
        tabels.getTableHeader().setPreferredSize(new Dimension(WIDTH, 30));
        tabels.setDefaultRenderer(String.class, tabel);
        }
        
        tabelTVAdm.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelTVAdm.getColumnModel().getColumn(0).setMaxWidth(50);
        tabelUsrAdm.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelUsrAdm.getColumnModel().getColumn(0).setMaxWidth(50);
        tabelPengguna.isCellEditable(0, 0);
        
        // Assignment card layout ke variabel
        this.mainPanel = (CardLayout) getContentPane().getLayout();
        this.adminPanel = (CardLayout) (mainPanelAdmin.getLayout());

        // Tampilan login
        mainPanel.show(getContentPane(), "login");
        
        // Jalankan penjadwalan
        penjadwalan.scheduleAtFixedRate(refreshTabel, 0, 1000);
    }
    
    private void initComponents() {

        loginPage = new javax.swing.JPanel();
        logoFilkom = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        alertUser = new javax.swing.JLabel();
        alertPass = new javax.swing.JLabel();
        adminPage = new javax.swing.JPanel();
        sideBarAdmin = new javax.swing.JPanel();
        logoutButtonAdm = new javax.swing.JButton();
        dashButtonAdm = new javax.swing.JButton();
        reqButtonAdm = new javax.swing.JButton();
        tvButtonAdm = new javax.swing.JButton();
        userButtonAdm = new javax.swing.JButton();
        topBarAdmin = new javax.swing.JPanel();
        logoAdm = new javax.swing.JLabel();
        mainPanelAdmin = new javax.swing.JPanel();
        dashAdmin = new javax.swing.JPanel();
        headingAdm = new javax.swing.JLabel();
        overviewReadyAdm = new javax.swing.JPanel();
        readyNum = new javax.swing.JLabel();
        readyIcon = new javax.swing.JLabel();
        readyLabel = new javax.swing.JLabel();
        scrollPaneDashAdm = new javax.swing.JScrollPane();
        tabelDashAdm = new javax.swing.JTable();
        pinjamAdmin = new javax.swing.JPanel();
        scrollPanePinjam = new javax.swing.JScrollPane();
        tabelRentalAdm = new javax.swing.JTable();
        headingPinjam = new javax.swing.JLabel();
        addPinjamButton = new javax.swing.JButton();
        saveHistoryButton = new javax.swing.JButton();
        tvAdmin = new javax.swing.JPanel();
        scrollPaneTV = new javax.swing.JScrollPane();
        tabelTVAdm = new javax.swing.JTable();
        hradingTV2 = new javax.swing.JLabel();
        addTVButton = new javax.swing.JButton();
        editTVButton = new javax.swing.JButton();
        delTVButton = new javax.swing.JButton();
        usrAdmin = new javax.swing.JPanel();
        scrollPaneUsrAdmin = new javax.swing.JScrollPane();
        tabelUsrAdm = new javax.swing.JTable();
        headingUsrAdmin2 = new javax.swing.JLabel();
        addUserButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        delUserButton = new javax.swing.JButton();
        addUsrAdmin = new javax.swing.JPanel();
        headingAddUsr = new javax.swing.JLabel();
        addUsrBackButton = new javax.swing.JButton();
        addUsrSimpanButton = new javax.swing.JButton();
        namaUserLabel = new javax.swing.JLabel();
        idUserLabel = new javax.swing.JLabel();
        nomorUserLabel = new javax.swing.JLabel();
        roleUserLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passWordLabel = new javax.swing.JLabel();
        fieldIdAdd = new javax.swing.JTextField();
        fieldNamaAdd = new javax.swing.JTextField();
        fieldNomorAdd = new javax.swing.JTextField();
        fieldRoleAdd = new javax.swing.JComboBox<>();
        fieldUnameAdd = new javax.swing.JTextField();
        fieldPwordAdd = new javax.swing.JTextField();
        alertNamaAdd = new javax.swing.JLabel();
        alertIDAdd = new javax.swing.JLabel();
        alertNomorAdd = new javax.swing.JLabel();
        alertRoleAdd = new javax.swing.JLabel();
        alertUnameAdd = new javax.swing.JLabel();
        alertPwordAdd = new javax.swing.JLabel();
        editUsrAdmin = new javax.swing.JPanel();
        headingEditUsr = new javax.swing.JLabel();
        EditUsrBackButton = new javax.swing.JButton();
        EditUsrSimpanButton = new javax.swing.JButton();
        idUserLabelEdit = new javax.swing.JLabel();
        namaUserLabelEdit = new javax.swing.JLabel();
        nomorUserLabelEdit = new javax.swing.JLabel();
        roleUserLabelEdit = new javax.swing.JLabel();
        userNameLabelEdit = new javax.swing.JLabel();
        passWordLabelEdit = new javax.swing.JLabel();
        fieldIDEdit = new javax.swing.JTextField();
        fieldNameEdit = new javax.swing.JTextField();
        fieldNomorEdit = new javax.swing.JTextField();
        fieldRoleEdit = new javax.swing.JComboBox<>();
        fieldUnameEdit = new javax.swing.JTextField();
        fieldPwordEdit = new javax.swing.JTextField();
        alertNamaEdit = new javax.swing.JLabel();
        alertIDEdit = new javax.swing.JLabel();
        alertNomorEdit = new javax.swing.JLabel();
        alertRoleEdit = new javax.swing.JLabel();
        alertUnameEdit = new javax.swing.JLabel();
        alertPwordEdit = new javax.swing.JLabel();
        addTVAdmin = new javax.swing.JPanel();
        headingAddTV = new javax.swing.JLabel();
        addTVBackButton = new javax.swing.JButton();
        addTVSimpanButton = new javax.swing.JButton();
        nomotTVLabel = new javax.swing.JLabel();
        jenisTVLabel = new javax.swing.JLabel();
        statusTVLabel = new javax.swing.JLabel();
        fieldNoTVAdd = new javax.swing.JTextField();
        fieldStatTVAdd = new javax.swing.JComboBox<>();
        fieldJenisTVAdd = new javax.swing.JComboBox<>();
        alertNomorTV = new javax.swing.JLabel();
        editTVAdmin = new javax.swing.JPanel();
        headingEditTV = new javax.swing.JLabel();
        editTVBackButton = new javax.swing.JButton();
        editTVSimpanButton = new javax.swing.JButton();
        nomotTVLabelEdit = new javax.swing.JLabel();
        jenisTVLabelEdit = new javax.swing.JLabel();
        statusTVLabelEdit = new javax.swing.JLabel();
        fieldNoTVEdit = new javax.swing.JTextField();
        fieldStatTVEdit = new javax.swing.JComboBox<>();
        fieldJenisTVEdit = new javax.swing.JComboBox<>();
        alertNomorTVEdit = new javax.swing.JLabel();
        addPinjamAdmin = new javax.swing.JPanel();
        headingPinjamAdd = new javax.swing.JLabel();
        backButtonPinjamAdd = new javax.swing.JButton();
        simpanButtonPinjamAdd = new javax.swing.JButton();
        idPinjamAdd = new javax.swing.JLabel();
        noTVPinjamAdd = new javax.swing.JLabel();
        sesiPinjamAdd = new javax.swing.JLabel();
        fieldIDPinjamAdd = new javax.swing.JTextField();
        alertNamaPinjamAdd = new javax.swing.JLabel();
        fieldNoTVPinjamAdd = new javax.swing.JComboBox<>();
        fieldSesiPinjamAdd = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        loginPage.setBackground(new java.awt.Color(255, 255, 255));
        loginPage.setForeground(new java.awt.Color(0, 0, 0));
        loginPage.setMinimumSize(new java.awt.Dimension(800, 600));
        loginPage.setPreferredSize(new java.awt.Dimension(800, 600));

        logoFilkom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoFilkom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/filkom.png"))); 

        heading.setFont(new java.awt.Font("Poppins SemiBold", 0, 48)); 
        heading.setForeground(new java.awt.Color(255, 102, 0));
        heading.setText("Game Corner");

        usernameLabel.setFont(new java.awt.Font("Poppins", 0, 12)); 
        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username");

        usernameField.setBackground(new java.awt.Color(255, 244, 229));
        usernameField.setFont(new java.awt.Font("Calibri", 0, 12)); 
        usernameField.setForeground(new java.awt.Color(0, 0, 0));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        passwordLabel.setFont(new java.awt.Font("Poppins", 0, 12)); 
        passwordLabel.setForeground(new java.awt.Color(0, 0, 0));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Password");

        loginButton.setBackground(new java.awt.Color(255, 166, 107));
        loginButton.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); 
        loginButton.setForeground(new java.awt.Color(0, 0, 0));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passwordField.setBackground(new java.awt.Color(255, 244, 229));
        passwordField.setFont(new java.awt.Font("Calibri", 0, 12)); 
        passwordField.setForeground(new java.awt.Color(0, 0, 0));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alertUser.setFont(new java.awt.Font("Poppins Light", 0, 8)); 
        alertUser.setForeground(new java.awt.Color(255, 255, 255));
        alertUser.setText("Username belum terisi!");

        alertPass.setFont(new java.awt.Font("Poppins Light", 0, 8)); 
        alertPass.setForeground(new java.awt.Color(255, 255, 255));
        alertPass.setText("Username belum terisi!");

        javax.swing.GroupLayout loginPageLayout = new javax.swing.GroupLayout(loginPage);
        loginPage.setLayout(loginPageLayout);
        loginPageLayout.setHorizontalGroup(
            loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPageLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addGroup(loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoFilkom, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(heading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(alertUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alertPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(loginPageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPageLayout.setVerticalGroup(
            loginPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPageLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(logoFilkom)
                .addGap(18, 18, 18)
                .addComponent(heading)
                .addGap(18, 18, 18)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(alertUser)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(alertPass)
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        getContentPane().add(loginPage, "login");

        adminPage.setBackground(new java.awt.Color(255, 255, 255));
        adminPage.setForeground(new java.awt.Color(0, 0, 0));
        adminPage.setMinimumSize(new java.awt.Dimension(800, 600));
        adminPage.setPreferredSize(new java.awt.Dimension(800, 600));

        sideBarAdmin.setBackground(new java.awt.Color(255, 156, 81));
        sideBarAdmin.setForeground(new java.awt.Color(0, 0, 0));
        sideBarAdmin.setMinimumSize(new java.awt.Dimension(130, 530));
        sideBarAdmin.setPreferredSize(new java.awt.Dimension(130, 530));

        logoutButtonAdm.setBackground(new java.awt.Color(255, 236, 224));
        logoutButtonAdm.setFont(new java.awt.Font("Poppins", 1, 10)); 
        logoutButtonAdm.setForeground(new java.awt.Color(0, 0, 0));
        logoutButtonAdm.setText("Log Out");
        logoutButtonAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutButtonAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonAdmActionPerformed(evt);
            }
        });

        dashButtonAdm.setBackground(new java.awt.Color(255, 236, 224));
        dashButtonAdm.setFont(new java.awt.Font("Poppins", 1, 10)); 
        dashButtonAdm.setForeground(new java.awt.Color(0, 0, 0));
        dashButtonAdm.setText("Dashboard");
        dashButtonAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dashButtonAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashButtonAdmActionPerformed(evt);
            }
        });

        reqButtonAdm.setBackground(new java.awt.Color(255, 236, 224));
        reqButtonAdm.setFont(new java.awt.Font("Poppins", 1, 10)); 
        reqButtonAdm.setForeground(new java.awt.Color(0, 0, 0));
        reqButtonAdm.setText("Peminjaman");
        reqButtonAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reqButtonAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqButtonAdmActionPerformed(evt);
            }
        });

        tvButtonAdm.setBackground(new java.awt.Color(255, 236, 224));
        tvButtonAdm.setFont(new java.awt.Font("Poppins", 1, 10)); 
        tvButtonAdm.setForeground(new java.awt.Color(0, 0, 0));
        tvButtonAdm.setText("TV");
        tvButtonAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tvButtonAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvButtonAdmActionPerformed(evt);
            }
        });

        userButtonAdm.setBackground(new java.awt.Color(255, 236, 224));
        userButtonAdm.setFont(new java.awt.Font("Poppins", 1, 10)); 
        userButtonAdm.setForeground(new java.awt.Color(0, 0, 0));
        userButtonAdm.setText("Pengguna");
        userButtonAdm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userButtonAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonAdmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarAdminLayout = new javax.swing.GroupLayout(sideBarAdmin);
        sideBarAdmin.setLayout(sideBarAdminLayout);
        sideBarAdminLayout.setHorizontalGroup(
            sideBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarAdminLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(sideBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reqButtonAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(userButtonAdm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashButtonAdm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(tvButtonAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(logoutButtonAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        sideBarAdminLayout.setVerticalGroup(
            sideBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarAdminLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(dashButtonAdm)
                .addGap(18, 18, 18)
                .addComponent(reqButtonAdm)
                .addGap(18, 18, 18)
                .addComponent(tvButtonAdm)
                .addGap(18, 18, 18)
                .addComponent(userButtonAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButtonAdm)
                .addGap(30, 30, 30))
        );

        topBarAdmin.setBackground(new java.awt.Color(255, 236, 224));
        topBarAdmin.setForeground(new java.awt.Color(0, 0, 0));
        topBarAdmin.setMinimumSize(new java.awt.Dimension(700, 70));
        topBarAdmin.setPreferredSize(new java.awt.Dimension(700, 70));

        logoAdm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/filkom.png"))); 

        javax.swing.GroupLayout topBarAdminLayout = new javax.swing.GroupLayout(topBarAdmin);
        topBarAdmin.setLayout(topBarAdminLayout);
        topBarAdminLayout.setHorizontalGroup(
            topBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoAdm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBarAdminLayout.setVerticalGroup(
            topBarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        mainPanelAdmin.setForeground(new java.awt.Color(0, 0, 0));
        mainPanelAdmin.setMinimumSize(new java.awt.Dimension(670, 530));
        mainPanelAdmin.setPreferredSize(new java.awt.Dimension(670, 530));
        mainPanelAdmin.setLayout(new java.awt.CardLayout());

        dashAdmin.setBackground(new java.awt.Color(255, 255, 255));
        dashAdmin.setForeground(new java.awt.Color(0, 0, 0));
        dashAdmin.setMinimumSize(new java.awt.Dimension(670, 530));
        dashAdmin.setPreferredSize(new java.awt.Dimension(670, 530));

        headingAdm.setFont(new java.awt.Font("Poppins", 0, 24)); 
        headingAdm.setForeground(new java.awt.Color(0, 0, 0));
        headingAdm.setText("Selamat Datang, Admin!");

        overviewReadyAdm.setBackground(new java.awt.Color(255, 191, 142));
        overviewReadyAdm.setMinimumSize(new java.awt.Dimension(295, 125));
        overviewReadyAdm.setPreferredSize(new java.awt.Dimension(295, 125));

        readyNum.setFont(new java.awt.Font("Poppins", 0, 36)); 
        readyNum.setForeground(new java.awt.Color(0, 0, 0));
        readyNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        readyNum.setText("0");

        readyIcon.setFont(new java.awt.Font("Poppins", 0, 56)); 
        readyIcon.setForeground(new java.awt.Color(0, 0, 0));
        readyIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        readyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/ready.png"))); 

        readyLabel.setFont(new java.awt.Font("Poppins", 0, 14)); 
        readyLabel.setForeground(new java.awt.Color(0, 0, 0));
        readyLabel.setText("Tersedia");

        javax.swing.GroupLayout overviewReadyAdmLayout = new javax.swing.GroupLayout(overviewReadyAdm);
        overviewReadyAdm.setLayout(overviewReadyAdmLayout);
        overviewReadyAdmLayout.setHorizontalGroup(
            overviewReadyAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, overviewReadyAdmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(readyIcon)
                .addGap(20, 20, 20)
                .addGroup(overviewReadyAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(readyLabel)
                    .addComponent(readyNum))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        overviewReadyAdmLayout.setVerticalGroup(
            overviewReadyAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overviewReadyAdmLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(overviewReadyAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(overviewReadyAdmLayout.createSequentialGroup()
                        .addComponent(readyNum, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(readyLabel))
                    .addComponent(readyIcon))
                .addGap(25, 25, 25))
        );

        tabelDashAdm.setBackground(new java.awt.Color(255, 255, 255));
        tabelDashAdm.setFont(new java.awt.Font("Calibri", 0, 13));
        tabelDashAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor TV", "Peminjam", "Sisa Waktu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelDashAdm.setFillsViewportHeight(true);
        tabelDashAdm.setRowHeight(40);
        scrollPaneDashAdm.setViewportView(tabelDashAdm);

        javax.swing.GroupLayout dashAdminLayout = new javax.swing.GroupLayout(dashAdmin);
        dashAdmin.setLayout(dashAdminLayout);
        dashAdminLayout.setHorizontalGroup(
            dashAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashAdminLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(dashAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPaneDashAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dashAdminLayout.createSequentialGroup()
                        .addComponent(headingAdm)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(overviewReadyAdm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        dashAdminLayout.setVerticalGroup(
            dashAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashAdminLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(headingAdm)
                .addGap(35, 35, 35)
                .addComponent(overviewReadyAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneDashAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        mainPanelAdmin.add(dashAdmin, "dashboard");

        pinjamAdmin.setBackground(new java.awt.Color(255, 255, 255));
        pinjamAdmin.setForeground(new java.awt.Color(0, 0, 0));
        pinjamAdmin.setMinimumSize(new java.awt.Dimension(670, 530));
        pinjamAdmin.setPreferredSize(new java.awt.Dimension(670, 530));

        tabelRentalAdm.setBackground(new java.awt.Color(255, 255, 255));
        tabelRentalAdm.setForeground(new java.awt.Color(0, 0, 0));
        tabelRentalAdm.setFont(new java.awt.Font("Calibri", 0, 13));
        tabelRentalAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Peminjam", "Nomor TV", "Tanggal", "Sesi", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelRentalAdm.setFillsViewportHeight(true);
        tabelRentalAdm.setRowHeight(35);
        scrollPanePinjam.setViewportView(tabelRentalAdm);

        headingPinjam.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        headingPinjam.setForeground(new java.awt.Color(255, 102, 0));
        headingPinjam.setText("Peminjaman Game Corner");

        addPinjamButton.setBackground(new java.awt.Color(255, 141, 66));
        addPinjamButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        addPinjamButton.setForeground(new java.awt.Color(255, 255, 255));
        addPinjamButton.setText("Tambah Peminjaman");
        addPinjamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPinjamButtonActionPerformed(evt);
            }
        });

        saveHistoryButton.setBackground(new java.awt.Color(255, 141, 66));
        saveHistoryButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        saveHistoryButton.setForeground(new java.awt.Color(255, 255, 255));
        saveHistoryButton.setText("Simpan Riyawat Peminjaman");
        saveHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHistoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pinjamAdminLayout = new javax.swing.GroupLayout(pinjamAdmin);
        pinjamAdmin.setLayout(pinjamAdminLayout);
        pinjamAdminLayout.setHorizontalGroup(
            pinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinjamAdminLayout.createSequentialGroup()
                .addGroup(pinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pinjamAdminLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(scrollPanePinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                    .addGroup(pinjamAdminLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveHistoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addPinjamButton)))
                .addGap(25, 25, 25))
            .addGroup(pinjamAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingPinjam)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pinjamAdminLayout.setVerticalGroup(
            pinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinjamAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(headingPinjam)
                .addGap(18, 18, 18)
                .addGroup(pinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPinjamButton)
                    .addComponent(saveHistoryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanePinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        mainPanelAdmin.add(pinjamAdmin, "peminjaman");

        tvAdmin.setBackground(new java.awt.Color(255, 255, 255));
        tvAdmin.setForeground(new java.awt.Color(0, 0, 0));
        tvAdmin.setMinimumSize(new java.awt.Dimension(670, 530));
        tvAdmin.setPreferredSize(new java.awt.Dimension(670, 530));

        tabelTVAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nomor TV", "Jenis", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelTVAdm.setFont(new java.awt.Font("Calibri", 0, 13));
        tabelTVAdm.setFillsViewportHeight(true);
        tabelTVAdm.setRowHeight(35);
        tabelTVAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelTVAdmMouseReleased(evt);
            }
        });
        scrollPaneTV.setViewportView(tabelTVAdm);

        hradingTV2.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        hradingTV2.setForeground(new java.awt.Color(255, 102, 0));
        hradingTV2.setText("Perangkat TV Game Corner");

        addTVButton.setBackground(new java.awt.Color(255, 141, 66));
        addTVButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        addTVButton.setForeground(new java.awt.Color(255, 255, 255));
        addTVButton.setText("Tambah TV");
        addTVButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTVButtonActionPerformed(evt);
            }
        });

        editTVButton.setBackground(new java.awt.Color(208, 198, 198));
        editTVButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        editTVButton.setForeground(new java.awt.Color(255, 255, 255));
        editTVButton.setText("Edit TV");
        editTVButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTVButtonActionPerformed(evt);
            }
        });

        delTVButton.setBackground(new java.awt.Color(208, 198, 198));
        delTVButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        delTVButton.setForeground(new java.awt.Color(255, 255, 255));
        delTVButton.setText("Hapus TV");
        delTVButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delTVButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tvAdminLayout = new javax.swing.GroupLayout(tvAdmin);
        tvAdmin.setLayout(tvAdminLayout);
        tvAdminLayout.setHorizontalGroup(
            tvAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tvAdminLayout.createSequentialGroup()
                .addGroup(tvAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tvAdminLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delTVButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editTVButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addTVButton))
                    .addGroup(tvAdminLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(scrollPaneTV, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(tvAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hradingTV2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tvAdminLayout.setVerticalGroup(
            tvAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tvAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(hradingTV2)
                .addGap(18, 18, 18)
                .addGroup(tvAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTVButton)
                    .addComponent(editTVButton)
                    .addComponent(delTVButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTV, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        mainPanelAdmin.add(tvAdmin, "tvmanagement");

        usrAdmin.setBackground(new java.awt.Color(255, 255, 255));
        usrAdmin.setForeground(new java.awt.Color(0, 0, 0));
        usrAdmin.setMinimumSize(new java.awt.Dimension(670, 530));
        usrAdmin.setPreferredSize(new java.awt.Dimension(670, 530));

        tabelUsrAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "NIM/NIP/NIDN", "Nama", "Nomor Telepon", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (rowIndex == 0) {
                    return false;
                }
                return canEdit [columnIndex];
            }
        });
        tabelUsrAdm.setFont(new java.awt.Font("Calibri", 0, 13));
        tabelUsrAdm.setFillsViewportHeight(true);
        tabelUsrAdm.setRowHeight(35);
        tabelUsrAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelUsrAdmMouseReleased(evt);
            }
        });
        scrollPaneUsrAdmin.setViewportView(tabelUsrAdm);

        headingUsrAdmin2.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        headingUsrAdmin2.setForeground(new java.awt.Color(255, 102, 0));
        headingUsrAdmin2.setText("Pengguna Game Corner");

        addUserButton.setBackground(new java.awt.Color(255, 141, 66));
        addUserButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        addUserButton.setForeground(new java.awt.Color(255, 255, 255));
        addUserButton.setText("Tambah Pengguna");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        editUserButton.setBackground(new java.awt.Color(208, 198, 198));
        editUserButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        editUserButton.setForeground(new java.awt.Color(255, 255, 255));
        editUserButton.setText("Edit Pengguna");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        delUserButton.setBackground(new java.awt.Color(208, 198, 198));
        delUserButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        delUserButton.setForeground(new java.awt.Color(255, 255, 255));
        delUserButton.setText("Hapus Pengguna");
        delUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usrAdminLayout = new javax.swing.GroupLayout(usrAdmin);
        usrAdmin.setLayout(usrAdminLayout);
        usrAdminLayout.setHorizontalGroup(
            usrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usrAdminLayout.createSequentialGroup()
                .addGroup(usrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(usrAdminLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delUserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editUserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addUserButton))
                    .addGroup(usrAdminLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(scrollPaneUsrAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(usrAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingUsrAdmin2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usrAdminLayout.setVerticalGroup(
            usrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usrAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(headingUsrAdmin2)
                .addGap(18, 18, 18)
                .addGroup(usrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserButton)
                    .addComponent(editUserButton)
                    .addComponent(delUserButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneUsrAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        mainPanelAdmin.add(usrAdmin, "usermanagement");

        addUsrAdmin.setBackground(new java.awt.Color(255, 255, 255));
        addUsrAdmin.setForeground(new java.awt.Color(0, 0, 0));
        addUsrAdmin.setMinimumSize(new java.awt.Dimension(670, 530));

        headingAddUsr.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        headingAddUsr.setForeground(new java.awt.Color(255, 102, 0));
        headingAddUsr.setText("Pendaftaran Pengguna Baru");

        addUsrBackButton.setBackground(new java.awt.Color(255, 141, 66));
        addUsrBackButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        addUsrBackButton.setForeground(new java.awt.Color(255, 255, 255));
        addUsrBackButton.setText("< Kembali");
        addUsrBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUsrBackButtonActionPerformed(evt);
            }
        });

        addUsrSimpanButton.setBackground(new java.awt.Color(255, 141, 66));
        addUsrSimpanButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        addUsrSimpanButton.setForeground(new java.awt.Color(255, 255, 255));
        addUsrSimpanButton.setText("Simpan");
        addUsrSimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUsrSimpanButtonActionPerformed(evt);
            }
        });

        namaUserLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        namaUserLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaUserLabel.setText("NIM/NIP/NIDN");

        idUserLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        idUserLabel.setForeground(new java.awt.Color(0, 0, 0));
        idUserLabel.setText("Nama");

        nomorUserLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        nomorUserLabel.setForeground(new java.awt.Color(0, 0, 0));
        nomorUserLabel.setText("Nomor Telepon");

        roleUserLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        roleUserLabel.setForeground(new java.awt.Color(0, 0, 0));
        roleUserLabel.setText("Role");

        userNameLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        userNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        userNameLabel.setText("Username");

        passWordLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        passWordLabel.setForeground(new java.awt.Color(0, 0, 0));
        passWordLabel.setText("Password");

        fieldIdAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldIdAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldIdAdd.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldIdAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldNamaAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldNamaAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldNamaAdd.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldNamaAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldNomorAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldNomorAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldNomorAdd.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldNomorAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldRoleAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldRoleAdd.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldRoleAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldRoleAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengguna", "Admin" }));
        fieldRoleAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldRoleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRoleAddActionPerformed(evt);
            }
        });

        fieldUnameAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldUnameAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldUnameAdd.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldUnameAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldUnameAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUnameAddActionPerformed(evt);
            }
        });

        fieldPwordAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldPwordAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldPwordAdd.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldPwordAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alertNamaAdd.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertNamaAdd.setForeground(new java.awt.Color(255, 255, 255));
        alertNamaAdd.setText("NIM/NIP/NIDN tidak boleh kosong!");

        alertIDAdd.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertIDAdd.setForeground(new java.awt.Color(255, 255, 255));
        alertIDAdd.setText("Nama tidak boleh kosong!");

        alertNomorAdd.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertNomorAdd.setForeground(new java.awt.Color(255, 255, 255));
        alertNomorAdd.setText("Nomor Telepon tidak boleh kosong!");

        alertRoleAdd.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertRoleAdd.setForeground(new java.awt.Color(255, 255, 255));
        alertRoleAdd.setText("Nama tidak boleh kosong!");

        alertUnameAdd.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertUnameAdd.setForeground(new java.awt.Color(255, 255, 255));
        alertUnameAdd.setText("Username tidak boleh kosong!");

        alertPwordAdd.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertPwordAdd.setForeground(new java.awt.Color(255, 255, 255));
        alertPwordAdd.setText("Password tidak boleh kosong!");

        javax.swing.GroupLayout addUsrAdminLayout = new javax.swing.GroupLayout(addUsrAdmin);
        addUsrAdmin.setLayout(addUsrAdminLayout);
        addUsrAdminLayout.setHorizontalGroup(
            addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUsrAdminLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addUsrAdminLayout.createSequentialGroup()
                        .addComponent(addUsrBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addUsrSimpanButton))
                    .addGroup(addUsrAdminLayout.createSequentialGroup()
                        .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(namaUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomorUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passWordLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleUserLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idUserLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(46, 46, 46)
                        .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNamaAdd)
                            .addComponent(fieldNomorAdd)
                            .addComponent(fieldRoleAdd, 0, 280, Short.MAX_VALUE)
                            .addComponent(fieldUnameAdd)
                            .addComponent(fieldPwordAdd)
                            .addComponent(alertNomorAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertIDAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertRoleAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertUnameAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertPwordAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertNamaAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldIdAdd))))
                .addGap(125, 125, 125))
            .addGroup(addUsrAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingAddUsr)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addUsrAdminLayout.setVerticalGroup(
            addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUsrAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(headingAddUsr)
                .addGap(50, 50, 50)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaUserLabel)
                    .addComponent(fieldIdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertNamaAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idUserLabel)
                    .addComponent(fieldNamaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertIDAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorUserLabel)
                    .addComponent(fieldNomorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertNomorAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleUserLabel)
                    .addComponent(fieldRoleAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertRoleAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(fieldUnameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertUnameAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passWordLabel)
                    .addComponent(fieldPwordAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertPwordAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(addUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUsrBackButton)
                    .addComponent(addUsrSimpanButton))
                .addGap(30, 30, 30))
        );

        mainPanelAdmin.add(addUsrAdmin, "adduser");

        editUsrAdmin.setBackground(new java.awt.Color(255, 255, 255));
        editUsrAdmin.setForeground(new java.awt.Color(0, 0, 0));
        editUsrAdmin.setMinimumSize(new java.awt.Dimension(670, 530));

        headingEditUsr.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        headingEditUsr.setForeground(new java.awt.Color(255, 102, 0));
        headingEditUsr.setText("Perubahan Data Pengguna");

        EditUsrBackButton.setBackground(new java.awt.Color(255, 141, 66));
        EditUsrBackButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        EditUsrBackButton.setForeground(new java.awt.Color(255, 255, 255));
        EditUsrBackButton.setText("< Kembali");
        EditUsrBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUsrBackButtonActionPerformed(evt);
            }
        });

        EditUsrSimpanButton.setBackground(new java.awt.Color(255, 141, 66));
        EditUsrSimpanButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        EditUsrSimpanButton.setForeground(new java.awt.Color(255, 255, 255));
        EditUsrSimpanButton.setText("Simpan");
        EditUsrSimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUsrSimpanButtonActionPerformed(evt);
            }
        });

        idUserLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        idUserLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        idUserLabelEdit.setText("NIM/NIP/NIDN");

        namaUserLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        namaUserLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        namaUserLabelEdit.setText("Nama");

        nomorUserLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        nomorUserLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        nomorUserLabelEdit.setText("Nomor Telepon");

        roleUserLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        roleUserLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        roleUserLabelEdit.setText("Role");

        userNameLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        userNameLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        userNameLabelEdit.setText("Username");

        passWordLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        passWordLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        passWordLabelEdit.setText("Password");

        fieldIDEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldIDEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldIDEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldIDEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldNameEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldNameEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldNameEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldNameEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldNomorEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldNomorEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldNomorEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldNomorEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldRoleEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldRoleEdit.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldRoleEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldRoleEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengguna", "Admin" }));
        fieldRoleEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldRoleEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRoleEditActionPerformed(evt);
            }
        });

        fieldUnameEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldUnameEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldUnameEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldUnameEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldPwordEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldPwordEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldPwordEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldPwordEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alertNamaEdit.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertNamaEdit.setForeground(new java.awt.Color(255, 255, 255));
        alertNamaEdit.setText("NIM/NIP/NIDN tidak boleh kosong!");

        alertIDEdit.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertIDEdit.setForeground(new java.awt.Color(255, 255, 255));
        alertIDEdit.setText("Nama tidak boleh kosong!");

        alertNomorEdit.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertNomorEdit.setForeground(new java.awt.Color(255, 255, 255));
        alertNomorEdit.setText("Nomor Telepon tidak boleh kosong!");

        alertRoleEdit.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertRoleEdit.setForeground(new java.awt.Color(255, 255, 255));
        alertRoleEdit.setText("Nama tidak boleh kosong!");

        alertUnameEdit.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertUnameEdit.setForeground(new java.awt.Color(255, 255, 255));
        alertUnameEdit.setText("Username tidak boleh kosong!");

        alertPwordEdit.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertPwordEdit.setForeground(new java.awt.Color(255, 255, 255));
        alertPwordEdit.setText("Password tidak boleh kosong!");

        javax.swing.GroupLayout editUsrAdminLayout = new javax.swing.GroupLayout(editUsrAdmin);
        editUsrAdmin.setLayout(editUsrAdminLayout);
        editUsrAdminLayout.setHorizontalGroup(
            editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editUsrAdminLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editUsrAdminLayout.createSequentialGroup()
                        .addComponent(EditUsrBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditUsrSimpanButton))
                    .addGroup(editUsrAdminLayout.createSequentialGroup()
                        .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idUserLabelEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomorUserLabelEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passWordLabelEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameLabelEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleUserLabelEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaUserLabelEdit, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(46, 46, 46)
                        .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNameEdit)
                            .addComponent(fieldNomorEdit)
                            .addComponent(fieldRoleEdit, 0, 280, Short.MAX_VALUE)
                            .addComponent(fieldUnameEdit)
                            .addComponent(fieldPwordEdit)
                            .addComponent(alertNomorEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertIDEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertRoleEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertUnameEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertPwordEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alertNamaEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldIDEdit))))
                .addGap(125, 125, 125))
            .addGroup(editUsrAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingEditUsr)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editUsrAdminLayout.setVerticalGroup(
            editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editUsrAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(headingEditUsr)
                .addGap(50, 50, 50)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idUserLabelEdit)
                    .addComponent(fieldIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertNamaEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaUserLabelEdit)
                    .addComponent(fieldNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertIDEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorUserLabelEdit)
                    .addComponent(fieldNomorEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertNomorEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleUserLabelEdit)
                    .addComponent(fieldRoleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertRoleEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabelEdit)
                    .addComponent(fieldUnameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertUnameEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passWordLabelEdit)
                    .addComponent(fieldPwordEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertPwordEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(editUsrAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditUsrBackButton)
                    .addComponent(EditUsrSimpanButton))
                .addGap(30, 30, 30))
        );

        mainPanelAdmin.add(editUsrAdmin, "edituser");

        addTVAdmin.setBackground(new java.awt.Color(255, 255, 255));
        addTVAdmin.setForeground(new java.awt.Color(0, 0, 0));
        addTVAdmin.setMinimumSize(new java.awt.Dimension(670, 530));

        headingAddTV.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        headingAddTV.setForeground(new java.awt.Color(255, 102, 0));
        headingAddTV.setText("Penambahan Perangkat TV");

        addTVBackButton.setBackground(new java.awt.Color(255, 141, 66));
        addTVBackButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        addTVBackButton.setForeground(new java.awt.Color(255, 255, 255));
        addTVBackButton.setText("< Kembali");
        addTVBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTVBackButtonActionPerformed(evt);
            }
        });

        addTVSimpanButton.setBackground(new java.awt.Color(255, 141, 66));
        addTVSimpanButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        addTVSimpanButton.setForeground(new java.awt.Color(255, 255, 255));
        addTVSimpanButton.setText("Simpan");
        addTVSimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTVSimpanButtonActionPerformed(evt);
            }
        });

        nomotTVLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        nomotTVLabel.setForeground(new java.awt.Color(0, 0, 0));
        nomotTVLabel.setText("Nomor TV");

        jenisTVLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        jenisTVLabel.setForeground(new java.awt.Color(0, 0, 0));
        jenisTVLabel.setText("Jenis");

        statusTVLabel.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        statusTVLabel.setForeground(new java.awt.Color(0, 0, 0));
        statusTVLabel.setText("Status");

        fieldNoTVAdd.setEditable(false);
        fieldNoTVAdd.setBackground(new java.awt.Color(242, 242, 242));
        fieldNoTVAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldNoTVAdd.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldNoTVAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldStatTVAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldStatTVAdd.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldStatTVAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldStatTVAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tersedia", "Dalam Perbaikan" }));
        fieldStatTVAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldJenisTVAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldJenisTVAdd.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldJenisTVAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldJenisTVAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PS 5", "XBOX", "PC" }));
        fieldJenisTVAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alertNomorTV.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertNomorTV.setForeground(new java.awt.Color(255, 255, 255));
        alertNomorTV.setText("NIM/NIP/NIDN tidak boleh kosong!");

        javax.swing.GroupLayout addTVAdminLayout = new javax.swing.GroupLayout(addTVAdmin);
        addTVAdmin.setLayout(addTVAdminLayout);
        addTVAdminLayout.setHorizontalGroup(
            addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTVAdminLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addTVAdminLayout.createSequentialGroup()
                        .addComponent(addTVBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addTVSimpanButton))
                    .addGroup(addTVAdminLayout.createSequentialGroup()
                        .addGroup(addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomotTVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusTVLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenisTVLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(46, 46, 46)
                        .addGroup(addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldStatTVAdd, 0, 280, Short.MAX_VALUE)
                            .addComponent(alertNomorTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldNoTVAdd)
                            .addComponent(fieldJenisTVAdd, 0, 280, Short.MAX_VALUE))))
                .addGap(125, 125, 125))
            .addGroup(addTVAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingAddTV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addTVAdminLayout.setVerticalGroup(
            addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTVAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(headingAddTV)
                .addGap(50, 50, 50)
                .addGroup(addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomotTVLabel)
                    .addComponent(fieldNoTVAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertNomorTV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenisTVLabel)
                    .addComponent(fieldJenisTVAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusTVLabel)
                    .addComponent(fieldStatTVAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(addTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTVBackButton)
                    .addComponent(addTVSimpanButton))
                .addGap(30, 30, 30))
        );

        mainPanelAdmin.add(addTVAdmin, "addtv");

        editTVAdmin.setBackground(new java.awt.Color(255, 255, 255));
        editTVAdmin.setForeground(new java.awt.Color(0, 0, 0));
        editTVAdmin.setMinimumSize(new java.awt.Dimension(670, 530));

        headingEditTV.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        headingEditTV.setForeground(new java.awt.Color(255, 102, 0));
        headingEditTV.setText("Perubahan Perangkat TV");

        editTVBackButton.setBackground(new java.awt.Color(255, 141, 66));
        editTVBackButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        editTVBackButton.setForeground(new java.awt.Color(255, 255, 255));
        editTVBackButton.setText("< Kembali");
        editTVBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTVBackButtonActionPerformed(evt);
            }
        });

        editTVSimpanButton.setBackground(new java.awt.Color(255, 141, 66));
        editTVSimpanButton.setFont(new java.awt.Font("Poppins", 1, 10)); 
        editTVSimpanButton.setForeground(new java.awt.Color(255, 255, 255));
        editTVSimpanButton.setText("Simpan");
        editTVSimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTVSimpanButtonActionPerformed(evt);
            }
        });

        nomotTVLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        nomotTVLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        nomotTVLabelEdit.setText("Nomor TV");

        jenisTVLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        jenisTVLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        jenisTVLabelEdit.setText("Jenis");

        statusTVLabelEdit.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        statusTVLabelEdit.setForeground(new java.awt.Color(0, 0, 0));
        statusTVLabelEdit.setText("Status");

        fieldNoTVEdit.setEditable(false);
        fieldNoTVEdit.setBackground(new java.awt.Color(242, 242, 242));
        fieldNoTVEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldNoTVEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldNoTVEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldStatTVEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldStatTVEdit.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldStatTVEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldStatTVEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldStatTVEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tersedia", "Dalam Perbaikan" }));
        fieldStatTVEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldJenisTVEdit.setBackground(new java.awt.Color(255, 255, 255));
        fieldJenisTVEdit.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldJenisTVEdit.setForeground(new java.awt.Color(0, 0, 0));
        fieldJenisTVEdit.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldJenisTVEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PS 5", "XBOX", "PC" }));
        fieldJenisTVEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alertNomorTVEdit.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertNomorTVEdit.setForeground(new java.awt.Color(255, 255, 255));
        alertNomorTVEdit.setText("NIM/NIP/NIDN tidak boleh kosong!");

        javax.swing.GroupLayout editTVAdminLayout = new javax.swing.GroupLayout(editTVAdmin);
        editTVAdmin.setLayout(editTVAdminLayout);
        editTVAdminLayout.setHorizontalGroup(
            editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTVAdminLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editTVAdminLayout.createSequentialGroup()
                        .addComponent(editTVBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editTVSimpanButton))
                    .addGroup(editTVAdminLayout.createSequentialGroup()
                        .addGroup(editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomotTVLabelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusTVLabelEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenisTVLabelEdit, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(47, 47, 47)
                        .addGroup(editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldStatTVEdit, 0, 280, Short.MAX_VALUE)
                            .addComponent(alertNomorTVEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldNoTVEdit)
                            .addComponent(fieldJenisTVEdit, 0, 280, Short.MAX_VALUE))))
                .addGap(125, 125, 125))
            .addGroup(editTVAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingEditTV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editTVAdminLayout.setVerticalGroup(
            editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editTVAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(headingEditTV)
                .addGap(50, 50, 50)
                .addGroup(editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomotTVLabelEdit)
                    .addComponent(fieldNoTVEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertNomorTVEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenisTVLabelEdit)
                    .addComponent(fieldJenisTVEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusTVLabelEdit)
                    .addComponent(fieldStatTVEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(editTVAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTVBackButton)
                    .addComponent(editTVSimpanButton))
                .addGap(30, 30, 30))
        );

        mainPanelAdmin.add(editTVAdmin, "edittv");

        addPinjamAdmin.setBackground(new java.awt.Color(255, 255, 255));
        addPinjamAdmin.setForeground(new java.awt.Color(0, 0, 0));
        addPinjamAdmin.setMinimumSize(new java.awt.Dimension(670, 530));

        headingPinjamAdd.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); 
        headingPinjamAdd.setForeground(new java.awt.Color(255, 102, 0));
        headingPinjamAdd.setText("Permintaan Peminjaman");

        backButtonPinjamAdd.setBackground(new java.awt.Color(255, 141, 66));
        backButtonPinjamAdd.setFont(new java.awt.Font("Poppins", 1, 10)); 
        backButtonPinjamAdd.setForeground(new java.awt.Color(255, 255, 255));
        backButtonPinjamAdd.setText("< Kembali");
        backButtonPinjamAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonPinjamAddActionPerformed(evt);
            }
        });

        simpanButtonPinjamAdd.setBackground(new java.awt.Color(255, 141, 66));
        simpanButtonPinjamAdd.setFont(new java.awt.Font("Poppins", 1, 10)); 
        simpanButtonPinjamAdd.setForeground(new java.awt.Color(255, 255, 255));
        simpanButtonPinjamAdd.setText("Simpan");
        simpanButtonPinjamAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonPinjamAddActionPerformed(evt);
            }
        });

        idPinjamAdd.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        idPinjamAdd.setForeground(new java.awt.Color(0, 0, 0));
        idPinjamAdd.setText("NIM/NIP/NIDN");

        noTVPinjamAdd.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        noTVPinjamAdd.setForeground(new java.awt.Color(0, 0, 0));
        noTVPinjamAdd.setText("Nomor TV");

        sesiPinjamAdd.setFont(new java.awt.Font("Poppins Medium", 0, 12)); 
        sesiPinjamAdd.setForeground(new java.awt.Color(0, 0, 0));
        sesiPinjamAdd.setText("Sesi");
        sesiPinjamAdd.setToolTipText("");

        fieldIDPinjamAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldIDPinjamAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldIDPinjamAdd.setFont(new java.awt.Font("Calibri", 0, 12));
        fieldIDPinjamAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alertNamaPinjamAdd.setFont(new java.awt.Font("Poppins Light", 0, 10)); 
        alertNamaPinjamAdd.setForeground(new java.awt.Color(255, 255, 255));
        alertNamaPinjamAdd.setText("NIM/NIP/NIDN tidak boleh kosong!");

        fieldNoTVPinjamAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldNoTVPinjamAdd.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldNoTVPinjamAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldNoTVPinjamAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldSesiPinjamAdd.setBackground(new java.awt.Color(255, 255, 255));
        fieldSesiPinjamAdd.setFont(new java.awt.Font("Calibri", 0, 12)); 
        fieldSesiPinjamAdd.setForeground(new java.awt.Color(0, 0, 0));
        fieldSesiPinjamAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout addPinjamAdminLayout = new javax.swing.GroupLayout(addPinjamAdmin);
        addPinjamAdmin.setLayout(addPinjamAdminLayout);
        addPinjamAdminLayout.setHorizontalGroup(
            addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPinjamAdminLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addPinjamAdminLayout.createSequentialGroup()
                        .addComponent(backButtonPinjamAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanButtonPinjamAdd))
                    .addGroup(addPinjamAdminLayout.createSequentialGroup()
                        .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(sesiPinjamAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(noTVPinjamAdd, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(idPinjamAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alertNamaPinjamAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldNoTVPinjamAdd, javax.swing.GroupLayout.Alignment.TRAILING, 0, 280, Short.MAX_VALUE)
                            .addComponent(fieldSesiPinjamAdd, 0, 280, Short.MAX_VALUE)
                            .addComponent(fieldIDPinjamAdd, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(125, 125, 125))
            .addGroup(addPinjamAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headingPinjamAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addPinjamAdminLayout.setVerticalGroup(
            addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPinjamAdminLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(headingPinjamAdd)
                .addGap(50, 50, 50)
                .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPinjamAdd)
                    .addComponent(fieldIDPinjamAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(alertNamaPinjamAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noTVPinjamAdd)
                    .addComponent(fieldNoTVPinjamAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sesiPinjamAdd)
                    .addComponent(fieldSesiPinjamAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(addPinjamAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButtonPinjamAdd)
                    .addComponent(simpanButtonPinjamAdd))
                .addGap(30, 30, 30))
        );

        mainPanelAdmin.add(addPinjamAdmin, "addpeminjaman");

        javax.swing.GroupLayout adminPageLayout = new javax.swing.GroupLayout(adminPage);
        adminPage.setLayout(adminPageLayout);
        adminPageLayout.setHorizontalGroup(
            adminPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPageLayout.createSequentialGroup()
                .addComponent(sideBarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(topBarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        adminPageLayout.setVerticalGroup(
            adminPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPageLayout.createSequentialGroup()
                .addComponent(topBarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(adminPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideBarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(adminPage, "admin");

        pack();
        setLocationRelativeTo(null);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        
        if(username.isBlank()) {
            alertUser.setForeground(Color.red);
            usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        } else {
            alertUser.setForeground(Color.white);
            usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        }
        
        if(password.isBlank()) {
            alertPass.setForeground(Color.red);
            passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        } else {
            alertPass.setForeground(Color.white);
            passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        }
        
        if(!username.isBlank() && !password.isBlank()) {
            if (controller.login(username, password)) {
                    String namaDepan;
                    try {
                        namaDepan = controller.getLoginAdmin().getNama().substring(0, controller.getLoginAdmin().getNama().indexOf(" "));
                    } catch (StringIndexOutOfBoundsException error) {
                        namaDepan = controller.getLoginAdmin().getNama();
                    }
                    headingAdm.setText("Selamat Datang, " + namaDepan + "!");
                    mainPanel.show(getContentPane(), "admin");
                    adminPanel.show(mainPanelAdmin, "dashboard");
                } else {
                JOptionPane.showMessageDialog(this, "Username/Password salah!", "Unauthorized", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void logoutButtonAdmActionPerformed(java.awt.event.ActionEvent evt) {
        mainPanel.show(getContentPane(), "login");
        usernameField.setText("");
        passwordField.setText("");
    }

    private void dashButtonAdmActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "dashboard");
    }

    private void reqButtonAdmActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "peminjaman");
        controller.refreshStatusPeminjaman();
        refreshTabelPeminjaman();
    }

    private void tvButtonAdmActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "tvmanagement");
        refreshTabelTV();
    }

    private void userButtonAdmActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "usermanagement");
        refreshTabelPengguna();
        
    }

    private void addUsrBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "usermanagement");
    }

    private void addUsrSimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (fieldNamaAdd.getText().isBlank()) {
            fieldNamaAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            alertIDAdd.setForeground(Color.red);
        } else {
            fieldNamaAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            alertIDAdd.setForeground(Color.white);
        }

        if (fieldIdAdd.getText().isBlank()) {
            fieldIdAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            alertNamaAdd.setForeground(Color.red);
        } else {
            fieldIdAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            alertNamaAdd.setForeground(Color.white);
        }

        if (fieldNomorAdd.getText().isBlank()) {
            fieldNomorAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            alertNomorAdd.setForeground(Color.red);
        } else {
            fieldNomorAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            alertNomorAdd.setForeground(Color.white);
        }

        if (fieldRoleAdd.getSelectedItem().toString().equals("Admin")) {
            if (fieldUnameAdd.getText().isBlank()) {
                fieldUnameAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
                alertUnameAdd.setForeground(Color.red);
            } else {
                fieldUnameAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                alertUnameAdd.setForeground(Color.white);
            }

            if (fieldPwordAdd.getText().isBlank()) {
                fieldPwordAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
                alertPwordAdd.setForeground(Color.red);
            } else {
                fieldPwordAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                alertPwordAdd.setForeground(Color.white);
            }
        }

        if (!fieldNamaAdd.getText().isBlank() && !fieldIdAdd.getText().isBlank() && !fieldNomorAdd.getText().isBlank() && fieldRoleAdd.getSelectedItem().toString().equals("Admin") && !fieldUnameAdd.getText().isBlank() && !fieldPwordAdd.getText().isBlank() ||
            !fieldNamaAdd.getText().isBlank() && !fieldIdAdd.getText().isBlank() && !fieldNomorAdd.getText().isBlank() && fieldRoleAdd.getSelectedItem().toString().equals("Pengguna")) {
            if (JOptionPane.showConfirmDialog(this, "Apakah data yang anda masukkan sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                if (controller.searchUserId(fieldIdAdd.getText()) == -1) {
                    if (fieldRoleAdd.getSelectedItem().toString().equals("Admin") && controller.searchUsername(fieldUnameAdd.getText()) != -1) {
                        JOptionPane.showMessageDialog(this, "Username yang anda masukkan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        controller.addUser( fieldIdAdd.getText(),
                                            fieldNamaAdd.getText(),
                                            fieldNomorAdd.getText(),
                                            fieldUnameAdd.getText(),
                                            fieldPwordAdd.getText(),
                                            fieldRoleAdd.getSelectedItem().toString());
                        adminPanel.show(mainPanelAdmin, "usermanagement");
                        editUserButton.setBackground(Color.decode("#D0C6C6"));
                        delUserButton.setBackground(Color.decode("#D0C6C6"));
                        refreshTabelPengguna();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Pengguna dengan NIM/NIP/NIDN yang anda masukkan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void fieldRoleAddActionPerformed(java.awt.event.ActionEvent evt) {
        if (fieldRoleAdd.getSelectedItem().toString().equals("Admin")) {
            userNameLabel.setVisible(true);
            passWordLabel.setVisible(true);
            fieldUnameAdd.setVisible(true);
            fieldPwordAdd.setVisible(true);
        } else {
            userNameLabel.setVisible(false);
            passWordLabel.setVisible(false);
            fieldUnameAdd.setVisible(false);
            fieldPwordAdd.setVisible(false);
        }
    }

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        userNameLabel.setVisible(false);
        passWordLabel.setVisible(false);
        fieldUnameAdd.setVisible(false);
        fieldPwordAdd.setVisible(false);
        
        fieldNamaAdd.setText("");
        fieldIdAdd.setText("");
        fieldNomorAdd.setText("");
        fieldRoleAdd.setSelectedIndex(0);
        fieldUnameAdd.setText("");
        fieldPwordAdd.setText("");
        
        adminPanel.show(mainPanelAdmin, "adduser");
    }

    private void fieldUnameAddActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void tabelUsrAdmMouseReleased(java.awt.event.MouseEvent evt) {
        int penggunaTerpilih = 0;
        
        for(int i = 0; i < tabelPengguna.getRowCount(); i++) {
            if((boolean) tabelPengguna.getValueAt(i, 0)) {
                penggunaTerpilih++;
            }
        }
        
        editUserButton.setBackground(penggunaTerpilih == 1 ? Color.decode("#FF8D42") : Color.decode("#D0C6C6"));
        delUserButton.setBackground(penggunaTerpilih > 0 ? Color.decode("#FF8D42") : Color.decode("#D0C6C6"));
    }

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (editUserButton.getBackground().equals(Color.decode("#FF8D42"))) {
            for (int i = 0; i < tabelPengguna.getRowCount(); i++) {
                if ((boolean) tabelPengguna.getValueAt(i, 0)) {
                    fieldIDEdit.setText(controller.getUser(i).getId());
                    fieldNameEdit.setText(controller.getUser(i).getNama());
                    fieldNomorEdit.setText(controller.getUser(i).getNomor());
                    fieldRoleEdit.setSelectedItem(controller.getUser(i).getRole());
                    fieldUnameEdit.setText(controller.getUser(i).getUsername());
                    fieldPwordEdit.setText(controller.getUser(i).getPassword());
                }
            }

            if (fieldRoleEdit.getSelectedItem().toString().equals("Admin")) {
                userNameLabelEdit.setVisible(true);
                passWordLabelEdit.setVisible(true);
                fieldUnameEdit.setVisible(true);
                fieldPwordEdit.setVisible(true);
            } else {
                userNameLabelEdit.setVisible(false);
                passWordLabelEdit.setVisible(false);
                fieldUnameEdit.setVisible(false);
                fieldPwordEdit.setVisible(false);
            }

            adminPanel.show(mainPanelAdmin, "edituser");
        }
    }

    private void EditUsrBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "usermanagement");
    }

    private void EditUsrSimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String startingID = "";
        String startingUsername = "";

        for (int i = 0; i < tabelPengguna.getRowCount(); i++) {
                if ((boolean) tabelPengguna.getValueAt(i, 0)) {
                    startingID = controller.getUser(i).getId();
                    startingUsername = controller.getUser(i).getUsername();
                }
        }

        if (fieldNameEdit.getText().isBlank()) {
            fieldNameEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            alertIDEdit.setForeground(Color.red);
        } else {
            fieldNameEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            alertIDEdit.setForeground(Color.white);
        }

        if (fieldIDEdit.getText().isBlank()) {
            fieldIDEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            alertNamaEdit.setForeground(Color.red);
        } else {
            fieldIDEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            alertNamaEdit.setForeground(Color.white);
        }

        if (fieldNomorEdit.getText().isBlank()) {
            fieldNomorEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            alertNomorEdit.setForeground(Color.red);
        } else {
            fieldNomorEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            alertNomorEdit.setForeground(Color.white);
        }

        if (fieldRoleEdit.getSelectedItem().toString().equals("Admin")) {
            if (fieldUnameEdit.getText().isBlank()) {
                fieldUnameEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
                alertUnameEdit.setForeground(Color.red);
            } else {
                fieldUnameEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                alertUnameEdit.setForeground(Color.white);
            }

            if (fieldPwordEdit.getText().isBlank()) {
                fieldPwordEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
                alertPwordEdit.setForeground(Color.red);
            } else {
                fieldPwordEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                alertPwordEdit.setForeground(Color.white);
            }
        }

        if (!fieldNameEdit.getText().isBlank() && !fieldIDEdit.getText().isBlank() && !fieldNomorEdit.getText().isBlank() && fieldRoleEdit.getSelectedItem().toString().equals("Admin") && !fieldUnameEdit.getText().isBlank() && !fieldPwordEdit.getText().isBlank() ||
            !fieldNameEdit.getText().isBlank() && !fieldIDEdit.getText().isBlank() && !fieldNomorEdit.getText().isBlank() && fieldRoleEdit.getSelectedItem().toString().equals("Pengguna")) {
            if (JOptionPane.showConfirmDialog(this, "Apakah data yang anda masukkan sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (controller.searchUserId(fieldIDEdit.getText()) == -1 || fieldIDEdit.getText().equals(startingID)) {
                    if (fieldRoleEdit.getSelectedItem().toString().equals("Admin") && controller.searchUsername(fieldUnameEdit.getText()) != -1 && !fieldUnameEdit.getText().equals(startingUsername)) {
                        JOptionPane.showMessageDialog(this, "Username yang anda masukkan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        controller.editUser(startingID,
                                            fieldIDEdit.getText(),
                                            fieldNameEdit.getText(),
                                            fieldNomorEdit.getText(),
                                            fieldUnameEdit.getText(),
                                            fieldPwordEdit.getText(),
                                            fieldRoleEdit.getSelectedItem().toString());
                        adminPanel.show(mainPanelAdmin, "usermanagement");
                        editUserButton.setBackground(Color.decode("#D0C6C6"));
                        delUserButton.setBackground(Color.decode("#D0C6C6"));
                        refreshTabelPengguna();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Pengguna dengan NIM/NIP/NIDN yang anda masukkan sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void fieldRoleEditActionPerformed(java.awt.event.ActionEvent evt) {
        if (fieldRoleEdit.getSelectedItem().toString().equals("Admin")) {
            userNameLabelEdit.setVisible(true);
            passWordLabelEdit.setVisible(true);
            fieldUnameEdit.setVisible(true);
            fieldPwordEdit.setVisible(true);
        } else {
            userNameLabelEdit.setVisible(false);
            passWordLabelEdit.setVisible(false);
            fieldUnameEdit.setVisible(false);
            fieldPwordEdit.setVisible(false);
        }
    }

    private void delUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (delUserButton.getBackground().equals(Color.decode("#FF8D42"))) {
            if (JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus pengguna yang dipilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                for (int i = 0; i < tabelPengguna.getRowCount(); i++) {
                    if ((boolean) tabelPengguna.getValueAt(i, 0)) {
                        controller.delUser(tabelPengguna.getValueAt(i, 1).toString());
                    }
                }
                refreshTabelPengguna();
                delUserButton.setBackground(Color.decode("#D0C6C6"));
                editUserButton.setBackground(Color.decode("#D0C6C6"));
            }
            
        }
    }

    private void addTVBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "tvmanagement");
    }

    private void addTVSimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
            if (JOptionPane.showConfirmDialog(this, "Apakah data yang anda masukkan sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                controller.addTV(   fieldNoTVAdd.getText(),
                                    fieldJenisTVAdd.getSelectedItem().toString(),
                                    fieldStatTVAdd.getSelectedItem().toString());
                adminPanel.show(mainPanelAdmin, "tvmanagement");
                delTVButton.setBackground(Color.decode("#D0C6C6"));
                editTVButton.setBackground(Color.decode("#D0C6C6"));
                refreshTabelTV();
            }
    }

    private void addTVButtonActionPerformed(java.awt.event.ActionEvent evt) {
        fieldNoTVAdd.setText(Integer.toString(controller.getJumlahTV() + 1));
        fieldJenisTVAdd.setSelectedIndex(0);
        fieldStatTVAdd.setSelectedIndex(0);
        
        adminPanel.show(mainPanelAdmin, "addtv");
    }

    private void editTVBackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "tvmanagement");
    }

    private void editTVSimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {
            if (JOptionPane.showConfirmDialog(this, "Apakah data yang anda masukkan sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                controller.editTV(  fieldNoTVEdit.getText(),
                                    fieldJenisTVEdit.getSelectedItem().toString(),
                                    fieldStatTVEdit.getSelectedItem().toString());
                adminPanel.show(mainPanelAdmin, "tvmanagement");
                delTVButton.setBackground(Color.decode("#D0C6C6"));
                editTVButton.setBackground(Color.decode("#D0C6C6"));
                refreshTabelTV();
            }
    }

    private void editTVButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (editTVButton.getBackground().equals(Color.decode("#FF8D42"))) {
            for (int i = 0; i < tabelTV.getRowCount(); i++) {
                if ((boolean) tabelTV.getValueAt(i, 0)) {
                    fieldNoTVEdit.setText(controller.getTV(i).getId());
                    fieldJenisTVEdit.setSelectedItem(controller.getTV(i).getJenis());
                    fieldStatTVEdit.setSelectedItem(controller.getTV(i).getStatus());
                }
            }
            adminPanel.show(mainPanelAdmin, "edittv");
        }
    }

    private void delTVButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (delTVButton.getBackground().equals(Color.decode("#FF8D42"))) {
            if (JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus TV yang dipilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                for (int i = tabelTV.getRowCount() - 1; i > -1; i--) {
                    if ((boolean) tabelTV.getValueAt(i, 0)) {
                        controller.delTV(controller.getTV(i).getId());
                    }
                }
                refreshTabelTV();
                delTVButton.setBackground(Color.decode("#D0C6C6"));
                editTVButton.setBackground(Color.decode("#D0C6C6"));
            }
        }
    }

    private void tabelTVAdmMouseReleased(java.awt.event.MouseEvent evt) {
        int tvTerpilih = 0;

        for(int i = 0; i < tabelTV.getRowCount(); i++) {
            if((boolean) tabelTV.getValueAt(i, 0)) {
                tvTerpilih++;
            }
        }

        editTVButton.setBackground(tvTerpilih == 1 ? Color.decode("#FF8D42") : Color.decode("#D0C6C6"));
        delTVButton.setBackground(tvTerpilih > 0 ? Color.decode("#FF8D42") : Color.decode("#D0C6C6"));
    }

    private void addPinjamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        fieldIDPinjamAdd.setText("");

        fieldNoTVPinjamAdd.removeAllItems();
        for (int i = 0; i < controller.getJumlahTV(); i++) {
            if (controller.getTV(i).getStatus().equals("Tersedia")) {
                fieldNoTVPinjamAdd.addItem("TV-" + controller.getTV(i).getId());
            }
        }
        
        fieldSesiPinjamAdd.removeAllItems();
        for (String sesi : controller.getSesiPeminjaman()) {
            fieldSesiPinjamAdd.addItem(sesi);
        }

        try {
            fieldNoTVPinjamAdd.setSelectedIndex(0);
        } catch (Exception e) {
            fieldNoTVPinjamAdd.addItem("");
        }
        
        try {
            fieldSesiPinjamAdd.setSelectedIndex(0);
        } catch (Exception e) {
            fieldSesiPinjamAdd.addItem("");
        }

        adminPanel.show(mainPanelAdmin, "addpeminjaman");
    }

    private void backButtonPinjamAddActionPerformed(java.awt.event.ActionEvent evt) {
        adminPanel.show(mainPanelAdmin, "peminjaman");
    }

    private void simpanButtonPinjamAddActionPerformed(java.awt.event.ActionEvent evt) {
        if (fieldIDPinjamAdd.getText().isBlank()) {
            fieldIDPinjamAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
            alertNamaPinjamAdd.setForeground(Color.red);
        } else {
            fieldIDPinjamAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            alertNamaPinjamAdd.setForeground(Color.white);
            if (JOptionPane.showConfirmDialog(this, "Apakah data yang anda masukkan sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (fieldNoTVPinjamAdd.getSelectedItem().toString().isBlank()){
                    JOptionPane.showMessageDialog(this, "Tidak ada TV yang tersedia!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (fieldSesiPinjamAdd.getSelectedItem().toString().isBlank()) {
                    JOptionPane.showMessageDialog(this, "Tidak ada sesi yang tersedia!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        if (controller.addPeminjaman(
                                controller.getUser(controller.searchUserId(fieldIDPinjamAdd.getText())),
                                controller.getTV(Integer.valueOf(fieldNoTVPinjamAdd.getSelectedItem().toString().substring(3)) - 1),
                                fieldSesiPinjamAdd.getSelectedItem().toString())) {
                            adminPanel.show(mainPanelAdmin, "peminjaman");
                            controller.refreshStatusPeminjaman();
                        } else {
                            JOptionPane.showMessageDialog(this, "TV dan Sesi yang anda pilih sudah dipinjam!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (IndexOutOfBoundsException error) {
                        JOptionPane.showMessageDialog(this,
                                "Pengguna dengan NIM/NIP/NIDN yang anda masukkan tidak ditemukan!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    private void saveHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {
        controller.saveRiwayatPeminjaman();
    }
    
    private void refreshTabelTV() {
        tabelTV.setRowCount(0);
        for (int i = 0; i < controller.getJumlahTV(); i++) {
            tabelTV.addRow(new Object[] {  false, 
                                            "TV-" + controller.getTV(i).getId(),
                                            controller.getTV(i).getJenis(),
                                            controller.getTV(i).getStatus()});
        }
    }
    
    private void refreshTabelPengguna() {
        tabelPengguna.setRowCount(0);
        for (int i = 0; i < controller.getJumlahUser(); i++) {
            tabelPengguna.addRow(new Object[] {  false, 
                                            controller.getUser(i).getId(),
                                            controller.getUser(i).getNama(),
                                            controller.getUser(i).getNomor(),
                                            controller.getUser(i).getRole()});
        }
    }

    private void refreshTabelPeminjaman() {
        tabelRental.setRowCount(0);
        for (int i = 0; i < controller.getJumlahPeminjaman(); i++) {
            tabelRental.insertRow(0, new Object[] {controller.getPeminjaman(i).getPengguna().getNama(),
                                            "TV-" + controller.getPeminjaman(i).getTelevisi().getId(),
                                            controller.getPeminjaman(i).getTanggal(),
                                            controller.getPeminjaman(i).getSesi(),
                                            controller.getPeminjaman(i).getStatus()});
        }
    }

    private void refreshTabelOverview() {    
        tabelDash.setRowCount(0);
        for (int i = 0; i < controller.getJumlahTV(); i++) {
            if (controller.getTV(i).getStatus().equals("Tersedia")) {
                try {
                    tabelDash.addRow(new String[] { "TV-" + controller.getTV(i).getId(),
                            controller.getPeminjamanAktif(i).getPengguna().getNama(),
                            controller.getSisaWaktu(controller.getPeminjamanAktif(i)) });
                } catch (NullPointerException aktifNotFound) {
                    tabelDash.addRow(new String[] { "TV-" + controller.getTV(i).getId(),
                            "-", "-" });
                }   
            }
        }
    }

    public void refreshAvailableTV() {
        int tidakTersedia = 0;
        int peminjamanAktif = 0;
        for (int i = 0; i < controller.getJumlahTV(); i++) {
            if (controller.getPeminjamanAktif(i) != null) {
                peminjamanAktif++;
            }

            if (controller.getTV(i).getStatus().equals("Dalam Perbaikan")) {
                tidakTersedia++;
            }
        }

        readyNum.setText(Integer.toString(controller.getJumlahTV() - peminjamanAktif - tidakTersedia));
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameCorner().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton EditUsrBackButton;
    private javax.swing.JButton EditUsrSimpanButton;
    private javax.swing.JPanel addPinjamAdmin;
    private javax.swing.JButton addPinjamButton;
    private javax.swing.JPanel addTVAdmin;
    private javax.swing.JButton addTVBackButton;
    private javax.swing.JButton addTVButton;
    private javax.swing.JButton addTVSimpanButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JPanel addUsrAdmin;
    private javax.swing.JButton addUsrBackButton;
    private javax.swing.JButton addUsrSimpanButton;
    private javax.swing.JPanel adminPage;
    private javax.swing.JLabel alertIDAdd;
    private javax.swing.JLabel alertIDEdit;
    private javax.swing.JLabel alertNamaAdd;
    private javax.swing.JLabel alertNamaEdit;
    private javax.swing.JLabel alertNamaPinjamAdd;
    private javax.swing.JLabel alertNomorAdd;
    private javax.swing.JLabel alertNomorEdit;
    private javax.swing.JLabel alertNomorTV;
    private javax.swing.JLabel alertNomorTVEdit;
    private javax.swing.JLabel alertPass;
    private javax.swing.JLabel alertPwordAdd;
    private javax.swing.JLabel alertPwordEdit;
    private javax.swing.JLabel alertRoleAdd;
    private javax.swing.JLabel alertRoleEdit;
    private javax.swing.JLabel alertUnameAdd;
    private javax.swing.JLabel alertUnameEdit;
    private javax.swing.JLabel alertUser;
    private javax.swing.JButton backButtonPinjamAdd;
    private javax.swing.JPanel dashAdmin;
    private javax.swing.JButton dashButtonAdm;
    private javax.swing.JButton delTVButton;
    private javax.swing.JButton delUserButton;
    private javax.swing.JPanel editTVAdmin;
    private javax.swing.JButton editTVBackButton;
    private javax.swing.JButton editTVButton;
    private javax.swing.JButton editTVSimpanButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JPanel editUsrAdmin;
    private javax.swing.JTextField fieldIDEdit;
    private javax.swing.JTextField fieldIDPinjamAdd;
    private javax.swing.JTextField fieldIdAdd;
    private javax.swing.JComboBox<String> fieldJenisTVAdd;
    private javax.swing.JComboBox<String> fieldJenisTVEdit;
    private javax.swing.JTextField fieldNamaAdd;
    private javax.swing.JTextField fieldNameEdit;
    private javax.swing.JTextField fieldNoTVAdd;
    private javax.swing.JTextField fieldNoTVEdit;
    private javax.swing.JComboBox<String> fieldNoTVPinjamAdd;
    private javax.swing.JTextField fieldNomorAdd;
    private javax.swing.JTextField fieldNomorEdit;
    private javax.swing.JTextField fieldPwordAdd;
    private javax.swing.JTextField fieldPwordEdit;
    private javax.swing.JComboBox<String> fieldRoleAdd;
    private javax.swing.JComboBox<String> fieldRoleEdit;
    private javax.swing.JComboBox<String> fieldSesiPinjamAdd;
    private javax.swing.JComboBox<String> fieldStatTVAdd;
    private javax.swing.JComboBox<String> fieldStatTVEdit;
    private javax.swing.JTextField fieldUnameAdd;
    private javax.swing.JTextField fieldUnameEdit;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel headingAddTV;
    private javax.swing.JLabel headingAddUsr;
    private javax.swing.JLabel headingAdm;
    private javax.swing.JLabel headingEditTV;
    private javax.swing.JLabel headingEditUsr;
    private javax.swing.JLabel headingPinjam;
    private javax.swing.JLabel headingPinjamAdd;
    private javax.swing.JLabel headingUsrAdmin2;
    private javax.swing.JLabel hradingTV2;
    private javax.swing.JLabel idPinjamAdd;
    private javax.swing.JLabel idUserLabel;
    private javax.swing.JLabel idUserLabelEdit;
    private javax.swing.JLabel jenisTVLabel;
    private javax.swing.JLabel jenisTVLabelEdit;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPage;
    private javax.swing.JLabel logoAdm;
    private javax.swing.JLabel logoFilkom;
    private javax.swing.JButton logoutButtonAdm;
    private javax.swing.JPanel mainPanelAdmin;
    private javax.swing.JLabel namaUserLabel;
    private javax.swing.JLabel namaUserLabelEdit;
    private javax.swing.JLabel noTVPinjamAdd;
    private javax.swing.JLabel nomorUserLabel;
    private javax.swing.JLabel nomorUserLabelEdit;
    private javax.swing.JLabel nomotTVLabel;
    private javax.swing.JLabel nomotTVLabelEdit;
    private javax.swing.JPanel overviewReadyAdm;
    private javax.swing.JLabel passWordLabel;
    private javax.swing.JLabel passWordLabelEdit;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel pinjamAdmin;
    private javax.swing.JLabel readyIcon;
    private javax.swing.JLabel readyLabel;
    private javax.swing.JLabel readyNum;
    private javax.swing.JButton reqButtonAdm;
    private javax.swing.JLabel roleUserLabel;
    private javax.swing.JLabel roleUserLabelEdit;
    private javax.swing.JButton saveHistoryButton;
    private javax.swing.JScrollPane scrollPaneDashAdm;
    private javax.swing.JScrollPane scrollPanePinjam;
    private javax.swing.JScrollPane scrollPaneTV;
    private javax.swing.JScrollPane scrollPaneUsrAdmin;
    private javax.swing.JLabel sesiPinjamAdd;
    private javax.swing.JPanel sideBarAdmin;
    private javax.swing.JButton simpanButtonPinjamAdd;
    private javax.swing.JLabel statusTVLabel;
    private javax.swing.JLabel statusTVLabelEdit;
    private javax.swing.JTable tabelDashAdm;
    private javax.swing.JTable tabelRentalAdm;
    private javax.swing.JTable tabelTVAdm;
    private javax.swing.JTable tabelUsrAdm;
    private javax.swing.JPanel topBarAdmin;
    private javax.swing.JPanel tvAdmin;
    private javax.swing.JButton tvButtonAdm;
    private javax.swing.JButton userButtonAdm;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userNameLabelEdit;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JPanel usrAdmin;
}