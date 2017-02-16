package fr.afti.proto.fact.controllers;

import fr.afti.proto.fact.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by khoya on 15/02/17.
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // URi to create a user
    @PostMapping("/create/{aEmail}/{aNomUtilisateur}")
    public String create(@PathVariable String aEmail, @PathVariable String aNomUtilisateur)
    {
        try{
            User newUser = new User(aEmail, aNomUtilisateur);
            userRepository.saveAndFlush(newUser);

        }
        catch (Exception ex)
        {
            return "Error when trying to create a user";
        }
        return "User successfully created";
    }

    /*
    GET METHOD WHICH WORK
    @GetMapping("/index/{mail}")
    public String index(@PathVariable String mail)
    {
        return "Hello it's the index page Email = " + mail;
    }*/

    // TODO :  return json with jackson2
    @GetMapping("user/{mail}")
    public @ResponseBody String getUserByMail(@PathVariable String mail)
    {
        String email;
        String userName;
        long nbSoireeOrganisee;
        Date date_inscription;
        float noteGeneral;
        User userResult;
        String res;

        try {
            res = userRepository.findUserByMail(mail);
            /*userResult = userRepository.findByEmail(mail);
            email = userResult.getUserEmail();
            userName = userResult.getUserName();
            nbSoireeOrganisee = userResult.getNbSoireeOrganisee();
            date_inscription = userResult.getDateInscription();
            noteGeneral = userResult.getNoteGenerale();*/
        }
        catch (Exception ex) {
            return "FAIL GETTING USER : " + ex.getMessage();
        }
        //return "Mail : " + email + " - Nom Utilisateur : " + userName + " - NbSsoireeOrganisee : " + nbSoireeOrganisee + " - Date d'inscription : " + date_inscription + " - Note générale : " + noteGeneral;
        return res;
    }

    @DeleteMapping("/users/delete/{mail}")
    @ResponseBody
    public String delete(String mail)
    {
        try
        {
            //userRepository.delete
            //userRepository.deleteAll();
            userRepository.delteUserById(mail);
        }
        catch (Exception e){
            return e.getMessage();
        }
        return "deletion successful";
    }
}
