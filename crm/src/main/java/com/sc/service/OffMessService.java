package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.OffMess;
import com.sc.entity.SysUsers;


public interface OffMessService {
	
		//��ȡ���Լ�����������û�
		public List<SysUsers> selectuser();
	
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
	
	public PageInfo<OffMess> selectdeta(Integer pageNum,Integer pageSize,String ser);

}
