package com.sc.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SaleKhcontacts;
import com.sc.entity.SaleKhinfo;


public interface SaleService{
	
    //��ϵ��
	public List<SaleKhcontacts>  lxcx(Long id);
	
	public PageInfo<SaleKhcontacts> lxselect(Integer pageNum,Integer pageSize);
    //�ͻ���Ϣ
	public PageInfo<SaleKhinfo> select(Integer pageNum,Integer pageSize,SaleKhinfo s);
	//�ͻ���Ϣ�޸�
	public void update(SaleKhinfo s);
	//�ͻ���Ϣ���
	public void add(SaleKhinfo s);
	
}