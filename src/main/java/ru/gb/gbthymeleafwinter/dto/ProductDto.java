package ru.gb.gbthymeleafwinter.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.gb.gbthymeleafwinter.entity.enums.Status;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

    private Long id;

    @NotBlank(message = "title is empty")
    private String title;

    @DecimalMin(value = "0.0", inclusive = false, message = "cost must be positive")
    private BigDecimal cost;

    @PastOrPresent
    private LocalDate date;

    private Status status;
}
