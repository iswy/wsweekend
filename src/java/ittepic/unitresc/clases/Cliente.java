package ittepic.unitresc.clases;

public class Cliente
{
    private int id;
    private String nombre;
    private String fechaCorta;
    private String fechaLarga;
    private int saldo;

    public int getSaldo()
    {
        return saldo;
    }

    public void setSaldo( int saldo )
    {
        this.saldo = saldo;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public String getFechaCorta()
    {
        return fechaCorta;
    }

    public void setFechaCorta( String fechaCorta )
    {
        this.fechaCorta = fechaCorta;
    }

    public String getFechaLarga()
    {
        return fechaLarga;
    }

    public void setFechaLarga( String fechaLarga )
    {
        this.fechaLarga = fechaLarga;
    }

}
