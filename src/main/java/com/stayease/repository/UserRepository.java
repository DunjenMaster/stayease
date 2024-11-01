package com.stayease.repository;

public class UserRepository {
    
}
package com.stayease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stayease.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
