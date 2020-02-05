package yusheng;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class JaXmlBeanUtilTest {

    @org.testng.annotations.Test
    public void testParseBeanToXml() throws IOException, JDOMException {
//        JaBeanToXml jaBeanToXml = new JaBeanToXml();
//        jaBeanToXml.setName("wangkecheng");
//        jaBeanToXml.setAddress("上海");
//        jaBeanToXml.setAge(28);
        ArrayList<PrintTxt> aList=new ArrayList<PrintTxt>();
        CardSide cardside=new CardSide();
        //cardside.setBackGroudImagePath("d:/picture/a.jpg");
        //cardside.setMagStrip("111111111111111");
        //cardside.setPanFt("0000#000000#00000");
        PrintTxt pt=new PrintTxt();
        pt.setTextString("cardno");
        pt.setX(2);
        pt.setY(3);
        Font  font=new Font("Arial", Font.BOLD, 16);
        pt.setFontColor(Color.BLACK);
        pt.setFont(font);
        aList.add(pt);
        pt=new PrintTxt();
        pt.setTextString("validdate");
        pt.setX(2);
        pt.setY(3);
        font=new Font("Arial", Font.PLAIN, 16);
        pt.setFont(font);
        aList.add(pt);
        cardside.setPrintTxt(aList);



        ArrayList<EndentText> bList=new ArrayList<EndentText>();
        EndentText et=new EndentText();
        et.setStrText("cardno");
        et.setToppingFoilType(0);
        et.setX(20);
        et.setY(40);
        et.setFontNum(4);
        bList.add(et);
        cardside.setEmbossTxt(bList);


        CardData  carddata=new CardData();
        carddata.setAngel(0);
        carddata.setMagStrip("-----------------");
        carddata.setFront(cardside);
        carddata.setBack(cardside);

        String xmlStr = JaXmlBeanUtil.parseBeanToXml(CardData.class,carddata);
        //System.out.println(xmlStr);
        Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");// 设置xml文件的字符为UTF-8，解决中文问题
        XMLOutputter xmlout = new XMLOutputter(format);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        java.io.Reader in = new StringReader(xmlStr);
        Document doc = (new SAXBuilder()).build(in);
        xmlout.output(doc, bo);
        System.out.println(bo.toString());


        Map<String,Object> tMap=new HashMap<String,Object>();
        tMap.put("out", "内容");
        tMap.put("result", "0");
        tMap.put("message", "OK");
        tMap.put("out", xmlStr);
        ObjectMapper objectMapper = new ObjectMapper();
        //ObjectMapper(org.codehaus.jackson.map.SerializationConfig.Feature.INDENT_OUTPUT);
        //objectMapper.
        String errorResultJson="{\"result\":\"%s\",\"message\":\"%s\",\"out\":[{}]}";
        //0:正常  1：json格式生成失败  2：IO异常 3:查询无结果

        String   out=objectMapper.writeValueAsString(tMap);
        System.out.println(out);

    }

    @org.testng.annotations.Test
    public void testParseXmlToBean() throws JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        sb.append("<root>");
        sb.append("<name>wangkecheng</name>");
        sb.append("<address>上海</address>");
        sb.append("<age>27</age>");
        sb.append("</root>");

        JaBeanToXml jaBeanToXml = (JaBeanToXml) JaXmlBeanUtil.parseXmlToBean(JaBeanToXml.class,sb.toString());


        //System.out.println(jaBeanToXml.toString());
    }
}