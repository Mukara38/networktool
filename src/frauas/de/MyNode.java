package frauas.de;
public class MyNode{
    private String id;
    private int vid;

    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id = id;
    }

    public int getVID(){
        return vid;
    }

    public void setVID(int vid){
        this.vid = vid;
    }

    public MyNode(){

    }

    public MyNode(String id){
        this.id = id;
    }
}