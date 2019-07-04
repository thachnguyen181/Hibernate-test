package tma.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tma.com.model.LocationDTO;
import tma.com.repository.ILocationRepository;
import tma.com.repository.Location;
import tma.com.service.ILocationService;

@RestController
public class LocationController {
	@Autowired
	private ILocationRepository locationRepo;

	@Autowired
	private ILocationService locaServ;

	/* ---------------- GET ALL LOCATION ------------------------ */
	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	public ResponseEntity<List<LocationDTO>> getAll() {
		return new ResponseEntity<List<LocationDTO>>(locaServ.findAll(), HttpStatus.OK);
	}

	/* ---------------- GET LOCATION BY ID ------------------------ */
	@RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getLocationById(@PathVariable int id) {
		Location loca = locaServ.findById(id).get();
		if (loca != null) {
			return new ResponseEntity<Object>(loca, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Not Found Location", HttpStatus.NO_CONTENT);
	}

	/* ---------------- CREATE NEW LOCATION ------------------------ */
	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public ResponseEntity<Location> createLocation(@RequestBody LocationDTO loca) {
		Location locaCreated = locaServ.insert(loca);
		if (locaCreated != null) {
			return new ResponseEntity<Location>(locaCreated, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Location>(locaCreated, HttpStatus.BAD_REQUEST);
		}
	}

	/* ---------------- EDIT LOCATION ------------------------ */
	@RequestMapping(value = "/locations", method = RequestMethod.PUT)
	public ResponseEntity<String> editLocation(@RequestBody Location loca) {
		if (locaServ.update(loca) != true) {
			return new ResponseEntity<String>("Edited!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Failure!", HttpStatus.BAD_REQUEST);
		}
	}

	/* ---------------- DELETE LOCATION ------------------------ */
	@RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLocationById(@PathVariable int id) {
		locaServ.delete(id);
		return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
	}
}
