package com.optima.citas.repository;

import com.optima.citas.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query("SELECT u FROM UserEntity u " +
            "WHERE u.rolEntity.id =:id")
    List<UserEntity> listarUsuariosPorRol(@Param("id") Integer id);
}
