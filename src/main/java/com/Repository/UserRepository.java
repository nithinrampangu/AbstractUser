package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.AbstractUser;

@Repository
public interface UserRepository extends JpaRepository<AbstractUser, Integer>
{
	AbstractUser getAbstractUserByString(String username);
	
	@Query("Select c from AbstractUser c where c.mobileNumber=?1 order by c.username")
	List<AbstractUser> getAbstractUSerBymobilenumberSorted(String mobileNumber);

	Object findByString(String usname);
	AbstractUser orElseThrow(Object s1);

	void deleteByString(String username);

	AbstractUser getAbstractUserByPassword(String password);

	List<AbstractUser> getAbstractUserByemail(String email);

	
}
