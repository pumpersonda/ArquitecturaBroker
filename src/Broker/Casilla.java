package Broker;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by André on 12/10/2015.
 */
public class Casilla {
    private String formato;

    public Casilla() {

    }

    public Candidato[] obtenerCandidato(String datos) {

        JsonElement archivoGeneral = new JsonParser().parse(datos);
        //Super objeto que encierra a todo el json
        JsonObject objetoGeneral = archivoGeneral.getAsJsonObject();
        //obtengo array de objetos room
        JsonArray candidatos = objetoGeneral.getAsJsonArray("candidatos");

        //temporal
        JsonObject actual = null;
        String name, votos;
        Candidato[] candidatosRegistrados = new Candidato[candidatos.size()];
        for (int actualObjectIndex = 0; actualObjectIndex < candidatos.size(); actualObjectIndex++) {
            //cada elemento del array es un objeto
            actual = candidatos.get(actualObjectIndex).getAsJsonObject();
            //obtengo sus propiedades
            name = actual.get("nombre").getAsString();
            votos = actual.get("votos").getAsString();


            candidatosRegistrados[actualObjectIndex] = new Candidato(name, Integer.parseInt(votos));
        }


        return candidatosRegistrados;
    }
}

