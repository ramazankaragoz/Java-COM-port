package com.ramazan.comport.starter;

import com.ramazan.comport.reader.PortReader;
import com.ramazan.comport.util.PortUtil;
import com.ramazan.comport.writer.PortWriter;

/**
 * Created by Ramazan Karagoz on 5.06.2017.
 */
public class App{

    static PortReader portReader;

    public static void main (String[] args)
    {
        PortUtil portUtil=new PortUtil();
        portUtil.readAllPort();

        portReader=new PortReader();
        PortWriter portWriter=new PortWriter("COM1");
        portWriter.SendData("Hello World");

        portWriter.writer();

    }

}
