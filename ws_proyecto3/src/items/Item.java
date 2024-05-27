package src.items;

public class Item {

    private String name;
    private String info;

    public Item(String name, String info){
        this.name = name;
        this.info = info;
    }

    public String getName(){
        return name;
    }

    public String getInfo(){
        return info;
    }
}
