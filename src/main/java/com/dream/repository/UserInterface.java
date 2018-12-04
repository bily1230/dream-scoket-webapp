package com.dream.repository;

import com.dream.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends CrudRepository<User, String> {
}
