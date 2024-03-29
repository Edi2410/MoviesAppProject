/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.models;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egraedi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
    @XmlElement
    private int id;
    @XmlElement
    private String Title;
    @XmlElement
    private String Description;
    @XmlElement
    private String Duration;   
    @XmlElement
    private String PhotoPath;
    @XmlElementWrapper
    @XmlElement(name = "actors")
    private List<People> Actors;

    public void setActors(List<People> Actors) {
        this.Actors = Actors;
    }

    public void setDirectors(List<People> Directors) {
        this.Directors = Directors;
    }

    public List<People> getActors() {
        return Actors;
    }

    public List<People> getDirectors() {
        return Directors;
    }
    @XmlElementWrapper
    @XmlElement(name = "director")
    private List<People> Directors;


    
    public Movie(int id, String Title, String Description, String Duration, String PhotoPath, List<People> Actors, List<People> Directors) {
        this.id = id;
        this.Title = Title;
        this.Description = Description;
        this.Duration = Duration;
        this.PhotoPath = PhotoPath;
        this.Actors = Actors;
        this.Directors = Directors;
    }

    public Movie(int id, String Title, String Description, String Duration, String PhotoPath) {
        this.id = id;
        this.Title = Title;
        this.Description = Description;
        this.Duration = Duration;
        this.PhotoPath = PhotoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.PhotoPath = photoPath;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public Movie() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDuration(String duration) {
        this.Duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", Title=" + Title + ", Description=" + Description + ", Duration=" + Duration + ", PhotoPath=" + PhotoPath + ", Actors=" + Actors + ", Directors=" + Directors + '}';
    }

    public String getDuration() {
        return Duration;
    }


}
