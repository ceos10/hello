package com.project.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;

import com.project.entities.comercio;
import com.project.utils.*;
@ManagedBean(name = "buscarBean")
@ViewScoped
public class BuscarBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private comercio selectedComerce;
	private String url_mapa;
	private String seleccion="rubro";
	private String entrada="";
	private List<comercio> coles=new ArrayList<comercio>();	
	private Session session = HibernateUtil.getSessionFactory().openSession();

	public List<comercio> getUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<comercio>  ListComercio = session.createCriteria(comercio.class).list();
        return ListComercio;
    }
	
	public String getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public comercio getSelectedComerce() {
		return selectedComerce;
	}

	
	public void setSelectedComerce(comercio selectedComerce) {
		this.selectedComerce = selectedComerce;
		if(selectedComerce!=null) {
			this.url_mapa = "http://maps.google.com/maps/api/staticmap?center="+selectedComerce.getGeo_y()+","+selectedComerce.getGeo_x()+"&zoom=16&markers=color:purple|label:D|"+selectedComerce.getGeo_y()+","+selectedComerce.getGeo_x()+"&size=400x300&sensor=TRUE_OR_FALSE";
		}
	}

	public String getUrl_mapa() {		
		return this.url_mapa;
	}

	public void setUrl_mapa(String url_mapa) {
		this.url_mapa = url_mapa;
	}
	
	public List<comercio> getColes() {
		return coles;
	}

	public void setColes(List<comercio> coles) {
		this.coles = coles;
	}
	
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	
	public void addMessage(String p) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontraron"+p,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	@PostConstruct
	public void mostrartodo(){
		coles = session.createCriteria(comercio.class).list();
		selectedComerce = coles.get(0);
	}
	
	public void filtrar(){
		
		boolean flag=true;
		
		if(seleccion.equals("rubro")){
		
			coles = session.createCriteria(comercio.class).add( Restrictions.like("giro", "%"+entrada+"%")).list();
		}
		else{
		
			if(entrada.isEmpty()){
				
				coles = session.createCriteria(comercio.class).add( Restrictions.like("giro", "%"+entrada+"%")).list();
			}
			else{
				
				for(int i=0;i<entrada.length();i++){
					
					if(!Character.isDigit(entrada.charAt(i))){
						
						flag=false;
					}
				}
				
				if(flag){
					
					int ent=Integer.parseInt(entrada);
					coles = session.createCriteria(comercio.class).add( Restrictions.eq("id", ent)).list();
				}
				else{
					
					coles = session.createCriteria(comercio.class).add( Restrictions.eq("id", 0)).list();
				}
			}
		}
		if(coles.size()!=0){
			selectedComerce = coles.get(0);
		}
		
	}
	
	
}