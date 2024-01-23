package com.example.final_project_2.repository.user;



import com.example.final_project_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T,Integer> {
//    @Query(value = "UPDATE User u SET u.password=:newPassword WHERE u.email = :email ")
    void updatePassword(String email, String newPassword);

    boolean existsByEmail(String email);
    Optional<T> findByEmail(String email);
}
