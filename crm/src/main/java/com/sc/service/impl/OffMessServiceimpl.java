package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.OffMess;
import com.sc.entity.OffMessdeta;
import com.sc.mapper.OffMessMapper;
import com.sc.service.OffMessService;

@Service
public class OffMessServiceimpl implements OffMessService {

	@Autowired
	OffMessMapper offMessMapper;
	
	@Override
	public void add(OffMess m) {
		
		 this.offMessMapper.insert(m);

	}

	@Override
	public void update(OffMess m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(OffMess m) {
		// TODO Auto-generated method stub

	}

	@Override
	public OffMess get(OffMess m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OffMess> select() {
		// TODO Auto-generated method stub
		return this.offMessMapper.selectByExample(null);
	}

	@Override
	public PageInfo<OffMess> selectpage(Integer pageNum, Integer pageSize) {
		//���÷�ҳ���ݣ���ʼ��ҳ
				PageHelper.startPage(pageNum, pageSize);
				//��ѯ��ǰҳ�ļ�������
				List<OffMess> list = this.offMessMapper.selectByExample(null);
				//��װ��pageinfo����
				PageInfo<OffMess> page=new PageInfo<OffMess>(list);
				
				return page;
	}

	@Override
	public PageInfo<OffMess> selectdeta(Integer pageNum, Integer pageSize, String ser) {
		//���÷�ҳ���ݣ���ʼ��ҳ
		System.out.println("����������ӿ�");
		PageHelper.startPage(pageNum, pageSize);
		//��ѯ��ǰҳ�ļ�������
		List<OffMess> list = this.offMessMapper.messdeta(ser);
		
		for (OffMess md : list) {
		    System.out.println(md);
		    for (OffMessdeta x : md.getOffMessdeta()) {
				System.out.println(x);
			}
		}
		
		//��װ��pageinfo����
		PageInfo<OffMess> page=new PageInfo<OffMess>(list);
		
		return page;
	}

}
