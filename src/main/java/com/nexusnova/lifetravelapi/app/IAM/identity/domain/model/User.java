package com.nexusnova.lifetravelapi.app.IAM.identity.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE users SET _deleted = true WHERE id = ?")
public class    User implements Serializable {

    @Id
    private String id;

    @NotNull
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(name = "google_name")
    private String googleName;

    @Column(name = "google_photo_url")
    private String googlePhotoUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnore
    private Role role;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Column(name="_deleted")
    @NotNull
    private Boolean _deleted;

    @PrePersist
    private void prePersist(){
        _deleted = false;
        createdDate = new Date();
    }
}
