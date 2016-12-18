package ittepic.unitresc.clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ErrorJson
{

    private String mensaje;

    public String getMensaje()
    {
        return mensaje;
    }

    public void setMensaje( String mensaje )
    {
        this.mensaje = mensaje;
    }

    public static String nuevo( String mensaje )
    {
        GsonBuilder gb = new GsonBuilder();
        Gson gs = gb.create();

        ErrorJson er = new ErrorJson();
        er.setMensaje( mensaje );

        return gs.toJson( er );
    }
}
