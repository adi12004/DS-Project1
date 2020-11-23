package com.hsrw.pds_practice01;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main (String[] args)throws IOException {
        try {
            Socket connection = new Socket("127.0.0.1", 1234);
            System.out.println("Connected: "+connection);

            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));
            DataInputStream input = new DataInputStream(new BufferedInputStream(connection.getInputStream()));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String intro = input.readUTF();
            System.out.println(intro);
            int func = Integer.parseInt(br.readLine());

            output.writeInt(func);
            output.flush();

            System.out.println(input.readUTF());
            String username= br.readLine();
            output.writeUTF(username);
            output.flush();

            System.out.println(input.readUTF());
            String password= br.readLine();
            output.writeUTF(password);
            output.flush();


            connection.close();
            input.close();
            output.close();


        }
        catch (IOException e) {
            //handle exceptions
        }
    }
}

