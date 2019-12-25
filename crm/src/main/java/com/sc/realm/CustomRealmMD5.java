package com.sc.realm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.entity.SysCompanyinfo;
import com.sc.entity.SysPowerinfo;
import com.sc.entity.SysUsers;
import com.sc.service.SysUsersService;




public class CustomRealmMD5 extends AuthorizingRealm {
	
	//����ע��
	@Autowired
	SysUsersService sysUsersService;
	@Autowired
	HttpSession session;
	
	//�û���Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SysUsers user=(SysUsers)arg0.getPrimaryPrincipal();
		System.out.println("��Ȩ���û�ID�ǣ�"+user.getUsersId());
		
		List<String> allperms=new ArrayList<String>();
		SysUsers selectPower = this.sysUsersService.selectPower(user);
		if(selectPower!=null){
			for (SysPowerinfo sp : selectPower.getSysPowerinfoes()) {
				String code = sp.getPowerCode();
				if(code!=null&&!code.equals("")){
					allperms.add(code);
				}
			}
		}
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(allperms);
		return info;
		
	}
	
	//�û���֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {

		String 	usersName = (String)arg0.getPrincipal();
		System.out.println("��֤���û����ǣ�"+usersName);
		SysUsers user = new SysUsers();
		user.setUsersName(usersName);
		SysUsers users = this.sysUsersService.login(user);
		SysCompanyinfo cinfo = (SysCompanyinfo)session.getAttribute("cinfo");
		System.out.println("��˾����Ϊ��"+cinfo.toString());
		
		
		
		if(users==null){
			System.out.println("�û������ڣ�");
		 	return null;
			  
		}
		
		if(users.getCompanyId()!=cinfo.getPk()){
	 		System.out.println("�û��Ǵ˹�˾Ա��");
	 		throw new NotCompanyAuthenticationException("notcompany");
	 	}
		
		System.out.println("�û����ڣ�");
		String password=users.getUsersPassword();
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(users, password,
				this.getName());
		System.out.println("����");
		return info;
	}

}
