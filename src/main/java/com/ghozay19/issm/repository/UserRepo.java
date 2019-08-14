package com.ghozay19.issm.repository;

import com.ghozay19.issm.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String Password);

}
