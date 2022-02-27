package ru.gb.gbthymeleafwinter.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gb.gbthymeleafwinter.dto.ProductDto;
import ru.gb.gbthymeleafwinter.entity.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductDtoConverter implements Converter<Product, ProductDto> {


    @Override
    public ProductDto convert(Product source) {
        ProductDto productDto = new ProductDto();
        productDto.setId(source.getId());
        productDto.setTitle(source.getTitle());
        productDto.setCost(source.getCost());
        productDto.setDate(source.getDate());
        productDto.setStatus(source.getStatus());
        return productDto;
    }

    public Map<ProductDto, Integer> convert(Map<Product, Integer> source) {
        Map<ProductDto, Integer> result = new HashMap<>();
        source.forEach((key, value) -> result.put(convert(key), value));
        return result;
    }

    public List<ProductDto> convert(List<Product> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
