package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.OffMess;


public interface OffMessService {
	
	
		//���
		public void add(OffMess m);
		
		//�޸�
	    public void update(OffMess m);
	    
	    //ɾ��
	    public void delete(OffMess m);
	    
	    //��ȡ
	    public OffMess get(OffMess m);
	    
	 //��ѯ��
	 public List<OffMess> select();

	   
	
	//��ѯ�б�-��ҳ
	public PageInfo<OffMess> selectpage(Integer pageNum,Integer pageSize);

}
