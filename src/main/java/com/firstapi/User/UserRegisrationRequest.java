package com.firstapi.User;

public record UserRegisrationRequest(
        String firstname, String lastname, String email
) {
}
