package app.shoppinglist.service;

import app.shoppinglist.domain.entities.enums.CategoryName;
import app.shoppinglist.domain.models.service.ProductServiceModel;
import app.shoppinglist.domain.models.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllByCategoryName(CategoryName categoryName);

    void buyById(String id);
}
