package app.shoppinglist.service;

import app.shoppinglist.domain.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
