package com.example.xx2.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.xx2.model.Product;
import com.example.xx2.service.ProductService;
import com.example.xx2.service.PromotionService;
import java.util.List;
@Component
public class PromotionScheduler {
    final
    ProductService productService;
    final
    PromotionService promotionService;

    public PromotionScheduler(ProductService productService, PromotionService promotionService) {
        this.productService = productService;
        this.promotionService = promotionService;
    }

    @Scheduled(cron = "* * * * * *")
    public void cronJob(){
        System.out.println("tes");
        List<Product> productPromoList = productService.getProductsList();
        promotionService.sendFCM(productPromoList);
    }
}
