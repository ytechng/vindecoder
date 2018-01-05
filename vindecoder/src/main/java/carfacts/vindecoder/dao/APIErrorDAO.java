package carfacts.vindecoder.dao;

import java.util.List;

import carfacts.vindecoder.dto.APIError;

public interface APIErrorDAO {
	
	/**
	 * Add User Record
	 * @param user
	 * @return boolean
	 */
	public boolean add(APIError error); 
	
	/**
	 * Update Error
	 * @param error
	 * @return boolean
	 */
	public boolean update(APIError error);
	
	/**
	 * Delete Error
	 * @param error
	 * @return boolean
	 */
	public boolean delete(APIError error);
	
	/**
	 * Delete Error
	 * @param id
	 * @return int
	 */
	public APIError get(int id);
	
	/**
	 * Fetch All Error Record
	 * @param Error
	 * @return error object
	 */
	public List<APIError> list();

	/**
	 * Get Error By Code
	 * @param Error
	 * @return error object
	 */
	public APIError getErrorByCode(String code);

}
