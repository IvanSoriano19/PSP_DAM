package UD2.banco;

import java.util.ArrayList;

public class Cuenta extends Thread{
    
    private int idCuenta;
    static int idGlobal = 0;
    private ArrayList<Cliente> clientes;
    private int saldo;
    private boolean deuda;

    public Cuenta() {
        idGlobal++;
        idCuenta = idGlobal;
        clientes = new ArrayList<Cliente>();
        saldo = 100;
        deuda = false;
        System.out.println("Daremos de alta la cuenta "+idCuenta);
    }

    public void addBeneficiario(Cliente c){
        clientes.add(c);
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public boolean getDeuda(){
        return deuda;
    }

    public void infoCuenta(){
        if (!deuda) {
            System.out.println("CUENTA "+idCuenta+": cuenta ACTIVA, el saldo es de "+getSaldo()+"€");
        } else {
            System.out.println("CUENTA "+idCuenta+": cuenta ENDEUDADA, el saldo es de "+getSaldo()+"€");
        }
        System.out.println("Beneficiarios de la cuenta");
        for (Cliente cliente : clientes) {
            cliente.info_cliente();
        }
    }

    public synchronized void sacarDinero(int cantidad, String nombre){
        if (getSaldo() >= cantidad) {
            System.out.println(nombre+" : va a retirar dinero. Saldo actual es de "+getSaldo()+"€");

            try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {

            }
            saldo -= cantidad;
            System.out.println("\t"+nombre+" acaba de retirar "+cantidad+"€ .\n\tSaldo disponible "+getSaldo());

        } else {
            System.out.println(nombre+" no puedes sacar dinero porque tu saldo es 0");
        }

        if (getSaldo() < 0) {
            System.out.println("Tu saldo es negativo "+getSaldo());
            deuda = true;
        }
    }

}
