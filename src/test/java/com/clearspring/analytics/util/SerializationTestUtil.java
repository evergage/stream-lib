package com.clearspring.analytics.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTestUtil
{

    public static Object roundTripSerialize(Object input) throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteOutputStream);

        oos.writeObject(input);
        oos.close();

        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
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
