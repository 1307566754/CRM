package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysUsers;

public interface SysUsersService {	
	//��
	public PageInfo<SysUsers> select(Integer pageNum,Integer pageSize);
	//��
	public void update(SysUsers s);
}
