package yusheng;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
//namespace = "http://www.aaa.bb.ccc"
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name="Root" )
@Data
public class CardSide
{

    //private String backGroudImagePath;
    //private byte[] backGroudImagedata;

    private ArrayList<EndentText> embossTxt;
    //@XmlElementWrapper(name = "printtxtList")
    private ArrayList<PrintTxt> printTxt;

    public CardSide() {
       // this.embossTxt = new ArrayList<EndentText>();
       // this.printTxt = new ArrayList<PrintTxt>();
    }
    @XmlElementWrapper(name = "embossTxtList")
    public ArrayList<EndentText> getEmbossTxt() {
        return embossTxt;
    }

    public void setEmbossTxt(ArrayList<EndentText> embossTxt) {
        this.embossTxt = embossTxt;
    }
    @XmlElementWrapper(name = "printtxtList")
    public ArrayList<PrintTxt> getPrintTxt() {
        return printTxt;
    }

    public void setPrintTxt(ArrayList<PrintTxt> printTxt) {
        this.printTxt = printTxt;
    }
}
