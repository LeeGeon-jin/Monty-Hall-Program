import java.util.ArrayList;
import java.util.Random;

public class SimpleTest
{
    
    //this game does not change mind
    public static void main(String args[])
    {
        int playTime=100000000;
        int prizeNum=0;
        
        //create three boxes and add to list with boolean
        ArrayList<Boolean> boxes=new ArrayList<Boolean>();
        boxes.add(false);
        boxes.add(false);
        boxes.add(false);
        
        for(int i=0;i<playTime;i++)
        {
            //set prize
            Random rand=new Random();
            boxes.set(rand.nextInt(boxes.size()),true);
        
            //pick a box and store its position
            Random r=new Random();
            int location=r.nextInt(boxes.size());
            boolean decision=boxes.get(location);
        
            //find the tip box
            int tipBox;
            for(boolean box:boxes)
            {
                if(boxes.indexOf(box)==location)
                    continue;
                    else if(box==false)
                    tipBox=boxes.indexOf(box);
                }
        
            //update the result
            if(decision==true)
            {prizeNum=prizeNum+1;}
        
        
            //reset variables
            boxes.set(0,false);
            boxes.set(1,false);
            boxes.set(2,false);
            tipBox=0;
        }
        
        
        System.out.println(prizeNum+" prize(s)");
        System.out.println("Winning rate: "+(double)prizeNum/playTime);
    }
}