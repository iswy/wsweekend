package ittepic.unitresc.clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class AbonoVentaTools
{
    public static String aJson( AbonoVenta av )
    {
        GsonBuilder gb = new GsonBuilder();
        Gson gs = gb.create();

        return gs.toJson( av );
    }

    public static String aJson( ArrayList<AbonoVenta> avs )
    {
        GsonBuilder gb = new GsonBuilder();
        Gson gs = gb.create();

        return gs.toJson( avs );
    }

    public static int obtenerSaldo( ArrayList<AbonoVenta> avs )
    {
        int saldo = 0;

        for ( int i = 0 ; i < avs.size() ; i++ )
        {
            int monto = avs.get( i ).getMonto();
            if ( avs.get( i ).getTipo().toLowerCase().contains( "abono" ) )
            {
                saldo += monto;
            }
            else
            {
                saldo -= monto;
            }
        }

        return saldo;
    }
}
