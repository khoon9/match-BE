package com.platform.match.domain;

import com.platform.match.domain.constant.ClickType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class ClickEvent extends AuditingFields  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private ClientVisitor clientVisitor; // 방문자 (ID)

    @Setter @Enumerated(EnumType.STRING) ClickType clickType;

    protected ClickEvent() {};

    private ClickEvent(ClientVisitor clientVisitor, ClickType clickType) {
        this.clientVisitor = clientVisitor;
        this.clickType = clickType;
    };

    public static ClickEvent of(ClientVisitor clientVisitor, ClickType clickType){
        return new ClickEvent(clientVisitor, clickType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClickEvent clickEvent)) return false;
        return id != null && id.equals(clickEvent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
