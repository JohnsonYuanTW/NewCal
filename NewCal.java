import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCal {
        JLabel label = new JLabel("0",SwingConstants.RIGHT);
        static public int isLight = 0;
        static JButton lighted;
        static BtnProcess bp = new BtnProcess();

	public static void main(String[] args) 
        {
                //這裡沒有東西
        }
       
       NewCal()
       {
        JFrame demo = new JFrame();
                demo.setSize(566, 460);
                demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                demo.getContentPane().setLayout(new FlowLayout(0,0,0));
                Panel p1 = new Panel(new FlowLayout(FlowLayout.CENTER));
                p1.setSize(550, 100);
                p1.setBackground(new Color(33, 33, 33));
                label.setPreferredSize(new Dimension(550,100));
                label.setForeground(Color.white);
                label.setLocation(20,10);
                label.setFont(new Font("Forte",Font.PLAIN,60));
                p1.add(label);
                demo.add(p1);

                String[] list = {"√", "^","C","÷", "7", "8", "9", "sin", "x!", "del", "X", "4", "5", "6", "cos", "1/x", "%", "-", "1", "2", "3", "tan", "log", "=", "+", "+/-", "0", "."}; 
                for (int i = 0; i < 28; i++) {
                	JButton a = new JButton("" + list[i]);
                    a.setFont(new Font("Forte", Font.PLAIN, 24));
                    a.setFocusPainted(false);
                    a.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    a.setPreferredSize(new Dimension(80,80));
                    if(i % 7 == 3 || i == 1 || i == 16)
                    {
                        a.setName("b" + list[i]);
                    }else if(i % 7 == 0 || i % 7 == 1 || i == 25){
                        if (i != 1) {
                        	a.setName("u" + list[i]);
                        }
                    }else{
                        a.setName(list[i]);
                    }
                    if (i % 7 == 4 || i % 7 == 5 || i % 7 == 6) {
                    	a.setBackground(new Color(209, 210, 212));
                    	a.setForeground(Color.black);
                    }
                    if (i % 7 == 2 || i % 7 == 3) {
                    	a.setBackground(new Color(249, 127, 16));
                    	a.setForeground(Color.white);
                    }
                    if (i % 7 == 0 || i % 7 == 1) {
                    	a.setBackground(new Color(197, 198, 200));
                    	a.setForeground(Color.black);
                    }
                    a.addActionListener(new BtnHandler());
                    a.addKeyListener(new BtnListener());
                    a.setFocusable(true);
                    demo.add(a);
               }
               demo.setResizable(false); 
               demo.setVisible(true);
       }


        static class BtnHandler implements ActionListener
        {
                public void actionPerformed(ActionEvent event)
                {

                        Object obj = event.getSource();                        
                        if(obj instanceof JButton)
                        {      
                                JButton btn = (JButton)obj;
                                String btnName = btn.getName();
                                System.out.println(btnName);
                                bp.checkType(btnName);
                                if(isLight == 1)
                                {
                                  bp.changeColor(lighted, "nolight");
                                  lighted = null;
                                  isLight = 0;
                                  System.out.println("isLight = " + isLight);
                                }
                                if((btnName.startsWith("b")) && isLight == 0)
                                {
                                    lighted = btn;
                                    bp.changeColor(btn, "light");
                                    isLight = 1;
                                    System.out.println("isLight = " + isLight);
                                }
                        }
                }
        }

        class BtnListener extends KeyAdapter{
          public void keyPressed(KeyEvent event){
            String btnName = "";
            if (event.getKeyCode() >= 48 && event.getKeyCode() <=57) {
              btnName = String.valueOf(event.getKeyCode() - 48);
            }else if(event.getKeyCode() >= 96 && event.getKeyCode() <=105){
              btnName = String.valueOf(event.getKeyCode() - 96);
			}else if(event.getKeyCode() >= 106 && event.getKeyCode() <= 111 && event.getKeyCode()!= 108 && event.getKeyCode() != 110){
				btnName = "b" + event.getKeyChar();
			/*	if(isLight == 1){
                    bp.changeColor(lighted, "nolight");
                    lighted = null;
                    isLight = 0;
                    System.out.println("isLight = " + isLight);
                }if((btnName.startsWith("b")) && isLight == 0){
                    lighted = btn;
                    bp.changeColor(btn, "light");
                    isLight = 1;
                    System.out.println("isLight = " + isLight);
                }*/
			}else if (event.getKeyCode() == 10) {
              btnName = "=";
            }else if (event.getKeyCode() == 110) {
              btnName = ".";
            }else if (event.getKeyChar() == 'c' || event.getKeyChar() == 'C') {
            	btnName = "C";
            }else{
              System.out.println(event.getKeyChar());
            }
            System.out.println(btnName);
            if (btnName != "") {
               bp.checkType(btnName);
             } 
            
          }
        }
}   


/**//**//**//**//**//**//**//**//**//**//**//**//**//*youporn*//*redtube*//*porn-hub*/