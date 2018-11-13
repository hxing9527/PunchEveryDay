package hxing.com.puncheveryday.bean;

public class Punch {
    int id;
    String title;
    String msg;
    String date_build;
    String date_punch;
    String date_warn;
    String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate_build() {
        return date_build;
    }

    public void setDate_build(String date_build) {
        this.date_build = date_build;
    }

    public String getDate_punch() {
        return date_punch;
    }

    public void setDate_punch(String date_punch) {
        this.date_punch = date_punch;
    }

    public String getDate_warn() {
        return date_warn;
    }

    public void setDate_warn(String date_warn) {
        this.date_warn = date_warn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Punch{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", msg='" + msg + '\'' +
                ", date_build='" + date_build + '\'' +
                ", date_punch='" + date_punch + '\'' +
                ", date_warn='" + date_warn + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
