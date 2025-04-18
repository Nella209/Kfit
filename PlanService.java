/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kfit.service;
import com.kfit.domain.Plan;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Karol
 */
public interface PlanService {
    
    List<Plan> listaPlan = new ArrayList<>();
    
    public List<Plan> gets();
    
    
    //Se recupera el registro que tiene el idItem pasado por parámetro
    //si no existe en la tabla se retorna null
    public Plan get(Plan plan);
    
    //Se elimina el registro que tiene el idItem pasado por parámetro
    public void delete(Plan plan);
    
    //Si el objeto item tiene un idItem que existe en la tabla item
    //El registro de actualiza con la nueva información
    //Si el idItem NO existe en la tabla, se crea el registro con esa información
    public void save(Plan plan);
    
    public void actualiza(Plan plan);
    
    public void facturar();
}
    

