package com.example.courtcasemanagementsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="courts")
public class CourtDetails {

    private String courtName;
    
    @Id
    private int courtId;
    private String city;
    private String state;
    private List<Integer> cases;

    @Override
    public String toString() {
        return "CourtDetails{" +
                "courtName='" + courtName + '\'' +
                ", courtId=" + courtId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cases=" + cases +
                '}';
    }

    public CourtDetails(String courtName, int courtId, String city, String state, List<Integer> cases) {
        this.courtName = courtName;
        this.courtId = courtId;
        this.city = city;
        this.state = state;
        this.cases = cases;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
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

    public List<Integer> getCases() {
        return cases;
    }

    public void setCases(List<Integer> cases) {
        this.cases = cases;
    }

    public void addCase(Integer caseId){
        this.cases.add(caseId);
    }

    public void deleteCase(Integer caseId){
        this.cases.remove(caseId);
    }
}
