package Employeemanagement;

import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEMPID;

    JButton delete,back;




    RemoveEmployee() {

        JLabel lable=new JLabel("Employee ID");
        lable.setBounds(50,50,100,30);
        lable.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lable);


        choiceEMPID=new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

      try {

          conn c=new conn();
          ResultSet resultSet=c.statement.executeQuery("select * from employee");
          while (resultSet.next()){
              choiceEMPID.add(resultSet.getString("empId"));
          }

      }
      catch (Exception e){
          e.printStackTrace();
      }

        JLabel lableName=new JLabel("Name");
        lableName.setBounds(50,100,100,30);
        lableName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lableName);

        JLabel textName=new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);

        JLabel lablephone=new JLabel("Phone");
        lablephone.setBounds(50,150,100,30);
        lablephone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lablephone);

        JLabel textPhone=new JLabel();
        textPhone.setBounds(200,150,100,30);
        add(textPhone);

        JLabel lableemail=new JLabel("Email");
        lableemail.setBounds(50,200,100,30);
        lableemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lableemail);

        JLabel textEmail=new JLabel();
        textEmail.setBounds(200,200,100,30);
        add(textEmail);


        try {

            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));

                    }
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);


        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22=i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image=new JLabel(i33);
        image.setBounds(0,0,1120,630);
        add(image);








        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==delete){
            try {
                    conn c=new conn();
                    String query="delete from employee where empId = '"+choiceEMPID.getSelectedItem()+"'";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Deleted Sucessfully");
                    setVisible(false);
                    new Main_class();
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }


}
