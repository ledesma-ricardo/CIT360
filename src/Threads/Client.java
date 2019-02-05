/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author RALedesma
 */
public class Client {
    
    private String name;
    private int[] shoppingCart;

    public String getName() {
        return name;
    }

    public int[] getShoppingCart() {
        return shoppingCart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShoppingCart(int[] shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Client(String name, int[] shoppingCart) {
        this.name = name;
        this.shoppingCart = shoppingCart;
    }


    
}
