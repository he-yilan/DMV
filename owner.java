import java.util.Date; 
public class owner
{
    private String firstName, middleInit, lastName; 
    private String birthday; 
    private int ssn, licenseNum; 
    private String homeNum, cellNum;
    private Address address; 
    private Date date;
    public owner(String first, String middleInit, String last, String birthday, int ssn, 
                    int license, String home, String cell, Address add)
    {
        date = new Date();
        firstName = first; 
        this.middleInit = middleInit;
        lastName = last; 
        this.birthday = birthday; 
        this.ssn = ssn; 
        licenseNum = license; 
        homeNum = home; 
        cellNum = cell; 
        address = add;
    }
    public Date getDate()
    {
        return date; 
    }
    public String getName()
    {
        return firstName +" "+ middleInit +" "+ lastName; 
    }
    public void setName(String f, String m, String l)
    {
        firstName = f; 
        middleInit = m;
        lastName = l; 
    }
    public String getBirthday()
    {
        return birthday; 
    }
    public int getssn()
    {
        return ssn;
    }
    public int getLicenseNum()
    {
        return licenseNum; 
    }
    public void setLicenseNum(int license)
    {
        licenseNum = license; 
    }
    public String getHomeNum()
    {
        return homeNum; 
    }
    public void setHomeNum(String home)
    {
        homeNum = home; 
    }
    public String getCellNum()
    {
        return cellNum; 
    }
    public void setCellNum(String cell)
    {
        cellNum = cell; 
    }
    public Address getAdd()
    {
       return address;  
    }
    public void setAdd(Address h)
    {
        address = h; 
    }
    public String toString()
    {
        String result; 
        result = "date viewed: "+ date +"\n"; 
        result += "full name: "+firstName+" "+middleInit+" "+ lastName+"\n"; 
        result += "birthday: "+ birthday +"\n"; 
        result += "social security number: "+ ssn +"\n"; 
        result += "driver's license number: "+ licenseNum +"\n"; 
        result += "home phone number: "+ homeNum +"\n"; 
        result += "cell phone number: "+ cellNum +"\n"; 
        result += "address: "+ address;
        return result; 
    }
}
