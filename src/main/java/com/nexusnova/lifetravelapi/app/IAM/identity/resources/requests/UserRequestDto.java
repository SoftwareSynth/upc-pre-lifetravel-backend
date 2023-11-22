package com.nexusnova.lifetravelapi.app.IAM.identity.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Usuario (Request)")
public class UserRequestDto {
    @Schema(description="Id del Usuario")
    private String id;
    @Schema(description="Nombre del Usuario")
    private String name;
    @Schema(description="Email del Usuario")
    private String email;
    @Schema(description="Url de la foto del Usuario")
    private String photoUrl;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
