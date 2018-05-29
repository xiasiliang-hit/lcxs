package com.lcxs.realm;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.lcxs.model.base.staffBean;
import com.lcxs.service.base.IStaffService;



public class SecurityRealm extends AuthorizingRealm {

	@Autowired
	private IStaffService staffService;
	@Resource
	private SessionDAO sessionDao;
	
	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户名
		String phone = (String) token.getPrincipal();
		// 根据用户号码phone到数据库查询，判断是否有这个用户
		//UserBean user=userService.selectByphone(phone);
		staffBean staff = staffService.queryByPhone(phone);
        if(staff==null){
        	return null;       	    
        }
        Collection<Session> sessions = sessionDao.getActiveSessions();
		// 取出每个在线用户
		for (Session session : sessions) {
			SimplePrincipalCollection principal = (SimplePrincipalCollection) session
				.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
			if (principal != null) {
				staffBean u = (staffBean) principal.getPrimaryPrincipal();
				if(phone.equals(u.getPhone())){
					session.setTimeout(0);
					break;
				}				
			}
		}
		String pwd = staff.getPassword().toString();
		AuthenticationInfo info = new SimpleAuthenticationInfo(staff, pwd,ByteSource.Util.bytes("jkfl"),"myrealm");
		Subject currentUser = SecurityUtils.getSubject(); 
		Session session = currentUser.getSession();
		session.setAttribute("staff", staff);
		session.setTimeout(-1000l);
		return info;
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		staffBean user =(staffBean) principal.getPrimaryPrincipal();
		// 根据 用户名到数据库中查询这个用户所拥有的所有的菜单权限
		 int type= user.getStype();
		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		 // 查询出用户的kind  1.管理员--2.客服--3.运营--4.IT---5.产品--6.财务--7.营销
		 if(type==1){
			 info.addStringPermission("HOME_LOOK");
			 info.addStringPermission("USER_LOOK");
			 info.addStringPermission("USER_ALL");
			 info.addStringPermission("STAFF_LOOK");
			 info.addStringPermission("STAFF_ALL");
			 info.addStringPermission("FRIENDS_LOOK");
			 info.addStringPermission("FRIENDS_ALL");
			 info.addStringPermission("OWN_ALL");
			 info.addStringPermission("USER_BANK");
			 info.addStringPermission("SHOP_ALL");
			 info.addStringPermission("PRODUCT_ALL");
			 info.addStringPermission("CASE_ALL");
			 info.addStringPermission("RED_LOOK");
			 info.addStringPermission("RED_ADD");
			 info.addStringPermission("RED_ALL");
			 info.addStringPermission("CHANNEL_ALL");
			 info.addStringPermission("RECEIPT_LOOK");
			 info.addStringPermission("RECEIPT_ALL");
		 }
		 
		 if(type==2){
			 info.addStringPermission("STAFF_LOOK");
			 info.addStringPermission("FRIENDS_LOOK");
			 info.addStringPermission("OWN_ALL");
			 info.addStringPermission("RED_LOOK");
			 info.addStringPermission("RED_ADD");
			 info.addStringPermission("RECEIPT_LOOK");
		 }
		 
		 if(type==3){
			 info.addStringPermission("HOME_LOOK");
			 info.addStringPermission("USER_LOOK");
			 info.addStringPermission("USER_ALL");
			 info.addStringPermission("STAFF_LOOK");
			 info.addStringPermission("FRIENDS_LOOK");
			 info.addStringPermission("FRIENDS_ALL");
			 info.addStringPermission("OWN_ALL");
			 info.addStringPermission("USER_BANK");
			 info.addStringPermission("SHOP_ALL");
			 info.addStringPermission("PRODUCT_ALL");
			 info.addStringPermission("CASE_ALL");
			 info.addStringPermission("RED_LOOK");
			 info.addStringPermission("RED_ADD");
			 info.addStringPermission("RED_ALL");
			 info.addStringPermission("CHANNEL_ALL");
			 info.addStringPermission("RECEIPT_LOOK");
			 info.addStringPermission("RECEIPT_ALL");
		 }
		 
		 if(type==4){
			 info.addStringPermission("HOME_LOOK");
			 info.addStringPermission("USER_LOOK");
			 info.addStringPermission("USER_ALL");
			 info.addStringPermission("STAFF_LOOK");
			 info.addStringPermission("STAFF_ALL");
			 info.addStringPermission("FRIENDS_LOOK");
			 info.addStringPermission("FRIENDS_ALL");
			 info.addStringPermission("OWN_ALL");
			 info.addStringPermission("USER_BANK");
			 info.addStringPermission("SHOP_ALL");
			 info.addStringPermission("PRODUCT_ALL");
			 info.addStringPermission("CASE_ALL");
			 info.addStringPermission("RED_LOOK");
			 info.addStringPermission("RED_ADD");
			 info.addStringPermission("RED_ALL");
			 info.addStringPermission("CHANNEL_ALL");
			 info.addStringPermission("RECEIPT_LOOK");
			 info.addStringPermission("RECEIPT_ALL");
		 }
		 
		 if(type==5){
			 info.addStringPermission("USER_LOOK");
			 info.addStringPermission("RECEIPT_LOOK");
		 }
		return info;
	}

}
