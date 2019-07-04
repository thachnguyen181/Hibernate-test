package tma.com.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.model.LocationDTO;
import tma.com.repository.ILocationRepository;
import tma.com.repository.Location;

@Service
public class LocationService implements ILocationService {

	@Autowired
	private ILocationRepository locaRepo;

	@Override
	public List<LocationDTO> findAll() {
		// TODO Auto-generated method stub
		List<Location> locations = locaRepo.findAll();
		if (locations.isEmpty()) 
			return null;
		List<LocationDTO> result = new ArrayList();
		for (Location location: locations) {
			LocationDTO dto = new LocationDTO();
			dto.setId(location.getId());
			dto.setCity(location.getCity());
			dto.setCountry(location.getCountry());
			result.add(dto);
		}
		return result;
	}

	@Override
	public Optional<Location> findById(long id) {
		// TODO Auto-generated method stub
		return locaRepo.findById(id);
	}

	@Override
	public Location insert(LocationDTO locationDto) {
		// TODO Auto-generated method stub
		Location location = new Location();
		location.setCity(locationDto.getCity());
		location.setCountry(locationDto.getCountry());
		
		location.setCreated_at(new Date());
		location.setModified_at(new Date());
		
		return locaRepo.save(location);
	}

	@Override
	public boolean update(Location location) {
		// TODO Auto-generated method stub
		if (locaRepo.findById(location.getId()) == null)
			return false;
		Location locaEdited = locaRepo.save(location);
		if (locaEdited != null) {
			return true;
		}
		return false;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		locaRepo.deleteById(id);
	}
}
