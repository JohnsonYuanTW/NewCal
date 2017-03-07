import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCal {
        JLabel label = new JLabel("0",SwingConstants.RIGHT);

        static BtnProcess bp = new BtnProcess();

	public static void main(String[] args) 
        {
                //安安你好我是UTF8
        }
       NewCal(){
        JFrame demo = new JFrame();
        demo.setSize(326, 550);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.getContentPane().setLayout(new FlowLayout(0,0,0));
       // demo.setHgap(0);
        Panel p1 = new Panel(new FlowLayout(FlowLayout.CENTER));
        p1.setSize(310, 100);
        p1.setBackground(Color.darkGray);
        label.setPreferredSize(new Dimension(310,110));
       // label.setLocation(20,10);
        label.setFont(new Font("Forte",Font.BOLD,50));
        label.setForeground(Color.white);
        label.setBackground(Color.black);
        p1.add(label);
        demo.add(p1);
        String[] list = {"sqrt", "sin","cos","/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "C", "0", ".", "="};                 
        for (int i = 0; i < 20; i++) {
            JButton a = new JButton("" + list[i]);
            a.setFont(new Font("Forte", Font.BOLD, 24));
            a.setFocusPainted(false);
            a.setBackground(Color.GRAY);
            a.setPreferredSize(new Dimension(80,80));
            if(i%4==3 && i!=19){
                a.setName("b" + list[i]);
                a.setBackground(Color.ORANGE);
            }else if(i<=3){
                a.setName("u" + list[i]);
            }else{
                a.setName(list[i]);
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
                            if(btnName.startsWith("b")&& btn.getForeground() != Color.BLUE){
                                //System.out.println(btn.getForeground());
                                btn.setBorder(BorderFactory.createLineBorder(Color.black,2));
                                //btn.setForeground(Color.BLUE);
                            }else{
                                btn.setForeground(Color.darkGray);
                            }
                            System.out.println(btnName);                 
                            bp.checkType(btnName);
                        }
                }
        }

        class BtnListener extends KeyAdapter{
          public void keyPressed(KeyEvent event){
            String btnName = "";
            if (event.getKeyCode() >= 96 && event.getKeyCode() <=105) {
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
            }else if (event.getKeyChar() == 'c' || event.getKeyChar() == 'C') {
                btnName = "C";
            }
            else{
              System.out.println(event.getKeyCode());
            }
            System.out.println(btnName);
            if (btnName != "") {
               bp.checkType(btnName);
             } 
            
          }
        }
}   


