package ru.gb.gbthymeleafwinter.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.gbthymeleafwinter.converter.ProductDtoConverter;
import ru.gb.gbthymeleafwinter.dto.ProductDto;
import ru.gb.gbthymeleafwinter.service.CartService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final ProductDtoConverter productDtoConverter;

    private final CartService cartService;

    @GetMapping("/all")
    public Map<ProductDto, Integer> getProductList() {
        return productDtoConverter.convert(cartService.findCartProducts());
    }

    @PostMapping("/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addProduct(@PathVariable Long productId) {
        return cartService.insertProduct(productId);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long updateProduct(@PathVariable Long productId) {
        return cartService.updateProduct(productId);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long productId) {
        cartService.deleteById(productId);
    }
}
