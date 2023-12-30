package tn.patient.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Patient implements Serializable {
    public enum Genre{
        Homme,Femme
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPatient;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String maladie;
    private String addresse;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int numeroTelephone;

}
