package carfacts.vindecoder.dao;

import java.util.List;

import carfacts.vindecoder.dto.Decoder;

public interface DecoderDAO {

	/**
	 * Get all VIN decoder details
	 * @return
	 */
	public List<Decoder> list();
	
	/**
	 * Get a single VIN decoder
	 * @param vin
	 * @return
	 */
	public Decoder get(String vin);
	
	/**
	 * Add a new VIN decoded
	 * @param decoder
	 * @return
	 */
	public boolean add(Decoder decoder);
	
	/**
	 * Update an existing VIN decoded
	 * @param decoder
	 * @return
	 */
	public boolean update(Decoder decoder);
	
	/**
	 * Delete an existing VIN decoded
	 * @param decoder
	 * @return
	 */
	public boolean delete(Decoder decoder);
}
