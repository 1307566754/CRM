package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysDept;

public interface SysDeptService {
	// ��ҳ��ѯ
	public PageInfo<SysDept> select(Integer pageNum, Integer pageSize);

	// ��
	public void add(SysDept s);

	// ɾ
	public void del(SysDept s);

	// ��
	public void update(SysDept s);

	// ͨ��������ȡ��Ϣ
	public SysDept get(Long deptId);
}
