package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysCompanyinfo;

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
}
