import java.util.ArrayList;

public class Binario extends Accion implements iFormato{
    ArrayList<Accion> acciones = new ArrayList<Accion>();




    public Binario(int precio, String nombre) {
        super(precio, nombre);
    }


    @Override
    public boolean verificardatosFormato(ArrayList<Accion> a) {
        int index=0;
        Boolean bueno=Boolean.TRUE;
        while (index < a.size()) {
            Accion acc=a.get(index);
            if(acc.nombre==null||acc.precio<0){bueno=Boolean.FALSE;}
            index = index + 1;
        }
        return bueno;
    }
}
