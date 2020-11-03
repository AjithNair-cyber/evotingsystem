package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 abstract class LoginPanel{

    static JFrame parentFrame;

    public static JPanel getPanel(JFrame frame){
        parentFrame = frame;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setFont(new Font("Ubuntu Mono", Font.BOLD, 15));

        JPanel intro = new JPanel();
        intro.setBounds(0, 0, 500, 600);
        intro.setBackground(new Color(128,128,128));

        JPanel registerPanel = new JPanel();
        registerPanel.setBounds(0, 0, 500, 600);
        registerPanel.setBackground(new Color(128,128,128));

        JPanel adminLogin = new JPanel();
        adminLogin.setLayout(null);
        adminLogin.setBounds(500, 0, 500, 280);
        adminLogin.setBackground(new Color(192,192,192));

        JPanel adminstrip = new JPanel();
        adminstrip.setBackground(new Color(32,32,32));
        adminstrip.setBounds(0,0,500,30);
        JButton adminButton = new JButton("Login");
        adminLogin.add(adminButton);
        adminButton.setBounds(275, 215,100,50);
        adminButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 15));
        adminButton.setBackground(Color.BLACK);
        adminButton.setForeground(Color.WHITE);
        adminButton.setBorder(null);
        adminButton.addActionListener(new AdminLoginListener(adminButton));
        JTextField adminName = new JTextField("Username",20);
        adminName.setBounds(100,215,165,25);
        adminName.setBackground(Color.BLACK);
        adminName.setForeground(Color.WHITE);
        adminName.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        JPasswordField adminPass = new JPasswordField("Password",20);
        adminPass.setBounds(100,240,165,25);
        adminPass.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        adminPass.setBackground(Color.BLACK);
        adminPass.setForeground(Color.WHITE);
        adminLogin.add(adminName);
        adminLogin.add(adminPass);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("app/resources/admin.png"));
        Image i2 = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(115,-25,250,250);
        adminLogin.add(l1);
        JLabel adminLabel = new JLabel("   Admin");
        adminLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        adminLabel.setOpaque(true);
        adminLabel.setBackground(Color.BLACK);
        adminLabel.setForeground(Color.WHITE);
        adminLabel.setLocation(190, 170);
        adminLabel.setSize(100, 25);
        adminLogin.add(adminLabel);
        adminLogin.add(adminstrip);


        JPanel userLogin = new JPanel();
        userLogin.setLayout(null);
        userLogin.setBounds(500,280,500,330);
        userLogin.setBackground(new Color(192,192,192));

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("app/resources/user.png"));
        Image i5 = i4.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(115,-35,250,250);
        userLogin.add(l2);

        JTextField userName = new JTextField("Username",20);
        userName.setBounds(100,205,165,25);
        userName.setBackground(Color.BLACK);
        userName.setForeground(Color.WHITE);
        userName.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        userLogin.add(userName);
        JPasswordField userPass = new JPasswordField("Password",20);
        userPass.setBounds(100,230,165,25);
        userPass.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        userPass.setBackground(Color.BLACK);
        userPass.setForeground(Color.WHITE);
        userLogin.add(userPass);
        JButton userButton = new JButton("Login");
        userButton.setBounds(275, 205,100,50);
        userButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 15));
        userButton.setBackground(Color.BLACK);
        userButton.setForeground(Color.WHITE);
        userButton.setBorder(null);
        userButton.addActionListener(new UserLoginListener(userButton));
        userLogin.add(userButton);
        JLabel userLabel = new JLabel("    User");
        userLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        userLabel.setOpaque(true);
        userLabel.setBackground(Color.BLACK);
        userLabel.setForeground(Color.WHITE);
        userLabel.setLocation(190, 160);
        userLabel.setSize(100, 35);
        userLogin.add(userLabel);

        intro.setLayout(null);

        JPanel introstrip = new JPanel();
        introstrip.setBackground(new Color(32,32,32));
        introstrip.setBounds(0,0,500,30);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("app/resources/voting.jpg"));
        Image i8 = i7.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l3 = new JLabel(i9);
        l3.setBounds(50,40,400,400);
        JButton registerButton = new JButton();
        registerButton.setBounds(175,480,150,35);
        registerButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setText("Register Now");
        registerButton.setBorder(null);
        registerButton.addActionListener(new RegisterListener(registerButton,intro));
        intro.add(l3);
        intro.add(introstrip);
        intro.add(registerButton);


        JPanel registerstrip = new JPanel();
        registerstrip.setBackground(new Color(32,32,32));
        registerstrip.setBounds(0,0,500,30);

        JLabel nameLabel = new JLabel("Name");
        JTextField name = new JTextField();

        mainPanel.add(intro);
        mainPanel.add(adminLogin);
        mainPanel.add(userLogin);
        mainPanel.setVisible(true);

        return mainPanel;

    }
    static class UserLoginListener implements ActionListener{
        JButton thisButton;
        UserLoginListener(JButton button){
            thisButton = button;
        }
        public void actionPerformed(ActionEvent event){
            //LOGIN AS ADMIN;
        }
    }

    static class AdminLoginListener implements ActionListener{
        JButton thisButton;
        AdminLoginListener(JButton button){
            thisButton = button;
        }
        public void actionPerformed(ActionEvent event){
            //LOGIN AS ADMIN
        }
    }

    static class RegisterListener implements ActionListener{
        JButton thisButton;
        JPanel thisPanel;
        RegisterListener(JButton button,JPanel panel){
            thisButton = button;
            thisPanel = panel;
        }
        public void actionPerformed(ActionEvent event){
            thisPanel.setVisible(false);
        }
    }



    public JFrame getParentFrame(){
        return parentFrame;
    }
}
