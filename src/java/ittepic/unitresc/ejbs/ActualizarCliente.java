package ittepic.unitresc.ejbs;

import ittepic.unitresc.clases.ErrorJson;
import ittepic.unitresc.clases.StringInt;
import ittepic.unitresc.entidades.Tablausuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ActualizarCliente
{

    @PersistenceContext
    private EntityManager entity;

    public String actualizarCliente( int clienteid , String fechaCorta , String FechaLarga )
    {
        try
        {
            Tablausuario cliente = entity.find( Tablausuario.class , clienteid );
            cliente.setUsuariofechacorta( fechaCorta );
            cliente.setUsuariofechalarga( FechaLarga );

            entity.merge( cliente );
            entity.flush();

            StringInt si = new StringInt();

            si.setCadena( "{ \"status\" : \"ok\"} " );
            si.setEntero( 0 );

            return si.getCadena();
        }

        catch ( Exception e )
        {
            return ErrorJson.nuevo( "Error al acualizar cliente: " + e.toString() );
        }
    }

    public String actualizarCliente( int clienteid , int saldo )
    {

        Tablausuario cliente = entity.find( Tablausuario.class , clienteid );
        cliente.setSaldo( saldo );

        entity.merge( cliente );
        entity.flush();

        StringInt si = new StringInt();

        si.setCadena( "{ \"status\" : \"ok\"} " );
        si.setEntero( 0 );

        System.out.println( ":::: cliente actualizado : " + cliente.getUsuarionombre() + " : " + cliente.getSaldo() );

        return si.getCadena();

    }
}
