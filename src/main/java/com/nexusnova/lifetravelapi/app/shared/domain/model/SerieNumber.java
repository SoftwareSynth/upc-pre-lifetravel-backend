package com.nexusnova.lifetravelapi.app.shared.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "correlative")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE correlative SET _deleted = true WHERE id = ?")
public class SerieNumber extends AuditModel {

    @Column(name = "serie")
    private String serie;

    @Column(name = "number")
    private String number;

    @Column(name = "digits")
    private Integer digits;

    @Column(name = "type")
    private String type;
}
