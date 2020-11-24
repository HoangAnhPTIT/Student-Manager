package com.hoanganh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hoanganh.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	List<UserEntity> findBycodeLike(String code, Pageable pageable);
	UserEntity findByid(Long id);
	UserEntity findOneByuserName(String userName);
	int countBycodeLike(String code);
}
