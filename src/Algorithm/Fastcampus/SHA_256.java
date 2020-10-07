package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SHA_256 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        String str = st.nextToken();

        digest.update(str.getBytes());
        byte[] hashData = digest.digest();

        StringBuffer buffer = new StringBuffer();
        for(byte b : hashData){
            buffer.append(String.format("%02x",b));
        }

        System.out.println(buffer);
    }
}
