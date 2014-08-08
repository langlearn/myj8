package myj8.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件
 * Created by yjj on 2014/8/8.
 */
public class LargeMappedFiles {
    static int length=0x8000000; //128Mb
    public static void main(String[] args) throws IOException {
        FileChannel channel=new RandomAccessFile("test.dat","rw").getChannel();
        MappedByteBuffer out=channel.map(FileChannel.MapMode.READ_WRITE,0,length);
        for(int i=0;i<length;i++){
            out.put((byte)'x');
        }
        System.out.println("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char) out.get(i));
        }
        channel.close();
    }
}
