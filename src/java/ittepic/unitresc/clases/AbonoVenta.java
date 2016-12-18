package ittepic.unitresc.clases;

public class AbonoVenta
{
    private int id;
    private int monto;

    public int getMonto()
    {
        return monto;
    }

    public void setMonto( int monto )
    {
        this.monto = monto;
    }
    private String tipo;
    private String descri;
    private String fechaCorta;
    private String fechaLarga;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo( String tipo )
    {
        this.tipo = tipo;
    }

    public String getDescri()
    {
        return descri;
    }

    public void setDescri( String descri )
    {
        this.descri = descri;
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
