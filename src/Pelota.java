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


import java.awt.Rectangle;
import java.io.Serializable;

public abstract class Pelota extends Thread implements Serializable {

    protected int x, y;
    protected int x0, y0;
    protected double vx, vy;
    protected double tiempo;
    protected boolean parar;
    Rectangle ractangulo;

    public Pelota(int x0, int y0) {
        setPosicionesIniciales(x0, y0);
    }

    public void setPosicionesIniciales(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;
        this.x = x0;
        this.y = y0;
        ractangulo=new Rectangle(x0, y0, 20, 20);
        parar = true;
    }

    public void lanzar(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
        tiempo = 0;
        parar = false;
    }

    public abstract void calcularPosicion(double tiempo);

    @Override
    public void run() {
        while (true) {
            try {
                
                if (!parar) {
                    tiempo += 0.1;
                    calcularPosicion(tiempo);
                }
                
                Thread.sleep(20);
                
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public boolean Colision(Pelota p1){
        return getRectangulo().intersects(p1.getRectangulo());
    }
    
    

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setVy(double vy) {
        this.vy = vy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isParar() {
        return parar;
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    public int getY0() {
        return y0;
    }
    public Rectangle getRectangulo(){
        return ractangulo;
    }

}
