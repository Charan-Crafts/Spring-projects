package com.growandshine.SocialMedia.DTO.AuthDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDTO {

    private String userName;

    private String about;

    private long followers;

    private long posts;
}
