package cn.it.shop.service.impl;

import org.hibernate.Session;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.utils.HibernateSessionFactory;
/**
 * @Description TODO��ĿǰService��DAO������һ��û�г�ȡ��
 * @author Ni Shengwu
 *
 */
public class CategoryServiceImpl implements CategoryService {

	@Override
	public void save(Category category) {
		//ͨ���������ȡsession
		Session session = HibernateSessionFactory.getSession();
		try {
			//�ֶ�����
			session.getTransaction().begin();
			//ִ��ҵ���߼�
			session.save(category);
			//�ֶ��ύ
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
	}

}
