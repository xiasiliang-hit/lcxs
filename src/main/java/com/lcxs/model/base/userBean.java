package com.lcxs.model.base;

public class userBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.id
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private Long id;
    private int count;
    private String bank;
    private String bankname;
    private String bankid;
    private String add;
    private String city;
    private String address;
    
    public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.vid
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private Long vid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.phone
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.password
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.owninvitation
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String owninvitation;

    private Double  totalMoney;//总投资金额
    private Double totalJMoney;//总方案金额
    private Double totalRMoney;//总已提现金额
    private Double totalRedMoney;//总红包金额

	public Double getTotalRedMoney() {
		return totalRedMoney;
	}

	public void setTotalRedMoney(Double totalRedMoney) {
		this.totalRedMoney = totalRedMoney;
	}

	private int friendCount;
    private int bankCount;
    
    public int getBankCount() {
		return bankCount;
	}

	public void setBankCount(int bankCount) {
		this.bankCount = bankCount;
	}

	public int getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}

	public Double getTotalJMoney() {
		return totalJMoney;
	}

	public void setTotalJMoney(Double totalJMoney) {
		this.totalJMoney = totalJMoney;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.invitation
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String invitation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.alipay
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String alipay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.realname
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String realname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.status
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.kf
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String kf;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.ctime
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String ctime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.ip
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String ip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_user.level
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    private String level;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.id
     *
     * @return the value of c_user.id
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.id
     *
     * @param id the value for c_user.id
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.vid
     *
     * @return the value of c_user.vid
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public Long getVid() {
        return vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.vid
     *
     * @param vid the value for c_user.vid
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setVid(Long vid) {
        this.vid = vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.phone
     *
     * @return the value of c_user.phone
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.phone
     *
     * @param phone the value for c_user.phone
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.password
     *
     * @return the value of c_user.password
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.password
     *
     * @param password the value for c_user.password
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.owninvitation
     *
     * @return the value of c_user.owninvitation
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getOwninvitation() {
        return owninvitation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.owninvitation
     *
     * @param owninvitation the value for c_user.owninvitation
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setOwninvitation(String owninvitation) {
        this.owninvitation = owninvitation == null ? null : owninvitation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.invitation
     *
     * @return the value of c_user.invitation
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getInvitation() {
        return invitation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.invitation
     *
     * @param invitation the value for c_user.invitation
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setInvitation(String invitation) {
        this.invitation = invitation == null ? null : invitation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.alipay
     *
     * @return the value of c_user.alipay
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getAlipay() {
        return alipay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.alipay
     *
     * @param alipay the value for c_user.alipay
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.realname
     *
     * @return the value of c_user.realname
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.realname
     *
     * @param realname the value for c_user.realname
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.status
     *
     * @return the value of c_user.status
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.status
     *
     * @param status the value for c_user.status
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.kf
     *
     * @return the value of c_user.kf
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getKf() {
        return kf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.kf
     *
     * @param kf the value for c_user.kf
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setKf(String kf) {
        this.kf = kf == null ? null : kf.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.ctime
     *
     * @return the value of c_user.ctime
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.ctime
     *
     * @param ctime the value for c_user.ctime
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.ip
     *
     * @return the value of c_user.ip
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.ip
     *
     * @param ip the value for c_user.ip
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_user.level
     *
     * @return the value of c_user.level
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_user.level
     *
     * @param level the value for c_user.level
     *
     * @mbggenerated Mon Mar 05 17:59:52 CST 2018
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getTotalRMoney() {
		return totalRMoney;
	}

	public void setTotalRMoney(Double totalRMoney) {
		this.totalRMoney = totalRMoney;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}