package com.mimaraslan.controller;

import com.mimaraslan.dto.request.UserProfileSaveRequestDto;
import com.mimaraslan.repository.entity.UserProfile;
import com.mimaraslan.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mimaraslan.constant.EndPoints.*;


//  http://localhost:9093/user
@RequiredArgsConstructor
@RestController
@RequestMapping(USER)
public class UserProfileController {

    private final UserProfileService userProfileService;

   //  http://localhost:9093/user/save
   @PostMapping(SAVE)
   public ResponseEntity<Boolean> save(@RequestBody UserProfileSaveRequestDto dto){
       return ResponseEntity.ok(userProfileService.saveDto(dto));
   }

    @GetMapping(GETALL)
    public ResponseEntity<List<UserProfile>> findAll () {
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/hi")
    public String info() {
        return "Hi: UserProfile Service";
    }

    @GetMapping("/getname")
    public ResponseEntity<String> getUpperCase(String fisrtName) {
        return ResponseEntity.ok(userProfileService.getUpperCase(fisrtName));
    }


    @GetMapping("/clearCache")
    public ResponseEntity<Void> getUpperCase() {
       userProfileService.clearCache();
        return ResponseEntity.ok().build();
    }

}
