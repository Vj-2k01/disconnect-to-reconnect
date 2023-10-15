import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.Font;

class BTime1 extends Canvas
{        
    public void paint(Graphics g)
    {  
        
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i =t.getImage("thirsty-water.gif");           
        g.drawImage(i,500,250,500,250,this); 
        Image k =t.getImage("20sec.gif");           
        g.drawImage(k, 50,250,300,250,this);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("Let\'s break time maamay!!! \n Drink some Water!!!",120,100);
        
        
    } 
}

class BTime2 extends Canvas{
    public void paint(Graphics b)
    {  
        Toolkit t=Toolkit.getDefaultToolkit();  
            Image i =t.getImage("Frustrated_programmer_qeR3D5O.gif");           
            b.drawImage(i, 500,250,600,500,this);
            Image k =t.getImage("30-seconds.gif");           
            b.drawImage(k, 45,300,350,200,this);
            b.setFont(new Font("Arial",Font.BOLD,50));
            b.drawString("PROBLEM SOLVED maamay!!! Take a Deep BREATHE!!",0,105); 
    } 
}

class BTime3 extends Canvas{
    public void paint(Graphics g)
    {  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i =t.getImage("eye-excercise.gif");           
        g.drawImage(i,300,150,700,700,this);              
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("Keep your vision healthy...Maamay!!!",10,105); 
    } 
}
public class BTime extends Canvas
{  
      
    public void paint(Graphics g)
    {  
        
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i =t.getImage("take-a-break-break.gif");       
        g.drawImage(i, 500,250,400,300,this); 
        Image k =t.getImage("10sec.gif");           
        g.drawImage(k, 50,250,this);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("Let\'s break time maamay!!!\nClose your eyes!!!",120,100);
    
    }  

    public static void main(String[] args)
    {  

        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(java.time.LocalTime.now());
        String ts = java.time.LocalTime.now().format(dft).toString();
        System.out.println(ts);

        String [] tArr = ts.split(":");
        int hr = Integer.parseInt(tArr[0]);
        int min = Integer.parseInt(tArr[1]);
        // int sec = Integer.parseInt(tArr[2]);


        JFrame f=new JFrame(); 
        JFrame f1=new JFrame(); 
        JFrame f2=new JFrame(); 
        JFrame f3=new JFrame(); 

        AltTabStopper.create(f);
        AltTabStopper.create(f1);
        AltTabStopper.create(f2);
        AltTabStopper.create(f3);

        f.setUndecorated(true);
        f1.setUndecorated(true);
        f2.setUndecorated(true);
        f3.setUndecorated(true);
    

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f3.setExtendedState(JFrame.MAXIMIZED_BOTH);

        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        f.add(new BTime());
        f1.add(new BTime1());
        f2.add(new BTime2());
        f3.add(new BTime3());
        int flag = 0;
        while(true)
        {       
            try 
            {
                TimeUnit.SECONDS.sleep(30);
                String ts1 = java.time.LocalTime.now().format(dft).toString();            
                String [] tArr1 = ts1.split(":");
                int hr1 = Integer.parseInt(tArr1[0]);
                int min1 = Integer.parseInt(tArr1[1]);
                // int sec1 = Integer.parseInt(tArr[2]);

                if((hr1> hr || (min1 >= min+1)) && flag == 0)
                {
                    
                    f.setVisible(true);
                    TimeUnit.SECONDS.sleep(40);
                    f.setVisible(false);
                    f.dispose();
                    flag = 1;
                    
                }
                else if (flag == 1)
                {
                    f1.setVisible(true);
                    TimeUnit.SECONDS.sleep(20);
                    f1.setVisible(false);
                    f1.dispose();
                    flag = 2;
                }
                else if (flag == 2)
                {
                    f2.setVisible(true);
                    TimeUnit.SECONDS.sleep(30);
                    f2.setVisible(false);
                    f2.dispose();
                    flag = 3;
                }
                else if (flag == 3)
                {
                    f3.setVisible(true);
                    TimeUnit.SECONDS.sleep(60);
                    f3.setVisible(false);
                    f3.dispose();
                    flag = 0;
                }
                if(min+5 <= min1)
                {
                    break;
                }   
            }

            catch (InterruptedException e)
            {
                e.printStackTrace();
            }  

        }       
    }   
}
