package com.zjl.myblog.repository;

import com.zjl.myblog.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findByRoleName(String roleName);
}
