package ru.gb.gbthymeleafwinter.dao;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Setter
@Getter
public class CartDao {

    private Map<Long, Integer> productIdMap = new HashMap<>();

    @PostConstruct
    void init() {
        productIdMap = new HashMap<>();
    }

    public void deleteById(Long id) {
        productIdMap.remove(id);
    }

    public Long insertProduct(Long productId) {
        productIdMap.put(productId, 1);
        return productId;
    }

    public Long updateProduct(Long productId) {
        Integer currentCount = productIdMap.get(productId);
        productIdMap.put(productId, currentCount + 1);
        return productId;
    }
}
