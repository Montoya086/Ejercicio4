/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Jugador.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
import java.util.ArrayList;
public class Jugador extends Combatiente{
    String clase;
    ArrayList<String> items;
    public Jugador(String nombre, String clase){
        super(nombre);
        if(clase=="Guerrero"){
            this.clase="Guerrero";
            atq= 200;
            vida= 700;
            items=new ArrayList<String>();
            items.add("Filo de la noche");
            items.add("Posion de fuerza");
            msg_inicio="Ganaremos!";
            msg_muerte="Me vengare...";
            msg_victoria="Mueran criaturas inmundas!";
        }
        if(clase=="Explorador"){
            this.clase="Exlorador";
            atq= 70;
            vida= 300;
            items=new ArrayList<String>();
            items.add("Filo de la noche");
            items.add("Posion de fuerza");
            items.add("Varita de vida");
            items.add("Varita de rayo");
            msg_inicio="Esto me dara una buena recompensa";
            msg_muerte="No puede ser...";
            msg_victoria="El gremio me dara una gran recompensa!";
        }
    }
    public String get_items(){//desplegar lista de items
        String list_items="\n";
        for(int i=0;i<items.size();i++){
            list_items=list_items+i+". "+items.get(i)+"\n";
        }
        return list_items;
    }
    public int cantidad_items(){
        return items.size();
    }
    public String getItem(int index){
        return items.get(index);
    }
    public void eliminar_item(int index){
        items.remove(index);
    }
    public void eliminar_habilidad(int index){

    }
    public String getHabilidad(int index){
        return "";
    }
    public String get_habilidades(){
        return "";
    }
    public int cantidad_habilidades(){
        return 0;
    }
}
