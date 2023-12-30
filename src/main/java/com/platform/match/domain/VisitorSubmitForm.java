package com.platform.match.domain;

import com.platform.match.domain.constant.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(
        indexes = {
                @Index(columnList = "createdAt"),
                @Index(columnList = "modifiedAt")
        }
)
@Entity
public class VisitorSubmitForm extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Enumerated(EnumType.STRING) private Gender gender;

    @Setter private String age;

    @Setter @Column(nullable = false) private String email;

    @Setter private String firstContent;

    @Setter private String secondContent;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitorSubmitForm visitorSubmitForm)) return false;
        return id != null && id.equals(visitorSubmitForm.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    protected VisitorSubmitForm() {};
    private VisitorSubmitForm(Gender gender, String age, String email, String firstContent, String secondContent) {
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.firstContent = firstContent;
        this.secondContent = secondContent;
    }

    public static VisitorSubmitForm of(Gender gender, String age, String email, String firstContent, String secondContent){
        return new VisitorSubmitForm(gender, age, email, firstContent, secondContent);
    }

}
