/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.io;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.TooManyListenersException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eipps
 */
public class BarcodeReader implements Runnable, SerialPortEventListener {

    private InputStream inputStream;
    private SerialPort serialPort;
    private CommPortIdentifier portId;
    private Vector<BarcodeCallback> barcodeCallback = new Vector();
    public BarcodeReader(CommPortIdentifier portId) {
        try {
            this.portId = portId;
            serialPort = (SerialPort) portId.open("Aadhar barcode Reader", 1000);
            inputStream = serialPort.getInputStream();
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            serialPort.setSerialPortParams(38400, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
           // serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

            Thread reader = new Thread(this);
            reader.start();
        } catch (UnsupportedCommOperationException ex) {
            System.out.println("Opps.. UnsupportedCommOperationException");
        } catch (TooManyListenersException ex) {
            System.out.println("Opps.. TooManyListenersException");
        } catch (IOException ex) {
            System.out.println("Opps.. IOException");
        } catch (PortInUseException ex) {
            System.out.println("Opps.. PortInUseException");
        }
    }
    public void addBarcodeListener(BarcodeCallback barcodeCallback1){
        barcodeCallback.add(barcodeCallback1);
    }
    @Override
    public void run() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        System.out.println("Dtaa");
        switch (event.getEventType()) {
            case SerialPortEvent.BI: System.out.println("BI"); break;
            case SerialPortEvent.OE: System.out.println("OE"); break;
            case SerialPortEvent.FE: System.out.println("FE"); break;
            case SerialPortEvent.PE: System.out.println("PE"); break;
            case SerialPortEvent.CD: System.out.println("CD"); break;
            case SerialPortEvent.CTS:System.out.println("CTS"); break;
            case SerialPortEvent.DSR:System.out.println("DSR"); break;
            case SerialPortEvent.RI: System.out.println("RI"); break;
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:System.out.println("EMPTY"); break;
            case SerialPortEvent.DATA_AVAILABLE:
                //byte[] readBuffer = new byte[1000];
                System.out.println("AVA"); 
                int bufferSize=0;
                try {
                    bufferSize = inputStream.available();
                    System.out.println("AVA:"+bufferSize); 
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                byte[] readBuffer = new byte[bufferSize];
                try {
                    if (bufferSize > 0) {
                        
                        int numBytes = inputStream.read(readBuffer);
                        barcodeCallback.get(0).getBarcodeData(new String(readBuffer));
                        System.out.print("Data:"+new String(readBuffer));
                    }
                    //System.out.print("Data:"+new String(readBuffer));
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
        }
    }
    public void clsePort(){
        try {
            inputStream.close();
            inputStream=null;
            serialPort.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
