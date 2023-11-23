package com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands;

public record AuthenticateUserCommand(String email, String password) {
    public String userId() {
        return String.valueOf(1L);
    }
}
