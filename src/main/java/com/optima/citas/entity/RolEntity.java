package com.optima.citas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="rol")
/*
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data */
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roleName;

    public RolEntity() {
    }

    public RolEntity(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}//fin de la clase rol
