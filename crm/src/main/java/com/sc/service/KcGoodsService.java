package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.entity.KcCangku;
import com.sc.entity.KcGoods;
import com.sc.entity.SysUsers;

public interface KcGoodsService {
	       //��ҳ��Ʒ���ֲ�ѯ
			public PageInfo<KcGoods> select(Integer pageNum,Integer pageSize,  KcGoods kcgs);//kcgs--KcCangku

			//���
			public void add(KcGoods kcgs);
			
			//�޸�
		    public void update(KcGoods kcgs);
		    
		    //ɾ��
		    public void delete(long gId);//gId--goodsId
		    
		    //ͨ�������ֿ��Ż�ȡ����
		    public KcGoods  getGsID(long  gId);
}
