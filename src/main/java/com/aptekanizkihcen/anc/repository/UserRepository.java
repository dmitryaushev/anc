package com.aptekanizkihcen.anc.repository;

import com.aptekanizkihcen.anc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update users set status = :status where id=:id", nativeQuery = true)
    void changeUserStatus(@Param("id") int id, @Param("status") String status);

    @Modifying
    @Transactional
    @Query(value = "update users set segment = :segment where id=:id", nativeQuery = true)
    void changeUserSegment(@Param("id") int id, @Param("segment") String segment);
}
