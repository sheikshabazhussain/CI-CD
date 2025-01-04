package com.shabaz.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shabaz.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	
	@Query("SELECT u FROM Users u WHERE u.userName = :username")
    Users findByUsername(@Param("username") String username);
	
}
