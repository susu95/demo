package service.demo;

import org.apache.thrift.TException;
import org.junit.*;

public class HelloImplTest {

    @Before
    public void initClient() {
        Client.initClient();
    }

    @After
    public void destroyClient() {
        Client.destroyClient();
    }

    @Test
public void testHelloString() throws TException { }

@Test
public void testHelloInt() throws TException { }

@Test
public void testHelloBoolean() throws TException { }

@Test
public void testHelloVoid() throws TException { }

@Test
public void testHelloNull() throws TException { }


}
