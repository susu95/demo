package service.demo;

import org.apache.thrift.TException;

public class HelloImpl implements Hello.Iface {

        public String helloString(String para)  throws TException { return null; }
    public int helloInt(int para)  throws TException { return 0; }
    public boolean helloBoolean(boolean para)  throws TException { return true; }
    public void helloVoid()  throws TException { }
    public String helloNull()  throws TException { return null; }


}
