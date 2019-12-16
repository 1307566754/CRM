package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.SysUsers;
import com.sc.mapper.SysUsersMapper;
import com.sc.service.SysUsersService;

@Service
public class SysUsersServiceImpl implements SysUsersService {
	
	@Autowired
	SysUsersMapper sysUsersMapper;
	
	@Override
	public PageInfo<SysUsers> select(Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<SysUsers> list = sysUsersMapper.selectByExample(null);
		
		PageInfo<SysUsers> pageInfo = new PageInfo<SysUsers>(list);
		
		return pageInfo;
	}

	@Override
	public void update(SysUsers s) {
		if (s != null && s.getUsersId()!= null) {
			
			this.sysUsersMapper.updateByPrimaryKey(s);
		
	}

}

	@Override
	public SysUsers selectPower() {
		
		
			SysUsers sysUsers = new SysUsers();
			sysUsers.setUsersId(61L);
			SysUsers users = this.sysUsersMapper.selectPower(sysUsers);
			return users;
		
	}

	@Override
	public SysUsers selectRole(Long uId) {
		SysUsers users = this.sysUsersMapper.selectRole(uId);
		return users;
	}

	@Override
	public SysUsers selectUserinfo(Long uId) {
		SysUsers users = this.sysUsersMapper.selectUserinfo(uId);
		return users;
	}
}
