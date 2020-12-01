package lambda;

import collection.Account;

import java.util.Objects;

public class Attachment {
    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Attachment attachment = (Attachment) o;
        return (this.name.equals(attachment.name)) && (this.size == attachment.size);
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}