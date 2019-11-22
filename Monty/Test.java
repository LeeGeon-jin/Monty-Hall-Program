import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test
{
    private ArrayList<Box> boxes=new ArrayList<Box>();
    //boolean a,b,c;
    private Box boxA=new Box("a");
    private Box boxB=new Box("b");
    private Box boxC=new Box("c");
    
    private Box decision;
    
    private int prizeNum=0;
    private int playTime;
    private boolean isChange;
    
    public Test()
    {
        setTimes();
        setIsChange();
   
        boxes.add(boxA);
        boxes.add(boxB);
        boxes.add(boxC);
        for(int i=0;i<playTime;i++)
        {
            setPrize();
            decide();
            
            
            if(isChange==true)
            {changeDecide();}
            else
            {findTipBox();}
            
            updateResult();
            reset();
        }
        
        System.out.println("You have played "+playTime+" times");
        System.out.println("Prize rate: "+(double)prizeNum/playTime);
    }
    
    public void setPrize()
    {
        Random rand=new Random();
        boxes.get(rand.nextInt(boxes.size())).setIsPrize(true);
        
        System.out.println("Generated: "+boxes.get(0).getIsPrize()
                                        +" "+boxes.get(1).getIsPrize()
                                           +" "+boxes.get(2).getIsPrize());
    }
    
    private void decide()
    {
        Random r=new Random();
        decision=boxes.get(r.nextInt(boxes.size()));
        
        System.out.println("Decided: "+decision.getName()+" "+decision.getIsPrize());
    }
    
    private Box findTipBox()
    {
        for(Box box: boxes)
        {
            if(box.equals(decision))
            {continue;}
            else
            {
                if(box.getIsPrize()==false)
                {
                    System.out.println("Tip: "+box.getName()+" false");
                    return box;
                    //break;
                }
            }
        }
        return null;
    }
    
    private void changeDecide()
    {
        for(Box b:boxes)
            {
                if(b.equals(decision) || b.equals(findTipBox()))
                {continue;}
                else
                {
                    decision=b;
                    break;
                }
            }
    }
    
    private void updateResult()
    {
        if(decision.getIsPrize()==true)
        {
            prizeNum=prizeNum+1;         
            
        }
        System.out.println(prizeNum+" prize(s)");
    }
    
    private void reset()
    {
        boxes.get(0).setIsPrize(false);
        boxes.get(1).setIsPrize(false);
        boxes.get(2).setIsPrize(false);
        
        //decision=null;
    }
    
    private void setTimes()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("How many play times do u want?");
        playTime=in.nextInt();
    }
    private void setIsChange()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Change box or not? (Y/N)");
        String mind=s.nextLine();
        if(mind.equals("Y")||mind.equals("y"))
            isChange=true;
    }
}