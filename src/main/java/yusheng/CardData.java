package yusheng;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Root" )
@Data
public class CardData {
    @XmlAttribute
    private String panFt;//卡号分割格式
    private String magStrip;//磁条数据
    private int angel;//0 横打  90 竖打
    private CardSide   front;
    //@XmlElement(nillable = true, required = true)
    private CardSide   back;
}
