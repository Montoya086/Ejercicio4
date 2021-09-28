public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int atq;
    protected String msg_victoria;
    protected String msg_inicio;
    protected String msg_muerte;
    public Combatiente(String nombre){
        this.nombre = nombre;
        vida=0;
        atq=0;
        msg_inicio="";
        msg_muerte="";
        msg_victoria="";
    }
    public String getNombre() {
        return nombre;
    }
    public int getVida(){
        return vida;
    }
    public int getAtq(){
        return atq;
    }
    public void dismunuir_vida(int cant){
        vida=vida-cant;
    }
    public String getMsgInicio(){
        return msg_inicio;
    }
    public String getMsgMuerte(){
        return msg_muerte;
    }
    public String getMsgVictoria(){
        return msg_victoria;
    }
    public void aumentar_atq(int a){
        atq=atq+a;
    }
    public void aumentar_vida(int a){
        vida=vida+a;
    }
    abstract String get_items();
    abstract int cantidad_items();
    abstract String get_habilidades();
    abstract int cantidad_habilidades();
    abstract String getItem(int index);
    abstract void eliminar_item(int index);
    abstract String getHabilidad(int index);
    abstract void eliminar_habilidad(int index);
}
