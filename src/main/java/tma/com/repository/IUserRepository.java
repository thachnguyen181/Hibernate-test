package tma.com.repository;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);	
}
