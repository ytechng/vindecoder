package carfacts.vindecoder.dao;

import java.util.List;

import carfacts.vindecoder.dto.Transaction;
import carfacts.vindecoder.dto.User;
import carfacts.vindecoder.dto.VinLog;

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
	public User get(int id);
	
	/**
	 * Fetch All User Record
	 * @param User
	 * @return user object
	 */
	public List<User> list();
	
	/**
	 * Activate User Account
	 * @param User
	 * @return user object
	 */
	public boolean activateUser(User user);

	/**
	 * Get User By Email
	 * @param User
	 * @return user object
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Deduct Credit
	 * @param qty
	 * @return boolean
	 */
	public boolean deductCredit(User user);
	
	/**
	 * Update Vin Logs
	 * @param vin
	 * @return boolean
	 */
	public boolean addVinLogs(VinLog vin);
	
	/**
	 * Get Vin Logs
	 * @param userId
	 * @return list
	 */
	public List<VinLog> getVinLogs(int userId);
	
	
	/**
	 * Get List of Business Users
	 * @return list
	 */
	public List<User> getUsersByRole(String role);
	
	/**
	 * Create Transaction Logs
	 * @param tranx
	 * @return
	 */
	public boolean addTranactionLog(Transaction tranx);
}
