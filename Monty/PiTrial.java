import java.util.Scanner;

public class PiTrial
{
     public static void main(String args[])
     {
        //System.out.println(Math.PI);
                
        boolean isPositive=true;
                
        double a=2.0;
        double b=0;
        
        Scanner in=new Scanner(System.in);
        System.out.println("Input the looping calculation times value:");
        int times=in.nextInt();
        for(int i=0;i<times;i++)
        {
            if(isPositive==true)
                b=b+4.0/(a*(a+1.0)*(a+2.0));
            else if(isPositive==false)
                b=b-4.0/(a*(a+1.0)*(a+2.0));
               
            a=a+2.0;
            isPositive=!isPositive;
        }
        
        double pi=b+3.0;
        
        System.out.println(pi);
        
      }
        
        
        
        //double pi=(double)3+4/(2*3*4)-4/(4*5*6)+4/(6*7*8)-4/(8*9*10)+4/(10*11*12)-4/(12*13*14);
        
        
        
    }
    
