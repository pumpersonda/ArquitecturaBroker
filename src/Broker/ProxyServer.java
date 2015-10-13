package Broker;



import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by André on 21/09/2015.
 */
public class ProxyServer {

    public static void main(String[] args) {
        int portNumber = 5555;
        ProxyServer aProxyServer = new ProxyServer();
        aProxyServer.attendBroker(portNumber);
    }
public void attendBroker(int portNumber){
    boolean comunicationEnabled=true;
    try {
        ServerSocket serverSocket = new ServerSocket(portNumber);


        while (comunicationEnabled) {
            Socket clientSocket = serverSocket.accept();
            new ServerThread(clientSocket, this).start();


        }




    } catch (IOException e) {
        System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
        System.out.println(e.getMessage());
    }

}

    public void FindService(String nameService, String data){


        Casilla casilla = new Casilla();

        switch (nameService){
            case "pastel":

               Pastel graficaPastel=new Pastel();

                    HandledAction(graficaPastel, data);




                break;

            case "barras":
                Barras graficaBarras=new Barras();
                graficaBarras.getGrafica(" Aqui hay una grafica: "+nameService);
                break;
            default:

        }


    }



    public void HandledAction(Grafica unaGrafica,String data){


            Casilla casilla = new Casilla();

         Candidato[] candidatos= casilla.obtenerCandidato(data);



        for (int NumCandidatos=0; NumCandidatos<candidatos.length;NumCandidatos++)
            unaGrafica.graficar(candidatos[NumCandidatos].getNombre(),candidatos[NumCandidatos].getVotos());



    }





}
