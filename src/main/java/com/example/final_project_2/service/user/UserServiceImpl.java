package com.example.final_project_2.service.user;


import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.User;
import com.example.final_project_2.repository.user.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl<T extends User,R extends UserRepository<T>> implements UserService<T>{

    protected final R repository;

    @Override
    public void changePassword(String email, String newPassword) {
        repository.updatePassword(email,newPassword);
    }

    @Override
    public boolean existByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public T logIn(String email, String password) {
        T user = repository.findByEmail(email).
                orElseThrow(() -> new NullPointerException("userName or password is wrong"));

        if (password.equals(user.getPassword())){
            return user;
        }
        throw new NoResultException("userName or password is wrong");

    }

    @Override
    public Collection<T> loadAll() {
        return repository.findAll();
    }
}