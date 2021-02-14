package app.shoppinglist.domain.models.service;

import app.shoppinglist.domain.entities.enums.CategoryName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryServiceModel {
    private String id;
    private CategoryName name;
    private String description;
}
