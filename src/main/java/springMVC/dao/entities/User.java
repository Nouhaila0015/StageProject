package springMVC.dao.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(nullable = false, length = 45)
    private String username;

    private String password;
    private String info;
    private String info2;
    private String lastname;
    private String firstname;
    private String fullName;
    private String id_photo;
    private String status;

    @Column(columnDefinition = "bit(1)")
    private Boolean enabled;
    
    private String gender;
    private String phone;
    private String job;

    @Column(name = "account_non_locked", columnDefinition = "bit(1)")
    private Boolean accountNonLocked;

    @Column(columnDefinition = "bit(1)")
    private Boolean active;

    private LocalDate birthday;
    private String cin;
    private String company;
    private String company_type;

    @Column(name = "contract_active", columnDefinition = "bit(1)")
    private Boolean contractActive;

    private Integer count_files;
    private LocalDateTime date;
    private Integer er_id;
    private Integer failed_attempt;

    @Column(columnDefinition = "bit(1)")
    private Boolean iexpense;

    @Column(columnDefinition = "bit(1)")
    private Boolean ilogistics;

    @Column(columnDefinition = "bit(1)")
    private Boolean internal;

    private LocalDateTime lock_time;
    private String login;
    private Integer mer_id;

    @Column(columnDefinition = "bit(1)")
    private Boolean myhr;

    @Column(columnDefinition = "bit(1)")
    private Boolean mytools;

    private String phone2;

    @Column(columnDefinition = "bit(1)")
    private Boolean sdm;

    private Integer customer_idcustomer;
    private Integer supplier_idsupplier;
    private Integer transporter_id;
    private String user_username;

    @Column(columnDefinition = "bit(1)")
    private Boolean vpn_access;

    private Integer company_idcompany;
    private String other;

    @Column(columnDefinition = "bit(1)")
    private Boolean ibuy;

    @Column(columnDefinition = "bit(1)")
    private Boolean is_using2fa;

    private String secret;
    private String last_app;
    private LocalDateTime last_online_date;
    private String verification_code;

}
