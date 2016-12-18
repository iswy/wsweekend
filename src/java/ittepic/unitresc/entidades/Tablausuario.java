/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ittepic.unitresc.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pi
 */
@Entity
@Table( name = "tablausuario" )
@XmlRootElement
@NamedQueries( 
{
    @NamedQuery( name = "Tablausuario.findAll" , query = "SELECT t FROM Tablausuario t" )
    , @NamedQuery( name = "Tablausuario.findByUsuarioid" , query = "SELECT t FROM Tablausuario t WHERE t.usuarioid = :usuarioid" )
    , @NamedQuery( name = "Tablausuario.findByUsuarionombre" , query = "SELECT t FROM Tablausuario t WHERE t.usuarionombre = :usuarionombre" )
    , @NamedQuery( name = "Tablausuario.findByUsuariofechalarga" , query = "SELECT t FROM Tablausuario t WHERE t.usuariofechalarga = :usuariofechalarga" )
    , @NamedQuery( name = "Tablausuario.findByUsuariofechacorta" , query = "SELECT t FROM Tablausuario t WHERE t.usuariofechacorta = :usuariofechacorta" )
    , @NamedQuery( name = "Tablausuario.findBySaldo" , query = "SELECT t FROM Tablausuario t WHERE t.saldo = :saldo" )
} )
public class Tablausuario implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Basic( optional = false )
    @Column( name = "usuarioid" )
    private Integer usuarioid;
    @Basic( optional = false )
    @NotNull
    @Size( min = 1 , max = 255 )
    @Column( name = "usuarionombre" )
    private String usuarionombre;
    @Size( max = 127 )
    @Column( name = "usuariofechalarga" )
    private String usuariofechalarga;
    @Size( max = 63 )
    @Column( name = "usuariofechacorta" )
    private String usuariofechacorta;
    @Column( name = "saldo" )
    private Integer saldo;
    @OneToMany( cascade = CascadeType.ALL , mappedBy = "refusuario" )
    private List<Tablaabonoventa> tablaabonoventaList;

    public Tablausuario()
    {
    }

    public Tablausuario( Integer usuarioid )
    {
        this.usuarioid = usuarioid;
    }

    public Tablausuario( Integer usuarioid , String usuarionombre )
    {
        this.usuarioid = usuarioid;
        this.usuarionombre = usuarionombre;
    }

    public Integer getUsuarioid()
    {
        return usuarioid;
    }

    public void setUsuarioid( Integer usuarioid )
    {
        this.usuarioid = usuarioid;
    }

    public String getUsuarionombre()
    {
        return usuarionombre;
    }

    public void setUsuarionombre( String usuarionombre )
    {
        this.usuarionombre = usuarionombre;
    }

    public String getUsuariofechalarga()
    {
        return usuariofechalarga;
    }

    public void setUsuariofechalarga( String usuariofechalarga )
    {
        this.usuariofechalarga = usuariofechalarga;
    }

    public String getUsuariofechacorta()
    {
        return usuariofechacorta;
    }

    public void setUsuariofechacorta( String usuariofechacorta )
    {
        this.usuariofechacorta = usuariofechacorta;
    }

    public Integer getSaldo()
    {
        return saldo;
    }

    public void setSaldo( Integer saldo )
    {
        this.saldo = saldo;
    }

    @XmlTransient
    public List<Tablaabonoventa> getTablaabonoventaList()
    {
        return tablaabonoventaList;
    }

    public void setTablaabonoventaList( List<Tablaabonoventa> tablaabonoventaList )
    {
        this.tablaabonoventaList = tablaabonoventaList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( usuarioid != null ? usuarioid.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Tablausuario ) )
        {
            return false;
        }
        Tablausuario other = ( Tablausuario ) object;
        if ( ( this.usuarioid == null && other.usuarioid != null ) || ( this.usuarioid != null && !this.usuarioid.equals( other.usuarioid ) ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "ittepic.unitresc.entidades.Tablausuario[ usuarioid=" + usuarioid + " ]";
    }

}
