package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userText,passwordText;
    Choice loginChoice;

    JButton loginButton,cancelButton,signupButton;

    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.yellow);

        JLabel username = new JLabel("UserName");
        username.setBounds(300,40,100,20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400,40,150,20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300,80,100,20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400,80,150,20);
        add(passwordText);

        JLabel loggin = new JLabel("Login In As");
        loggin.setBounds(300,120,100,20);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,120,150,20);
        add(loginChoice);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/new/login.png"));
        Image i2 = i1.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);
        loginButton = new JButton("Login", new ImageIcon(i2));
        loginButton.setBounds(330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/new/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);
        cancelButton = new JButton("Cancel", new ImageIcon(i4));
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/new/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
        signupButton = new JButton("Signup", new ImageIcon(i6));
        signupButton.setBounds(400,215,130,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne =  new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTow = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTow);
        JLabel profileLable = new JLabel(fprofileOne);
        profileLable.setBounds(5,5,250,250);
        add(profileLable);



        setSize(640,300);
        setLocation(400,200);
        setLayout(null); //default bounder line remove
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginButton){
             String susername = userText.getText();
             String spassword = passwordText.getText();
             String user = loginChoice.getSelectedItem();

             try{
                 database d = new database();
                 String query = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"' and usertype ='"+user+"'";
                 ResultSet resultSet = d.statement.executeQuery(query);

                 if (resultSet.next()){
                     String meter = resultSet.getString("meter_no");
                     setVisible(false);
                     new main_class(user,meter);
                 }else {
                     JOptionPane.showMessageDialog(null ,"Invalid Login");
                     userText.setText("");
                     passwordText.setText("");
                 }

             }catch (Exception E){
                 E.printStackTrace();
             }
        } else if (e.getSource()==cancelButton) {
            setVisible(false);
        } else if (e.getSource()==signupButton) {
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
