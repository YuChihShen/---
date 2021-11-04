package model.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.MemberBean;

import model.dao.MemberDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	//新增
	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		if(bean!=null && bean.getAccount()!=null) {
			result = memberDAO.insert(bean);
		}
		return result;
	}
	//查詢
//	public List<MemberBean> selectInfo(MemberBean bean) {
//		List<MemberBean> result = null;
//		if(bean!=null && bean.getAccount()!=null && !bean.getAccount().equals(0)) {
//			MemberBean account = memberDAO.select(bean.getAccount());
//			if(account!=null) {
//				result = new ArrayList<MemberBean>();
//				result.add(account);
//			}
//		} else {
//			result = memberDAO.selectInfo(); 
//		}
//		return result;
//	}
	
	//確認帳號重複
	public boolean isRepeatAccount(MemberBean bean) {		
			MemberBean account = memberDAO.select(bean.getAccount());			
			if(account!= null) {
				return true;
			}else {
				return false;
			}		
	}
	//確認email重複
	public boolean isRepeatEmail(MemberBean bean) {			
			MemberBean email = memberDAO.selectEmail(bean.getEmail());			
			if(email!= null) {
				return true;
			}else {
				return false;
			}		
	}		
}
