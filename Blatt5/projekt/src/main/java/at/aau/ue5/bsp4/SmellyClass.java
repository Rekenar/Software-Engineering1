package at.aau.ue5.bsp4;
/**
 * Long-Method, Duplicate Code
 */
public class SmellyClass {

    public void erstelleRechnung(Order order) {

        //calculate temporary price
        Double totalPrice= order.getPrice(order);

        //check for shipping costs
        order.getShippingCosts(totalPrice,order);

        //get Price with shipping costs
        totalPrice = order.getPrice(order);

        //Print Invoice
        rechnungAusgabe(totalPrice,order);
    }


    public void rechnungAusgabe(double totalPrice, Order order ){
        System.out.println("Rechnung:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName()+": "+item.getPrice());
        }
        System.out.println("Total: "+ totalPrice);
    }
}
