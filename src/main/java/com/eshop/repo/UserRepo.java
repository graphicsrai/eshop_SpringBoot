package com.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eshop.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	@Query(value = "SELECT u.uid as uid, u.uname as uname,u.utype as utype, u.password as password, u.uemail as uemail FROM User u WHERE uemail = :uemail", nativeQuery = true)
	public User getByEmail(String uemail);
}
