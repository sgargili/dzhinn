package imf.backend;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.03.11 (11:42)
 */

public class Entry {
    private String oldKey;
    private String newKey;
    private String parentNewKey;
    private String value;

    public Entry() {
    }

    public String getOldKey() {
        return oldKey;
    }

    public void setOldKey(String oldKey) {
        this.oldKey = oldKey;
    }

    public String getNewKey() {
        return newKey;
    }

    public void setNewKey(String newKey) {
        this.newKey = newKey;
    }

    public String getParentNewKey() {
        return parentNewKey;
    }

    public void setParentNewKey(String parentNewKey) {
        this.parentNewKey = parentNewKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (newKey != null ? !newKey.equals(entry.newKey) : entry.newKey != null) return false;
        if (oldKey != null ? !oldKey.equals(entry.oldKey) : entry.oldKey != null) return false;
        if (parentNewKey != null ? !parentNewKey.equals(entry.parentNewKey) : entry.parentNewKey != null) return false;
        if (value != null ? !value.equals(entry.value) : entry.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oldKey != null ? oldKey.hashCode() : 0;
        result = 31 * result + (newKey != null ? newKey.hashCode() : 0);
        result = 31 * result + (parentNewKey != null ? parentNewKey.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
