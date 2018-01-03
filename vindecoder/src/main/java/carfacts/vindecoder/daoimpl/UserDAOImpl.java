package carfacts.vindecoder.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.Transaction;
import carfacts.vindecoder.dto.User;
import carfacts.vindecoder.dto.VinLog;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User user) {
		user.setActive(false);

		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(id));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> list() {
		try {
			String selectUser = "FROM User";
			Query query = sessionFactory.getCurrentSession().createQuery(selectUser);
			//query.setParameter("active", true);

			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();			
			return null;
		}
	}

	@Override
	public boolean activateUser(User user) {

		user.setActive(true);

		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User getUserByEmail(String email) {
		
		String query = "FROM User WHERE email = :email";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(query, User.class)
						.setParameter("email", email)
							.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deductCredit(User user) {
		// Get the logged in user credit and deduct 1
		int newCredit = (user.getCredit() - 1);
		
		// set the user new credit
		user.setCredit(newCredit);
		
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addVinLogs(VinLog vin) {
		try {
			sessionFactory.getCurrentSession().persist(vin);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<VinLog> getVinLogs(int userId) {
		String selectQuery = "FROM VinLog WHERE userId = :userId";

		try {
			Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
			query.setParameter("userId", userId);
			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getUsersByRole(String role) {
		String selectQuery = "FROM User WHERE role = :role";
		
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery(selectQuery)
						.setParameter("role", role);
			return query.getResultList();
					
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addTranactionLog(Transaction tranx) {
		try {
			sessionFactory.getCurrentSession().persist(tranx);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	

}
