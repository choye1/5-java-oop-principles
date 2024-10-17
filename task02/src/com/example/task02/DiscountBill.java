package com.example.task02;

public class DiscountBill extends Bill {

    private final double discount;
    private Bill bill;

    public DiscountBill(int discount) {
        this.discount = discount;

    }

    public double getDiscount() {
        return discount;
    }


    public long calculateSizeOfDiscount() {
        return (long) (super.getPrice()*(discount / 100));
    }

    @Override
    public long getPrice() {
        return (long) super.getPrice() - calculateSizeOfDiscount();
    }


    @Override
    public String toString() {
         return ("Счет:"+ super.getPrice() +
                 "\nCчёт со скидкой:"+ getPrice() +
                 "\nРазмер скидки в процентах:" + getDiscount() +
                 "\nАбсолютное значение скидки: "+ calculateSizeOfDiscount());

        //return Double.toString(getPrice());
    }
}
