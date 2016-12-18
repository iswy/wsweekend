package ittepic.unitresc.ejbs;

import ittepic.unitresc.clases.Cliente;
import ittepic.unitresc.clases.ClienteTools;
import ittepic.unitresc.entidades.Tablausuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GetUsuarios
{

    @PersistenceContext
    private EntityManager entity;

    public String obtenerlos()
    {

        List<Tablausuario> lista;
        Query q;

        try
        {
            q = entity.createNamedQuery( "Tablausuario.findAll" );
        }
        catch ( Exception e )
        {
            return ( "error en findall: " + e.toString() );
        }
        try
        {
            lista = ( List<Tablausuario> ) q.getResultList();
        }
        catch ( Exception e )
        {
            return ( "error en getresultlist: " + e.toString() );
        }
        try
        {

            ArrayList<Cliente> al = new ArrayList<>();

            for ( int i = 0 ; i < lista.size() ; i++ )
            {
                Tablausuario tu = lista.get( i );

                Cliente c = new Cliente();

                c.setId( tu.getUsuarioid() );
                c.setNombre( tu.getUsuarionombre() );
                c.setFechaCorta( tu.getUsuariofechacorta() );
                c.setFechaLarga( tu.getUsuariofechalarga() );
                c.setSaldo( tu.getSaldo() );

                al.add( c );
            }

            return ClienteTools.aJson( al );
        }
        catch ( Exception e )
        {
            return ( "error en otro lado: " + e.toString() );
        }
    }
}
