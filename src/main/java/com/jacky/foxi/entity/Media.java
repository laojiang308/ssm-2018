package com.jacky.foxi.entity;

public class Media {
    private long media_id;// 主键
    private String media_src; // 媒体地址
    private int media_status;// 状态
    private long create_time;// 创建时间
    private long delete_time;// 删除时间

    public Media() {

    }

    public long getMedia_id() {
        return media_id;
    }

    public void setMedia_id(long media_id) {
        this.media_id = media_id;
    }

    public String getMedia_src() {
        return media_src;
    }

    public void setMedia_src(String media_src) {
        this.media_src = media_src;
    }

    public int getMedia_status() {
        return media_status;
    }

    public void setMedia_status(int media_status) {
        this.media_status = media_status;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(long delete_time) {
        this.delete_time = delete_time;
    }
}
