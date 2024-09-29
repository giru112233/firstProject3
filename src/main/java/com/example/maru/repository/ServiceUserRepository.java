package com.example.maru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.maru.entity.ServiceUserEnitity;

/**
 * ユーザー情報 Entity
 */

@Repository
public interface ServiceUserRepository extends JpaRepository<ServiceUserEnitity, Integer> {


}