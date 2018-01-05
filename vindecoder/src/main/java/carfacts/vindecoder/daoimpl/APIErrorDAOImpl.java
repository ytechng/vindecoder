package carfacts.vindecoder.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import carfacts.vindecoder.dao.APIErrorDAO;
import carfacts.vindecoder.dto.APIError;

@Repository("apiErrorDAO")
@Transactional
public class APIErrorDAOImpl implements APIErrorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(APIError error) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(APIError error) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(APIError error) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public APIError get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(APIError.class, Integer.valueOf(id));
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<APIError> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public APIError getErrorByCode(String code) {
		
		String query = "FROM APIError WHERE code = :code";
		
		try {
			
			return sessionFactory.getCurrentSession()
					.createQuery(query, APIError.class)
						.setParameter("code", code)
							.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
