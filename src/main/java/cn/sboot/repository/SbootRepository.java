package cn.sboot.repository;


import cn.sboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SbootRepository extends JpaRepository<User, Integer> {

    User findByUserId(Integer userId);

    User findByUserName(String userName);

    @Override
    List<User> findAll();

}