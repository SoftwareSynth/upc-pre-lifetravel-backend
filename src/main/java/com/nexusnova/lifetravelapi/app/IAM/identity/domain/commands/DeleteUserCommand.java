package com.nexusnova.lifetravelapi.app.IAM.identity.domain.commands;

public record DeleteUserCommand(Long id) {
    public String userId() {
        return id.toString();
    }
}
