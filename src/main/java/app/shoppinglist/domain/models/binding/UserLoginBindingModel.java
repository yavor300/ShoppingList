package app.shoppinglist.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {
    @NotBlank(message = "Username can't be empty.")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    private String username;
    @NotBlank(message = "Password can't be empty.")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    private String password;
}
