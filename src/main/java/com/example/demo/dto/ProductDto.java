package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class ProductDto {
    @NotBlank
    @Size(min = 3, max = 50)
    private String title;
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int price;
}
