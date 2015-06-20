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

public class PelotaParabolica extends Pelota implements Serializable {

    public PelotaParabolica(int x0, int y0) {
        super(x0, y0);
    }

    @Override
    public void calcularPosicion(double tiempo) {
        x = (int) (vx * tiempo + x0);
        y = (int) ((0.5) * 9.8 * tiempo * tiempo - vy * tiempo + y0);
        if(x>=1000 || y<=0 || y>=550 || x<-1){
            x=x0;
            y=y0;
        }
        ractangulo.x=this.x;
        ractangulo.y=this.y;

    }
}
