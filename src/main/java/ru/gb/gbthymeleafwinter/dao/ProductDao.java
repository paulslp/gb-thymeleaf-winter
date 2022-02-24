package ru.gb.gbthymeleafwinter.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbthymeleafwinter.entity.Product;
import ru.gb.gbthymeleafwinter.entity.enums.Status;

import java.util.List;
import java.util.Set;

public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByTitle(String title);

    List<Product> findAllByTitleContaining(String title);

    Set<Product> findAllByIdIn(Set<Long> ids);

    List<Product> findAllByStatus(Status status);

    List<Product> findAllByStatus(Status status, Pageable pageable);

    List<Product> findAllByStatus(Status status, Sort sort);
}
