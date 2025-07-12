package sum25.longvtse184610.pehsf302trialexamse184610.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "Directors")
public class Directors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "DirectorName", columnDefinition = "NVARCHAR(50)", nullable = false, length = 100)
    private String directorName;

    @Column(name = "Nationality", columnDefinition = "NVARCHAR(50)", nullable = false, length = 150)
    private String nationality;

    public Directors() {
    }

    public Directors(String directorName, String nationality) {
        this.directorName = directorName;
        this.nationality = nationality;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
