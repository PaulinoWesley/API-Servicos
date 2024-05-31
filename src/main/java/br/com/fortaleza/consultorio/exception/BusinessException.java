package br.com.fortaleza.consultorio.exception;

import java.io.Serial;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class BusinessException extends Exception {
    @Serial
    private static final long serialVersionUID = 1793870120454212885L;
    private final Properties properties = new Properties();
    public BusinessException() {}
    public BusinessException(String message) { super(message); }
    public BusinessException(Throwable cause) { super(cause); }
    public BusinessException(String message, Throwable cause) { super(message, cause); }
    public void addProperty(Object key, Object value) { this.properties.put(key, value); }
    public void removeProperty(Object key) { this.properties.remove(key); }
    public Set<Entry<Object, Object>> listProperties() { return this.properties.entrySet(); }
    public void setType(String type) { this.addProperty("type", type); }
    public Object getProtperety(Object key) {
        if(this.properties.containsKey(key)) {
            return this.properties.get(key);
        }
        return null;
    }
}
