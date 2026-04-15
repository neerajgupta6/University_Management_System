package university.mangement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice choiceEmpId;
    JTable table;
    JButton search,cancel,print;


    TeacherLeaveDetails(){
        getContentPane().setBackground(new Color(0xE185EF));

        JLabel heading=new JLabel(" Search by Employee Id");
        heading.setBounds(20,20,150,20);
        //heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(180,20,150,20);
        add(choiceEmpId);

        try{
            conn c = new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from teacher");
            while (resultSet.next()){
                choiceEmpId.add(resultSet.getString("empId"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        table= new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet= c.statement.executeQuery("select * from TeacherLeave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane= new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        cancel =new JButton("cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);




        setSize(900,700);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){
            String q = "select * from  teacherLeave where empId ='"+choiceEmpId.getSelectedItem()+"'";

            try{
                conn c = new conn();
                ResultSet resultSet=c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception E){
                E.printStackTrace();

            }
        }else if (e.getSource()==print){
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();

    }
}
