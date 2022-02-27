package ru.gb.gbthymeleafwinter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.gbthymeleafwinter.dao.CartDao;
import ru.gb.gbthymeleafwinter.entity.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartDao cartDao;

    private final ProductService productService;

    public Long insertProduct(Long productId) {
        return cartDao.insertProduct(productId);
    }

    public Long updateProduct(Long productId) {
        return cartDao.updateProduct(productId);
    }

    public Map<Product, Integer> findCartProducts() {
        Map<Product, Integer> resultMap = new HashMap<>();
        Map<Long, Integer> productIdMap = cartDao.getProductIdMap();
        Set<Product> productSet = productService.findAllByIdIn(cartDao.getProductIdMap().keySet());
        productSet.forEach(product -> resultMap.put(product, productIdMap.get(product.getId())));
        return resultMap;
    }

    public void deleteById(Long id) {
        cartDao.deleteById(id);
    }
}
