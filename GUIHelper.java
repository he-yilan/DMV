import javax.swing.*; 
import java.awt.FlowLayout; 
import java.awt.event.*; 
import java.awt.*; 
public class dmvGUI extends JFrame 
{
    private static JFrame frame; 
    private static JPanel panel; 
 
    public static owner o = null; //this user's personal information
    public static user u = null; //this user
    public static user changeU = null; //user whose record the admin wants to edit
    public static owner changeO = null; //this user can edit this personal information of another user
    
    public static String bodyType; //type of car body
    public static String brandName; //car brand
    public static String mod; //model of car
    public static String vin; //vehicle identification number
    public static String plateNum; //license plate number
    public static double priceTag; //price of carr

    Boolean usernameIsThere = new Boolean(false); 
    Boolean passwordIsThere = new Boolean(false);
    public static boolean isAdmin = false;
    public static boolean isDealershipCar = false; 
    Boolean changeUsernameIsThere = new Boolean(false); 
    Boolean changePasswordIsThere = new Boolean(false);
    
    public static void main (String[] args)
    {
        GUIHelper.addDefaultUsersAndCars();
        
        frame = new JFrame("DMV Vehicle Registration"); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        panel = new JPanel(); 
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 1; 
        
        
        JLabel label = new JLabel("DMV Vehicle Registration"); 
        JButton login = new JButton(); 
        JButton signup = new JButton(); 
        login.setText("Log in"); 
        signup.setText("Sign up");
        panel.add(label, c); 
        c.gridx = 0; 
        c. gridy = 2; 
        panel.add(login, c); 
        c.gridx = 0; 
        c. gridy = 3; 
        panel.add(signup, c); 
        c.gridx = 0; 
        c. gridy = 4; 
        
    
        login.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               chooseAdminOrCustomerLogin(); 
            }
            }); 
            
            signup.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               chooseAdminOrCustomerSignUp();
            }
            }); 
        

        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true);
    }
    
    public static void chooseAdminOrCustomerLogin()
    {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 1; 
        
        JLabel label = new JLabel("Are you an admin or a customer?");
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;

        JButton admin = new JButton(); 
        JButton customer = new JButton(); 
        admin.setText("Admin"); 
        customer.setText("Customer");
        panel.add(admin, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(customer, c); 
        c.gridx = 10;
        c.gridy = 4; 
        
        admin.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               adminLogin(); 
            }
            }); 
        customer.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               customerLogin(); 
            }
            }); 
            
        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
        
    }
    
    public static void adminLogin()
    {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 1; 
        
        JLabel label = new JLabel(""); 
        JTextField username = new JTextField("username"); 
        JTextField password = new JTextField("password"); 
        panel.add(label); 
        panel.add(username); 
        panel.add(password); 

        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit); 

        
        submit.addActionListener (new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               String user = username.getText(); 
               String pass = password.getText();  
               String output = GUIHelper.adminLogin(user, pass);
               String s = "This account is registered.";
               if (output.compareTo(s) == 0)
               {
                  isAdmin = true;
                  u = GUIHelper.getUser(user, pass); 
                  o = GUIHelper.getThisOwner(u);
                  registerCarOption(); 
                }
               else
               {
                   isAdmin = false; 
                   label.setText("This account is not registered. "); 
                   label.setVisible(true);
                }
               
            }
            }); 

        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void customerLogin()
    {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 1; 
        
        JLabel label = new JLabel(""); 
        JTextField username = new JTextField("username"); 
        JTextField password = new JTextField("password"); 
        panel.add(label); 
        panel.add(username); 
        panel.add(password); 
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit); 
        submit.addActionListener (new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               String user = username.getText(); 
               String pass = password.getText(); 
               String output = GUIHelper.customerLogin(user, pass);
               if (output.equals("This account is registered. "))
               {
                   isAdmin = false; 
                   u = GUIHelper.getUser(user, pass); 
                   o = GUIHelper.getThisOwner(u);
                   registerCarOption(); 
                }
               else
               {
                   label.setText("This account is not registered. "); 
                   label.setVisible(true); 
                }
               
            }
            }); 

        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void chooseAdminOrCustomerSignUp()
    {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 1; 
        
        JLabel label = new JLabel("Would you like to sign up for a customer or admin account?");
        JLabel label2 = new JLabel("DMV employees are qualified for an admin account.");
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        panel.add(label2, c); 
      import java.lang.Math; 
import java.util.ArrayList; 
import java.util.Collection;
import java.util.Iterator;
    public class GUIHelper
    {
    public static ArrayList <car> cars = new ArrayList(); 
    public static ArrayList <user> users = new ArrayList(); 

    static owner o = null; //this user
    static user u = null;
    
    static Address address; 
    static Boolean usernameIsThere = new Boolean(false); 
    static Boolean passwordIsThere = new Boolean(false);
    static boolean isAdmin = false;
    static boolean ad = false; 
    static Boolean changeUsernameIsThere = new Boolean(false); 
    static Boolean changePasswordIsThere = new Boolean(false);
    
    static double price;
    static double regFee;
    
    public static void addDefaultUsersAndCars()
    {
        Address add = new Address("1234", "Silver Spur Road", "Rolling Hills Estates", "CA", 90274);
        owner own  = new owner("Mei", "L", "Johnson", "12/26/2000", 511229, 98765, "310-123-4567", "310-987-6543", add); 
        normalUser use = new normalUser("octopus", "frog", own); 
        dealershipCar car = new dealershipCar("Hatchback", "Peugeot", "Peugeot 208 T16", "1HGBH41JXMN109186", "24681", own, 35945); 
        cars.add(car); 
        users.add(use);

        owner elana = new owner("Elana", "Y", "Ho", "12/28/2002", 577610, 12345, "310-907-5585", "310-808-3799", add); 
        admin Elana = new admin ("elanah", "california", elana); 
        privateCar priv = new privateCar ("coupe", "BMW", " 1989 BMW E30 M3", "1HGBH41KYNO109186", "3425621", elana, 432452); 
        users.add(Elana); 
        cars.add(priv); 
    }
    
    public static String getUsers()
    {
        String userList = ""; 
        for (user i : users)
        {
            if (i.getAdmin() == true)
          {
              userList += GUIHelper.organizeAdmin(i) + "\n"; 
            }
          else if (i.getAdmin() == false)
          {
              userList += GUIHelper.organizeCustomer(i) + "\n"; 
            }
        }
        return userList;
    }
    
    public static String getCars()
    {
        String carList = ""; 
        for (car i : cars)
        {
            carList += i + "\n\n";
        }
        return carList; 
    }
    
    public static void adminSignUp(String first, String middle, String last, String birthday, int ssn, int license, String home, String cell, String house, String street, String town, String state, int zip, String username, String password)
    {
        address = new Address(house, street, town, state, zip);
        o = new owner(first, middle, last, birthday, ssn, license, home, cell, address); 
        admin a = new admin(username, password, o); 
        u = a; 
        users.add(a); 
        }

    public static void customerSignUp(String first, String middle, String last, String birthday, int ssn, int license, String home, String cell, String house, String street, String town, String state, int zip, String username, String password)
    {
        address = new Address(house, street, town, state, zip);
        o = new owner(first, middle, last, birthday, ssn, license, home, cell, address); 
        normalUser n = new normalUser(username, password, o); 
        u = n;
        users.add(n); 
        }
    
    public static boolean verifyAdminAccount(String username, String password)
    {
        boolean realAdmin = false; 
        String aUser = username;
        String aPass = password; 
            
        for (user i : users)
            {
                String admin