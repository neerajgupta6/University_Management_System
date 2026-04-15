package university.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        //img.setBounds(400, 50, 500, 300);
        add(img);

        JMenuBar mb=new JMenuBar();

        // Information

        JMenu newinfo=new JMenu("New Information");
        newinfo.setForeground(Color.black);
        mb.add(newinfo );

        JMenuItem FacultyInfo=new JMenuItem("New Faculty Information");
        FacultyInfo.setBackground(Color.white);
        FacultyInfo.addActionListener(this);
        newinfo.add(FacultyInfo);

        JMenuItem StudentInfo=new JMenuItem("New Student Information");
        StudentInfo.setBackground(Color.white);
        StudentInfo.addActionListener(this);
        newinfo.add(StudentInfo);


        //Details
        JMenu detail=new JMenu("View Details");
        detail.setForeground(Color.black);
        mb.add(detail );

        JMenuItem StudentDetail=new JMenuItem("View Student Details");
        StudentDetail.setBackground(Color.white);
        StudentDetail.addActionListener(this);
        detail.add(StudentDetail);

        JMenuItem FacultyDetails=new JMenuItem("View Faculty Details");
        FacultyDetails.setBackground(Color.white);
        FacultyDetails.addActionListener(this);
        detail.add(FacultyDetails);
        //Leave

        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.black);

        mb.add(leave );

        JMenuItem StudentLeavel=new JMenuItem("Student Leave");
        StudentLeavel.setBackground(Color.white);
        StudentLeavel.addActionListener(this);
        leave.add(StudentLeavel);

        JMenuItem FacultyLeave=new JMenuItem("Faculty Leave");
        FacultyLeave.setBackground(Color.white);
        FacultyLeave.addActionListener(this);
        leave.add(FacultyLeave);

        //Leave Details

        JMenu leaveDetails=new JMenu("Apply Leave Details");
        leaveDetails.setForeground(Color.black);
        mb.add(leaveDetails);

        JMenuItem StudentLeaveDetails=new JMenuItem("Student Leave Details");
        StudentLeaveDetails.setBackground(Color.white);
        StudentLeaveDetails.addActionListener(this);
        leaveDetails.add(StudentLeaveDetails);

        JMenuItem FacultyLeaveDetails=new JMenuItem("Faculty Leave Details");
        FacultyLeaveDetails.setBackground(Color.white);
        FacultyLeaveDetails.addActionListener(this);
        leaveDetails.add(FacultyLeaveDetails);
        //
         //Exam

        JMenu Exam=new JMenu("Examination");
        Exam.setForeground(Color.black);
        mb.add(Exam );

        JMenuItem ExaminationDetails=new JMenuItem("Examination Result");
        ExaminationDetails.setBackground(Color.white);
        ExaminationDetails.addActionListener(this);
        Exam.add(ExaminationDetails);

        JMenuItem EnterMark=new JMenuItem("Enter Mark");
        EnterMark.setBackground(Color.white);
        EnterMark.addActionListener(this);
        Exam.add(EnterMark);

        //Update Info
        JMenu UpdateInfo=new JMenu("Update Information");
        UpdateInfo.setForeground(Color.black);
        mb.add(UpdateInfo );

        JMenuItem StudentUpdateInfo=new JMenuItem("Student Update Info");
        StudentUpdateInfo.setBackground(Color.white);
        StudentUpdateInfo.addActionListener(this);
        UpdateInfo.add(StudentUpdateInfo);

        JMenuItem FacultyUpdateInfo=new JMenuItem("Faculty Update Info");
        FacultyUpdateInfo.setBackground(Color.white);
        FacultyUpdateInfo.addActionListener(this);
        UpdateInfo.add(FacultyUpdateInfo);

        //Fee
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.black);
        mb.add(fee );

        JMenuItem feeStructure=new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm=new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.white);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        //Utility
        JMenu Utility=new JMenu("Utility ");
        Utility.setForeground(Color.black);
        mb.add(Utility );

        JMenuItem calculator=new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.addActionListener(this);
        Utility.add(calculator);

        JMenuItem Note=new JMenuItem("Note");
        Note.setBackground(Color.white);
        Note.addActionListener(this);
        Utility.add(Note);

        //About
        JMenu about=new JMenu("About");
        about.setForeground(Color.black);
        mb.add(about );

        JMenuItem About=new JMenuItem(" About");
        About.setBackground(Color.white);
        about.add(About);

        //Exit
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit );

        JMenuItem Exit=new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);




        setJMenuBar(mb);


        setSize(1540,850);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm=e.getActionCommand();
        if (sm.equals("Exit")){
            System.exit(15);
        } else if (sm.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("open -a Calculator");
            }catch (Exception E){
                E.printStackTrace();
            }
            
        } else if (sm.equals("New Faculty Information")) {
            new Addfaculty();
            
        } else if (sm.equals("New Student Information")) {
            new Addstudent();
            
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
            
        } else if (sm.equals("View Faculty Details")) {
            new FacultyDetails();
            
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
            
        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();
            
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetail();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
            
        } else if (sm.equals("Student Update Info")) {
            new UpdateStudent();
            
        } else if (sm.equals("Faculty Update Info")) {
            new UpdateTeacher();

        } else if (sm.equals("Enter Mark")) {
            new EnterMarkes();
        } else if (sm.equals("Examination Result")) {
            new ExaminationDetails();
            
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
            
        } else if (sm.equals("Student Fee Form")) {
            new StudentFeeForm();
            
        }

    }

    public static void main (String []args){
        new main_class();
    }
}
