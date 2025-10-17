package com.growandshine.SocialMedia.Repositories;

import com.growandshine.SocialMedia.Entites.Posts;
import com.growandshine.SocialMedia.Entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts,String > {
}
