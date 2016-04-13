import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private final int BUMPER = 5;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    public void drawCanvas(Canvas canvas)
    {
        Double height = canvas.getSize().getHeight();  
        Double width = canvas.getSize().getWidth();  
        
        //Does it work?
        canvas.setVisible(true);  
        
        //Draw 4 lines in which form a rectangle and holy hell was there really no easier way to do this look at the insane amount of code, jesus freaking-
        canvas.drawLine(BUMPER, height.intValue() - BUMPER, width.intValue() - BUMPER, height.intValue() - BUMPER);  
        canvas.drawLine(BUMPER, BUMPER, width.intValue() - BUMPER, BUMPER);  
        canvas.drawLine(BUMPER, BUMPER, BUMPER, height.intValue() - BUMPER);  
        canvas.drawLine(width.intValue() - BUMPER, BUMPER, width.intValue() - BUMPER, height.intValue() - BUMPER);  
    }
    
    public void boxBounce(int Balls)
    {
        if (Balls < 0) 
        {  
            System.out.println("The heck man, cut the crap out!");  
            return;  
        } 
        int BALLSSS = Balls - 1;
        int x = 0;  
        ArrayList<boxBall> balls = new ArrayList<>();  
        drawCanvas(myCanvas);  
   
        //Uses an Array list for balls
        for (int i = 0; i <= BALLSSS; i++) 
        {  
            balls.add(new boxBall(myCanvas, BUMPER));  
        }  
   
        //draw balls from the Array
        for (boxBall ball : balls) 
        {  
        ball.draw();  
        }  
        
        while (x <= 100) //sets the timer for how long the balls are going to be moving
        {  
            myCanvas.wait(50); // small delay  
            for (boxBall ball : balls) 
            {  
                ball.move();  
            }  
            x++;  
        }
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
