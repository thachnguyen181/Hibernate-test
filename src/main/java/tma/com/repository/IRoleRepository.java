package tma.com.repository;

import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role, Integer>{
	Role findByName(String name);
}
