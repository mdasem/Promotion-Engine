package com.promotion.util;



import com.promotion.engine.promotion.BundledProductPromotion;
import com.promotion.engine.promotion.Promotion;
import com.promotion.engine.promotion.SingleProductPromotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PromotionUtil {
    public static List<Promotion> setupPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        BundledProductPromotion bundlePromotion = new BundledProductPromotion(Arrays.asList("C", "D"), 30.0);
        SingleProductPromotion singleProductGroupPromotionA = new SingleProductPromotion("A", 3, 130.0);
        SingleProductPromotion singleProductGroupPromotionB = new SingleProductPromotion("B",2, 45.0);
        promotions.add(bundlePromotion);
        promotions.add(singleProductGroupPromotionA);
        promotions.add(singleProductGroupPromotionB);
        return promotions;
    }
}
