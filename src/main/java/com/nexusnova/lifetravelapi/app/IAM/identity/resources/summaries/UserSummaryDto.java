package com.nexusnova.lifetravelapi.app.IAM.identity.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Usuario (Summary)")
public class UserSummaryDto {
    @Schema(description="Id del Usuario")
    private String id;
    @Schema(description="Nombre del Usuario")
    private String name;
    @Schema(description="Role")
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
