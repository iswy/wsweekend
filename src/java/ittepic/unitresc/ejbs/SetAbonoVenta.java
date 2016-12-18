package ittepic.unitresc.ejbs;

import ittepic.unitresc.clases.AbonoVenta;
import ittepic.unitresc.clases.ErrorJson;
import ittepic.unitresc.entidades.Tablaabonoventa;
import ittepic.unitresc.entidades.Tablausuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SetAbonoVenta
{
    @PersistenceContext
    private EntityManager entity;

    public String setAbonoVenta( AbonoVenta av , int usuarioid )
    {
        Tablaabonoventa a = new Tablaabonoventa();

        Tablausuario usus = null;

        try
        {


            usus = entity.find( Tablausuario.class , usuarioid );


            a.setAbonoventadescri( av.getDescri() );
            a.setAbonoventatipo( av.getTipo() );
            a.setMonto( av.getMonto() );
            a.setAbonoventafechacorta( av.getFechaCorta() );
            a.setAbonoventafechalarga( av.getFechaLarga() );

            a.setRefusuario( usus );

            entity.persist( a );
            entity.flush();
        }
        catch ( Exception e )
        {
            return ErrorJson.nuevo( "Error al insertar abono: " + usus.getUsuarionombre() + " :" + e.toString() );
        }

        return ( "{\"status\":\"ok\"}" );
    }
}
