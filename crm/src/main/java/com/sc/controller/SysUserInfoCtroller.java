package com.sc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.SysUserinfo;
import com.sc.service.SysUsersInfoService;

@Controller
@RequestMapping("/SysUsersInfoCtrl")
public class SysUserInfoCtroller {
	@Autowired
	SysUsersInfoService sysUsersInfoService;

	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {

		mav.addObject("p", sysUsersInfoService.select(pageNum, pageSize));
		mav.setViewName("ssf/UserINFOlist");
		System.out.println(sysUsersInfoService.select(pageNum, pageSize));

		System.out.println("��ҳ");

		return mav;
	}

	@RequestMapping("/goupdate.do")
	public ModelAndView goupdate(ModelAndView mav, SysUserinfo u) {
		System.out.println("����goupdate����" + u.getEmpId());
		SysUserinfo users = sysUsersInfoService.get(u.getEmpId());
		System.out.println("���ð�empid��ѯ��Ϣ��" + users);
		mav.addObject("u", users);
		mav.setViewName("ssf/updateINFO");

		return mav;
	}

	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav, MultipartFile upload, HttpServletRequest req, SysUserinfo u)
			throws IllegalStateException, IOException {
		System.out.println("��ʼ�ϴ��ļ�" + u);

		// ����û�ѡ���ļ�����ôִ���ϴ�����
		if (upload != null) {
			String filename = upload.getOriginalFilename();// �ļ���
			if (filename != null && !filename.equals("")) {
				// ��ȡupload�ļ�������·��
				String path = req.getSession().getServletContext().getRealPath("upload");
				// ���磺26456456435.jpg
				filename = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
				// Ŀ�ĵ��ļ�����
				File file = new File(path + "/" + filename);
				upload.transferTo(file);// ת���洢�ļ�

				// ����ͼƬ����
				u.setEmpPhoto(filename);
			}
		}

		this.sysUsersInfoService.update(u);
		System.out.println(u);
		mav.setViewName("redirect:listPage.do");// �ض���list����
		return mav;
	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(ModelAndView mav, SysUserinfo s) {
		System.out.println("ɾ���û���" + s);
		this.sysUsersInfoService.delete(s);
		mav.setViewName("redirect:listPage.do");// �ض���list����
		return mav;
	}

	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav, SysUserinfo user) {

		mav.setViewName("ssf/usersINFOadd");
		System.out.println("׼������û�");
		return mav;
	}

	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav, MultipartFile upload, HttpServletRequest req, SysUserinfo u)
			throws IllegalStateException, IOException {
		System.out.println("��ʼ����û�" + u);
		if (upload != null) {
			String filename = upload.getOriginalFilename();// �ļ���
			if (filename != null && !filename.equals("")) {
				String path = req.getServletContext().getRealPath("upload");
				// ԭʼ�ļ���
				String n = upload.getOriginalFilename();
				// ��ȡԭʼ�ļ���׺��
				String suffix = n.substring(n.lastIndexOf("."));
				// �����µ��ļ����ƣ����磺ϵͳ������.��չ��
				String name = System.currentTimeMillis() + suffix;
				File file = new File(path + "/" + name);
				System.out.println(path + "/" + name);
				upload.transferTo(file);
				u.setEmpPhoto(filename);
			}
			sysUsersInfoService.add(u);
			mav.setViewName("redirect:listPage.do");

		}
		return mav;
	}
}
