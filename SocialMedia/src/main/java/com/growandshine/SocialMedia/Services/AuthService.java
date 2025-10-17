package com.growandshine.SocialMedia.Services;

import com.growandshine.SocialMedia.DTO.AuthDTO.ProfileResponseDTO;
import com.growandshine.SocialMedia.DTO.AuthDTO.SignupDTO;
import com.growandshine.SocialMedia.Entites.Profile;
import com.growandshine.SocialMedia.Entites.Users;
import com.growandshine.SocialMedia.Repositories.ProfileRepository;
import com.growandshine.SocialMedia.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public ResponseEntity<String> signup(SignupDTO signupDTO) {

        // check the user first

        Users user = usersRepository.findByEmail(signupDTO.getEmail()).orElse(null);

        if (user != null) {
            return new ResponseEntity<>("User is already exists !! ", HttpStatus.BAD_REQUEST);
        }

        Users newUser = new Users();
        newUser.setUserName(signupDTO.getUserName());
        newUser.setEmail(signupDTO.getEmail());
        newUser.setPassword(signupDTO.getPassword());

        usersRepository.save(newUser);

        return new ResponseEntity<>("User created !!", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateProfile(String email, String about) {

        Users user = usersRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return new ResponseEntity<>("User not found !", HttpStatus.BAD_REQUEST);
        }


        Profile profile = profileRepository.findById(user.getUserId()).orElse(null);

        if (profile == null) {

            Profile newProfile = new Profile();

            newProfile.setAbout(about);

            newProfile.setUser(user);

            profileRepository.save(newProfile);

            return new ResponseEntity<>("Profile is updated !", HttpStatus.OK);
        }
        profile.setAbout(about);

        profileRepository.save(profile);

        return new ResponseEntity<>("Profile is updated !", HttpStatus.OK);


    }


    public ResponseEntity<ProfileResponseDTO> getUserProfile(String userName) {

        //find the user

        Users user = usersRepository.findByUserName(userName).orElse(null);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Profile profile = profileRepository.findByUserId(user.getUserId()).orElse(null);

        if (profile != null) {
            ProfileResponseDTO profileResponseDTO = ProfileResponseDTO.builder()
                    .posts(profile.getPosts())
                    .about(profile.getAbout())
                    .followers(profile.getFollowers())
                    .userName(user.getUserName())
                    .build();
            return new ResponseEntity<>(profileResponseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
