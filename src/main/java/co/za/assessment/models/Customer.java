package co.za.assessment.models;
/*
created by mumakhado on 2021/03/04
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "customerNumber")
    private String customerNumber;

    @Column(name = "statusActive")
    private boolean statusActive;

}
