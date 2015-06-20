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


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Panel extends javax.swing.JPanel implements Runnable {

    public static final int tamanioX = 1000, tamanioY = 550;
    private int xLinea, yLinea;
    private Juego juego;
    private boolean lanzamiento = false;
    private int campo1;
    private boolean activado = true;
        
    JLabel puntaje1 = new JLabel("0");
    JLabel puntaje2 = new JLabel("0");
    
    public Panel() {
        setBackground(new Color(0, 0, 0, 50));
        super.setLayout(null);
        
        juego = new Juego(tamanioX, tamanioY);
        puntaje1.setBounds(0, 25, 250, 75);
        puntaje2.setBounds(tamanioX - 250, 25, 250, 75);
        puntaje1.setHorizontalAlignment(JLabel.CENTER);
        puntaje2.setHorizontalAlignment(JLabel.CENTER);
        puntaje1.setFont(new Font("Courier New", Font.ITALIC, 36));
        puntaje2.setFont(new Font("Courier New", Font.ITALIC, 36));        
        puntaje1.setForeground(new Color(0, 163, 255, 25));
        puntaje2.setForeground(new Color(0, 163, 255, 25));
        
        this.add(puntaje1);
        this.add(puntaje2);
        
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                if (juego != null) {
                    xLinea = e.getX();
                    yLinea = e.getY();
                }                
            }

        });
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (juego != null) {
                    if ((juego.getPelota1().getX() == juego.getPelota1().getX0())) {

                        if (xLinea > campo1 && xLinea != 0) {
                            yLinea = (((yLinea - tamanioY) * campo1) / (xLinea)) + (tamanioY);
                            xLinea = campo1;
                            juego.lanzar(xLinea, yLinea);
                        } else {
                            juego.lanzar(xLinea, yLinea);
                        }
                    }

                    lanzamiento = true;
                }

            }
        });

        new Thread(this).start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
            super.paintComponent(g);
            g.setColor(new Color(92, 92, 92, 10));
            g.fillRect(0, 0, campo1, tamanioY);
            g.setColor(new Color(0, 163, 255));

                if (xLinea > campo1 && xLinea != 0) {
                    yLinea = ((campo1 * (yLinea - tamanioY)) / xLinea) + tamanioY;
                    xLinea = campo1;
                    g.drawLine(0, tamanioY, xLinea, yLinea);
                } else {
                    g.drawLine(0, tamanioY, xLinea, yLinea);
                }
            
            if (juego != null) {
                
                g.setColor(new Color(0, 163, 255));
                g.fillOval(juego.getPelota1().getX() - 10, juego.getPelota1().getY() - 10, 20, 20);
//                g.setColor(Color.CYAN);
                g.fillOval(juego.getPelota2().getX() - 10, juego.getPelota2().getY() - 10, 20, 20);
                g.setColor(Color.RED);
                g.fillOval(juego.getPelota3().getX() - 10, juego.getPelota3().getY() - 10, 20, 20);
                
                campo1 = juego.getPelota3().getX() / 2;
                
                if ((juego.getPelota1().Colision(juego.getPelota3())) && lanzamiento) {
                    juego.incCount1();
                    
                    lanzamiento = false;
                    int posicion = juego.getPelota3().getX0() + 20;
                    int posicionY = juego.getPelota3().getY();
                    juego.recrearPelota(posicion, posicionY);
                } else if ((juego.getPelota2().Colision(juego.getPelota3())) && lanzamiento) {
                    juego.incCount2();
                    int posicion = juego.getPelota3().getX0() - 20;
                    int posicionY = juego.getPelota3().getY();
                    juego.recrearPelota(posicion, posicionY);
                }
                
                puntaje1.setText(Integer.toString(juego.getCount1()));
                puntaje2.setText(Integer.toString(juego.getCount2()));
            }
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
