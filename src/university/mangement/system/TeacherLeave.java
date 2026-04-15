package university.mangement.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice choiceRollNo,choTime;
    JDateChooser selDate;
    JButton submit,cancel;

    TeacherLeave(){

        getContentPane().setBackground(new Color(49, 223, 223));


        JLabel heading=new JLabel(" Apply Teacher Leave");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel RollNo=new JLabel("Search by Emp ID");
        RollNo.setBounds(60,100,200,20);
        RollNo.setFont(new Font("Tahoma",Font.BOLD,20));
        add(RollNo);

        choiceRollNo= new Choice();
        choiceRollNo.setBounds(60,130,200,20);
        add(choiceRollNo);

        try {
            conn c= new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Teacher");
            while (resultSet.next()){
                choiceRollNo.add(resultSet.getString("empId"));
            }


        }catch (Exception e){
            e.printStackTrace();

        }
        JLabel lbldate =new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);


        selDate =new JDateChooser();
        selDate.setBounds(60,210,200,25);
        add(selDate);

        JLabel time =new JLabel("Time Duration");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(time);

        choTime = new Choice();
        choTime.setBounds(60,290,280,20);
        choTime.add("Full Day");
        choTime.add("Half Day");
        add(choTime);

        submit =new JButton("Submit");
        submit.setBounds(60,350,100,20);
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        add(submit);


        cancel =new JButton("Cancel");
        cancel.setBounds(280,350,100,20);
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);
        cancel.addActionListener(this);
        add(cancel);










        setSize(600,700);
        setLocation(450,100);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit){
            String empId= choiceRollNo.getSelectedItem();
            String date =((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time =choTime.getSelectedItem();

            String Q = "insert into teacherLeave  values('"+empId+"','"+date+"','"+time+"')";

            try{
                conn c =new conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);



            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeave();

    }
}
