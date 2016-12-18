package ittepic.unitresc.ejbs;

import ittepic.unitresc.clases.AbonoVenta;
import ittepic.unitresc.clases.AbonoVentaTools;
import ittepic.unitresc.clases.ErrorJson;
import ittepic.unitresc.entidades.Tablaabonoventa;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GetAbonoVentas
{
    @PersistenceContext
    private EntityManager entity;

    @EJB
    ActualizarCliente ac;

    public String obtenerlos( int idx )
    {
        ArrayList<AbonoVenta> ls = new ArrayList<>();
        List<Tablaabonoventa> avs;


        javax.persistence.Query q;

        try
        {
            q = entity.createNamedQuery( "Tablaabonoventa.findAll" );
        }
        catch ( Exception e )
        {
            return ( "error en findall: " + e.toString() );
        }
        try
        {
            avs = ( List<Tablaabonoventa> ) q.getResultList();
        }
        catch ( Exception e )
        {
            return ( "error en getresultlist: " + e.toString() );
        }
        try
        {
            for ( int i = 0 ; i < avs.size() ; i++ )
            {
                AbonoVenta abonoVenta = new AbonoVenta();
                Tablaabonoventa tav = avs.get( i );

                abonoVenta.setId( tav.getAbonoventaid() );
                abonoVenta.setDescri( tav.getAbonoventadescri() );
                abonoVenta.setTipo( tav.getAbonoventatipo() );
                abonoVenta.setMonto( tav.getMonto() );
                abonoVenta.setFechaCorta( tav.getAbonoventafechacorta() );
                abonoVenta.setFechaLarga( tav.getAbonoventafechalarga() );

                if ( idx == 0 )
                {
                    ls.add( abonoVenta );
                }
                else if ( tav.getRefusuario().getUsuarioid() != idx )
                {
                }
                else
                {
                    ls.add( abonoVenta );
                }
            }

            // aquí se actualiza lo que tiene el cliente de saldo
            if ( idx != 0 )
                ac.actualizarCliente( idx , AbonoVentaTools.obtenerSaldo( ls ) );

            //return "tamaño de abono/venta: " + avs.size()
            //    + " : tamaño del cobjeto sin usuarios q no :" + ls.size();
            return AbonoVentaTools.aJson( ls );
        }
        catch ( Exception e )
        {
            return ErrorJson.nuevo( "exepción al obtener abonos: " + e.toString() );
        }
    }
}
