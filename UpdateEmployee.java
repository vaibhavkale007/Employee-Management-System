package Employeemanagement;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;


public class UpdateEmployee extends JFrame implements ActionListener {


    Random ran=new Random();
    int number=ran.nextInt(999999);

    JTextField teducation,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel  tempid;

    JButton add,back;
     String numberr;




    UpdateEmployee(String numberr){

      this.numberr=numberr;

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading=new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);


        JLabel name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname=new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);



        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

       JLabel tdob=new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tdob);





        JLabel salary=new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address=new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel email=new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail=new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);


        JLabel education=new JLabel("Higest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation=new JTextField();
        teducation.setBounds(600,300,150,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);



        JLabel aadhar=new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel taadhar=new JLabel();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid=new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid=new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel designation=new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation=new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        try {
            conn c=new conn();
            String query="select * from employee where empId ='"+numberr+"'";
            ResultSet resultSet=c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getNString("name"));
                tfname.setText(resultSet.getNString("fname"));
                tdob.setText(resultSet.getNString("dob"));
                taddress.setText(resultSet.getNString("address"));
                tsalary.setText(resultSet.getNString("salary"));
                tphone.setText(resultSet.getNString("phone"));
                temail.setText(resultSet.getNString("email"));
                teducation.setText(resultSet.getNString("education"));
                taadhar.setText(resultSet.getNString("aadhar"));
                tempid.setText(resultSet.getNString("empId"));
                tdesignation.setText(resultSet.getNString("designation"));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }




        add=new JButton("UPDATE");
        add.setBounds(450,550,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==add){
        String fname=tfname.getText();
        String salary=tsalary.getText();
        String address=taddress.getText();
        String phone=tphone.getText();
        String email=temail.getText();
        String education=teducation.getText();
        String designation=tdesignation.getText();

        try {
            conn c=new conn();
            String query="update employee set fname ='" + fname +"',salary= '"+ salary + "',address='" + address + "',phone='" + phone + "',email='" + email + "',education='"+education+"', designation ='" + designation + "' where empId='"+numberr+"'";
           c.statement.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Details updated successfully");
           setVisible(false);
           new Main_class();

        }

        catch (Exception E){
            E.printStackTrace();
        }

    }
    else {
        setVisible(false);
        new View_Employee();
    }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");

    }
}
