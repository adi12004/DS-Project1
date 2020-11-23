package com.hsrw.pds_practice01;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main (String[] args)throws IOException {
        try {
            Socket connection = new Socket("192.0.0.1", 1234);
            System.out.println("Connected: "+connection);

            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));
            DataInputStream input = new DataInputStream(new BufferedInputStream(connection.getInputStream()));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String intro = input.readUTF();
            System.out.println(intro);

            connection.close();
            input.close();
            output.close();


        }
        catch (IOException e) {
            //handle exceptions
        }
        }
    }

