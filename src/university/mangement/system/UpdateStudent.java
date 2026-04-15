package university.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField textAddress,textPhone,textEmail,textAadharNO,textCourse,textbranch;
    JLabel empText;

    JButton submit,cancel;
    Choice cEMPID;

    UpdateStudent(){

        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel empId=new JLabel("Select Roll Number");
        empId.setBounds(50,100,200,20);
        empId.setFont(new Font("serif",Font.PLAIN,20));
        add(empId);

        cEMPID =new Choice();
        cEMPID.setBounds(250,100,200,20);
        add(cEMPID);

        try {
            conn c =new conn();
            ResultSet rs=c.statement.executeQuery("select * from student");
            while (rs.next()){
                cEMPID.add(rs.getString("rollno"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel name= new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName=new JLabel();
        textName.setBounds(200,150,200,30);
        add(textName);

        JLabel fname= new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        JLabel textFather=new JLabel();
        textFather.setBounds(600,150,200,30);
        add(textFather);

        JLabel EMPIDD= new JLabel(" Rollno");
        EMPIDD.setBounds(50,200,200,30);
        EMPIDD.setFont(new Font("serif",Font.BOLD,20));
        add(EMPIDD);

        empText= new JLabel();
        empText.setBounds(200,200,200,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel dob= new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel dobdob=new JLabel();
        dobdob.setBounds(600,200,250,30);
        add(dobdob);


        JLabel address= new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress=new JTextField();
        textAddress.setBounds(200,250,200,30);
        add(textAddress);

        JLabel phone= new JLabel("Phone Number");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone=new JTextField();
        textPhone.setBounds(600,250,200,30);
        add(textPhone);

        JLabel email= new JLabel("E-Mail");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textEmail=new JTextField();
        textEmail.setBounds(200,300,200,30);
        add(textEmail);

        JLabel M10= new JLabel("10th (%)");
        M10.setBounds(400,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

        JLabel textM10=new JLabel();
        textM10.setBounds(600,300,200,30);
        add(textM10);

        JLabel M12= new JLabel("12th (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        JLabel textM12=new JLabel();
        textM12.setBounds(200,350,200,30);
        add(textM12);

        JLabel aadhar= new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,200,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);

        textAadharNO=new JTextField();
        textAadharNO.setBounds(600,350,200,30);
        add(textAadharNO);

        JLabel Qualification= new JLabel("course");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        textCourse=new JTextField();
        textCourse.setBounds(200,400,150,30);
        add(textCourse);


        JLabel Department= new JLabel("branch");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textbranch=new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);


        try {
            conn c=new conn();
            String query="select * from student where rollno='"+cEMPID.getSelectedItem()+"'";
            ResultSet resultSet=c.statement.executeQuery(query);
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textEmail.setText(resultSet.getString("email"));
                textPhone.setText(resultSet.getString("phone"));
                textM10.setText(resultSet.getString("class_X"));
                textM12.setText(resultSet.getString("class_XII"));
                textAadharNO.setText(resultSet.getString("aadhar"));
                empText.setText(resultSet.getString("rollno"));
                textCourse.setText(resultSet.getString("course"));
                textbranch.setText(resultSet.getString("branch"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {

                    conn c=new conn();
                    String query="select * from student where rollno='"+cEMPID.getSelectedItem()+"'";
                    ResultSet resultSet=c.statement.executeQuery(query);
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textFather.setText(resultSet.getString("fname"));
                        dobdob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textEmail.setText(resultSet.getString("email"));
                        textPhone.setText(resultSet.getString("phone"));
                        textM10.setText(resultSet.getString("class_X"));
                        textM12.setText(resultSet.getString("class_XII"));
                        textAadharNO.setText(resultSet.getString("aadhar"));
                        empText.setText(resultSet.getString("rollno"));
                        textCourse.setText(resultSet.getString("course"));
                        textbranch.setText(resultSet.getString("branch"));
                    }


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        submit=new JButton("Update");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        add(cancel);










        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String empid=empText.getText();
            String address=textAddress.getText();
            String phone=textPhone.getText();
            String email=textEmail.getText();
            String course=textCourse.getText();
            String branch=textbranch.getText();

            try {
                String Q="update student set address='"+address+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where rollno='"+empid+"'";
                conn c=new conn();
                c.statement.executeUpdate(Q);

                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }



    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
