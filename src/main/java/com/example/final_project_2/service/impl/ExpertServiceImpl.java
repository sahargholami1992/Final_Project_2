package com.example.final_project_2.service.impl;


import com.example.final_project_2.entity.Expert;
import com.example.final_project_2.entity.enumaration.ExpertStatus;
import com.example.final_project_2.repository.ExpertRepository;
import com.example.final_project_2.service.ExpertService;
import com.example.final_project_2.service.dto.ExpertRegisterDto;
import com.example.final_project_2.service.user.UserServiceImpl;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ExpertServiceImpl extends UserServiceImpl<Expert, ExpertRepository>
                              implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }

    @Override
    public void registerExpert(ExpertRegisterDto dto) {
        Expert expert = new Expert();
       expert.setFirstName(dto.getFirstName());
       expert.setLastName(dto.getLastName());
       expert.setEmail(dto.getEmail());
       expert.setPassword(dto.getPassword());
       expert.setDateRegister(dto.getDateRegister());
       expert.setRoll(dto.getRoll());
       expert.setPermission(dto.getPermission());
       expert.setExpertStatus(dto.getExpertStatus());
       expert.setScore(dto.getScore());
       expert.setProfileImage(dto.getProfileImage());
       repository.save(expert);

    }

    @Override
    public void changeExpertStatus(Expert expert) {
        repository.updateExpert(expert);
    }
@Override
public Expert logIn(String email, String password) {

    Expert user = repository.findByEmail(email).
            orElseThrow(() -> new NoResultException("userName or password is wrong"));

    if (password.equals(user.getPassword()) && !user.getExpertStatus().equals(ExpertStatus.AWAITING_CONFIRMATION)) {
        return user;
    }
    throw new RuntimeException("userName or password is wrong or you are new yet");

}

}
