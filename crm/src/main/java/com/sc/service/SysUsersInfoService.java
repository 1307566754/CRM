package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysUserinfo;

public interface SysUsersInfoService {
	//��
	public PageInfo<SysUserinfo> select(Integer pageNum,Integer pageSize);
	//��
	public void update(SysUserinfo info);
	//��ȡ����
	public SysUserinfo get(Long empId);
}
