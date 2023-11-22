package com.nexusnova.lifetravelapi.app.core.tours.domain.model;

import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "regions")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE regions SET _deleted = true WHERE id = ?")
public class Region extends AuditModel{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
    private Set<TourPackage> tourPackages;

}
