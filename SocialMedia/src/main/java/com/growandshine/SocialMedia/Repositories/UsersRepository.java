package com.growandshine.SocialMedia.Repositories;

import com.growandshine.SocialMedia.Entites.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String > {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByUserName(String userName);
}
