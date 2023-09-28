import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {

    JButton delete, back;
    String username;

    DeleteDetails (String username) {

        this.username = username;

        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(new Color(250, 249, 246));
        setLayout(null);

        JLabel lblusername = new JLabel("Username: ");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id: ");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number: ");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name: ");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender: ");
        lblgender.setBounds(30, 290, 150, 25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country: ");
        lblcountry.setBounds(30, 350, 150, 25);
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(220, 350, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address: ");
        lbladdress.setBounds(30, 410, 150, 25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(220, 410, 150, 25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setBounds(30, 470, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 470, 150, 25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email: ");
        lblemail.setBounds(30, 530, 150, 25);
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(220, 530, 150, 25);
        add(labelemail);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(740, 550, 100, 25);
        back.addActionListener(this);
        add(back);

        delete = new JButton("Delete");
        delete.setForeground(Color.BLACK);
        delete.setBounds(740, 500, 100, 25);
        delete.addActionListener(this);
        add(delete);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }



        setVisible(true);
    }

    public static void main(String[] args) {
        DeleteDetails deleteDetails = new DeleteDetails("bhushan");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username = '"+username+"'");
                c.s.executeUpdate("delete from customer where username = '"+username+"'");
                c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
                c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");

                JOptionPane.showMessageDialog(null, "Data Deleted Successfully!");
                setVisible(false);
            }catch (Exception e1) {
                e1.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
}
