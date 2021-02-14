package app.shoppinglist.service;

import app.shoppinglist.domain.entities.enums.CategoryName;
import app.shoppinglist.domain.models.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();

    CategoryServiceModel findByName(CategoryName categoryName);
}
