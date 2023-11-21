package com.ldg.webchat.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserDTO {
    private String userId;
    private String userName;

    public UserDTO(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
