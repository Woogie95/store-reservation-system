package com.zerobase.storereservationsystem.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zerobase.storereservationsystem.domain.type.ReservationStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private LocalDateTime registered;

    private LocalDateTime updated;

}
