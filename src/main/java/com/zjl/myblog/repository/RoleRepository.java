package com.zjl.myblog.repository;

import com.zjl.myblog.domain.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleDO, Integer> {

    RoleDO findByRoleName(String roleName);
}
