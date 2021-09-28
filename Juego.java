import java.util.ArrayList;
public class Juego {
    ArrayList<Combatiente> combatientes;
    int nenemigos;
    public Juego(String clase, String nombre){
        combatientes = new ArrayList<Combatiente>();
        combatientes.add(new Jugador(nombre, clase));
        nenemigos=(int)(Math.random()*3+1);//numero de enemigos
        int jefe = (int)(Math.random()*100);//posibilidad de ser jefe
        if(jefe>=50){//generar jefe
            nenemigos--;
            int tipo =(int)(Math.random()*3);//tipo de jefe
            if(tipo==0){
                combatientes.add(new Jefe("Slime"));
            }
            if(tipo==1){
                combatientes.add(new Jefe("Undead"));
            }
            if(tipo==2){
                combatientes.add(new Jefe("Goblin"));
            }
        }
        for(int i=0;i<nenemigos;i++){//elegir enemigo
            int tipo =(int)(Math.random()*3);//tipo de enemigo
            if(tipo==0){
                combatientes.add(new Enemigo("Slime"));
            }
            if(tipo==1){
                combatientes.add(new Enemigo("Undead"));
            }
            if(tipo==2){
                combatientes.add(new Enemigo("Goblin"));
            }
        }
    }
    public void atacar(int atacante, int objetivo){//atacar
        combatientes.get(objetivo).dismunuir_vida(combatientes.get(atacante).getAtq());
    }
    public boolean verificar_vivo(int index){//verificar si un combatiente está vivo
        if(combatientes.get(index).getVida()<=0){
            return false;
        }else{
            return true;
        }
    }
    public void eliminar_combatiente(int index){//eliminar combatiente
        combatientes.remove(index);
    }
    public String mostrar_combatientes(){//mostrar lista de combatientes
        String lista="\n";
        for(int i=0;i<combatientes.size();i++){
            lista=lista+i+". "+combatientes.get(i).getNombre()+"\t HP: "+combatientes.get(i).getVida()+"\t ATQ: "+combatientes.get(i).getAtq()+"\n";
        }
        return lista;
    }
    public int ncombatientes(){//mostrar cantidad de combatientes
        return combatientes.size();
    }
    public String getNombre(int index){//mostrar nombre del combatiente
        return combatientes.get(index).getNombre();
    }
    public String getMsgInicio(int index){//mostrar mensaje de inicio de un combatiente
        return combatientes.get(index).getMsgInicio();
    }
    public String getMsgMuerte(int index){//mostrar mensaje de muerte de un combatiente
        return combatientes.get(index).getMsgMuerte();
    }
    public String getMsgVictoria(int index){//mostrar mensaje de victoria de un combatiente
        return combatientes.get(index).getMsgVictoria();
    }
    public boolean verificar_win(String nombre){//verificar si el jugador ganó
        if(combatientes.size()==1){
            if(combatientes.get(0).getNombre()==nombre){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public boolean verificar_derrota(String nombre){//verificar derrota
        if(combatientes.get(0).getNombre()!=nombre){
            return true;
        }else{
            return false;
        }
    }
    public String mostrar_items(){//mostrar items
        return combatientes.get(0).get_items();
    }
    public int numero_items(){//mostrar numero de items
        return combatientes.get(0).cantidad_items();
    }
    public String mostrar_habilidades(int index){//mostrar habilidades
        return combatientes.get(index).get_habilidades();
    }
    public int numero_habilidades(int index){//mostrar numero de habilidades
        return combatientes.get(index).cantidad_habilidades();
    }
    public void usar_item(int portador, int item, int objetivo){//utilizar item
        String nombre_item = combatientes.get(portador).getItem(item);//devolver el nombre del item
        switch (nombre_item) {//items:
            case "Filo de la noche":
                combatientes.get(objetivo).dismunuir_vida(combatientes.get(portador).getAtq()+100);
                combatientes.get(portador).eliminar_item(item);
                break;
            case "Posion de fuerza":
                combatientes.get(objetivo).aumentar_atq(50);
                combatientes.get(portador).eliminar_item(item);
                break;
            case "Varita de vida":
                combatientes.get(objetivo).aumentar_vida(150);
                combatientes.get(portador).eliminar_item(item);
                break;
            case "Varita de rayo":
                combatientes.get(objetivo).dismunuir_vida(150);
                combatientes.get(portador).eliminar_item(item);
                break;
            default:
                break;
        }
    }
    public void usar_habilidad(int portador, int habilidad, int objetivo){//usar habilidades
        String nombre_habilidad = combatientes.get(portador).getHabilidad(habilidad);//buscar el nombre de la habilidad
        switch (nombre_habilidad) {//habilidades normales:
            case "Veneno":
                combatientes.get(objetivo).dismunuir_vida(80);
                break;
            case "Fuerza":
                combatientes.get(objetivo).aumentar_atq(25);
                break;
            case "Curacion":
                combatientes.get(objetivo).aumentar_vida(50);
                break;//habilidades de jefe: (1 uso)
            case "Veneno refinado":
                combatientes.get(objetivo).dismunuir_vida(160);
                combatientes.get(portador).eliminar_habilidad(habilidad);
                break;
            case "Fuerza de la muerte":
                combatientes.get(objetivo).aumentar_atq(75);
                combatientes.get(portador).eliminar_habilidad(habilidad);
                break;
            case "Curacion ancestral":
                combatientes.get(objetivo).aumentar_vida(175);
                combatientes.get(portador).eliminar_habilidad(habilidad);
                break;
            default:
                break;
        }
    }

}
