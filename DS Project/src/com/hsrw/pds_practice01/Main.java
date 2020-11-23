package com.hsrw.pds_practice01;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    ServerSocket ss = new ServerSocket(1234);
	    System.out.println("Server is waiting for a connection");
	    Socket connection = ss.accept();
	    System.out.println("Connection established with client: "+connection);

	    DataInputStream input = new DataInputStream(new BufferedInputStream(connection.getInputStream()));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        output.writeUTF("Welcome, please choose one of the functionalities:\n1.Register     2.Log In     3.Join Team     4.Play Game");
        output.flush();
        int func = input.readInt();
        switch (func){
            case 1:
                String request_username="Please enter your desired username: ";
                output.writeUTF(request_username);
                output.flush();
                String username=input.readUTF();
                System.out.println("User gave this username: "+username);

                String request_password="Please enter your desired password: ";
                output.writeUTF(request_password);
                output.flush();
                String password=input.readUTF();
                System.out.println("User registered with password: "+password);

                ; break;
            case 2: System.out.println("User wants to log in"); break;
            case 3: System.out.println("User wants to join team"); break;
            case 4: System.out.println("User wants to play game"); break;
            default: System.out.println("User entered invalid function");
        }





        input.close();
        output.close();
        connection.close();
        ss.close();



    }
    public static void register (int func){


    }
}
