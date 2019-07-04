package tma.com.service;

import java.util.List;
import java.util.Optional;

import tma.com.repository.Location;
import tma.com.model.LocationDTO;

public interface ILocationService {
	
	public List<LocationDTO> findAll();
	public Optional<Location> findById(long id);
	public Location insert(LocationDTO location);
	public boolean update(Location location);
	public void delete(long id);
}
