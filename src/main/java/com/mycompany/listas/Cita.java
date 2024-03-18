
package com.mycompany.listas;


public class Cita {
    private String especialidadRequerida;
    private String profesionalAsignado;
    private enum motivoDeLaCita{Valoracion, Examen, Control}

    public Cita(String especialidadRequerida, String profesionalAsignado) {
        this.especialidadRequerida = especialidadRequerida;
        this.profesionalAsignado = profesionalAsignado;
    }

    public String getEspecialidadRequerida() {
        return especialidadRequerida;
    }

    public void setEspecialidadRequerida(String especialidadRequerida) {
        this.especialidadRequerida = especialidadRequerida;
    }

    public String getProfesionalAsignado() {
        return profesionalAsignado;
    }

    public void setProfesionalAsignado(String profesionalAsignado) {
        this.profesionalAsignado = profesionalAsignado;
    }

    
}
