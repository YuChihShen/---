package model.dao;



import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.MemberBean;


@Repository
public class MemberDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	//新增
	public MemberBean insert(MemberBean bean) {
		if(bean!=null ) {
			MemberBean temp = 
					this.getSession().get(MemberBean.class, bean.getAccount());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;}
		}return null;
	}
	//查詢帳號(PK)
	public MemberBean select(String bean) {
		if(bean!=null) {
			System.out.println("bean:"+bean);
			return this.getSession().get(MemberBean.class, bean );
		}else{
			return null;
		}
	}
	//查詢email
	public MemberBean selectEmail(String email) {
		if(email!=null) {
			Query<MemberBean> query = sessionFactory.getCurrentSession().createQuery(
					"FROM MemberBean WHERE email = :email",MemberBean.class);	
			query.setParameter("email", email);
			MemberBean mail = query.uniqueResult();
			//System.out.println("bean:"+mail);
			return mail;
			}else {
				return null;
			}		
	}
		
	public List<MemberBean> selectInfo() {
		return this.getSession().createQuery(
				"from MemberBean", MemberBean.class).list();
	}
}
