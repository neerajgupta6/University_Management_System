package university.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textFiledName;
    JPasswordField passwordField;
    JButton login,back;


    login(){
        JLabel labelName =new JLabel("Username");
        labelName.setBounds(40,20,100,20);
        add(labelName);

        textFiledName =new JTextField();
        textFiledName.setBounds(150,20,150,20);
        add(textFiledName);

        JLabel labelpass =new JLabel("Password");
        labelpass.setBounds(40,70,100,20);
        add(labelpass);

        passwordField =new JPasswordField();
        passwordField.setBounds(150,70,150,20);
        add(passwordField);

        login =new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.black);
        login.setBackground(Color.white);
        login.addActionListener(this);
        add(login);

        back =new JButton("Back");
        back.setBounds(180,140,120,30);
        back.setBackground(Color.black);
        back.setBackground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel img =new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);


        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i22=i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 =new ImageIcon(i22);
        JLabel image =new JLabel(i33);
        image.setBounds(0,0,600,300);
        add(image);






        setSize(600,300);
        setLocation(500,250);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== login){
            String username=textFiledName.getText();

            String password=passwordField.getText();

            String query="select * from login where username='"+username+"' and password='"+password+"'";
            try{
                conn c= new conn();
                ResultSet resultSet=c.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    //next class
                    new main_class();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");

                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }

    }

    public static void main (String []args){
        new login();
    }
}
