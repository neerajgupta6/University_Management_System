package university.mangement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FeeStructure extends JFrame implements ActionListener {

    FeeStructure(){
        getContentPane().setBackground(Color.white);

        JLabel heading=new JLabel("Fee Structure");
        heading.setBounds(400,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);

        JTable table=new JTable();

        try {
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }


        JScrollPane js=new JScrollPane(table);
        js.setBounds(0,60,1000,700);
        add(js);




        setSize(1000,700);
        setLayout(null);
        setLocation(250,50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
