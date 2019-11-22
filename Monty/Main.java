import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    private ArrayList<Box> boxes=new ArrayList<Box>();
    //boolean a,b,c;
    private Box boxA=new Box("a");
    private Box boxB=new Box("b");
    private Box boxC=new Box("c");
    
    private String decision;
    private Box tipBox;
    
    public Main()
    {
        boxes.add(boxA);
        boxes.add(boxB);
        boxes.add(boxC);
        
        setPrize();
        decide();
        
        if(decision.equals("a")||decision.equals("b")||decision.equals("c"))
        {
            findOtherBox();
            finalDecide();
            displayResult();
        }
        else
        {System.out.println("Invalid input!");}
        
        playAgain();
    }
    
    private void setPrize()
    {
        Random rand=new Random();
        boxes.get(rand.nextInt(boxes.size())).setIsPrize(true);
        //System.out.println(boxes);
    }
    
    private void decide()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Three boxes: a,b,c. One of them has a prize.");
        System.out.println("Choose one:");
        decision=in.nextLine();
    }
    

    
    private void findOtherBox()
    {
        for(Box box: boxes)
        {
            if(box.getName().equals(decision))
            {continue;}
            else
            {
                if(box.getIsPrize()==false)
                {
                    tipBox=box;
                    System.out.println("\n"+"The following box does not have the prize: ");
                    System.out.println("Box"+" "+box.getName());
                    break;
                }
            }
        }
    }
    
    private void finalDecide()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("\n"+"Would u like to change your mind to the other box? (Y/N)");    
        String mind=s.nextLine();
        if(mind.equals("Y")||mind.equals("y"))
        {
            for(Box b:boxes)
            {
                if(b.getName().equals(decision) || b.equals(tipBox))
                {continue;}
                else
                {
                    decision=b.getName();
                    
                    break;
                }
            }
        }
        
        System.out.println("Your final decision is Box "+decision);
    }
    
    private void displayResult()
    {
        for(Box b:boxes)
        {
            if(b.getName().equals(decision))
            {
                boolean isPrize=b.getIsPrize();
                if(isPrize==true)
                    System.out.println("Congratulations! Box "+b.getName()+" has prize. YOU WIN!");
                else if(isPrize==false)
                    System.out.println("Sorry. Box "+b.getName()+" doesn't have prize. YOU LOSE!");
                break;
            }
        }
    }
    
    private void playAgain()
    {
        System.out.println("\n"+"Play again? (Y/N)");
        
        Scanner s=new Scanner(System.in);
        String answer=s.nextLine();
        
        if(answer.equals("Y") || answer.equals("y"))
            new Main();
        else
            System.exit(0);
    }
}