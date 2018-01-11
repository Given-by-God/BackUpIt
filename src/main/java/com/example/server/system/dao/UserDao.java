package com.example.server.system.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.server.system.model.User;


@Repository
public interface UserDao extends CrudRepository<User, Long> {

}