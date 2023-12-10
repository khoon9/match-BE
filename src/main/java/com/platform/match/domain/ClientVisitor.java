package com.platform.match.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "visitCount"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "modifiedAt")
})
@Entity
public class ClientVisitor extends AuditingFields  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Setter @Column(nullable = false) private String uuid;
    @Setter int visitCount;

    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "clientVisitor", cascade = CascadeType.ALL)
    private final Set<ClickEvent> clickEvents = new LinkedHashSet<>();

    protected ClientVisitor() {};

    private ClientVisitor(String uuid, int visitCount){
        this.uuid = uuid;
        this.visitCount = visitCount;
    };

    public static ClientVisitor of(String uuid, int visitCount){
        return new ClientVisitor(uuid, visitCount);
    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientVisitor clientVisitor)) return false;
        return id != null && id.equals(clientVisitor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
