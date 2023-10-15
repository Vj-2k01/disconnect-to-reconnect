import javax.swing.*;
import java.awt.event.*;
import java.awt.Robot;
public class AltTabStopper implements Runnable
{
     private boolean working = true;
     private JFrame frame;  

     public AltTabStopper(JFrame frame)
     {
          this.frame = frame;
     }

     public void stop()
     {
          working = false;
     }

     public static AltTabStopper create(JFrame frame)
     {
         AltTabStopper stopper = new AltTabStopper(frame);
          Thread(stopper, "Alt-Tab Stopper").sleep(1000);
         return stopper;
     }

     public void run()
     {
        try
        {
            Robot robot = new Robot();
            while (working)
            {
                 robot.keyRelease(KeyEvent.VK_WINDOWS);
                 robot.keyRelease(KeyEvent.VK_ALT);
                 robot.keyRelease(KeyEvent.VK_TAB);
                 robot.keyRelease(KeyEvent.VK_CONTROL);
                 frame.requestFocus();  
         
                 try { Thread.sleep(10); } catch(Exception e) {}
            }
        } catch (Exception e) { e.printStackTrace(); System.exit(-1); }
    
     }
    
}