package carfacts.vindecoder.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import carfacts.vindecoder.dao.ApiDAO;
import carfacts.vindecoder.dto.Api;
import carfacts.vindecoder.dto.Decoder;

@Service("apiDAO")
@Transactional
public class ApiDAOImpl implements ApiDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Api> list() {
		String selectQuery = "SELECT Api WHERE status = :status";
		
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
			query.setParameter("status", true);
			
			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Api get(String vin) {
		String query = "FROM Api WHERE vin = :vin";

		try {

			return sessionFactory.getCurrentSession()
					.createQuery(query, Api.class)
						.setParameter("vin", vin)
							.getSingleResult();

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(Api api) {
		try {
			sessionFactory.getCurrentSession().persist(api);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Api api) {
		try {
			sessionFactory.getCurrentSession().update(api);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Api api) {
		
		api.setStatus(false);
		
		try {
			sessionFactory.getCurrentSession().update(api);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
