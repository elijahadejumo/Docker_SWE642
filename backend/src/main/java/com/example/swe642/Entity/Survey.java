package com.example.swe642.Entity;


import java.time.LocalDate;

// import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "students")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

   // REQUIRED text fields
    @NotBlank(message = "First name is required")
    @Column
    private String first_name;

    @NotBlank(message = "Last name is required")
    @Column
    private String last_name;

    @NotBlank(message = "Street address is required")
    @Column
    private String street_address;

    @NotBlank(message = "City is required")
    @Column
    private String city;

    @NotBlank(message = "State is required")
    @Column
    private String state;

    @NotBlank(message = "Zip is required")
    @Column
    private String zip;

    @NotBlank(message = "Telephone is required")
    @Column
    private String telephone;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column
    private String email;
    
    @NotNull(message = "Date of survey is required")
    @Column
    private LocalDate date_of_survey;

    // Checkboxes – what they liked most (each is a separate checkbox)
    @Column
    private Boolean  liked_students;

    @Column
    private Boolean liked_location;

    @Column
    private Boolean liked_campus;

    @Column
    private Boolean liked_atmosphere;

    @Column
    private Boolean liked_dorm_rooms;

    @Column
    private Boolean liked_sports;

    // Radio buttons – how they became interested
    // values can be: "friends", "television", "internet", "other"
    @Column
    private String how_interested;

    // Dropdown – likelihood of recommending school
    // values: "Very Likely", "Likely", "Unlikely"
    @Column
    private String likelihood_recommend;

    // Text area – additional comments
    @Lob
    @Column
    private String comments;

    public Survey() {
    }

    // You can keep a shorter constructor or add a full one if you want
    public Survey(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate_of_survey() {
        return date_of_survey;
    }

    public void setDate_of_survey(LocalDate date_of_survey) {
        this.date_of_survey = date_of_survey;
    }

    public Boolean isLiked_students() {
        return liked_students;
    }

    public void setLiked_students(boolean liked_students) {
        this.liked_students = liked_students;
    }

    public Boolean isLiked_location() {
        return liked_location;
    }

    public void setLiked_location(boolean liked_location) {
        this.liked_location = liked_location;
    }

    public Boolean isLiked_campus() {
        return liked_campus;
    }

    public void setLiked_campus(boolean liked_campus) {
        this.liked_campus = liked_campus;
    }

    public Boolean isLiked_atmosphere() {
        return liked_atmosphere;
    }

    public void setLiked_atmosphere(boolean liked_atmosphere) {
        this.liked_atmosphere = liked_atmosphere;
    }

    public Boolean isLiked_dorm_rooms() {
        return liked_dorm_rooms;
    }

    public void setLiked_dorm_rooms(boolean liked_dorm_rooms) {
        this.liked_dorm_rooms = liked_dorm_rooms;
    }

    public Boolean isLiked_sports() {
        return liked_sports;
    }

    public void setLiked_sports(boolean liked_sports) {
        this.liked_sports = liked_sports;
    }

    public String getHow_interested() {
        return how_interested;
    }

    public void setHow_interested(String how_interested) {
        this.how_interested = how_interested;
    }

    public String getLikelihood_recommend() {
        return likelihood_recommend;
    }

    public void setLikelihood_recommend(String likelihood_recommend) {
        this.likelihood_recommend = likelihood_recommend;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Survey [id=" + id
                + ", first_name=" + first_name
                + ", last_name=" + last_name
                + ", street_address=" + street_address
                + ", city=" + city
                + ", state=" + state
                + ", zip=" + zip
                + ", telephone=" + telephone
                + ", email=" + email
                + ", date_of_survey=" + date_of_survey
                + ", liked_students=" + liked_students
                + ", liked_location=" + liked_location
                + ", liked_campus=" + liked_campus
                + ", liked_atmosphere=" + liked_atmosphere
                + ", liked_dorm_rooms=" + liked_dorm_rooms
                + ", liked_sports=" + liked_sports
                + ", how_interested=" + how_interested
                + ", likelihood_recommend=" + likelihood_recommend
                + ", comments=" + comments
                + "]";
    }
}