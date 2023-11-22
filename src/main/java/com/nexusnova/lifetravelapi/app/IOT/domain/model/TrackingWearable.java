package com.nexusnova.lifetravelapi.app.IOT.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tracking_wereables")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE tracking_wereables SET _deleted = true WHERE id = ?")
public class TrackingWearable extends AuditModel {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tourist_user_id")
    @JsonIgnore
    private User touristUser;

    @Column(name = "latitude", columnDefinition = "decimal(13,10)")
    @Null
    private BigDecimal latitude;

    @Column(name = "longitude", columnDefinition = "decimal(13,10)")
    @Null
    private BigDecimal longitude;

    @Formula("concat(serie,'-', number)")
    private String serieNumber;

    @Column(name = "serie")
    private String serie;

    @Column(name = "number")
    private String number;
}
