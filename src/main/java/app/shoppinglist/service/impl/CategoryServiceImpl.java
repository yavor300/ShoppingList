package app.shoppinglist.service.impl;

import app.shoppinglist.domain.entities.Category;
import app.shoppinglist.domain.entities.enums.CategoryName;
import app.shoppinglist.domain.models.service.CategoryServiceModel;
import app.shoppinglist.repository.CategoryRepository;
import app.shoppinglist.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName,
                                "Description for " + categoryName);
                        categoryRepository.saveAndFlush(category);
                    });
        }
    }

    @Override
    public CategoryServiceModel findByName(CategoryName categoryName) {
        return modelMapper.map(categoryRepository.findByName(categoryName), CategoryServiceModel.class);
    }
}
