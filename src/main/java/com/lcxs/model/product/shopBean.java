package com.lcxs.model.product;

public class shopBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.id
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.shopid
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private Long shopid;

    @Override
	public String toString() {
		return "shopBean [id=" + id + ", shopid=" + shopid + ", shopname="
				+ shopname + ", shopphone=" + shopphone + ", regcap=" + regcap
				+ ", background=" + background + ", channel=" + channel
				+ ", address=" + address + ", financing=" + financing
				+ ", risk=" + risk + ", area=" + area + ", recommend="
				+ recommend + ", status=" + status + ", tag=" + tag + ", sort="
				+ sort + ", logo=" + logo + ", more=" + more + ", shopurl="
				+ shopurl + ", smurl=" + smurl + ", pcurl=" + pcurl
				+ ", appurl=" + appurl + ", ctime=" + ctime + ", mtime="
				+ mtime + ", context=" + context + "]";
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.shopname
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String shopname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.shopphone
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String shopphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.regcap
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private Double regcap;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.background
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String background;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.channel
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String channel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.address
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.financing
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String financing;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.risk
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private Integer risk;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.area
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String area;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.recommend
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String recommend;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.status
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.tag
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String tag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.sort
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.logo
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String logo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.more
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String more;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.shopurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String shopurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.smurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String smurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.pcurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String pcurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.appurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String appurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.ctime
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String ctime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.mtime
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String mtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_shop.context
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    private String context;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.id
     *
     * @return the value of c_shop.id
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.id
     *
     * @param id the value for c_shop.id
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.shopid
     *
     * @return the value of c_shop.shopid
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public Long getShopid() {
        return shopid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.shopid
     *
     * @param shopid the value for c_shop.shopid
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setShopid(Long shopid) {
        this.shopid = shopid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.shopname
     *
     * @return the value of c_shop.shopname
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getShopname() {
        return shopname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.shopname
     *
     * @param shopname the value for c_shop.shopname
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.shopphone
     *
     * @return the value of c_shop.shopphone
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getShopphone() {
        return shopphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.shopphone
     *
     * @param shopphone the value for c_shop.shopphone
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setShopphone(String shopphone) {
        this.shopphone = shopphone == null ? null : shopphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.regcap
     *
     * @return the value of c_shop.regcap
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public Double getRegcap() {
        return regcap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.regcap
     *
     * @param regcap the value for c_shop.regcap
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setRegcap(Double regcap) {
        this.regcap = regcap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.background
     *
     * @return the value of c_shop.background
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getBackground() {
        return background;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.background
     *
     * @param background the value for c_shop.background
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setBackground(String background) {
        this.background = background == null ? null : background.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.channel
     *
     * @return the value of c_shop.channel
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getChannel() {
        return channel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.channel
     *
     * @param channel the value for c_shop.channel
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.address
     *
     * @return the value of c_shop.address
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.address
     *
     * @param address the value for c_shop.address
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.financing
     *
     * @return the value of c_shop.financing
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getFinancing() {
        return financing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.financing
     *
     * @param financing the value for c_shop.financing
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setFinancing(String financing) {
        this.financing = financing == null ? null : financing.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.risk
     *
     * @return the value of c_shop.risk
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public Integer getRisk() {
        return risk;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.risk
     *
     * @param risk the value for c_shop.risk
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.area
     *
     * @return the value of c_shop.area
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.area
     *
     * @param area the value for c_shop.area
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.recommend
     *
     * @return the value of c_shop.recommend
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getRecommend() {
        return recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.recommend
     *
     * @param recommend the value for c_shop.recommend
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.status
     *
     * @return the value of c_shop.status
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.status
     *
     * @param status the value for c_shop.status
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.tag
     *
     * @return the value of c_shop.tag
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.tag
     *
     * @param tag the value for c_shop.tag
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.sort
     *
     * @return the value of c_shop.sort
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.sort
     *
     * @param sort the value for c_shop.sort
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.logo
     *
     * @return the value of c_shop.logo
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getLogo() {
        return logo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.logo
     *
     * @param logo the value for c_shop.logo
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.more
     *
     * @return the value of c_shop.more
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getMore() {
        return more;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.more
     *
     * @param more the value for c_shop.more
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setMore(String more) {
        this.more = more == null ? null : more.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.shopurl
     *
     * @return the value of c_shop.shopurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getShopurl() {
        return shopurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.shopurl
     *
     * @param shopurl the value for c_shop.shopurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setShopurl(String shopurl) {
        this.shopurl = shopurl == null ? null : shopurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.smurl
     *
     * @return the value of c_shop.smurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getSmurl() {
        return smurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.smurl
     *
     * @param smurl the value for c_shop.smurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setSmurl(String smurl) {
        this.smurl = smurl == null ? null : smurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.pcurl
     *
     * @return the value of c_shop.pcurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getPcurl() {
        return pcurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.pcurl
     *
     * @param pcurl the value for c_shop.pcurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setPcurl(String pcurl) {
        this.pcurl = pcurl == null ? null : pcurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.appurl
     *
     * @return the value of c_shop.appurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getAppurl() {
        return appurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.appurl
     *
     * @param appurl the value for c_shop.appurl
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setAppurl(String appurl) {
        this.appurl = appurl == null ? null : appurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.ctime
     *
     * @return the value of c_shop.ctime
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.ctime
     *
     * @param ctime the value for c_shop.ctime
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.mtime
     *
     * @return the value of c_shop.mtime
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getMtime() {
        return mtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.mtime
     *
     * @param mtime the value for c_shop.mtime
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setMtime(String mtime) {
        this.mtime = mtime == null ? null : mtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_shop.context
     *
     * @return the value of c_shop.context
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_shop.context
     *
     * @param context the value for c_shop.context
     *
     * @mbggenerated Wed Mar 14 17:20:13 CST 2018
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}