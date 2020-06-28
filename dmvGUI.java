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
        c.gridx = 0; 
        c.gridy = 3;
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
               setPageForAdminSignup(); 
            }
            }); 
        customer.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               setPageForCustomerSignup(); 
            }
            }); 
            
        frame.add(panel); 
 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
        
    }
    
    public static void setPageForAdminSignup(){
        panel.removeAll();
        panel.revalidate();
        panel.repaint(); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 1; 
        
        JLabel label = new JLabel("Sign up for a new account"); 
        JTextField username = new JTextField("username"); 
        JTextField password = new JTextField("password"); 
        JTextField FirstName = new JTextField("first name"); 
        JTextField MiddleInitial = new JTextField("middle initial"); 
        JTextField LastName = new JTextField("last name"); 
        JTextField birthday = new JTextField("birthday (mm/dd/yyyy)"); 
        JTextField ssn = new JTextField("social security number"); 
        JTextField license = new JTextField("driver's license number");
        JTextField homePhoneNumber = new JTextField("home phone number");
        JTextField cellPhoneNumber = new JTextField("cell phone number");
        JTextField houseNumber = new JTextField("house number");
        JTextField street = new JTextField("street name");
        JTextField town = new JTextField("city");
        JTextField state = new JTextField("state");
        JTextField zip = new JTextField("zipcode");
        //LastName.setBounds(50, 200, 100, 100); 
        
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        panel.add(username, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        panel.add(password, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(FirstName, c); 
        c.gridx = 0; 
        c.gridy = 5; 
        panel.add(MiddleInitial, c); 
        c.gridx = 0; 
        c.gridy = 6; 
        panel.add(LastName, c);
        c.gridx = 0; 
        c.gridy = 7; 
        panel.add(birthday, c); 
        c.gridx = 0; 
        c.gridy = 8; 
        panel.add(ssn, c); 
        c.gridx = 0; 
        c.gridy = 9; 
        panel.add(license, c); 
        c.gridx = 0; 
        c.gridy = 10; 
        panel.add(homePhoneNumber, c); 
        c.gridx = 0; 
        c.gridy = 11; 
        panel.add(cellPhoneNumber, c); 
        c.gridx = 0; 
        c.gridy = 12; 
        panel.add(houseNumber, c); 
        c.gridx = 0; 
        c.gridy = 13; 
        panel.add(street, c); 
        c.gridx = 0; 
        c.gridy = 14; 
        panel.add(town, c); 
        c.gridx = 0; 
        c.gridy = 15; 
        panel.add(state, c); 
        c.gridx = 0; 
        c.gridy = 16;
        panel.add(zip, c); 
        c.gridx = 0; 
        c.gridy = 17;
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit); 
        submit.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
                isAdmin = true; 
               String user = username.getText(); 
                String pass = password.getText(); 
               String first = FirstName.getText(); 
                String middle = MiddleInitial.getText(); 
                String last = LastName.getText(); 
                String birth = birthday.getText(); 
                int ssnNum = Integer.parseInt(ssn.getText());
                int dLicense = Integer.parseInt(license.getText());
                String homePhone = homePhoneNumber.getText();
                String cellPhone = cellPhoneNumber.getText();
                String houseNum = houseNumber.getText(); 
                String streetName = street.getText(); 
                String townName = town.getText(); 
                String st = state.getText(); 
                int zipcode = Integer.parseInt(zip.getText()); 
               GUIHelper.adminSignUp(first, middle, last, birth, ssnNum, dLicense, homePhone, cellPhone, houseNum, streetName, townName, st, zipcode, user, pass); 
               Address address = new Address(houseNum, streetName, townName, st, zipcode);
                o = new owner(first, middle, last, birth, ssnNum, dLicense, homePhone, cellPhone, address); 
               admin a = new admin(user, pass, o); 
               u = a;  
                registerCarOption(); 
            }
            }); 

        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
        
        }
        
    public static void setPageForCustomerSignup(){
        panel.removeAll();
        panel.revalidate();
        panel.repaint(); 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        panel.setLayout(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; 
        c.gridy = 1; 
        
        JLabel label = new JLabel("Sign up for a new account"); 
        JTextField username = new JTextField("username"); 
        JTextField password = new JTextField("password"); 
        JTextField FirstName = new JTextField("first name"); 
        JTextField MiddleInitial = new JTextField("middle initial"); 
        JTextField LastName = new JTextField("last name"); 
        JTextField birthday = new JTextField("birthday (mm/dd/yyyy)"); 
        JTextField ssn = new JTextField("social security number"); 
        JTextField license = new JTextField("driver's license number");
        JTextField homePhoneNumber = new JTextField("home phone number");
        JTextField cellPhoneNumber = new JTextField("cell phone number");
        JTextField houseNumber = new JTextField("house number");
        JTextField street = new JTextField("street name");
        JTextField town = new JTextField("town");
        JTextField state = new JTextField("state");
        JTextField zip = new JTextField("zipcode");
        
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        panel.add(username, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        panel.add(password, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(FirstName, c); 
        c.gridx = 0; 
        c.gridy = 5; 
        panel.add(MiddleInitial, c); 
        c.gridx = 0; 
        c.gridy = 6; 
        panel.add(LastName, c);
        c.gridx = 0; 
        c.gridy = 7; 
        panel.add(birthday, c); 
        c.gridx = 0; 
        c.gridy = 8; 
        panel.add(ssn, c); 
        c.gridx = 0; 
        c.gridy = 9; 
        panel.add(license, c); 
        c.gridx = 0; 
        c.gridy = 10; 
        panel.add(homePhoneNumber, c); 
        c.gridx = 0; 
        c.gridy = 11; 
        panel.add(cellPhoneNumber, c); 
        c.gridx = 0; 
        c.gridy = 12; 
        panel.add(houseNumber, c); 
        c.gridx = 0; 
        c.gridy = 13; 
        panel.add(street, c); 
        c.gridx = 0; 
        c.gridy = 14; 
        panel.add(town, c); 
        c.gridx = 0; 
        c.gridy = 15; 
        panel.add(state, c); 
        c.gridx = 0; 
        c.gridy = 16;
        panel.add(zip, c); 
        c.gridx = 0; 
        c.gridy = 17;
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit); 
        submit.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
                
               String user = username.getText(); 
                String pass = password.getText(); 
               String first = FirstName.getText(); 
                String middle = MiddleInitial.getText(); 
                String last = LastName.getText(); 
                String birth = birthday.getText(); 
                int ssnNum = Integer.parseInt(ssn.getText());
                int dLicense = Integer.parseInt(license.getText());
                String homePhone = homePhoneNumber.getText();
                String cellPhone = cellPhoneNumber.getText();
                String houseNum = houseNumber.getText(); 
                String streetName = street.getText(); 
                String townName = town.getText(); 
                String st = state.getText(); 
                int zipcode = Integer.parseInt(zip.getText()); 
               GUIHelper.customerSignUp(first, middle, last, birth, ssnNum, dLicense, homePhone, cellPhone, houseNum, streetName, townName, st, zipcode, user, pass); 
               Address address = new Address(houseNum, streetName, townName, st, zipcode);
                o = new owner(first, middle, last, birth, ssnNum, dLicense, homePhone, cellPhone, address); 
               normalUser n = new normalUser(user, pass, o); 
               u = n;
                registerCarOption(); 
            }
            }); 

        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
        
        }
        
    public static void registerCarOption()
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
        
        JLabel label = new JLabel("Would you like to register a vehicle?");
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        
        JButton yes = new JButton(); 
        JButton no = new JButton(); 
        yes.setText("Yes"); 
        no.setText("No");
        panel.add(yes, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(no, c); 
        c.gridx = 10;
        c.gridy = 4; 
        
        yes.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               setPageForCarRegistration(); 
            }
            }); 
            
        no.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               if (isAdmin)
                   {
                       adminCanEdit(); 
                       }
                   else 
                   {
                       viewAccount(); 
                        }
            }
            }); 
            
        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
        
    }
    public static void setPageForCarRegistration()
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
        
        JLabel label = new JLabel("Please fill out the following information about your car. "); 
        JTextField body = new JTextField("body type"); 
        JTextField brand = new JTextField("brand"); 
        JTextField model = new JTextField("model"); 
        JTextField vehicleIDNum = new JTextField("VIN"); 
        JTextField plate = new JTextField("license plate number"); 
        JTextField price = new JTextField("price"); 
        
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        panel.add(body, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        panel.add(brand, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(model, c); 
        c.gridx = 0; 
        c.gridy = 5; 
        panel.add(vehicleIDNum, c); 
        c.gridx = 0; 
        c.gridy = 6; 
        panel.add(plate, c);
        c.gridx = 0; 
        c.gridy = 7; 
        panel.add(price, c); 
        c.gridx = 0; 
        c.gridy = 8; 
        
        JLabel obtenir = new JLabel("Was your car bought from a car dealership or a private individual?"); 
        panel.add(obtenir, c); 
        c.gridx = 0; 
        c.gridy = 9; 
        
        JButton isDealership = new JButton(); 
        JButton notDealership = new JButton(); 
        isDealership.setText("Car Dealership"); 
        notDealership.setText("Private Individual"); 
        panel.add(isDealership, c); 
        c.gridx = 0; 
        c.gridy = 10; 
        panel.add(notDealership, c); 
        c.gridx = 10; 
        c.gridy = 10; 

        isDealership.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
                isDealershipCar = true; 
                bodyType = body.getText(); 
                brandName = brand.getText(); 
                mod = model.getText(); 
                vin = vehicleIDNum.getText(); 
                plateNum = plate.getText(); 
                priceTag = Double.parseDouble(price.getText());
                payDealershipFee(); 

            }
            }); 
            
            notDealership.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
                isDealershipCar = false; 
               bodyType = body.getText(); 
                brandName = brand.getText(); 
                mod = model.getText(); 
                vin = vehicleIDNum.getText(); 
                plateNum = plate.getText(); 
                priceTag = Double.parseDouble(price.getText());
                payPrivateFee(); 

            }
            }); 

        frame.add(panel); 
        
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 

    }
    
    public static void payPrivateFee()
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
        
        double regFee = GUIHelper.calcPrivateFee(priceTag);
        
        JLabel label = new JLabel("The registration fee is "+regFee+". Please pay using a digital payment method.");
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        
        JTextField pay = new JTextField("pay registration fee"); 
        panel.add(pay, c);
        c.gridx = 0; 
        c.gridy = 3;
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit, c); 
        c.gridx = 0; 
        c.gridy = 4;
        submit.addActionListener (new ActionListener() //register car if owner pays regFee
        {
           public void actionPerformed(ActionEvent e){ 
               double payment = Double.parseDouble(pay.getText()); 
               if (payment == regFee)
               {
                   privateCar pCar = new privateCar(bodyType, brandName, mod, vin, plateNum,o, priceTag);
                   GUIHelper.regCar(pCar); 
                   //vehicle is now registered 
                   
                   if (isAdmin)
                   {
                       adminCanEdit(); 
                       }
                   else 
                   {
                       viewAccount(); 
                        }
                }
               else
               {
                   label.setText("The amount submitted was not sufficient. We cannot register your vehicle."); 
                   panel.add(label, c); 
                   c.gridx = 0; 
                   c.gridy = 2; 
                   
                }
               
            }
            }); 
        
        frame.add(panel); 
        
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true);
    }
    
    public static void payDealershipFee()
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
        
        double regFee = GUIHelper.calcDealershipFee(priceTag);
        
        JLabel label = new JLabel("The registration fee is "+regFee+". Please pay using a digital payment method.");
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        
        JTextField pay = new JTextField("pay registration fee"); 
        panel.add(pay, c);
        c.gridx = 0; 
        c.gridy = 3;
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit, c); 
        c.gridx = 0; 
        c.gridy = 4;
        submit.addActionListener (new ActionListener() //register car if owner pays regFee
        {
           public void actionPerformed(ActionEvent e){ 
               double payment = Double.parseDouble(pay.getText()); 
               if (payment == regFee)
               {
                   dealershipCar dCar = new dealershipCar(bodyType, brandName, mod, vin, plateNum,o, priceTag);
                   GUIHelper.regCar(dCar); 

                   String carInfo = GUIHelper.getCar(o);
                   
                   if (isAdmin)
                   {
                       adminCanEdit(); 
                       }
                   else 
                   {
                       viewAccount(); 
                        }
                }
               else
               {
                   label.setText("The amount submitted was not sufficient. We cannot register your vehicle."); 
                   panel.add(label, c); 
                   c.gridx = 0; 
                   c.gridy = 2; 
                }
               
            }
            }); 
        
        frame.add(panel); 
        
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true);
    }
    
    public static void viewAccount()
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
        
        JLabel label = new JLabel("Would you like to see your account?");
        
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;
        
        JButton yes = new JButton(); 
        JButton no = new JButton(); 
        yes.setText("Yes"); 
        no.setText("No");
        panel.add(yes, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(no, c); 
        c.gridx = 10;
        c.gridy = 4; 
        
        yes.addActionListener(new ActionListener()//MAKE A SCROLLBAR
        {
           public void actionPerformed(ActionEvent e){ 
              String carInfo = GUIHelper.getCar(o);
               String userInfo = GUIHelper.organizeCustomer(u);
               yes.setVisible(false); 
               no.setVisible(false);
               label.setVisible(false); 
               
               JTextArea textArea = new JTextArea(userInfo + "\n" + "\n" + carInfo + "\n" 
                                            + "Thank you for using this DMV online service!" );
               JScrollPane scrollPane = new JScrollPane(textArea); 
               textArea.setEditable(false);
               textArea.setLineWrap(true);
               textArea.setWrapStyleWord(true);
        
               JScrollPane areaScrollPane = new JScrollPane(textArea);
               areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //areaScrollPane.setPreferredSize(new Dimension(1000, 1000));
                
                panel.add(areaScrollPane); 
            }
            }); 
            
        no.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               yes.setVisible(false); 
               no.setVisible(false);
               label.setText("Thank you for using this DMV online service!"); 
            }
            }); 
            
            frame.add(panel); 
         
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true);
    }
    
    public static void adminCanEdit()
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
        
        JLabel label = new JLabel("Would you like to change anything as admin?"); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2; 
        
        JButton yes = new JButton(); 
        JButton no = new JButton(); 
        yes.setText("Yes"); 
        no.setText("No");
        panel.add(yes, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(no, c); 
        c.gridx = 10;
        c.gridy = 4; 
        
        yes.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               adminChangeUserVerification(); 
            }
            }); 
            
        no.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               printRecord(); 
            }
            }); 
            
            frame.add(panel); 
        
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true);
        }
        
        public static void adminChangeUserVerification()
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
        
        JLabel label = new JLabel("Please enter the person's username and password."); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2; 
        
        JTextField username = new JTextField("username"); 
        JTextField password = new JTextField("password"); 
        panel.add(username, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        panel.add(password, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        
        JLabel label2 = new JLabel("Is this person an admin or a customer?"); 
        panel.add(label2, c); 
        c.gridx = 0; 
        c.gridy = 5; 
        
        JButton admin = new JButton(); 
        JButton customer = new JButton(); 
        admin.setText("Admin"); 
        customer.setText("Customer");
        panel.add(admin, c); 
        c.gridx = 0; 
        c.gridy = 6; 
        panel.add(customer, c); 
        c.gridx = 5;
        c.gridy = 6; 
        
        admin.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
                String user = username.getText(); 
               String pass = password.getText();  
               boolean output = GUIHelper.verifyAdminAccount(user, pass);
               if (output)
               {
                  adminChange(); 
                  changeU = GUIHelper.getUser(user, pass); 
                  changeO = GUIHelper.getThisOwner(changeU);  
                }
               else
               {
                   label2.setVisible(false); 
                   label.setText("This account is not registered. "); 
                }
            }
            }); 
        customer.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               String user = username.getText(); 
               String pass = password.getText();  
               boolean output = GUIHelper.verifyCustomerAccount(user, pass);
               if (output == true)
               {
                  adminChange(); 
                  changeU = GUIHelper.getUser(user, pass); 
                  changeO = GUIHelper.getThisOwner(changeU); 
                }
               else
               {
                   label2.setVisible(false); 
                   label.setText("This account is not registered. "); 
                }
            }
            }); 

        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void adminChange()
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
        
        JLabel label = new JLabel("What would you like to change about the user's personal information?"); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2;  
       
        JTextField change = new JTextField("          ");  
        panel.add(change, c); 
        c.gridx = 0; 
        c.gridy = 3;
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        submit.addActionListener (new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               String edit = change.getText(); 
               switch (edit)
                    {
                       case "username": 
                       changeSingleString(edit); 
                       break; 
                       
                       case "password":
                       changeSingleString(edit); 
                       break;
                        
                        case "name": 
                       changeName(); 
                       break; 
                       
                       case "driver's license number": 
                       changeInteger(); 
                       break;
                        
                       case "home phone number": 
                       changeSingleString(edit); 
                       break;
                       
                       case "cell phone number": 
                       changeSingleString(edit); 
                       break;
                       
                       case "address": 
                       changeAddress(); 
                       break; 

                    }
            }
            });
            
            frame.add(panel); 
 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void changeSingleString(String edit)
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
         
        
        JLabel label = new JLabel("Replace with: "); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2; 
        
        JTextField change = new JTextField("          ");  
        panel.add(change, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        submit.addActionListener (new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               String editTo =  change.getText(); 
               switch (edit)
             {
                case "username": 
                changeU.changeUserName(editTo);  
                break; 
                       
                case "password": 
                changeU.changePass(editTo); 
                break;
                       
                case "home phone number": 
                changeO.setHomeNum(editTo); 
                break;
                       
                case "cell phone number": 
                changeO.setCellNum(editTo); 
                break;
                    }
               changeAnythingElse();
            }
            }); 
            
            frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void changeName()
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
         
        
        JLabel label = new JLabel("Enter new name: "); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        
        JTextField first = new JTextField("first name");  
        panel.add(first); 
        JTextField middle = new JTextField("middle initial");  
        panel.add(middle);
        JTextField last = new JTextField("last name");  
        panel.add(last);
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit); 
        submit.addActionListener (new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               String f = first.getText(); 
               String m = middle.getText(); 
               String l = last.getText(); 
               changeO.setName(f, m, l); 
               changeAnythingElse();
            }
            }); 
            
            frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void changeAddress()
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
         
        
        JLabel label = new JLabel("Enter new address: "); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        
        JTextField house = new JTextField("house number");  
        panel.add(house); 
        JTextField street = new JTextField("street name");  
        panel.add(street);
        JTextField city = new JTextField("name of city");  
        panel.add(city);
        JTextField state = new JTextField("name of state");  
        panel.add(state);
        JTextField zip = new JTextField("zipcode");  
        panel.add(zip);
        
        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit); 
        submit.addActionListener (new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               String h = house.getText(); 
               String st = street.getText(); 
               String cityName = city.getText(); 
               String stateName = state.getText(); 
               int zipcode = Integer.parseInt(zip.getText()); 
               Address changeAddress = new Address(h, st, cityName, stateName, zipcode); 
               changeO.setAdd(changeAddress); 
               changeAnythingElse();
            }
            }); 
            
            frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void changeInteger()
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
         
        
        JLabel label = new JLabel("Enter new driver's license number: "); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 3; 
        
        JTextField licenseNum = new JTextField("driver's license number");  
        panel.add(licenseNum); 

        JButton submit = new JButton(); 
        submit.setText("Submit"); 
        panel.add(submit); 
        submit.addActionListener (new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               int license = Integer.parseInt(licenseNum.getText()); 
              changeO.setLicenseNum(license); 
              changeAnythingElse();
            }
            }); 
            
        frame.add(panel); 

        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame. setVisible(true); 
    }
    
    public static void changeAnythingElse()
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
        
        JLabel label = new JLabel("Would you like to change anything else?"); 
        panel.add(label, c); 
        c.gridx = 0; 
        c.gridy = 2; 
        
        JButton yes = new JButton(); 
        JButton no = new JButton(); 
        yes.setText("Yes"); 
        no.setText("No");
        panel.add(yes, c); 
        c.gridx = 0; 
        c.gridy = 4; 
        panel.add(no, c); 
        c.gridx = 10;
        c.gridy = 4; 
        
        yes.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               adminChange(); 
            }
            }); 
            
        no.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e){ 
               printRecord(); 
            }
            }); 
            
            frame.add(panel); 
         
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
    }
    
    public static void printRecord()
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
        
        /*
        String textUsers = "DMV user record: \n\n";
        textUsers += GUIHelper.getUsers(); 
        textUsers += "\n"; 
        String textCars = "DMV vehicle record: \n\n";
        textCars += GUIHelper.getCars(); 
        
        String text = textUsers + textCars; 
        */
        
        ///*
        //String carInfo = GUIHelper.getCar(o);
               //String userInfo = GUIHelper.organizeCustomer(u);
               //yes.setVisible(false); 
               //no.setVisible(false);
               //label.setVisible(false); 
               String text = GUIHelper.printRecord();
               JTextArea textArea = new JTextArea(text);
             
               JScrollPane scrollPane = new JScrollPane(textArea); 
               textArea.setEditable(false);
               textArea.setLineWrap(true);
               textArea.setWrapStyleWord(true);
        
               JScrollPane areaScrollPane = new JScrollPane(textArea);
               areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //areaScrollPane.setPreferredSize(new Dimension(1000, 1000));
                
                panel.add(areaScrollPane); 
        
        //*/
       
       /*
        String text = GUIHelper.printRecord();
      
        JTextArea textArea = new JTextArea(text);
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        //JScrollPane scrollPane = new JScrollPane(textArea); 
        
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       
        //areaScrollPane.setPreferredSize(new Dimension(5000, 1000));
          */      
        panel.add(areaScrollPane); 
        frame.add(panel);
        
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
    }
}

