package at.aau.ue5.bsp4;

import java.util.List;

public class Order {

    private Long id;
    private Customer customer;
    private List<Item> items;

    public double getPrice(Order order){
        double totalPrice=0.0d;
        for (Item item : order.getItems()) {
            totalPrice+=item.getPrice();
        }
        return totalPrice;
    }
    public void getShippingCosts(double totalPrice, Order order){
        if(totalPrice<=100) {
            Item item = new Item();
            item.setId(99l);
            item.setName("Porto und Versand");
            if(totalPrice>90) {
                item.setPrice(totalPrice*0.05);
            } else if(totalPrice>50) {
                item.setPrice(7.5d);
            } else {
                item.setPrice(10d);
            }
            order.getItems().add(item);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}
