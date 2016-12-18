package ittepic.unitresc.clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class ClienteTools
{
    public static String aJson( Cliente c )
    {
        GsonBuilder gb = new GsonBuilder();
        Gson gs = gb.create();

        return gs.toJson( c );
    }

    public static String aJson( ArrayList<Cliente> al )
    {
        GsonBuilder gb = new GsonBuilder();
        Gson gs = gb.create();

        return gs.toJson( al );
    }
}
