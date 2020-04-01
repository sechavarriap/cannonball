/*
 * Copyright (C) 2015 sechavarriap
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * @author Santiago Echavarria Puerta
 */

public class Juego extends Thread{
    
    private Pelota pelota1, pelota2, pelota3;    
    private final int tamanioX, tamanioY;
    private int count1 = 0, count2 = 0;
    private boolean comenzar = false;
    
    public Juego(int tamanioX, int tamanioY){
        super();
        this.comenzar = true;
        this.tamanioX = tamanioX;
        this.tamanioY = tamanioY;
        pelota1 = new PelotaParabolica(0, tamanioY);
        pelota2 = new PelotaParabolica(tamanioX, tamanioY);
        pelota3 = new PelotaRectilinea((int) (0.5 * tamanioX), (int) (0.5 * tamanioY), tamanioY);
        pelota1.start();
        pelota2.start();
        pelota3.start();
        pelota3.lanzar(0, 30);
    }
    
    public void lanzar(int xLinea, int yLinea){
        pelota1.lanzar(0.5 * xLinea, 0.5 * (tamanioY - yLinea));
    }
    
    public void recrearPelota(int posicion, int posicionY){
        pelota3.setX0(posicion);
        pelota3.setVy(pelota3.vy * 1.3);
    }
    
    public int getCount1(){
        return count1;
    }
    
    public int getCount2(){
        return count2;
    }
    
    public void incCount1(){
        count1++;
    }

    public void incCount2(){
        count2++;
    }    
    
    public boolean isComenzar() {
        return comenzar;
    }

    public void setComenzar(boolean comenzar) {
        this.comenzar = comenzar;
    }
    
    public Pelota getPelota1() {
        return pelota1;
    }

    public void setPelota1(Pelota pelota1) {
        this.pelota1 = pelota1;
    }

    public Pelota getPelota2() {
        return pelota2;
    }

    public void setPelota2(Pelota pelota2) {
        this.pelota2 = pelota2;
    }

    public Pelota getPelota3() {
        return pelota3;
    }

    public void setPelota3(Pelota pelota3) {
        this.pelota3 = pelota3;
    }
}
