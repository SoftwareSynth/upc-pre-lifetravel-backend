package com.nexusnova.lifetravelapi.app.IAM.profile.domain.model;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.model.Vehicle;
import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agencies")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE agencies SET _deleted = true WHERE id = ?")
public class Agency extends AuditModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Size(max = 100)
    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "RUC")
    private Long RUC;

    @Size(max = 240)
    @Column(name = "address")
    private String address;

    @Column(name = "agency_photo_url")
    private String agencyPhotoUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "web_page_url")
    private String webPageUrl;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agency")
    private Set<TourPackage> tourPackages;


}
