package carfacts.vindecoder.dao;

import java.util.List;

import carfacts.vindecoder.dto.Decoder;

public interface DecoderDAO {

	/**
	 * Get all VIN decoder details
	 * @return
	 */
	List<Decoder> list();
	
	/**
	 * Get a single VIN decoder
	 * @param vin
	 * @return
	 */
	Decoder get(int vin);
	
	/**
	 * Add a new VIN decoded
	 * @param decoder
	 * @return
	 */
	boolean add(Decoder decoder);
	
	/**
	 * Update an existing VIN decoded
	 * @param decoder
	 * @return
	 */
	boolean update(Decoder decoder);
	
	/**
	 * Delete an existing VIN decoded
	 * @param decoder
	 * @return
	 */
	boolean delete(Decoder decoder);
}
