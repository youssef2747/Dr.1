

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

public class intrface  implements ActionListener{

    ImageIcon icon=new ImageIcon("22.jpg");
    JFrame fr=new JFrame();
    JButton lb=new JButton("LOGIN");
    JButton rb=new JButton("RESET");
    JTextField t =new JTextField();
    JPasswordField pass=new JPasswordField();
    JLabel l =new JLabel("USER NAME");
    JLabel lpass =new JLabel("PASSWORD");
    JLabel lmaseg =new JLabel("");


    HashMap<String,String> logan= new HashMap <String,String>();
    intrface(HashMap<String,String> loganinfo){
        logan=loganinfo;



        l.setForeground(Color.red);
        l.setBounds(50,100,75,25);
        lpass.setForeground(Color.red);
        lpass.setBounds(50,150,75,25);


        lmaseg.setBounds(125,250,250,35);
        lmaseg.setFont(new Font(null,Font.BOLD,25));

        t.setFont(new Font(null,Font.ITALIC,15));
        t.setForeground(Color.cyan);
        t.setBackground(Color.red);
        t.setBounds(125,100,200,25);
        pass.setBounds(125,150,200,25);
        pass.setBackground(Color.red);
        pass.setForeground(Color.cyan);
        pass.setFont(new Font(null,Font.BOLD,15));




        rb.setBounds(225,200,100,25);
        rb.addActionListener(this);
        rb.setFocusable(false);
        rb.setBackground(Color.green);

        lb.setFocusable(false);
        lb.setBounds(125,200,100,25);
        lb.setBackground(Color.green);
        lb.addActionListener(this);


        fr.add(pass);
        fr.add(lb);
        fr.add(rb);
        fr.add(lmaseg);
        fr.add(t);
        fr.add(lpass);
        fr.add(l);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500,500);
        fr.setLayout(null);
        fr.setVisible(true);
        fr.getContentPane().setBackground(Color.black);
      //  fr.setIconImage(icon.getImage());
        


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource()==rb){
            t.setText("");
            pass.setText("");


        }
        if (actionEvent.getSource()==lb){
            String userid = t.getText();
            String password =String.valueOf(pass.getPassword());
            if (logan.containsKey(userid)){
                if (logan.get(userid).equals(password)){
                    lmaseg.setForeground(Color.green);
                    lmaseg.setText("login successful");
                    SliderDemo b =new SliderDemo();
                    fr.dispose();
                }

                else {

                    lmaseg.setForeground(Color.red);
                    lmaseg.setText("worng password");

                }

            }
            else {
                lmaseg.setForeground(Color.red);
                lmaseg.setText("username not found");
            }




        }
    }
}

