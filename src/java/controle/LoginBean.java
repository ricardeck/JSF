/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.DAOUsuario;
import DAO.DAOUsuarioDerby;
import com.sun.faces.facelets.util.Path;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Usuario;

/**
 *
 * @author ManoelNeto
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    private Usuario usuario;

    public LoginBean() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void logarPF(ActionEvent ev){
        
        String message;
        DAOUsuario dao = new DAOUsuarioDerby();
        try {
//          if(dao.Logar(this.getUsuario())){
            if(this.getUsuario().getLogin().equalsIgnoreCase("ze") && this.getUsuario().getSenha().equalsIgnoreCase("1234")){
                message = "Login efetuado com sucesso!!!";
            }else{
                message = "Problemas ao realizar o login do usuário: " + this.getUsuario().getLogin();
            }
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD!!!"+ex;
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("LoginPF", message));
    }
    
    public void logarPJ(ActionEvent ev){
        
        String message;
        DAOUsuario dao = new DAOUsuarioDerby();
        try {
//          if(dao.Logar(this.getUsuario())){
            if(this.getUsuario().getLogin().equalsIgnoreCase("admin") && this.getUsuario().getSenha().equalsIgnoreCase("1234")){
                message = "Login efetuado com sucesso!!!";
            }else{
                message = "Problemas ao realizar o login do usuário: " + this.getUsuario().getLogin();
            }
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD!!!"+ex;
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("LoginPJ", message));
    }
    
    public void getIMC(ActionEvent ev){
        
        String message;
//        DAOUsuario dao = new DAOUsuarioDerby();
        try {
//          if(dao.Logar(this.getUsuario())){
          message = this.getUsuario().getIMC();
            
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD!!!"+ex;
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("IMC", message));
    }
        
    
}
