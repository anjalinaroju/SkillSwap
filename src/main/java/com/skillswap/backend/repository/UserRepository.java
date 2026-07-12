//package com.skillswap.backend.repository;
//
//public interface UserRepository {
//
//}

package com.skillswap.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillswap.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}