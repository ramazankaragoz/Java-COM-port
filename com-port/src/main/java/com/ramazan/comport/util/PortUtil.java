package com.ramazan.comport.util;

import jssc.SerialPortList;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Ramazan Karagoz on 6.06.2017.
 */
public class PortUtil{

    public void readAllPort() {
        String[] portNames = SerialPortList.getPortNames();

        if (portNames.length == 0) {
            System.out.println("Serial port not-found.");
            System.out.println("Press Enter to exit...");
            try {
                System.in.read();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }

        for (int i = 0; i < portNames.length; i++) {
            System.out.println(portNames[i]);
        }
    }

    public String convertStringToJsonData(String data)
    {
        String redata=data.replace("\r","");
        JSONObject json=new JSONObject();
        json.put("data",redata);

        return json.toString();
    }



}
