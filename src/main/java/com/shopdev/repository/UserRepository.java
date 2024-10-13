package com.shopdev.repository;

import com.shopdev.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    // find userName and userEmail
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    UserEntity findByUserName(String userName);

    /**
     * WHERE userName LIKE ?%
     *
     * @param userName
     * @return List<UserEntity>
     */
    List<UserEntity> findByUserNameStartingWith(String userName);

    /**
     * WHERE id < 1
     *
     * @param id
     * @return List<UserEntity>
     */
    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail =?2")
    List<UserEntity> getUserEntityBy(String userName, String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName, @Param("userEmail") String userEmail);

    @Modifying
    @Query("UPDATE UserEntity u SET u.userEmail = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // native query
    /**
     * get count user use native query
     */
    @Query(value = "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();
}
