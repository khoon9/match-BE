package com.platform.match.domain;

import com.platform.match.domain.constant.ClickType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

}
