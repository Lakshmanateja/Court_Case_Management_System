package com.example.courtcasemanagementsystem.service;

import com.example.courtcasemanagementsystem.model.CourtDetails;
import com.example.courtcasemanagementsystem.repo.CourtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class CourtServiceImpl implements CourtService{

    @Autowired
    private CourtRepo courtRepo;

    /**
     * createCourtDetails method adds the court details by passing the court details object
     *
     * @param courtDetails this object contains all the details
     * @return courtDetails object after creating
     * @throws InstanceAlreadyExistsException if court is already exists
     * @author Lakshmana Teja Kapuganti
     */
    public CourtDetails createCourtDetails(CourtDetails courtDetails) throws InstanceAlreadyExistsException {
        if(getCourtById(courtDetails.getCourtId())!=null){
            throw new InstanceAlreadyExistsException("Court details already exists");
        }
        try{
            sendingMailForNewCourt(courtDetails.getCourtId());
            return courtRepo.save(courtDetails);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Court details input data is incorrect.");
        }
    }

    /**
     * getCourtById method retrieves the court details for a particular courtId
     *
     * @param courtId the id of a particular court
     * @return the court details object
     * @author Lakshmana Teja Kapuganti
     */
    public CourtDetails getCourtById(int courtId){
        return courtRepo.findById(courtId).orElse(null);
    }

    /**
     * getAllCourtDetails method retrieves all the court details in the database
     *
     * @return list of all court details objects
     * @author Lakshmana Teja Kapuganti
     */
    public List<CourtDetails> getAllCourtDetails(){
        return courtRepo.findAll();
    }

    /**
     * updateCourtDetails method updates the court details by passing the court details object
     *
     * @param courtDetails this object contains all the details
     * @return courtDetails object after updating
     * @throws IllegalArgumentException if court is not found
     * @author Lakshmana Teja Kapuganti
     */
    public CourtDetails updateCourtDetails(CourtDetails courtDetails) throws IllegalArgumentException{
        try{
            return courtRepo.save(courtDetails);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Court details input data is incorrect.");
        }
    }

    /**
     * deleteCourtDetails method deletes the court details by passing the courtId
     *
     * @param courtId id of court which needed to be deleted
     * @throws NoSuchElementException if court is not found
     * @author Lakshmana Teja Kapuganti
     */
    public void deleteCourtDetails(int courtId) throws NoSuchElementException {
        try{
            courtRepo.deleteById(courtId);
        }
        catch(Exception e){
            throw new NoSuchElementException("Court details not found");
        }
    }

    /**
     * updateCaseIdInCourtDetails method updates the caseId in the particular court details object in the database
     *
     * @param caseId,courtId the id of the case which needed to be changed in the court details object
     * @throws NoSuchElementException if court is not found
     * @author Lakshmana Teja Kapuganti
     */
    public void updateCaseIdInCourtDetails(int caseId, int courtId) throws NoSuchElementException{
        CourtDetails courtDetails = getCourtById(courtId);
        if(!courtDetails.getCases().contains(caseId)){
            courtDetails.addCase(caseId);
        }
        courtRepo.save(courtDetails);
    }

    /**
     * deleteCaseIdInCourtDetails method deletes the caseId in the particular court details object in the database
     *
     * @param caseId,courtId the id of the case which needed to be deleted in the court details object
     * @throws NoSuchElementException if court is not found
     * @author Lakshmana Teja Kapuganti
     */
    public void deleteCaseIdInCourtDetails(int caseId, int courtId) throws NoSuchElementException{
        CourtDetails courtDetails = getCourtById(courtId);
        if(courtDetails.getCases().contains(caseId)){
            courtDetails.deleteCase(caseId);
        }
        courtRepo.save(courtDetails);
    }

    /**
     * sendingMailForNewCourt method sends an email to the admin from the system whenever a court is added
     * The password here is not original password, it is 16 character code security key generated by google account
     *
     * @param courtId the id of the court which is added
     * @author Lakshmana Teja Kapuganti
     */
    public void sendingMailForNewCourt(int courtId) {
        final String username = "courtcasesystem@gmail.com";
        final String password = "nsln lqeu zmnv uawr";


        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS


        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("courtcasesystem@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("admin@gmail.com")
            );
            message.setSubject("New Court added");
            message.setText("New Court " + courtId + " added successfully \n\n Please do not reply. This is system generated email");


            Transport.send(message);
            LOGGER.info("Mail sent successfully after court creation");


        } catch (MessagingException e) {
            LOGGER.error(e.getMessage());
        }
    }
}