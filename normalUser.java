public class normalUser implements user
{
    String userN = ""; 
    String passW = ""; 
    boolean isAdmin = false; 
    owner o; 
    public normalUser(String n, String p, owner o)
    {
        isAdmin = false;  
        userN = n; 
        passW = p; 
        this.o = o;
    }
    @Override
    public void changeUserName (String n)
    {
        userN = n;
    }
    @Override
    public void changePass (String p)
    {
        passW = p;
    }
    @Override
    public String getUser()
    {
        return userN;
    }
    @Override
    public String getPass()
    {
        return passW;
    }
    @Override
    public boolean getAdmin()
    {
        return isAdmin; 
    }
    @Override
    public owner getOwner()
    {
        return o; 
    }
    @Override
    public String toString() 
    {
        String result; 
        result = "username: "+userN + "\n"; 
        result += "password: "+passW + "\n"; 
        result += "customer" + "\n"; 
        result += "\n"; 
        result += o; 
        return result; 
        }
}
