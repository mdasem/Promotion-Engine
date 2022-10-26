package com.promotion.engine.promotion;

import com.promotion.engine.model.Cart;
import com.promotion.engine.model.Product;
import com.promotion.util.PriceList;

import java.util.HashMap;
import java.util.Map;

public class SingleProductPromotion implements Promotion {
    private String appliedItem;
    private Integer quota;
    private Double promotedPrice;

    public SingleProductPromotion(String appliedItem, Integer quota, Double promotedPrice) {
        this.appliedItem = appliedItem;
        this.quota = quota;
        this.promotedPrice = promotedPrice;
    }

    @Override
    public Cart applyPromotion(Cart cart) {
        if(cart.getContents().isEmpty())
            return cart;

        if(!isAvailable(cart)) {
            System.out.println("No promotion available at this moment...");
        }

        Cart promotedCart = new Cart(cart.getContents());

        int cartQuantity = promotedCart.getQuantity(appliedItem);
        Map<Product, Integer> updatedContents = new HashMap<>();

        if(cartQuantity - quota == 0) {
            updatedContents.putAll(promotedCart.removeItem(appliedItem));
        }
        else {
            updatedContents.putAll(promotedCart.adjustInventory(appliedItem, cartQuantity - quota));
        }

        promotedCart.setContents(updatedContents);
        return promotedCart;
    }

    /**
     * This returns true if the cart for the given item has the item meeting quota criteria of the promotion
     * @param cart
     * @return
     */
    @Override
    public Boolean isAvailable(Cart cart) {
        for(Map.Entry<Product, Integer> kv: cart.getContents().entrySet()){
            if(kv.getKey().getName().equalsIgnoreCase(appliedItem) && kv.getValue() >= quota)
                return true;
        }
        return false;
    }

    @Override
    public Double getDiscountedPrice() {
        return (PriceList.getPrice(appliedItem) * this.quota) - this.promotedPrice;
    }
}
