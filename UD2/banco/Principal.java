package UD2.banco;

import java.util.*;

public class Principal {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        int op = 0;
        while (op != 4) {
            op = menu();
            switch (op) {
                case 1:
                    altaCuenta(cuentas);
                    break;
                case 2:
                    informacionCuenta(cuentas);
                    break;
                case 3:
                    sacarDinero(cuentas);
                    break;
            
            }
        }
        System.out.println("chao chao chao chao");
    }

    public static int menu(){
        int op = 0;
        System.out.println("---------------------------");
        System.out.println("1- Dar de alta una cuenta");
        System.out.println("2- Resumen de las cuentas");
        System.out.println("3- Sacar dinero de una cuenta");
        System.out.println("4- Salir");
        System.out.println("---------------------------");

        op = sc.nextInt();
        return op;
        
    }

    public static void altaCuenta(ArrayList<Cuenta> cuentas){
        Cuenta cuenta = new Cuenta();
        int benef, edad;
        char nacionalidad;
        String name;
        System.out.println("Dime el numero de beneficiciarios de la cuenta");
        benef = sc.nextInt();

        for (int i = 1; i <= benef; i++) {
            sc.nextLine();
            System.out.println("Como se llama el beneficiario "+i);
            name = sc.nextLine();
            System.out.println("Que edad tiene el beneficiario "+i);
            edad = sc.nextInt();
            System.out.println(name+ " tiene la nacionalidad espanola?(s/n)");
            nacionalidad = sc.next().charAt(0);

            Cliente cliente = new Cliente(name, edad, nacionalidad);
            cuenta.addBeneficiario(cliente);
        }
        cuentas.add(cuenta);
        
    }


    public static void informacionCuenta(ArrayList<Cuenta> cuentas){
        System.out.println("*** Informacion global de las cuentas ***");
        for (Cuenta cuenta : cuentas) {
            cuenta.infoCuenta();
        }
        System.out.println("");
    }

    public static void sacarDinero(ArrayList<Cuenta> cuentas){
        boolean cuentaExists = false;
        int id;
        Cuenta cuenta = null;
        SacarDinero h = null;
        
        while (!cuentaExists) {
            System.out.println("Dime el id del que quieres sacar dinero");
            id = sc.nextInt();
            sc.nextLine();

            for (Cuenta cuentaux : cuentas) {

                if(cuentaux.getIdCuenta() == id){
                    cuenta = cuentaux;
                    cuentaExists = true;
                    break;
                }
            }
            if (!cuentaExists) {
                System.out.println("No existe la cuenta "+id);
            }
        }

        ArrayList<Cliente> listaClientes = cuenta.getClientes();
        for (int i = 0; i < listaClientes.size(); i++) {
            h = new SacarDinero(listaClientes.get(i).getNombre(), cuenta);
            h.start();
        }

        try {
            h.join();
        } catch (Exception e) {
        }


    }

    
}
