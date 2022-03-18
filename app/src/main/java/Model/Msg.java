package Model;

public class Msg {
    private String reciver,msg,time;
    private int id;

    public Msg(){}



    public Msg(String reciver, String msg) {
        this.reciver = reciver;
        this.msg = msg;
    }

    public Msg(int id,String reciver, String msg) {
        this.reciver = reciver;
        this.msg = msg;
        this.id = id;
    }

    public Msg(int id,String reciver,String time, String msg) {
        this.reciver = reciver;
        this.msg = msg;
        this.id = id;
        this.time=time;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
