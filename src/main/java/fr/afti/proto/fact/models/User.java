package fr.afti.proto.fact.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Created by khelou on 15/02/17.
 */
@Entity
public class User {

    @Id
    private String email;

    @NotNull
    private String nomUtilisateur;

    @NotNull
    private Date dateInscription;

    @NotNull
    private long nbSoireeOrganisee;

    @NotNull
    private float noteGenerale;

    public User(String aEmail, String aNomUtilisateur)
    {
        email = aEmail;
        nomUtilisateur = aNomUtilisateur;
        /*
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43*/

        // Mysql datetime format
        dateInscription = new Date();
        nbSoireeOrganisee = 0;
        noteGenerale = 0;
       /* DateFormat mysqlDateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateInscription = new java.util.Date();
        dateInscription = SystemClockFactory.getDatetime();*/

    }

    public User(){
        // Only JPA
    }

    public String getUserEmail()
    {
        return email;
    }

    public String getUserName()
    {
        return nomUtilisateur;
    }

    public Date getDateInscription()
    {
        return dateInscription;
    }

    public long getNbSoireeOrganisee()
    {
        return nbSoireeOrganisee;
    }

    public float getNoteGenerale()
    {
        return  noteGenerale;
    }
}
