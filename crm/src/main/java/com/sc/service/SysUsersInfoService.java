package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysUserinfo;

public interface SysUsersInfoService {
	//�� ��ҳ
	public PageInfo<SysUserinfo> select(Integer pageNum,Integer pageSize);
	//��
	public void update(SysUserinfo info);
	//��ȡ����
	public SysUserinfo get(Long empId);
	//ɾ
    public void delete(SysUserinfo s);
    //����
    public void add(SysUserinfo s);
    //�� 
    public List<SysUserinfo> selectlist();
}
