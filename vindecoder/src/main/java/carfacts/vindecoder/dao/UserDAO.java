package carfacts.vindecoder.dao;

import carfacts.vindecoder.dto.User;

public interface UserDAO {

	/**
	 * Add User Record
	 * @param user
	 * @return boolean
	 */
	public boolean add(User user); 
	
	/**
	 * Update User
	 * @param user
	 * @return boolean
	 */
	public boolean update(User user);
	
	/**
	 * Delete User
	 * @param user
	 * @return boolean
	 */
	public boolean delete(User user);
	
	/**
	 * Get User Record
	 * @param id
	 * @return int
	 */
	public User getUser(int id);
}
