package com.zjl.myblog.repository;

import com.zjl.myblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserPhone(String userPhone);

    public User findByUserEmail(String userEmail);

    public User findByUserName(String userName);
}
