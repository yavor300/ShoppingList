package app.shoppinglist.domain.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductViewModel {
    private String id;
    private String name;
    private String price;
}
