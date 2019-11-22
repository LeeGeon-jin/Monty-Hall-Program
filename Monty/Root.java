import java.util.Scanner;

public class Root
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Game or Test? (G for game, T for test)");
        String got=in.nextLine();
        
        if(got.equals("G") || got.equals("g"))
            new Main();
        else if(got.equals("T") || got.equals("t"))
            new Test();
        else
        {
            System.out.println("Invalid input!");
        }
            
    }
}