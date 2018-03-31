package by.bsuir.nesenchuk.dto;

import java.io.Serializable;

public class DTO<K extends Serializable> implements Serializable {
    private static final long serialVersionUID = 2134722856194625476L;

    protected K id;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }
}
