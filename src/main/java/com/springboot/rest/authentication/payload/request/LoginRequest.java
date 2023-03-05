package com.springboot.rest.authentication.payload.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor (access= AccessLevel.PRIVATE, force=true)
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
