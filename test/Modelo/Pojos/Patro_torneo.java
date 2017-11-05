/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Pojos;

/**
 *
 * @author Villa
 */
public class Patro_torneo {
    private String torneo;
    private String patrocinador;

    public Patro_torneo() {
    }

    public Patro_torneo(String torneo, String patrocinador) {
        this.torneo = torneo;
        this.patrocinador = patrocinador;
    }

    /**
     * @return the torneo
     */
    public String getTorneo() {
        return torneo;
    }

    /**
     * @param torneo the torneo to set
     */
    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    /**
     * @return the patrocinador
     */
    public String getPatrocinador() {
        return patrocinador;
    }

    /**
     * @param patrocinador the patrocinador to set
     */
    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }
}
