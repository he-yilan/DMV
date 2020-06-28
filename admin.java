public class admin implements user
{
    String userN = ""; 
    String passW = ""; 
    owner o;
    boolean isAdmin = true; 
    public admin(String n, String p, owner o)
    {
       isAdmin = true;  
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
        result += "admin" + "\n"; 
        result += "\n"; 
        result += o; 
        return result; 
        }
}
