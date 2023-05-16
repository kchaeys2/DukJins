package com.duksung.dukjins.repository;

import com.duksung.dukjins.model.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface UserRepository extends JpaRepository<user,Integer> {
}
