package com.example.jenkinstest.dasibom.domain;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diaryId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petId")
    private Pet pet;

    private String title;
    private String content;

    @OneToMany(mappedBy = "diary", cascade = CascadeType.ALL)
    @Enumerated(EnumType.STRING)
    private List<DiaryStamp> stamps;

//    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDate createdAt;

//    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDate updatedAt;
}
