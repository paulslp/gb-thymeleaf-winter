package ru.gb.gbthymeleafwinter.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gb.gbthymeleafwinter.dto.ProductDto;
import ru.gb.gbthymeleafwinter.entity.Product;

@Component
public class ProductConverter implements Converter<ProductDto, Product> {

    @Override
    public Product convert(ProductDto source) {
        Product product = new Product();
        product.setId(source.getId());
        product.setTitle(source.getTitle());
        product.setCost(source.getCost());
        product.setDate(source.getDate());
        product.setStatus(source.getStatus());
        return product;
    }
}
