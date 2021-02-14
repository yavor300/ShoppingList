package app.shoppinglist.domain.models.binding;

import app.shoppinglist.domain.entities.enums.CategoryName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductAddBindingModel {
    @NotBlank(message = "Cannot be empty.")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String name;
    @Size(min = 5, message = "Description must be minimum 5 characters.")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Date cannot be in the past.")
    private LocalDateTime neededBefore;
    @Positive(message = "Price must be positive.")
    private BigDecimal price;
    @NotNull(message = "You must select the category.")
    private CategoryName category;
}
