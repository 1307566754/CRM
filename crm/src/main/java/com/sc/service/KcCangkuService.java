package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.entity.KcCangku;
import com.sc.entity.SysUsers;

public interface KcCangkuService {
	//ͨ���ֿ�����ѯ�ֿ���Ϣ�����
	public PageInfo<KcCangku> select(Integer pageNum,Integer pageSize);
		
}
