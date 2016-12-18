package ittepic.unitresc.ejbs;

import ittepic.unitresc.clases.AbonoVenta;
import ittepic.unitresc.clases.ErrorJson;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path( "ws" )
public class ServiciosWeb
{

    @Context
    private UriInfo context;

    @EJB
    GetUsuarios getUsuarios;

    @EJB
    SetAbonoVenta sAV;

    @EJB
    GetAbonoVentas gav;

    @EJB
    ActualizarCliente actualizarCliente;

    public ServiciosWeb()
    {
    }

    @GET
    @Path( "getUsuarios" )
    @Produces( MediaType.APPLICATION_JSON )
    public String getUsuarios()
    {
        return getUsuarios.obtenerlos();
    }

    @GET
    @Path( "getAvonoVentasRaw" )
    @Produces( MediaType.APPLICATION_JSON )
    public String getAAVVraws()
    {
        return gav.obtenerlos( 0 );
    }

    @POST
    @Path( "obtenerAbonosVentas" )
    @Produces( MediaType.APPLICATION_JSON )
    public String getAbonos( JsonObject jo )
    {
        int clienteid;

        try
        {
            clienteid = jo.getInt( "clienteid" );
        }
        catch ( Exception e )
        {
            return ErrorJson.nuevo( "Parámetros insuficientes: " + jo.toString() );
        }

        return gav.obtenerlos( clienteid );
    }

    @POST
    @Path( "setAbonoVenta" )
    @Produces( MediaType.APPLICATION_JSON )
    public String setAAVV( JsonObject jo )
    {
        AbonoVenta av = new AbonoVenta();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        String fechaCorta = sdf.format( cal.getTime() );

        SimpleDateFormat sdf2 = new SimpleDateFormat( "yyyy-MM-dd HH:mm.ss" );
        String fechaLarga = sdf2.format( cal.getTime() );

        int clienteid = 0;

        try
        {
            av.setId( 0 );
            av.setTipo( jo.getString( "tipo" ) );
            av.setMonto( jo.getInt( "monto" ) );
            av.setDescri( jo.getString( "descri" ) );
            av.setFechaCorta( fechaCorta );
            av.setFechaLarga( fechaLarga );

            clienteid = jo.getInt( "clienteid" );

            actualizarCliente.actualizarCliente( clienteid , fechaCorta , fechaLarga );
            return sAV.setAbonoVenta( av , clienteid );
        }
        catch ( Exception e )
        {
            return ErrorJson.nuevo( " : No se obtuvieron los datos necesrios: " + jo.toString() );
        }
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public String getJson()
    {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes( MediaType.APPLICATION_JSON )
    public void putJson( String content )
    {
    }
}
