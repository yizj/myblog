package com.zjl.myblog.repository;

import com.zjl.myblog.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Integer> {

    UserDO findByUserPhone(String userPhone);

    UserDO findByUserEmail(String userEmail);

    UserDO findByUserName(String userName);

    UserDO findUserByUserEmailAndUserPwd(String userEmail, String userPwd);
}
