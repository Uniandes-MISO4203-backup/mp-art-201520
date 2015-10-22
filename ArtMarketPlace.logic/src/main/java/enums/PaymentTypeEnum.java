/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author ms.lancheros10
 */
public enum PaymentTypeEnum {

    CREDIT_CARD("Credit Card"), PSE("PSE"), PAYPAL("PayPal");

    private String name;

    PaymentTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
