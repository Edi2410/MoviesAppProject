/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.models;

/**
 *
 * @author egraedi
 */
public class People {
    private Integer Id;
    private String Name;

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public People() {
    }

    public People(Integer Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }
}
