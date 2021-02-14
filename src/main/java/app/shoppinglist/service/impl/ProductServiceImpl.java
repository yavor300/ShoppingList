package app.shoppinglist.service.impl;

import app.shoppinglist.domain.entities.Category;
import app.shoppinglist.domain.entities.Product;
import app.shoppinglist.domain.entities.enums.CategoryName;
import app.shoppinglist.domain.models.service.CategoryServiceModel;
import app.shoppinglist.domain.models.service.ProductServiceModel;
import app.shoppinglist.domain.models.view.ProductViewModel;
import app.shoppinglist.repository.ProductRepository;
import app.shoppinglist.service.CategoryService;
import app.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
   private final ProductRepository productRepository;
   private final ModelMapper modelMapper;
   private final CategoryService categoryService;
   @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
       this.categoryService = categoryService;
   }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);

        CategoryServiceModel categoryServiceModel = categoryService.findByName(product.getCategory().getName());
        Category category = modelMapper.map(categoryServiceModel, Category.class);

        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllByCategoryName(CategoryName categoryName) {
        return productRepository.findAllByCategory_Name(categoryName)
                .stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
