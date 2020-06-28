public class TestDriver
{
    public static void main (String[] args)
    {
        GUIHelper g = new GUIHelper(); 
        g.addDefaultUsersAndCars();
        System.out.println(g.printRecord()); 
    }
}