package tn.esprit.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tn.esprit.entites.Logement;
import tn.esprit.entites.Logement.Type;
import tn.esprit.entites.RendezVous;;
public class LogementBusiness {
	
	private List<Logement> logements;

	
	public LogementBusiness() {
		logements=new ArrayList<Logement>();
		logements.add(new Logement(1,"27, Rue des roses", "El ghazela","Ariana",Type.Studio,"cuisine equipee",300f));
		logements.add(new Logement(5,"58, Rue des roses", "El ghazela","Ariana",Type.EtageVilla,"cuisine equipee",450f));
		logements.add(new Logement(2,"201, Residence Omrane4", "Riadh El Andalous","Ariana",Type.Appartement,"chauffage central, ascenseur, climatisation",700f));
		logements.add(new Logement(3,"540, Residence Les Tulipes", "El Aouina","Ariana",Type.Appartement,"S+2, chauffage central, ascenseur, climatisation",500f));
		logements.add(new Logement(4,"78, Rue des Oranges", "Bardo","Tunis",Type.EtageVilla,"chauffage central, ascenseur, climatisation",400f));
	}

	public boolean addLogement(Logement logement){
		//int refLogement=logement.getReference();
	//	for (Logement l:logements){
			//if(l.getReference()!=refLogement)
				logements.add(logement);
		return true;
		//	}

	}

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}
	
	public Logement getLogementsByReference(int reference){
		
		for (Logement l:logements){
			if(l.getReference()==reference)
				return l;
		}
		return null;
	}
	
	public List<Logement> getLogementsByDeleguation(String deleguation){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getDeleguation().equals(deleguation))
				liste.add(l);
		}
		return liste;
	}

	public boolean deleteLogement(int ref){
		Iterator<Logement> iterator=logements.iterator();
		while(iterator.hasNext()){
			Logement l=iterator.next();
			if(l.getReference()==ref){
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	public boolean updateLogement(int ref, Logement logement){
		for(Logement l:logements){
			if(l.getReference()==ref){
				int index=logements.indexOf(logement);
				logements.set(index, logement);
				return true;
			}
		}
		return false;
	}

	public List<Logement> getLogementsByGouvernorat(String gouvernorat){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getGouvernorat().equals(gouvernorat))
				liste.add(l);
		}
		return liste;
	}
	
	public List<Logement> getLogementsByType(Type type){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getType().equals(type))
				liste.add(l);
		}
		return liste;
	}
	
	public List<Logement> getLogementsByPrix(float prix){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getPrix()<=prix)
				liste.add(l);
		}
		return liste;
	}
	

}
