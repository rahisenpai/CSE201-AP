package org.example;

public class Discount {
    private String category;
    private int lower_age;
    private int upper_age;
    private String code;
    private int discount;

    Discount(String category, int discount, int lage, int uage, String code){
        this.category = category;
        this.discount = discount;
        this.lower_age = lage;
        this.upper_age = uage;
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code+": "+this.discount+"% discount for "+this.category+"("+this.lower_age+"-"+this.upper_age+")";
    }

    public int getDiscount() {
        return discount;
    }

    public int getUpper_age() {
        return upper_age;
    }

    public int getLower_age() {
        return lower_age;
    }

    public String getCode() {
        return code;
    }
}