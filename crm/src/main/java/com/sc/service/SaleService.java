package com.sc.service;


import com.github.pagehelper.PageInfo;
import com.sc.entity.SaleKhcontacts;
import com.sc.entity.SaleKhinfo;

public interface SaleService{
	
    //��ϵ��
	public PageInfo<SaleKhcontacts> lxselect(Integer pageNum,Integer pageSize);
    //�ͻ���Ϣ
	public PageInfo<SaleKhinfo> select(Integer pageNum,Integer pageSize,SaleKhinfo s);
	
}