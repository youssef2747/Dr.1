import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.lang.Object;



public class Doctor implements ActionListener {
    Doctor(){
        JFrame frame=new JFrame("sheet");
        JTable table =new JTable();
        JButton rb=new JButton("BACK");
        JLabel id=new  JLabel("ID OR CODE");
        JLabel name=new  JLabel("NAME");
        JLabel st=new  JLabel("START OF History");
        JLabel end=new  JLabel("END OF History");
        
        
        Object[] columns={"ID OR CODE","NAME","HASTORY","END OF HESTORY"};
        DefaultTableModel model =new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.BLACK);
        table.setForeground(Color.red);
        Font font =new Font ("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        for(int i =0 ; i<database.getPersons().size();i++) {
        	person a = new person(database.getPersons().get(i).getId(),database.getPersons().get(i).getName(),database.getPersons().get(i).getStart_His(),database.getPersons().get(i).getEnd_His());
        	Object []row = new Object[4];
        	row[0]=a.getId();
            row[1]=a.getName();
            row[2]=a.getStart_His();
            row[3]=a.getEnd_His();
            model.addRow(row);
        }

        JTextField textcode =new JTextField();
        JTextField textname =new JTextField();
        JTextField texthastory =new JTextField();
        JTextField textend =new JTextField();

        JButton badd=new JButton("ADD");
        JButton badelet=new JButton("DELETE");
        badelet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = String.valueOf(model.getValueAt(table.getSelectedRow(), 1));
				database.remove(person.LinearSearch(name));
				model.removeRow(table.getSelectedRow());
				
			}
        	
        });
        
        JButton bubdate=new JButton("UPDATE");
        bubdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String code=textcode.getText();
				String name=textname.getText();
				String Start_history=texthastory.getText();
				String End_History=textend.getText();
				database.updatePerson(Integer.parseInt(code), name, Integer.parseInt(Start_history), Integer.parseInt(End_History), person.LinearSearch(String.valueOf(model.getValueAt(table.getSelectedRow(), 1))));
				model.setValueAt(code, table.getSelectedRow(), 0);
				model.setValueAt(name, table.getSelectedRow(), 1);
				model.setValueAt(Start_history, table.getSelectedRow(), 2);
				model.setValueAt(End_History, table.getSelectedRow(), 3);
			}
        	
        });


        textcode.setBounds(150, 220, 100, 25);
        textcode.setBackground(Color.cyan);
        textname.setBounds(150, 250, 100, 25);
        textname.setBackground(Color.cyan);
        texthastory.setBounds(150, 280, 100, 25);
        texthastory.setBackground(Color.cyan);
        textend.setBounds(150, 310, 100, 25);
        textend.setBackground(Color.cyan);
        
        id.setBounds(20, 220, 100, 25);
        id.setBackground(Color.cyan);
        name.setBounds(20, 250, 100, 25);
        name.setBackground(Color.cyan);
        st.setBounds(20, 280, 100, 25);
        st.setBackground(Color.cyan);
        end.setBounds(20, 310, 100, 25);
        end.setBackground(Color.cyan);
        


        badd.setBounds(270, 220, 100, 25);
        badd.setBackground(Color.cyan);        
        badelet.setBounds(270, 265, 100, 25);
        badelet.setBackground(Color.cyan);
        bubdate.setBounds(270, 310, 100, 25);
        bubdate.setBackground(Color.cyan);
        
        JScrollPane pane=new JScrollPane(table);
        pane.setBounds(0, 0, 880,200);
        pane.setBackground(Color.black);
        
        rb.setBounds(700, 310, 100, 25); 
        rb.setBackground(Color.yellow);
        rb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SliderDemo();
			}
        	
        });
        
        frame .setLayout(null);
        frame.add(textcode);
        frame.add(textname);
        frame.add(texthastory);
        frame.add(textend);
        frame.add(badelet);
        frame.add(bubdate);
        frame.add(badd);
        frame.add(pane);
        frame.add(rb);

        frame.add(id);
        frame.add(name);
        frame.add(st);
        frame.add(end);
        
        
        
        Object[] row= new Object[4];
        badd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                row[0]=textcode.getText();
                row[1]=textname.getText();
                row[2]=texthastory.getText();
                row[3]=textend.getText();
                model.addRow(row);
                database.addPerson(String.valueOf(row[1]), Integer.parseInt(String.valueOf(row[0])), Integer.parseInt(String.valueOf(row[2])), Integer.parseInt(String.valueOf(row[3])));
            }
        });

        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

