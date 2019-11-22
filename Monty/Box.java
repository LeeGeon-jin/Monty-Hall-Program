public class Box
{
    private String name;
    private boolean isPrize;
    
    public Box(String name)
    {
        this.name=name;
    }
    
    public String getName()
    {return name;}
    
    public void setName(String newName)
    {name=newName;}
    
    public Boolean getIsPrize()
    {return isPrize;}
    
    public void setIsPrize(boolean newIsPrize)
    {isPrize=newIsPrize;}
}