package app.shoppinglist.repository;

import app.shoppinglist.domain.entities.Category;
import app.shoppinglist.domain.entities.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(CategoryName categoryName);
}
