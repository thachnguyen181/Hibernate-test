package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.repository.Location;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {
	
}
