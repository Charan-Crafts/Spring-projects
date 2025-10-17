package com.growandshine.SocialMedia.Controllers;

import com.growandshine.SocialMedia.DTO.AuthDTO.ProfileResponseDTO;
import com.growandshine.SocialMedia.DTO.AuthDTO.SignupDTO;
import com.growandshine.SocialMedia.DTO.AuthDTO.UpdateProfileDTO;
import com.growandshine.SocialMedia.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthControllers {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupDTO signupDTO){

        return authService.signup(signupDTO);
    }

    @PutMapping("/profile/{email}")
    public ResponseEntity<String> updateProfile(@PathVariable String email, @RequestBody UpdateProfileDTO profileDTO) {
        return authService.updateProfile(email, profileDTO.getAbout());
    }


    @GetMapping("/profile/{userName}")
    public ResponseEntity<ProfileResponseDTO> getUserProfile(@PathVariable String userName){

        return authService.getUserProfile(userName);
    }
}

