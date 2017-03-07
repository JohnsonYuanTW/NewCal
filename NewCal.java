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
                demo.setSize(400, 600);
                demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                demo.getContentPane().setLayout(new FlowLayout());
                Panel p1 = new Panel(new FlowLayout(FlowLayout.CENTER));
                p1.setSize(400, 100);
                
                label.setPreferredSize(new Dimension(360,110));
                label.setLocation(20,10);
                label.setFont(new Font("Informal Roman",Font.BOLD,50));
                p1.add(label);
                demo.add(p1);

                String[] list = {"sqrt", "sin","cos","/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "C", "0", ".", "="}; 
                for (int i = 0; i < 20; i++) {
                       JButton a = new JButton("" + list[i]);
                       a.setFont(new Font("Informal Roman", Font.BOLD, 26));
                       a.setFocusPainted(false);
                       a.setBackground(Color.GRAY);
                       a.setPreferredSize(new Dimension(80,80));
                       if(i%4==3 && i!=19)
                        {
                                a.setName("b" + list[i]);
                        }else if(i<=3)
                        {
                                a.setName("u" + list[i]);
                        }else
                        {
                                a.setName(list[i]);
                        }
                       a.addActionListener(new BtnHandler());
                       //a.addKeyListener(new BtnListener());
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

        /*class BtnListener extends KeyAdapter{
          public void keyPressed(KeyEvent event){
            String btnName = "";
            if (event.getKeyCode() >= 48 && event.getKeyCode() <=57) {
              btnName = String.valueOf(event.getKeyCode() - 48);
            }else if(event.getKeyCode() >= 96 && event.getKeyCode() <=105){
              btnName = String.valueOf(event.getKeyCode() - 96);
            }else if (event.getKeyCode() == 107) {
              btnName = "b+";
            }else if (event.getKeyCode() == 106) {
              btnName = "b*";
            }else if (event.getKeyCode() == 109) {
              btnName = "b-";
            }else if (event.getKeyCode() == 111) {
              btnName = "b/";
            }else if (event.getKeyCode() == 10) {
              btnName = "=";
            }else if (event.getKeyCode() == 110) {
              btnName = ".";
            }else{
              System.out.println(event.getKeyChar());
            }
            System.out.println(btnName);
            if (btnName != "") {
               bp.checkType(btnName);
             } 
            
          }
        }*/
}   


/**//**//**//**//**//**//**//**//**//**//**//**//**//*youporn*//*redtube*//*porn-hub*/