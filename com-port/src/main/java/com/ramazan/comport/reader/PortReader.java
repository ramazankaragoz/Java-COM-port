package com.ramazan.comport.reader;

import com.ramazan.comport.util.PortUtil;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;



/**
 * Created by Ramazan Karagoz on 6.06.2017.
 */
public class PortReader implements SerialPortEventListener {

    private SerialPort serialPort;

    private String receivedData;


    public PortReader() {
    }

    public PortReader(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    public void serialEvent(SerialPortEvent event) {

        if(event.isRXCHAR() && event.getEventValue() > 0) {
            try {
                receivedData = this.serialPort.readString(event.getEventValue());
                messageProccessor(receivedData);
                //System.out.println(receivedData);
                //this.serialPort.closePort();
            }
            catch (SerialPortException ex) {
                System.out.println("Error in receiving string from COM-port: " + ex);
                try {
                    this.serialPort.closePort();
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void messageProccessor(String message)
    {
        if (message!=null && !message.equals(""))
        {
            PortUtil portUtil=new PortUtil();
            System.out.println(portUtil.convertStringToJsonData(message));
        }
        else
            System.out.println("The received data is null.");
    }


    public String getReceivedData() {
        return this.receivedData;
    }

    public SerialPort getSerialPort() {
        return this.serialPort;
    }
}
