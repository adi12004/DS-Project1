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
            boolean cont = true;
            while(cont == true){
                String intro = input.readUTF();
                System.out.println(intro);
                int func = Integer.parseInt(br.readLine());

                output.writeInt(func);
                output.flush();

                switch(func){
                    case 1:
                        System.out.println(input.readUTF());
                        String username= br.readLine();
                        output.writeUTF(username);
                        output.flush();

                        System.out.println(input.readUTF());
                        String password= br.readLine();
                        output.writeUTF(password);
                        output.flush();

                        System.out.println(input.readUTF()); break;



                    case 2:
                        System.out.println(input.readUTF());
                        String given_username = br.readLine();
                        output.writeUTF(given_username);
                        output.flush();

                        System.out.println(input.readUTF());
                        String given_password = br.readLine();
                        output.writeUTF(given_password);
                        output.flush(); 

                        System.out.println(input.readUTF()); break;

                    case 3:


                        cont = false;


                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + func);
                }

            }
            connection.close();
            input.close();
            output.close();

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

