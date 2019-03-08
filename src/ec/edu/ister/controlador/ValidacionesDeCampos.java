/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.controlador;

/**
 *
 * @author Registro Automoviles-....
 */
public class ValidacionesDeCampos {
    public void enteros(java.awt.event.KeyEvent evt) { 
        char c=evt.getKeyChar();
        if (c<'0' || c>'9')evt.consume();{
        }
    }
    public void flotanes(java.awt.event.KeyEvent evt) { 
        char c=evt.getKeyChar();
        if ((c<'0' || c>'9') && c != '.')evt.consume();{ 
        }
    }
    public void alfabeticos(java.awt.event.KeyEvent evt) { 
        char c = evt.getKeyChar();
        if ((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' ' || c>' ' )) evt.consume(); {
        }
    }
        
}
