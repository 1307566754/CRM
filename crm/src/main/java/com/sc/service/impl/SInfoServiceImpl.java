package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.KcGoods;
import com.sc.entity.SaleSinfo;
import com.sc.entity.SaleSinfoExample;
import com.sc.entity.SaleSoutOrder;
import com.sc.entity.SaleSinfoExample.Criteria;
import com.sc.mapper.SaleSinfoMapper;
import com.sc.service.SInfoService;

@Service
public class SInfoServiceImpl implements SInfoService {

	// ����ע��
	@Autowired
	SaleSinfoMapper saleSinfoMapper;
	//��ҳ��ѯ
	@Override
	public PageInfo<SaleSinfo> select(Integer pageNum, Integer pageSize, Long soid) {
		PageHelper.startPage(pageNum, pageSize);
		SaleSinfoExample example = new SaleSinfoExample();
		Criteria c = example.createCriteria();
		System.out.println("�õ�������id"+soid);
		if(soid!=null){
			c.andSorderIdEqualTo(soid);
			List<SaleSinfo> list = this.saleSinfoMapper.selectByExample(example);
			PageInfo<SaleSinfo> pageInfo = new PageInfo<SaleSinfo>(list);
			if(list!=null&&list.size()>0){
				return pageInfo;
			}
		}
		return null;
		
	}
	

	@Override
	public void add(SaleSinfo sinfo) {
		saleSinfoMapper.insert(sinfo);
		
	}

	@Override
	public void update(SaleSinfo sinfo) {
		saleSinfoMapper.updateByPrimaryKey(sinfo);
		
	}

	
	//ͨ��sorderId��ȡ����
	@Override
	public SaleSinfo get(long sid) {
	
		return	this.saleSinfoMapper.selectByPrimaryKey(sid);
			
			
			
	}

	//��ȡ����
	@Override
	public List<SaleSinfo> getAll() {
		List<SaleSinfo> list = saleSinfoMapper.selectByExample(null);
		return list;
		
		
	}

	//ͨ������ɾ��
	@Override
	public void delete(Long sid) {
		saleSinfoMapper.deleteByPrimaryKey(sid);
		
	}


	@Override //ͨ��soid��ȡ��soid�����е��������鼯��
	public List<SaleSinfo> getsoidlist(Long soid) {
		SaleSinfoExample example = new SaleSinfoExample();
		Criteria c = example.createCriteria();
		c.andSorderIdEqualTo(soid);
		List<SaleSinfo> list = saleSinfoMapper.selectByExample(example);
		return list;
	}
	

}
