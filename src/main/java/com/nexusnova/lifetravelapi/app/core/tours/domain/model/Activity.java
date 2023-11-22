package com.nexusnova.lifetravelapi.app.core.tours.domain.model;

import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.Null;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "activities")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE activities SET _deleted = true WHERE id = ?")
public class Activity extends AuditModel {

    @Column(name = "title")
    private String title;

    @Column(name = "img_url")
    @Null
    private String imgUrl;

    @ManyToMany(mappedBy = "activities")
    private Set<TourPackage> tourPackages;

}
