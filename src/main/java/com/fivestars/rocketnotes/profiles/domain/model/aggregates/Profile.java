package com.fivestars.rocketnotes.profiles.domain.model.aggregates;

import com.fivestars.rocketnotes.profiles.domain.model.commands.CreateProfileCommand;
import com.fivestars.rocketnotes.profiles.domain.model.valueobjects.EmailAddress;
import com.fivestars.rocketnotes.profiles.domain.model.valueobjects.PersonName;
import com.fivestars.rocketnotes.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    public Profile(String firstName, String lastName, String email) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
       
    }

    public Profile() {}

    public Profile(CreateProfileCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }



}
