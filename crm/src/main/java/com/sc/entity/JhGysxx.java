package com.sc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class JhGysxx implements Serializable {
    private String gysId;

    private String gysName;

    private String gysJc;

    private String lxr;

    private BigDecimal gdPhone;

    private Long ydPhone;

    private String lxcz;

    private String lxdz;

    private Long lxyb;

    private String mail;

    private String khbank;

    private String yhzh;

    private String gszy;

    private String isYx;

    private String operator;

    private String remark;

    private String gsId;

    private Date ltime;

    private static final long serialVersionUID = 1L;

    public JhGysxx(String gysId, String gysName, String gysJc, String lxr, BigDecimal gdPhone, Long ydPhone, String lxcz, String lxdz, Long lxyb, String mail, String khbank, String yhzh, String gszy, String isYx, String operator, String remark, String gsId, Date ltime) {
        this.gysId = gysId;
        this.gysName = gysName;
        this.gysJc = gysJc;
        this.lxr = lxr;
        this.gdPhone = gdPhone;
        this.ydPhone = ydPhone;
        this.lxcz = lxcz;
        this.lxdz = lxdz;
        this.lxyb = lxyb;
        this.mail = mail;
        this.khbank = khbank;
        this.yhzh = yhzh;
        this.gszy = gszy;
        this.isYx = isYx;
        this.operator = operator;
        this.remark = remark;
        this.gsId = gsId;
        this.ltime = ltime;
    }

    public JhGysxx() {
        super();
    }

    public String getGysId() {
        return gysId;
    }

    public void setGysId(String gysId) {
        this.gysId = gysId == null ? null : gysId.trim();
    }

    public String getGysName() {
        return gysName;
    }

    public void setGysName(String gysName) {
        this.gysName = gysName == null ? null : gysName.trim();
    }

    public String getGysJc() {
        return gysJc;
    }

    public void setGysJc(String gysJc) {
        this.gysJc = gysJc == null ? null : gysJc.trim();
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr == null ? null : lxr.trim();
    }

    public BigDecimal getGdPhone() {
        return gdPhone;
    }

    public void setGdPhone(BigDecimal gdPhone) {
        this.gdPhone = gdPhone;
    }

    public Long getYdPhone() {
        return ydPhone;
    }

    public void setYdPhone(Long ydPhone) {
        this.ydPhone = ydPhone;
    }

    public String getLxcz() {
        return lxcz;
    }

    public void setLxcz(String lxcz) {
        this.lxcz = lxcz == null ? null : lxcz.trim();
    }

    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz == null ? null : lxdz.trim();
    }

    public Long getLxyb() {
        return lxyb;
    }

    public void setLxyb(Long lxyb) {
        this.lxyb = lxyb;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getKhbank() {
        return khbank;
    }

    public void setKhbank(String khbank) {
        this.khbank = khbank == null ? null : khbank.trim();
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh == null ? null : yhzh.trim();
    }

    public String getGszy() {
        return gszy;
    }

    public void setGszy(String gszy) {
        this.gszy = gszy == null ? null : gszy.trim();
    }

    public String getIsYx() {
        return isYx;
    }

    public void setIsYx(String isYx) {
        this.isYx = isYx == null ? null : isYx.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getGsId() {
        return gsId;
    }

    public void setGsId(String gsId) {
        this.gsId = gsId == null ? null : gsId.trim();
    }

    public Date getLtime() {
        return ltime;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }
}