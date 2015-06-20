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


import java.io.Serializable;

public class PelotaRectilinea extends Pelota implements Serializable {

    private int maxY;

    public PelotaRectilinea(int x0, int y0, int maxY) {
        super(x0, y0);
        this.maxY = maxY;
    }

    @Override
    public void calcularPosicion(double tiempo) {
        if (y > maxY) {
            setPosicionesIniciales(x0, maxY);
            lanzar(0, -vy);
        } else if (y < 0) {
            setPosicionesIniciales(x0, 0);
            lanzar(0, -vy);
        } else {
            x = (int) (vx * tiempo + x0);
            y = (int) (vy * tiempo + y0);
        }
        ractangulo.x=this.x;
        ractangulo.y=this.y;
    }
    

    public int getMaxY() {
        return maxY;
    }
}
