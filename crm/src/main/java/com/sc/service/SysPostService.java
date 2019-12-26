package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysCompanyinfo;
import com.sc.entity.SysPost;

public interface SysPostService {
	//��ҳ��ѯ
	public PageInfo<SysPost> select(Integer pageNum,Integer pageSize);
	//��
	public void add(SysPost s);
	//ɾ
	public void del(SysPost s);
	//��
	public void update(SysPost s);
	//ͨ��������ȡ��Ϣ
	public SysPost get(Long postId);
	//�� ����ҳ
	public List<SysPost> selectlist();
}
