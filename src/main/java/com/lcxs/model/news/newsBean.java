package com.lcxs.model.news;

public class newsBean {
    private Long id;
    private String title;
    private String context;
    private String source;
    private Long praise;
    private Long collection;
    private String ntime;
    private String imgurl;
    private String remark;
    private int type;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Long getPraise() {
        return praise;
    }
    public void setPraise(Long praise) {
        this.praise = praise;
    }
    public Long getCollection() {
        return collection;
    }
    public void setCollection(Long collection) {
        this.collection = collection;
    }
    public String getNtime() {
        return ntime;
    }
    public void setNtime(String ntime) {
        this.ntime = ntime;
    }
    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public int getType() { return type; }
    public void setType(int type) { this.type = type; }
}
