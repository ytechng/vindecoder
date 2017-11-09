package carfacts.vindecoder.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import carfacts.vindecoder.dao.DecoderDAO;
import carfacts.vindecoder.dto.Decoder;

@Repository("decoderDAO")
@Transactional
public class DecoderDAOImpl implements DecoderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Decoder> list() {
		String selectQuery = "SELECT Decoder WHERE status = :status";
		
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
	public Decoder get(int vin) {
		String selectQuery = "SELECT Decoder WHERE vin = :vin and status = :status";
		try {
			return sessionFactory.getCurrentSession().get(Decoder.class, Integer.valueOf(vin));
//					.createQuery(selectQuery, Decoder.class)
//						.setParameter("vin", vin)
//						.setParameter("status", true)
//							.getSingleResult();
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(Decoder decoder) {
		try {
			sessionFactory.getCurrentSession().persist(decoder);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Decoder decoder) {
		try {
			sessionFactory.getCurrentSession().update(decoder);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Decoder decoder) {
		
		decoder.setStatus(false);
		
		try {
			sessionFactory.getCurrentSession().update(decoder);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
