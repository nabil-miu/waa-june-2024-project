package edu.miu.cs545.project.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.*;

@SQLDelete(sql = "UPDATE #{#entityName} SET deleted = true WHERE id=?")
//@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
//@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")
@Where(clause = "deleted = false")
@Data
@MappedSuperclass
public class BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private boolean deleted = false;

    public void softDelete() {
        this.deleted = true;
    }

}
