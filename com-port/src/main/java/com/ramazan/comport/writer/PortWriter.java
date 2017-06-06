package com.ramazan.comport.writer;

import com.ramazan.comport.reader.PortReader;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * Created by Ramazan Karagoz on 6.06.2017.
 */
public class PortWriter {

    private SerialPort serialPort;
    private String portName;
    private String sendData;

    public PortWriter() {
    }

    public PortWriter(String portName) {
        this.portName = portName;
    }

    public void writer()
    {
        serialPort=new SerialPort(portName.toUpperCase());

        try {
            serialPort.openPort();

            serialPort.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);

            serialPort.writeString(sendData);

            PortReader portReader=new PortReader(serialPort);

            serialPort.addEventListener(portReader, SerialPort.MASK_RXCHAR);

        } catch (SerialPortException e) {
            System.out.println("There are an error on writing string to port т: " + e);
        }
    }

    public String getData() {
        return sendData;
    }

    public void SendData(String sendData) {
        this.sendData = sendData;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
}
