
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.Vector;

public class SliderDemo implements ChangeListener {

    JFrame frame;
    JPanel panel;
    JLabel label;

    JSlider slider;

   // ImageIcon image =new ImageIcon("orsrc41690");

    JButton bb=new JButton("BACK");
    JButton bn=new JButton("NEXT");


    SliderDemo(){


        frame=new JFrame( new ImageIcon ("D:\\22.jpg") +"Slider Demo");
        panel=new JPanel();
        label= new  JLabel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        slider=new JSlider(0,100,50);

        Border border=BorderFactory.createLineBorder(Color.black,3);
        bb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				intrface2 i2=new intrface2();


			     intrface i=new intrface(i2.getlogan());
			     frame.dispose();
			}
        	
        });
        bn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Doctor();
			}
        	
        });


        panel.setBackground(Color.white);

        


        slider.setBackground(Color.white);
        slider.setForeground(Color.red);
        slider.setBorder(border);

      //  label.setBounds(20, 250, 100, 25);
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setForeground(Color.red);
        label.setBorder(border);
        
        
        
        bb.setBounds(225,250,100,25);
        bb.setBackground(Color.yellow);
        
        bn.setBounds(125,250,100,25);
        bn.setBackground(Color.yellow);

        JButton b = new JButton("Submit");



        slider.setPreferredSize(new Dimension(400,200));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        label.setFont(new Font("MV Boli",Font.PLAIN,15));

        frame.add(bb);
        frame.add(bn);


        frame.add(b,BorderLayout.SOUTH);
        b.setBackground(Color.black);
        slider.setOrientation(SwingConstants.VERTICAL);
        //   slider.setOrientation(SwingConstants.HORIZONTAL);
        JLabel j = new JLabel();
        j.setForeground(Color.red);
        j.setFont(new Font("MV Boli",Font.PLAIN,13));
        frame.getContentPane().setBackground(Color.white);
        j.setBorder(border);
        j.setBounds(20, 250, 100, 25);
        


        label.setText("°C =" +"°"+ slider.getValue());


        slider.addChangeListener(this);

       // frame .setIconImage(image.getImage());

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                j.setText(""+slider.getValue());
            //    if(slider.getValue() >75&&slider.getValue()<=100){
              //      j.setText("Error");
               // }
  

              if(slider.getValue() >29&&slider.getValue()<=32){

                
                j.setText("signs begen to appear including difficulty spieaking and memory loss in addition to the inabilty to use hands and cassation of cessation of celluler metabolism");
              }
            
                
                if(slider.getValue() >33&&slider.getValue()<=35){
                	j.setText("Cold/icing pain, freezing and tissue destruction. Superficial cooling of tissues without destroying cells ");
                }

                if(slider.getValue()==37){
                	
                	j.setText("The normal human body temperature");
                	
                }


                if(slider.getValue()==36){
                	
                	j.setText("The normal human body temperature");
                	
                }
                                
                if(slider.getValue() >21&&slider.getValue()<=28){
                
                	j.setText("Unconscious, trembling severely");
                }

                if(slider.getValue() ==20){
                
                j.setText("No vital signs");                	
             
                }

                if(slider.getValue() ==38){
                j.setText("fever and When touching the chest or back, it may be one of the symptoms of corona.");
                }
                
                if(slider.getValue() >0&&slider.getValue()<=19){
                	
                	j.setText("case has not been diagnosed");
                	
                }
                if(slider.getValue() >43&&slider.getValue()<=100){
                	
                	j.setText("case has not been diagnosed");

                }
                if(slider.getValue() ==40){
                	
                	j.setText("OF THE SYMBTOMS ARE  1.heat stroke 2.heat iliness ");
                }

                
                    if(slider.getValue() ==39){
                        j.setText("OF THE SYMBTOMS ARE 1.server headache and dizziness   2.sensitivity to bright lig  3.nack or neck stiffness  4.skin resh  5.breathing difficuty  6.frequent vomiting  7.drought .stomaachache  9.muscle spam "  );                    
                    }
      
                    if(slider.getValue()==42){
                    	
                    	j.setText("these high body temperatures can cause malfunction and eventual failure of most orgens somtimes this extreme elevation is cusid by vary sever infection(such as sepsis malaria or meningitis) heat stroke or the use of certin medications drougs that can cause avery high temperature include some illegal drugs (such as cocaine amphetamines or phencyclidine  )anesthetics   ");
                    	
                    }


                    if(slider.getValue()==41){
                    	
                    	j.setText("these high body temperatures can cause malfunction and eventual failure of most orgens somtimes this extreme elevation is cusid by vary sever infection(such as sepsis malaria or meningitis) heat stroke or the use of certin medications drougs that can cause avery high temperature include some illegal drugs (such as cocaine amphetamines or phencyclidine  )anesthetics   ");
                    }
                }

            


            
            

        });
        panel.add(j);
        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(600,600);
        frame.setVisible(true);



    }



    @Override
    public void stateChanged(ChangeEvent changeEvent) {

        label.setText("°C = " + "°"+slider.getValue());


    }
}



