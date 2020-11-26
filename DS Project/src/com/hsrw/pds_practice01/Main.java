package com.hsrw.pds_practice01;
import java.util.*;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server is waiting for a connection");
        Socket connection = ss.accept();
        System.out.println("Connection established with client: "+connection);
        String str = ("Welcome to the game");
        System.out.println(str);

        DataInputStream input = new DataInputStream(new BufferedInputStream(connection.getInputStream()));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> pass = new ArrayList<String>();
        boolean logged_in=false;
        boolean cont = true;
        while(cont=true){
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
                    users.add(username);

                    String request_password="Please enter your desired password: ";
                    output.writeUTF(request_password);
                    output.flush();
                    String password=input.readUTF();
                    System.out.println("User registered with password: "+password);
                    pass.add(password);

                    output.writeUTF("You are now registered! ");
                    output.flush();


                    break;
                case 2:
                   output.writeUTF("Enter your username: ");
                    output.flush();
                    String given_username = input.readUTF();
                    users.add(given_username);

                    output.writeUTF("Enter your password: ");
                    output.flush();
                    String given_password = input.readUTF();
                    pass.add(given_password);

                    boolean user_ok=false;
                    boolean pass_ok=false;
                    int index=-1;
                    for(int i=0;i<users.size();i++){
                        if (users.get(i)==given_username){
                            user_ok=true;
                            index=i;
                        }

                    }
                    if (pass.get(index)==given_password){pass_ok=true;}

                    if (pass_ok && user_ok) {logged_in=true;}
                    if (logged_in){
                    output.writeUTF("You are now logged in! ");
                    output.flush();}
                    else {
                        output.writeUTF("Wrong credentials ");
                        output.flush();
                    }



                    break;
                case 3: System.out.println("User wants to join team"); break;
                case 4: System.out.println("User wants to play game"); break;
                default: System.out.println("User entered invalid function");
            }
        }




        input.close();
        output.close();
        connection.close();
        ss.close();



    }

}
