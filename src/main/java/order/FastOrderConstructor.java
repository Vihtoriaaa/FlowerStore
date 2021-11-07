package order;

import delivery.DHLDeliveryStrategy;
import delivery.Delivery;
import delivery.PostDeliverStrategy;
import flowers.*;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;
import payment.Payment;
import users.Receiver;
import users.Sender;


public enum FastOrderConstructor {
    ROSE_BUCKET(FlowerType.ROSE),
    TULIP_BUCKET(FlowerType.TULIP),
    CHAMOMILE_BUCKET(FlowerType.CHAMOMILE);
    private FlowerType type;

    FastOrderConstructor(FlowerType type) {this.type = type;}

    private FlowerType getType(){return this.type;}

    public static Order createOrder(FastOrderConstructor bucket_type, int num_flowers, int price, String deliv, String paym){
        Order order = new Order();
        Delivery delivery = null;
        Payment payment = null;
        Receiver receiver = new Receiver();
        Sender sender = new Sender();
        if (deliv.equals("Post")){
            delivery = new PostDeliverStrategy();
        } else if (deliv.equals("DHL")){
            delivery = new DHLDeliveryStrategy();}

        if (paym.equals("PayPal")){
            payment = new PayPalPaymentStrategy();
        } else if (paym.equals("Card")){
            payment = new CreditCardPaymentStrategy();}

        Item bucket = new FlowerBucket();
        Flower flower = new Flower(bucket_type.getType());
        flower.setPrice(price);
        FlowerPack pack = new FlowerPack(flower, num_flowers);
        pack.setFlower((Flower) flower);
        pack.setAmount(10);
        ((FlowerBucket) bucket).addFlowerPack(pack);
        order.addItem(bucket);
        order.addUser(sender);
        order.addUser(receiver);
        order.setPaymentStrategy(payment);
        order.setDeliveryStrategy(delivery);
        return order;
    }
}