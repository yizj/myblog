package com.zjl.myblog.repository;

import com.zjl.myblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserPhone(String userPhone);

    User findByUserEmail(String userEmail);

    User findByUserName(String userName);
}
