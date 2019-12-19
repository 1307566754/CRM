package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysUsers;

public interface SysUsersService {	
	//��
	public PageInfo<SysUsers> select(Integer pageNum,Integer pageSize);
	//��
	public void update(SysUsers s);
	
	public SysUsers selectPower();
	
	public SysUsers selectRole(Long uId);
	
	public SysUsers selectUserinfo(Long uId);
	
	public List<SysUsers> selectAllNOSelf(Long uId);
	
	public List<SysUsers> selectNoRoleUser();
}
