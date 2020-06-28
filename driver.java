import java.lang.Math; 
import java.util.Scanner; 
import java.util.ArrayList; 
public class driver
{
    public static void main (String[] args)
    {
        ArrayList <car> cars = new ArrayList(); 
        ArrayList <user> users = new ArrayList(); 
       
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
        
        
        Scanner scan = new Scanner(System.in); 
        String first; 
        String middle; 
        String last;
        String birthday;
        int ssn = 0;
        int license;
        String home;
        String cell;
        String house; 
        String street;
        String town;
        String state;
        int zip;
        Address address; 
        owner o = null; //this user
        user u = null;
        Boolean usernameIsThere = new Boolean(false); 
        Boolean passwordIsThere = new Boolean(false);
        boolean isAdmin = false;
        boolean ad = false; 
        Boolean changeUsernameIsThere = new Boolean(false); 
        Boolean changePasswordIsThere = new Boolean(false);
        
        boolean isDealership = false;
        String body;
        String brand;
        String model;
        String vin;
        String plate;
        double price;
        double regFee;
        
        System.out.println("Would you like to log in (type 1) or sign up for a new account (type 0)?");
        int x = scan.nextInt();
        int y = 10; 
        int z = 10;
        
        if (x == 1)//login
        {
            System.out.println("Type 1 if you are a DMV employee with an admin account. Type 0 for a customer account."); 
            y = scan.nextInt(); 
        }
        else if (x == 0)//create new account
        {
            System.out.println("Please fill out the following personal information. ");
        System.out.println("first name: "); 
        first = scan.next(); 
        System.out.println("middle initial: "); 
        middle = scan.next(); 
        System.out.println("last name: "); 
        last = scan.next(); 
        System.out.println("birthday (mm/dd/yyyy): "); 
        birthday = scan.next(); 
        System.out.println("social security number: "); 
        ssn = scan.nextInt(); 
        System.out.println("driver's license number: "); 
        license = scan.nextInt(); 
        System.out.println("home phone number: "); 
        home = scan.next(); 
        System.out.println("cell phone number: "); 
        cell = scan.next(); 
        System.out.println("house number: "); 
        house = scan.next(); 
        scan.nextLine(); 
        System.out.println("street name: "); 
        street = scan.nextLine(); 
        System.out.println("town: "); 
        town = scan.nextLine(); 
        System.out.println("state: "); 
        state = scan.next(); 
        System.out.println("zipcode: "); 
        zip = scan.nextInt(); 
        
        address = new Address(house, street, town, state, zip);
        o = new owner(first, middle, last, birthday, ssn, license, home, cell, address); 
            System.out.println("Would you like to sign up for an admin account or a customer account?");
            System.out.println("DMV employees are qualified for an admin account.");
            System.out.println("Type 2 if you are a DMV employee and would like an admin account. Type 3 for a customer account."); 
            z = scan.nextInt(); 
        }
        
            if (z == 2)//sign up for admin account
        {
            ad = true; 
            System.out.println("Please set a username and password"); 
            System.out.println("username: ");
            String user = scan.next();
            System.out.println("password: "); 
            String pass = scan.next(); 
            admin a = new admin(user, pass, o); 
            u = a; 
            users.add(a); 
        }
        else if (z == 3)//sign up for user account
        {
            ad = false;
            System.out.println("Please set a username and password"); 
            System.out.println("username: ");
            String user = scan.next();
            System.out.println("password: "); 
            String pass = scan.next(); 
            normalUser n = new normalUser(user, pass, o);
            u = n; 
            users.add(n); 
        
        }
        //else//error 
        //{
        //    System.out.println("ERROR: this option is not valid.");
        //}
        
        if (y == 0)//customer login
        {
            System.out.println("username: ");
            String cUser = scan.next();
            System.out.println("password: "); 
            String cPass = scan.next(); 
            
            for (user i : users)
            {
                String customerPass = i.getPass(); 
                String customerName = i.getUser(); 
                isAdmin = i.getAdmin(); 
                if (customerName.equals(cUser))
                {
                    usernameIsThere = true; 
                    u = i; 
                }
                
            }
            if (usernameIsThere)
            {
                if (u.getPass().equals(cPass) )
                { 
                    passwordIsThere = true; 
                    }
                else
                {
                     passwordIsThere = false; 
                }
            }
            else if (! usernameIsThere)
            {
                 passwordIsThere = false; 
            }
            if (passwordIsThere)
            {
                if (!u.getAdmin())
                {
                    System.out.println("This account is registered. ");
                    o = u.getOwner(); 
                    ad = false; 
                    }
                else
                {
                     System.out.println("This account is not registered. ");
                }
            }
            else if (! passwordIsThere)
            {
                 System.out.println("This account is not registered. ");
            }

        }
           
        
        else if (y == 1)//admin login
        {
             System.out.println("username: ");
            String aUser = scan.next();
            System.out.println("password: "); 
            String aPass = scan.next(); 
            
            for (user i : users)
            {
                String adminPass = i.getPass(); 
                String adminName = i.getUser(); 
                ad = i.getAdmin(); 
                if (adminName.equals(aUser))
                {
                    usernameIsThere = true; 
                    u = i; 
                }
                
            }
            if (usernameIsThere)
            {
                if (u.getPass().equals(aPass) )
                { 
                    passwordIsThere = true; 
                    }
                else
                {
                     passwordIsThere = false; 
                }
            }
            else if (! usernameIsThere)
            {
                 passwordIsThere = false; 
            }
            if (passwordIsThere)
            {
                if (u.getAdmin())
                {
                    System.out.println("This account is registered. ");
                    o = u.getOwner(); 
                    ad = true; 
                    }
                else
                {
                     System.out.println("This account is not registered. ");
                     ad = false; 
                }
            }
            else if (! passwordIsThere)
            {
                 System.out.println("This account is not registered. ");
                 ad = false; 
            }
        }
        
        if (o != null)
        {
        System.out.println("Would you like to register a vehicle (y/n)?"); 
        String b = scan.next(); 
        
        if (b.equalsIgnoreCase("y"))
        {
            System.out.println("Please fill out the following information about your car. ");
            System.out.println("body type: "); 
            body = scan.next(); 
            scan.nextLine(); 
            System.out.println("brand: "); 
            brand = scan.nextLine(); 
            System.out.println("model: "); 
            model = scan.nextLine(); 
            System.out.println("VIN: ");
            vin = scan.next(); 
            System.out.println("license plate number: "); 
            plate = scan.next(); 
            System.out.println("price of car: "); 
            price = scan.nextDouble(); 
            System.out.println("Was your car bought from a car dealership (y/n)?"); 
            String c = scan.next(); 
            if (c.equalsIgnoreCase("y"))
        {
            isDealership = true; 
        }
        else if (c.equalsIgnoreCase("n"))
        {
            System.out.println("Was your car bought from a private individual?");
            String p = scan.next(); 
            if (p.equalsIgnoreCase("y"))
            {
                isDealership = false; 
            }
        }
        else
        {
            System.out.println("ERROR: this option is not valid.");
        }
        
        if (isDealership == true)
        {
            dealershipCar dCar = new dealershipCar(body, brand, model, vin, plate, o, price);
            cars.add(dCar);
            dealershipFee dFee = new dealershipFee(); 
            regFee= dFee.calcFee(price); 
            System.out.println("The registration fee is "+regFee+". Please pay using a digital payment method."); 
            double money = scan.nextDouble(); 
            
            if (money == regFee)
            {
                System.out.println("Your vehicle is now registered."); 
            }
            else
            {
                System.out.println("The amount submitted was not sufficient. We cannot register your vehicle.");
                int index = cars.indexOf(dCar); 
                cars.remove(index); 
            }
        }
        else
        {
            privateCar pCar = new privateCar(body, brand, model, vin, plate, o, price);
            cars.add(pCar);
            privateFee pFee = new privateFee(); 
            regFee= pFee.calcFee(price); 
            System.out.println("The registration fee is "+regFee+". Please pay using a digital payment method."); 
            double money = scan.nextDouble();
            if (money == regFee)
            {
                System.out.println("Your vehicle is now registered."); 
            }
            else
            {
                System.out.println("The amount submitted was not sufficient. We cannot register your vehicle.");
                int index = cars.indexOf(pCar); 
                cars.remove(index); 
            }
        }
        }
    }
    

    if (!ad)
    {
        System.out.println("Would you like to see your account (y/n)?");
        String viewAccount = scan.next(); 
        if (viewAccount.equalsIgnoreCase("y"))
        {
            System.out.println();
            System.out.println(u); 
            System.out.println(); 
            for (car i : cars)
        {
            owner carOwner = i.getOwner(); 
            if (o == carOwner)
            {
            System.out.println(i); 
            System.out.println(); 
        }
        }
            System.out.println("Thank you for using this DMV online service!"); 
        }
        else 
        {
            System.out.println("Thank you for using this DMV online service!"); 
        }
    }

    
    
    if (ad)
    {
        System.out.println("Would you like to change anything as admin (y/n)?"); 
        String change = scan.next();
        
        if (change.equalsIgnoreCase("y"))
        {
            System.out.println("Please enter the person's username: ");
            String user = scan.next();
            System.out.println("Please enter the person's password: "); 
            String pass = scan.next(); 
            for (user i : users)
            {
                String Pass = i.getPass(); 
                String Name = i.getUser(); 
                if (Name.equals(user))
                {
                    changeUsernameIsThere = true; 
                    u = i; 
                }
                
            }
            if (changeUsernameIsThere)
            {
                if (u.getPass().equals(pass))
                { 
                    changePasswordIsThere = true; 
                    }
                else
                {
                     changePasswordIsThere = false; 
                }
            }
            else if (! changeUsernameIsThere)
            {
                 passwordIsThere = false; 
            }
           
                if (changeUsernameIsThere && changePasswordIsThere)
                {
                    System.out.println("This account is registered. ");
                    o = u.getOwner(); 
                    String makeChange = "y"; 
                    while (makeChange.equalsIgnoreCase("y"))
                    {
                    System.out.println("What would you like to change about the user's personal information?"); 
                    String edit = scan.next(); 
                    edit = edit.toLowerCase(); 
                   
                    //add while loop so admin can change multiple things?
                    switch (edit)
                    {
                       case "username": //OK
                       System.out.println("new username: "); 
                       String newUserName = scan.next(); 
                       u.changeUserName(newUserName); 
                       break; 
                       
                       case "password": //OK
                       System.out.println("new password: "); 
                       String newPass = scan.next(); 
                       u.changePass(newPass); 
                       break;
                        
                        case "name": //OK
                       System.out.println("new first name: "); 
                       String f = scan.next(); 
                       System.out.println("new middle initial: "); 
                       String m = scan.next(); 
                       System.out.println("new last name: ");
                       String l = scan.next(); 
                       o.setName(f, m, l); 
                       break; 
                       
                       case "license": //OK
                       System.out.println("new driver's license number: "); 
                       int newLicenseNum = scan.nextInt();
                       o.setLicenseNum(newLicenseNum); 
                       break;
                        
                       case "home": //OK
                       System.out.println("new home phone number: "); 
                       String homePhone = scan.next(); 
                       o.setHomeNum(homePhone); 
                       break;
                       
                       case "cell": //OK
                       System.out.println("new cell phone number: ");
                       String cellPhone = scan.next(); 
                       o.setCellNum(cellPhone); 
                       break;
                       
                       case "address": //OK
                       System.out.println("house number: "); 
                       house = scan.next(); 
                       scan.nextLine(); 
                       System.out.println("street name: "); 
                       street = scan.nextLine(); 
                       System.out.println("town: "); 
                       town = scan.nextLine(); 
                       System.out.println("state: "); 
                       state = scan.next(); 
                       System.out.println("zipcode: "); 
                       zip = scan.nextInt(); 
                       address = new Address(house, street, town, state, zip);
                       o.setAdd(address); 
                       break; 

                    }
                    System.out.println("Would you like to change anything else (y/n)?");
                    makeChange = scan.next();
                }
                    
                }
                else 
                {
                    System.out.println("This account is not registered. "); 
                }
            
        }
        else
        {
            System.out.println("Okay. Here is the record saved at the DMV: ");
        }
    }
    
     if (ad)
      {
        
        System.out.println(); 
        System.out.println("DMV user record:");
        
        for (user i : users)
        {
            System.out.println(); 
            System.out.println(i);
        }
        
        System.out.println(); 
        System.out.println("DMV vehicle record:");
        for (car i : cars)
        {
            System.out.println(); 
            System.out.println(i); 
        }
    }
    }
}
