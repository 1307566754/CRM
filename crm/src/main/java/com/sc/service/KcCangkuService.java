package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.KcCangku;
import com.sc.entity.SaleSinfo;
import com.sc.entity.SysUsers;

public interface KcCangkuService {
	//��ҳ�ֿ����ֲ�ѯ
		public PageInfo<KcCangku> select(Integer pageNum,Integer pageSize,  KcCangku kcck);//kcck--KcCangku

		//���
		public void add(KcCangku kcck);
		
		//�޸�
	    public void update(KcCangku kcck);
	    
	    //ɾ��
	    public void delete(long cangkuId);
	    
	    //ͨ�������ֿ��Ż�ȡ����
	    public KcCangku  getCkID(long  cangkuId);
	   
}
