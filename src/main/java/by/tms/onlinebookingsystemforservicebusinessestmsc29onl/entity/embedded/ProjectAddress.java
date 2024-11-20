package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAddress {

    private String city;
    private String country;
    private String streetAddress;
    private String houseNumber;
    private String postalCode;

}
