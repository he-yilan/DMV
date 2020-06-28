public abstract class car
{
    public String body, brand, model, vin, plate; 
    public owner x; 
    public double price; 
    public boolean isDealership; 
    public car(String body, String brand, String model, String vin, String plate, owner x, double price, boolean isDealership)
    {
        this.body = body; 
        this.brand = brand; 
        this.model = model; 
        this.vin = vin; 
        this.plate = plate; 
        this.x = x;
        this.price = price; 
        this.isDealership = isDealership; 
    }
    public String getBody()
    {
        return body;
    }
    public void setBody(String b)
    {
        body = b; 
    }
    public String brand()
    {
        return brand; 
    }
    public void setBrand(String b)
    {
        brand = b;
    }
    public String model()
    {
        return model;
    }
    public void setModel(String m)
    {
        model = m; 
    }
    public String vin()
    {
        return vin;
    }
    public void setVin(String v)
    {
        vin = v;
    }
    public String plate()
    {
        return plate; 
    }
    public void setPlate(String p)
    {
        plate = p;
    }
    public owner getOwner()
    {
        return x; 
    }
    public void setOwner(owner y)
    {
        x = y; 
    }
    public double getPrice()
    {
        return price;
    }
    public boolean getDealership()
    {
        return isDealership; 
    }
    public void setDealership(boolean d)
    {
        isDealership = d; 
    }
    public abstract String toString();
}

