package carfacts.vindecoder.dao;

import java.util.List;

import carfacts.vindecoder.dto.Api;

public interface ApiDAO {

	/**
	 * Get all VIN decoder details
	 * @return
	 */
	List<Api> list();
	
	/**
	 * Get a single VIN decoder
	 * @param vin
	 * @return
	 */
	Api get(int vin);
	
	/**
	 * Add a new VIN decoded
	 * @param decoder
	 * @return
	 */
	boolean add(Api decoder);
	
	/**
	 * Update an existing VIN decoded
	 * @param decoder
	 * @return
	 */
	boolean update(Api decoder);
	
	/**
	 * Delete an existing VIN decoded
	 * @param decoder
	 * @return
	 */
	boolean delete(Api api);
}
