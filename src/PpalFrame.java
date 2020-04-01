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


import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PpalFrame extends JFrame {

    private final Panel panel;
    private final int tamanioX, tamanioY;

    public PpalFrame() {
        super("Cannonball");
        setLayout(null);
        setSize(1002, 590);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar en pantalla
        setVisible(true); //Colocar visible
        tamanioX = 1000;
        tamanioY = 550;

        panel = new Panel();
        //Como el layout es null se le debe dar posicion X, Y y tamaños
        panel.setBounds(0, 0, tamanioX, tamanioY);
        add(panel);
    }
}
