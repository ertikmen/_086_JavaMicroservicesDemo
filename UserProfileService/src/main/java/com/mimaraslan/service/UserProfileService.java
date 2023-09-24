package com.mimaraslan.service;

import com.mimaraslan.dto.request.UserProfileSaveRequestDto;
import com.mimaraslan.mapper.IUserProfileMapper;
import com.mimaraslan.repository.IUserProfileRepository;
import com.mimaraslan.repository.entity.UserProfile;
import com.mimaraslan.utility.ServiceManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.mimaraslan.constant.EndPoints.GETALL;

@Service
public class UserProfileService extends ServiceManager <UserProfile, Long> {

    private final IUserProfileRepository repository;

    public UserProfileService(IUserProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public Boolean saveDto(UserProfileSaveRequestDto dto) {


//        UserProfile userProfile=UserProfile.builder()
//                .authid(dto.getAuthid())
//                .username(dto.getUsername())
//                .email(dto.getEmail())
//                .build();
//
//        save(userProfile);

        save(IUserProfileMapper.INSTANCE.toUserProfile(dto));

        return  true;
    }


    @Cacheable(value="getupperCase")
    public String getUpperCase(String firstName){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return firstName.toUpperCase();

    }

    @CacheEvict(value="getupperCase",allEntries = true)
    public void clearCache(){
        System.out.println("getUpperCase temizlendi...");
    }

}
