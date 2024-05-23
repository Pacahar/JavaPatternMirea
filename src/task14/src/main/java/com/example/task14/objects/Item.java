package com.example.task14.objects;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {
    String name;
    String creationDate;
    Integer price;
}
