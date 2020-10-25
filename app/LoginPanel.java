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
        intro.setBackground(Color.RED);

        JPanel adminLogin = new JPanel();
        adminLogin.setLayout(null);
        adminLogin.setBounds(500, 0, 500, 270);
        adminLogin.setBackground(Color.WHITE);
        JButton adminButton = new JButton("Login");
        adminLogin.add(adminButton);
        adminButton.setBounds(275, 195,100,50);
        adminButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 15));
        adminButton.setBackground(Color.BLACK);
        adminButton.setForeground(Color.WHITE);
        adminButton.setBorder(null);
        adminButton.addActionListener(new AdminLoginListener(adminButton));
        JTextField adminName = new JTextField("Username",20);
        adminName.setBounds(100,195,165,25);
        adminName.setBackground(Color.BLACK);
        adminName.setForeground(Color.WHITE);
        adminName.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        JPasswordField adminPass = new JPasswordField("Password",20);
        adminPass.setBounds(100,220,165,25);
        adminPass.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        adminPass.setBackground(Color.BLACK);
        adminPass.setForeground(Color.WHITE);
        adminLogin.add(adminName);
        adminLogin.add(adminPass);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("app/resources/admin3.png"));
        Image i2 = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(115,-45,250,250);
        adminLogin.add(l1);
        JLabel adminLabel = new JLabel("   Admin");
        adminLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        adminLabel.setOpaque(true);
        adminLabel.setBackground(Color.BLACK);
        adminLabel.setForeground(Color.WHITE);
        adminLabel.setLocation(190, 150);
        adminLabel.setSize(100, 25);
        adminLogin.add(adminLabel);


        JPanel userLogin = new JPanel();
        userLogin.setLayout(null);
        userLogin.setBounds(500,270,500,330);
        userLogin.setBackground(Color.WHITE);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("app/resources/user3.png"));
        Image i5 = i4.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(115,-45,250,250);
        userLogin.add(l2);

        JTextField userName = new JTextField("Username",20);
        userName.setBounds(100,195,165,25);
        userName.setBackground(Color.BLACK);
        userName.setForeground(Color.WHITE);
        userName.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        userLogin.add(userName);
        JPasswordField userPass = new JPasswordField("Password",20);
        userPass.setBounds(100,220,165,25);
        userPass.setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
        userPass.setBackground(Color.BLACK);
        userPass.setForeground(Color.WHITE);
        userLogin.add(userPass);
        JButton userButton = new JButton("Login");
        userButton.setBounds(275, 195,100,50);
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
        userLabel.setLocation(190, 150);
        userLabel.setSize(100, 25);
        userLogin.add(userLabel);

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
            thisButton.setText("Hit");
        }
    }

    static class AdminLoginListener implements ActionListener{
        JButton thisButton;
        AdminLoginListener(JButton button){
            thisButton = button;
        }
        public void actionPerformed(ActionEvent event){
            thisButton.setText("Hit");
        }
    }



    public JFrame getParentFrame(){
        return parentFrame;
    }
}
