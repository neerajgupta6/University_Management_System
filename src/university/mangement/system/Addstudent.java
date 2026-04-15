package university.mangement.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Addstudent extends JFrame implements ActionListener {

    JTextField textName,textFather,textAddress,textPhone,textEmail,textM10,textM12,textAadharNO;
    JLabel empText;
    JDateChooser cdob;
    JComboBox courseBox,departmentBox;
    JButton submit,cancel;

    Random ran = new Random();
    Long f4= Math.abs((ran.nextLong()%9000L)+1000L);


    Addstudent(){
        getContentPane().setBackground(new Color(166,164,255));

        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);


        JLabel name= new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName=new JTextField();
        textName.setBounds(200,150,200,30);
        add(textName);

        JLabel fname= new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textFather=new JTextField();
        textFather.setBounds(600,150,200,30);
        add(textFather);

        JLabel empId= new JLabel("Enrollment No");
        empId.setBounds(50,200,200,30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);

        empText= new JLabel("2026"+f4);
        empText.setBounds(200,200,200,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        JLabel dob= new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob =new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

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

        textM10=new JTextField();
        textM10.setBounds(600,300,200,30);
        add(textM10);

        JLabel M12= new JLabel("12th (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        textM12=new JTextField();
        textM12.setBounds(200,350,200,30);
        add(textM12);

        JLabel aadhar= new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,200,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);

        textAadharNO=new JTextField();
        textAadharNO.setBounds(600,350,200,30);
        add(textAadharNO);

        JLabel Qualification= new JLabel("Course");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        String course[]={"B.TECH","MCA","MBA","BBA","BCA","B.COM"};
        courseBox=new JComboBox(course);
        courseBox.setBounds(200,400,200,30);
        courseBox.setFont(new Font("serif",Font.BOLD,20));
        add(courseBox);

        JLabel Department= new JLabel("Branch");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        String department[]={"Computer Science","Electronic","Mechanical","Commerce","Civil"};
        departmentBox=new JComboBox(department);
        departmentBox.setBounds(600,400,200,30);
        departmentBox.setFont(new Font("serif",Font.BOLD,20));
        add(departmentBox);

        submit=new JButton("Submit");
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
        if(e.getSource()==submit){
            String name =textName.getText();
            String fname =textFather.getText();
            String empId =empText.getText();
            String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String address =textAddress.getText();
            String phone =textPhone.getText();
            String email =textEmail.getText();
            String x =textM10.getText();
            String xii =textM12.getText();
            String addhar =textAadharNO.getText();
            String course=(String) courseBox.getSelectedItem();
            String department=(String) departmentBox.getSelectedItem();
            try{
                String q= "insert into student values ('"+name+"', '"+fname+"', '"+empId+"', '"+dob+"', '"+address+"', '"+phone+"','"+email+"','"+x+"','"+xii+"','"+addhar+"' ,'"+course+"','"+department+"')";
                conn c  =new conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Inserted");
                setVisible(false);


            }catch (Exception E){
                E.printStackTrace();

            }

        }else {
            setVisible(false);
        }

    }
    public static void main (String[]args){
        new Addstudent();
    }


}
