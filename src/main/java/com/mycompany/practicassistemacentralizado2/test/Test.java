
package com.mycompany.practicassistemacentralizado2.test;

import com.mycompany.practicassistemacentralizado2.controllers.ProductoJpaController;
import com.mycompany.practicassistemacentralizado2.entidades.Producto;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//PRUEBA
public class Test {


    public static void main(String[] args) {
          //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXIÓN 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
        // LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXIÓN
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        //CREAMOS UN NUEVO PRODUCTO
        Producto p = new Producto();

        p.setNombre("AUDIFONOS");
        Double d1 = 10.99;
        BigDecimal bd1 = BigDecimal.valueOf(d1.doubleValue());
        p.setPrecio(bd1);
      
        try {
            pjc.create(p);
            //pjc.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
    }
    
}
