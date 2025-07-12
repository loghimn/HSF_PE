package sum25.longvtse184610.pehsf302trialexamse184610.pojo;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int acountId;

    @Column(name = "Email", columnDefinition = "NVARCHAR(50)", nullable = false, length = 50)
    private String email;

    @Column(name = "Password", columnDefinition = "NVARCHAR(50)", nullable = false, length = 50)
    private String password;

    @Column(name = "RoleID", nullable = false, length = 50)
    private int roleID;

    public Accounts() {
    }

    public Accounts(String email, String password, int roleID) {
        this.email = email;
        this.password = password;
        this.roleID = roleID;
    }

    public int getAcountId() {
        return acountId;
    }

    public void setAcountId(int acountId) {
        this.acountId = acountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
