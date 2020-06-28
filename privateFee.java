public class privateFee implements fee
{
    private static double price; 
    private static int regisFee; 
    @Override
    public double calcFee(double price)
    {
        if (price >= 0 && price <= 4999)
        {
            regisFee = 25; 
        }
        if (price >= 5000 && price <= 24999)
        {
            regisFee = 50; 
        }
        if (price >= 25000 && price <= 34999)
        {
            regisFee = 100; 
        }
        if (price >= 35000 && price <= 59999)
        {
            regisFee = 150; 
        }
        if (price >= 60000)
        {
            regisFee = 175; 
        }
        regisFee += 26;
        regisFee += 60; 
   
        return regisFee; 
    }
}
