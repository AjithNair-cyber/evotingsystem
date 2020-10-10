package app;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{

    JPanel mainPanel;
    
    public MainFrame(){
        setSize(1000, 600);
        setTitle("E-Voting System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel =  LoginPanel.getPanel(this);
        getContentPane().add(BorderLayout.CENTER,mainPanel);
        setVisible(true);
        setResizable(false);
    }

    public void setPanel(JPanel panel){
       mainPanel =  panel;
    }

    public JPanel getPanel(){
        return mainPanel;
    }
}
