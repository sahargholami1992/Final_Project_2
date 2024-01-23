package com.example.final_project_2.service.user;


import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.User;

import java.util.Collection;

public interface UserService<T extends User>  {
    void changePassword(String email, String newPassword);
    boolean existByEmail(String email);
    T logIn(String email, String password);

    Collection<T> loadAll();
}
