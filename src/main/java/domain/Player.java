package domain;

public class Player {
    private final String name;
    private int position;

    public Player(String name,int position) {
        this.name = name;
        this.position = position;
    }

    public void moveLeft(){
        position--;
        System.out.println(getName()+getPosition());
    }

    public void moveRight(){
        position++;
        System.out.println(getName()+getPosition());
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
