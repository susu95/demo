package service.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TFramedTransport;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class Client {

    public static final int SERVER_PORT = 9001;
    public static final int TIMEOUT = 30000;
    public static TTransport transport = null;

    public static Hello.Client client;

    public static void initClient() {
        try {
            transport = new TSocket(getLocalIp(), SERVER_PORT, TIMEOUT);

            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);

            client = new Hello.Client(protocol);


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void destroyClient(){
        if (null != transport)
            transport.close();
    }


    public static String getLocalIp(){
        String ipAddress = null;
        Enumeration<NetworkInterface> net = null;
        try {
            net = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        while(net.hasMoreElements()){
            NetworkInterface element = net.nextElement();
            Enumeration<InetAddress> addresses = element.getInetAddresses();
            while (addresses.hasMoreElements()){
                InetAddress ip = addresses.nextElement();
                if (ip instanceof Inet4Address){

                    if (ip.isSiteLocalAddress()){

                        ipAddress = ip.getHostAddress();
                    }

                }

            }
        }
        return ipAddress;
    }
}

