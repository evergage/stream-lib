package com.clearspring.analytics.util;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTestUtil
{

    public static Object roundTripSerialize(Object input) throws IOException, ClassNotFoundException
    {
        ByteOutputStream byteOutputStream = new ByteOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteOutputStream);

        oos.writeObject(input);
        oos.close();

        ByteInputStream byteInputStream = byteOutputStream.newInputStream();
        ObjectInputStream iis = new ObjectInputStream(byteInputStream);

        try
        {
            return iis.readObject();
        }
        finally
        {
            iis.close();
            byteOutputStream.close();
            byteInputStream.close();
        }
    }

}
