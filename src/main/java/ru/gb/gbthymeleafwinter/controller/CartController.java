package ru.gb.gbthymeleafwinter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbthymeleafwinter.service.CartService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products",
                cartService.findCartProducts());
        return "cart-product-list";
    }

    @GetMapping
    public String addProduct(@RequestParam Long productId) {

        cartService.save(productId);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        cartService.deleteById(id);
        return "redirect:/cart/all";
    }
}
