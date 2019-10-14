package yusheng;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.*;

public class FontAdapter extends XmlAdapter<String, Font> {

 
    @Override
    public Font unmarshal(String fontSize) throws Exception {
        return new Font("宋体", Font.PLAIN, 16);
    }
 
    @Override
    public String marshal(Font font) throws Exception {
        return font.getSize()+"|"+font.getStyle()+"|"+font.getFontName();
    }
}
