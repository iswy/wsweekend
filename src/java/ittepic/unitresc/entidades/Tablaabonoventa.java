/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ittepic.unitresc.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pi
 */
@Entity
@Table( name = "tablaabonoventa" )
@XmlRootElement
@NamedQueries( 
{
    @NamedQuery( name = "Tablaabonoventa.findAll" , query = "SELECT t FROM Tablaabonoventa t" )
    , @NamedQuery( name = "Tablaabonoventa.findByAbonoventaid" , query = "SELECT t FROM Tablaabonoventa t WHERE t.abonoventaid = :abonoventaid" )
    , @NamedQuery( name = "Tablaabonoventa.findByAbonoventatipo" , query = "SELECT t FROM Tablaabonoventa t WHERE t.abonoventatipo = :abonoventatipo" )
    , @NamedQuery( name = "Tablaabonoventa.findByAbonoventadescri" , query = "SELECT t FROM Tablaabonoventa t WHERE t.abonoventadescri = :abonoventadescri" )
    , @NamedQuery( name = "Tablaabonoventa.findByAbonoventafechalarga" , query = "SELECT t FROM Tablaabonoventa t WHERE t.abonoventafechalarga = :abonoventafechalarga" )
    , @NamedQuery( name = "Tablaabonoventa.findByAbonoventafechacorta" , query = "SELECT t FROM Tablaabonoventa t WHERE t.abonoventafechacorta = :abonoventafechacorta" )
    , @NamedQuery( name = "Tablaabonoventa.findByMonto" , query = "SELECT t FROM Tablaabonoventa t WHERE t.monto = :monto" )
} )
public class Tablaabonoventa implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Basic( optional = false )
    @Column( name = "abonoventaid" )
    private Integer abonoventaid;
    @Basic( optional = false )
    @NotNull
    @Size( min = 1 , max = 31 )
    @Column( name = "abonoventatipo" )
    private String abonoventatipo;
    @Basic( optional = false )
    @NotNull
    @Size( min = 1 , max = 254 )
    @Column( name = "abonoventadescri" )
    private String abonoventadescri;
    @Size( max = 63 )
    @Column( name = "abonoventafechalarga" )
    private String abonoventafechalarga;
    @Size( max = 31 )
    @Column( name = "abonoventafechacorta" )
    private String abonoventafechacorta;
    @Basic( optional = false )
    @NotNull
    @Column( name = "monto" )
    private int monto;
    @JoinColumn( name = "refusuario" , referencedColumnName = "usuarioid" )
    @ManyToOne( optional = false )
    private Tablausuario refusuario;

    public Tablaabonoventa()
    {
    }

    public Tablaabonoventa( Integer abonoventaid )
    {
        this.abonoventaid = abonoventaid;
    }

    public Tablaabonoventa( Integer abonoventaid , String abonoventatipo , String abonoventadescri , int monto )
    {
        this.abonoventaid = abonoventaid;
        this.abonoventatipo = abonoventatipo;
        this.abonoventadescri = abonoventadescri;
        this.monto = monto;
    }

    public Integer getAbonoventaid()
    {
        return abonoventaid;
    }

    public void setAbonoventaid( Integer abonoventaid )
    {
        this.abonoventaid = abonoventaid;
    }

    public String getAbonoventatipo()
    {
        return abonoventatipo;
    }

    public void setAbonoventatipo( String abonoventatipo )
    {
        this.abonoventatipo = abonoventatipo;
    }

    public String getAbonoventadescri()
    {
        return abonoventadescri;
    }

    public void setAbonoventadescri( String abonoventadescri )
    {
        this.abonoventadescri = abonoventadescri;
    }

    public String getAbonoventafechalarga()
    {
        return abonoventafechalarga;
    }

    public void setAbonoventafechalarga( String abonoventafechalarga )
    {
        this.abonoventafechalarga = abonoventafechalarga;
    }

    public String getAbonoventafechacorta()
    {
        return abonoventafechacorta;
    }

    public void setAbonoventafechacorta( String abonoventafechacorta )
    {
        this.abonoventafechacorta = abonoventafechacorta;
    }

    public int getMonto()
    {
        return monto;
    }

    public void setMonto( int monto )
    {
        this.monto = monto;
    }

    public Tablausuario getRefusuario()
    {
        return refusuario;
    }

    public void setRefusuario( Tablausuario refusuario )
    {
        this.refusuario = refusuario;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( abonoventaid != null ? abonoventaid.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Tablaabonoventa ) )
        {
            return false;
        }
        Tablaabonoventa other = ( Tablaabonoventa ) object;
        if ( ( this.abonoventaid == null && other.abonoventaid != null ) || ( this.abonoventaid != null && !this.abonoventaid.equals( other.abonoventaid ) ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "ittepic.unitresc.entidades.Tablaabonoventa[ abonoventaid=" + abonoventaid + " ]";
    }

}
