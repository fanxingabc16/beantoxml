package yusheng;

import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Data
public class EndentText implements Serializable
{
    private String strText;
    private int fontNum;
    private float x;
    private float y;
    private int toppingFoilType;
    public EndentText() {
        this.strText = "";
        this.fontNum = 0;
        this.x = 0.0f;
        this.y = 0.0f;
        this.strText = "";
        this.fontNum = 0;
        this.x = 0.0f;
        this.y = 0.0f;
    }
    
    public EndentText(final String strText, final int fontNum, final float x, final float y) {
        this.strText = "";
        this.fontNum = 0;
        this.x = 0.0f;
        this.y = 0.0f;
        this.strText = strText;
        this.fontNum = fontNum;
        this.x = x;
        this.y = y;
    }

    
    public static byte[] ConvertEndentTextToByteArray(final ArrayList<EndentText> arrayText) throws UnsupportedEncodingException {
        final int lineCount = 1;
        String xmltext = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><emboss>";
        if (arrayText != null) {
            for (int i = 0; i < arrayText.size(); ++i) {
                xmltext = String.valueOf(xmltext) + "<line number=\"" + lineCount + "\"><font>" + arrayText.get(i).fontNum + "</font><horz>" + arrayText.get(i).x * 1000.0f + "</horz><vert>" + arrayText.get(i).y * 1000.0f + "</vert><stringData>" + arrayText.get(i).strText + "</stringData></line>";
            }
        }
        xmltext = String.valueOf(xmltext) + "</emboss>";
        final byte[] embCardDataBytes = xmltext.getBytes("utf-8");
        return embCardDataBytes;
    }
}
