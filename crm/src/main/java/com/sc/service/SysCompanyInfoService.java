package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysCompanyinfo;
import com.sc.entity.SysUserinfo;

public interface SysCompanyInfoService {
	//��ҳ��ѯ
	public PageInfo<SysCompanyinfo> select(Integer pageNum,Integer pageSize);
	//��
	public void add(SysCompanyinfo s);
	//ɾ
	public void del(SysCompanyinfo s);
	//��
	public void update(SysCompanyinfo s);
	//ͨ��������ȡ��Ϣ
	public SysCompanyinfo get(Long pk);
	//�飬����ҳ
	public List<SysCompanyinfo> selectlist();
}
