package com.growandshine.SocialMedia.Repositories;

import com.growandshine.SocialMedia.Entites.Profile;
import com.growandshine.SocialMedia.Entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,String> {

    @Query(value = "SElECT * FROM Profile p where p.user_id =:userId",nativeQuery = true)
    Optional<Profile> findByUserId(String userId);
}
