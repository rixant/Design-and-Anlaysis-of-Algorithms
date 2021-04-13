package rrokaha;

import java.util.Objects;

public class MutableKey {

    private String name;

    public MutableKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj==null||getClass() != obj.getClass())
            return false;
        MutableKey that = (MutableKey) obj;
        return Objects.equals(this.name, that.name );

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name + "("
                + this.hashCode() + ")";
    }
}
