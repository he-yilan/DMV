public class dealershipCar extends car
{
    public dealershipCar(String body, String brand, String model, String vin, String plate, owner x, double price)
    {
        super(body, brand, model, vin, plate, x, price, true);
    }
    public String toString()
    {
        String result; 
        result = x.getName() + "\n"; 
        result += "body type: "+ body+"\n"; 
        result += "brand: "+ brand +"\n"; 
        result += "model: "+ model +"\n"; 
        result += "vehicle identification number: "+ vin +"\n"; 
        result += "license plate number: "+ plate + "\n"; 
        result += "price: "+price +"\n";
        result += "This car was bought from a car dealership.";
        return result; 
        }
}
