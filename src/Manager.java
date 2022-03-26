public class Manager implements iSerial{
    @Override
    public String Serializar(Binario b) {
        int index=0;
        String out="{";
        while (index < b.acciones.size()) {
            Accion a=b.acciones.get(index);
            out=out.concat(a.nombre).concat(String.valueOf(a.precio)).concat("}");
            index = index + 1;
        }
        return  out;
    }

    @Override
    public Binario desSerializar(String xml) {
        String s=xml.substring(xml.indexOf("<") + 1,xml.indexOf(">"));
        //System.out.print(s);
        String[] parts=s.split("=");
        Binario bin=new Binario(Integer.parseInt(parts[1]),parts[0]);
        bin.acciones.add(bin);
        return bin;

    }

    public static void main(String[] args) {
    //que se lo envie a otra clase y ella lo imprima
        String str="<davivienda=328976>";//esto es un xml por ejemplo
        Manager m=new Manager();
        Binario deserializado=m.desSerializar(str);
        Boolean formatocorrecto=deserializado.verificardatosFormato(deserializado.acciones);
        if(formatocorrecto) {
            String json = m.Serializar(deserializado);
            System.out.print(json);
        }else
        {
            System.out.print("Hay valores erroneos no se puede formatear a JSON {}");
        }
    }

}
