package com.tuershen.nbtlibrary.io;



import com.tuershen.nbtlibrary.code.ByteStream;



import java.io.*;



public class SerializableStream {

    private static final ByteStream.Encoder encoder = ByteStream.getEncoder();

    private static final ByteStream.Decoder decoder = ByteStream.getDecoder();

    private static ByteArrayOutputStream byteArrayOutputStream;

    protected static String encode(byte[] bytes) { return encoder.encodeToString(bytes); }

    protected static byte[] decode(String encodedText) { return decoder.decode(encodedText); }



    /**
     * 序列化
     * @param serializableFormat
     * @return
     */
    public static <T extends Serializable> String getByteStream(T serializableFormat) {
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objStream = new ObjectOutputStream(byteArrayOutputStream);
            objStream.writeObject(serializableFormat);
            byte[] data = byteArrayOutputStream.toByteArray();
            return encode(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 反序列化
     * @param data
     * @return
     */
    public static <T extends Serializable> T deserializeObj(String data) {
        ByteArrayInputStream byteStream = decodeByteInputStream(data);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(byteStream);
            T obj = (T)ois.readObject();
            return obj;
        }
        catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    protected static ByteArrayInputStream decodeByteInputStream(String data){
        return new ByteArrayInputStream(decode(data));
    }







}
