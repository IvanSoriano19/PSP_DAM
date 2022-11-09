package UD2.ejercicio33;

public class Speed extends Thread {

    private Autobus autobus;
    private String accion;

    public Speed(Autobus autobus, String accion) {
        this.autobus = autobus;
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public void run() {

        boolean infinite = true;

        int newSpeed = 0;
        int busSpeed = 0;

        synchronized (autobus) {
            while (infinite) {
                busSpeed = autobus.getVelocidad();
                newSpeed = (int) (Math.random() * 10);

                if (accion.equals("acelerar")) {

                    if (busSpeed < 80) {

                        busSpeed += newSpeed;
                        autobus.setVelocidad(busSpeed);

                        System.out.println("El bus esta acelerando "+newSpeed+"Km/h. Ahora la velocidad es de "+busSpeed+"Km/h.");

                        try {
                            sleep(1000);
                        } catch (Exception e) {
                        }
                    }else{
                        autobus.notify();
                        try {
                            autobus.wait();
                        } catch (Exception e) {
                        }
                    }

                } else {
                    if (busSpeed > 50) {

                        busSpeed -= newSpeed;
                        autobus.setVelocidad(busSpeed);

                        System.out.println("El bus esta frenando "+newSpeed+"Km/h. Ahora la velocidad es de "+busSpeed+"Km/h.");
                        try {
                            sleep(1000);
                        } catch (Exception e) {
                        }
                    }else{
                        autobus.notify();
                        try {
                            autobus.wait();
                        } catch (Exception e) {
                        }
                    }
                }
            }

        }
    }

}
