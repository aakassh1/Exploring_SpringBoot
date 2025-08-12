package com.spiralmantra.native_query.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spiralmantra.native_query.dto.UserWithNameAndEmail;
import com.spiralmantra.native_query.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from users where email = ?1", nativeQuery = true)
	public User findUserByEmail(String email);

	@Query(value = "select * from users where dob = ?1", nativeQuery = true)
	public User findUserByDob(LocalDate dob);

	@Query(value = "select * from users where dob >= ?1", nativeQuery = true)
	public List<User> findUsersBornAfter(LocalDate dob);

	@Query(value = "select * from users where name = ?1 and email = ?2", nativeQuery = true)
	public User findUserByNameAndEmail(String name, String email);

	@Query(value = "select * from users where name like concat('%',?1,'%')", nativeQuery = true)
	public List<User> findByName(String name);

	@Query(value = "select count(*) from users where address = ?1", nativeQuery = true)
	public int countUserByAddress(String address);

//	@Modifying
//	@Transactional
//	@Query(value = "update users set address = ?2  where id = ?1")
//	public int updateAddressById(int id,String address);
}
