package cn.tomoya.module.user.dao;

import cn.tomoya.module.user.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * http://tomoya.cn
 */
@Repository
@CacheConfig(cacheNames = "users")
public interface UserDao extends JpaRepository<User, Integer> {

  @Cacheable
  User findOne(int id);

  @Cacheable
  User findByUsername(String username);

  @CacheEvict
  void delete(int id);

  @Cacheable
  User findByToken(String token);

  @Cacheable
  User findByEmail(String email);

}
