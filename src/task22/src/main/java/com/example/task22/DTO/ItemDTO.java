package com.example.task22.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {
    private String name;
    private String creationDate;
    private Integer price;
}
