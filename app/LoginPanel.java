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
        JPanel intro = new JPanel();
        intro.setBounds(0, 0, 500, 600);
        intro.setBackground(Color.RED);
        JPanel adminLogin = new JPanel();
        adminLogin.setBounds(500, 0, 500, 300);
        adminLogin.setBackground(Color.BLUE);
        JPanel userLogin = new JPanel();
        userLogin.setBounds(500, 300, 500, 300);
        userLogin.setBackground(Color.YELLOW);


        mainPanel.add(intro);
        mainPanel.add(adminLogin);
        mainPanel.add(userLogin);

        return mainPanel;

    }

    public JFrame getParentFrame(){
        return parentFrame;
    }
}
