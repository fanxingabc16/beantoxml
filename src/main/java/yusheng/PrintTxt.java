package yusheng;



import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
import java.io.Serializable;

@XmlRootElement(name="printTxtList")
//@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class PrintTxt implements Serializable
{

    private String textString;

    private float x;

    private float y;

    private Font font;

    private Color fontColor;
    
    public PrintTxt(final String textString, final float x, final float y, final Font font, final Color fontColor) {
        this.textString = textString;
        this.x = x;
        this.y = y;
        this.font = font;
        this.fontColor = fontColor;
    }
    public PrintTxt(){

    }

    public Font getFont() {
        return font;
    }
    @XmlJavaTypeAdapter(FontAdapter.class)
    @XmlElement
    public void setFont(Font font) {
        this.font = font;
    }

    public Color getFontColor() {
        return fontColor;
    }
    @XmlJavaTypeAdapter(ColorAdapter.class)
    @XmlElement
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }
}
