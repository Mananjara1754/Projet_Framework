package modelview;
import java.util.HashMap;
public class ModelView {
    String view;
    HashMap<String,Object> data; 
    public String getView() {
        return view;
    }
    public void setView(String view) {
        this.view = view;
    }
    public ModelView(String view) {
        this.setView(view);
    }
    public HashMap<String, Object> getData() {
        return data;
    }
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    public void addItem(String key,Object valeur) {
        this.data.put(key,valeur);
    }
    public ModelView(String view, HashMap<String, Object> data) {
        this.view = view;
        this.data = data;
    }
}