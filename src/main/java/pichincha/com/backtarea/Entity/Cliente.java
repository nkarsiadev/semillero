package pichincha.com.backtarea.Entity;

import java.util.ArrayList;

public class Cliente<T> {
    private ArrayList<T> entities1;
    private Usuario entities2;

    public ArrayList<T> getEntities1() {
        return entities1;
    }

    public void setEntities1(ArrayList<T> entities1) {
        this.entities1 = entities1;
    }

    public Usuario getEntities2() {
        return entities2;
    }

    public void setEntities2(Usuario entities2) {
        this.entities2 = entities2;
    }

}
