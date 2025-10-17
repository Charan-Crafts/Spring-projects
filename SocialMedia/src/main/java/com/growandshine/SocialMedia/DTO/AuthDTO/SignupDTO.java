package com.growandshine.SocialMedia.DTO.AuthDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupDTO {

    private String userName;

    private String password;

    private String email;
}
