package it.fi.meucci;

import java.io.*;
import java.net.*;

public class client{
    String nomeServer= "localhost";
    int portaServer=6788;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringautente;
    String stringricevuta;
    DataOutputStream outVersoServer;
    BufferedReader indalServer;

    public Socket connect(){
        try{

       

        tastiera = new BufferedReader(new InputStreamReader(System.in));
        mioSocket=new Socket(nomeServer, portaServer);
        outVersoServer =new DataOutputStream(mioSocket.getOutputStream());
        indalServer =new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        }
        catch(UnknownHostException e){
            System.err.println("no host");
        }
     
        catch(Exception e){
            System.out.println("no so");
        }
        return mioSocket;
    }

    public void comunica(){
        try{

        System.out.println("4, inserisci una stringa: "+ '\n');
        stringautente = tastiera.readLine();
        System.out.println("5, invio la stringa");
        outVersoServer.writeBytes(stringautente+'\n');
        stringricevuta=indalServer.readLine();
        System.out.println("8, risposta: "+'\n'+stringricevuta);
        System.out.println("9, passo e chiudo");
        mioSocket.close();

        }
        catch(Exception e){}
    }




}