package ExamenPrimeraEv;

import java.util.ArrayList;

public class Bolsa {

    ArrayList<Patata> bolsaPatatas = new ArrayList<Patata>();

    public void addPatatas(Patata patata){
        if (!estadoBolsa()) {
            bolsaPatatas.add(patata);
        }
    }


    public boolean estadoBolsa(){
        if (getSize() == 5) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize(){
        return bolsaPatatas.size();
    }
}
