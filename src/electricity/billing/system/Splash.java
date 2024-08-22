package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t1;
    Splash(){
        super("Splash");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/new/elect.jpg"));
        Image imageOne = imageIcon.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);  //600,400
        ImageIcon imageIcon2 = new ImageIcon( imageOne);
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);



        /*

        ////implements Runnable  also delete this one from top
        setSize(600,500);
        setLocation(500,200);
        setVisible(true);


        try {
            Thread.sleep(3000);
            setVisible(false);

            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

     */




        setVisible(true);

        int x = 1;
        for (int i = 2; i < 600; i+=4, x+=1) {
            setSize(i + x, i);
            setLocation(700 - ((i + x)/2), 400 - (i/2));
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);

            // login frame
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
