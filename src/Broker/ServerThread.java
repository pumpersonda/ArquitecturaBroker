package Broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by André on 29/09/2015.
 */
public class ServerThread extends Thread {
    private Socket clientSocket;
    private ProxyServer asignedProxyServer;
    private int serviceKeyIndex=0;
    private int actionKeyIndex=1;
    private int dataKeyIndex=2;

    private String regexToken="\\Q::::\\E";

    public ServerThread(Socket clientSocket,ProxyServer asignedProxyServer){
        this.clientSocket=clientSocket;
        this.asignedProxyServer=asignedProxyServer;

    }

    @Override
    public void run(){
        try (
                PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        )
        {

            String clientResponse=inputFromClient.readLine();
            String[] separateData = clientResponse.split(regexToken);
            System.out.println(regexToken);
            System.out.println(separateData.toString());
            asignedProxyServer.FindService(separateData[serviceKeyIndex],separateData[actionKeyIndex],separateData[dataKeyIndex]);


            this.clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


}
