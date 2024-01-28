package com.example.final_project_2.service.user;


import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService<T extends User>  {
    T changePassword(String email, String newPassword);
    boolean existByEmail(String email);
    T logIn(String email, String password);
    T findByEmail(String email);

    Collection<T> loadAll();
}
