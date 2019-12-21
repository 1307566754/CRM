package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.OffMess;
import com.sc.entity.OffMessdeta;


public interface OffMessService {
	
	public List<OffMess> mdetail(Long mid);
	
		//������Ϣ
		public void write (OffMess m);
	
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
	public List<OffMessdeta> selectdeta1(Long did);

}
