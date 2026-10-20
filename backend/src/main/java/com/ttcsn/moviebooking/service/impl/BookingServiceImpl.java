/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttcsn.moviebooking.service.impl;

import com.ttcsn.moviebooking.dto.request.BookingCreateRequest;
import com.ttcsn.moviebooking.dto.request.BookingUpdateRequest;
import com.ttcsn.moviebooking.dto.response.BookingResponse;
import com.ttcsn.moviebooking.entity.Booking;
import com.ttcsn.moviebooking.entity.BookingDetail;
import com.ttcsn.moviebooking.entity.Showtime;
import com.ttcsn.moviebooking.entity.ShowtimeSeat;
import com.ttcsn.moviebooking.entity.User;
import com.ttcsn.moviebooking.entity.enums.BookingStatus;
import com.ttcsn.moviebooking.entity.enums.SeatStatus;
import com.ttcsn.moviebooking.repository.BookingDetailRepository;
import com.ttcsn.moviebooking.repository.BookingRepository;
import com.ttcsn.moviebooking.repository.ShowtimeRepository;
import com.ttcsn.moviebooking.repository.ShowtimeSeatRepository;
import com.ttcsn.moviebooking.repository.UserRepository;
import com.ttcsn.moviebooking.service.BookingService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author quanghieu
 */
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowtimeRepository showtimeRepository;
    private final ShowtimeSeatRepository showtimeSeatRepository;
    private final BookingDetailRepository bookingDetailRepository;

    @Override
    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponse getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
        return convertToResponse(booking);
    }

    @Override
    public List<BookingResponse> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUser_UserId(userId).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingResponse> getBookingsByShowtimeId(Long showtimeId) {
        return bookingRepository.findByShowtime_ShowtimeId(showtimeId).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BookingResponse createBooking(BookingCreateRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.userId()));

        Showtime showtime = showtimeRepository.findById(request.showtimeId())
                .orElseThrow(() -> new RuntimeException("Showtime not found with id: " + request.showtimeId()));

        List<ShowtimeSeat> seatsToBook = showtimeSeatRepository.findAllById(request.showtimeSeatIds());

        if (seatsToBook.isEmpty() || seatsToBook.size() != request.showtimeSeatIds().size()) {
            throw new RuntimeException("Một hoặc nhiều ghế không tồn tại");
        }

        boolean anySeatAlreadyBooked = seatsToBook.stream()
                .anyMatch(seat -> seat.getStatus() == SeatStatus.BOOKED);
        if (anySeatAlreadyBooked) {
            throw new RuntimeException("Một hoặc nhiều ghế đã được đặt bởi người khác");
        }

        seatsToBook.forEach(seat -> {
            seat.setStatus(SeatStatus.BOOKED);
            seat.setUpdatedAt(OffsetDateTime.now());
        });
        showtimeSeatRepository.saveAll(seatsToBook);

        String generatedBookingCode = "BK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Booking booking = Booking.builder()
                .bookingCode(generatedBookingCode)
                .totalAmount(request.totalAmount())
                .status(BookingStatus.PAID)
                .paymentMethod(request.paymentMethod())
                .bookingTime(OffsetDateTime.now())
                .user(user)
                .showtime(showtime)
                .build();
        Booking savedBooking = bookingRepository.save(booking);

        BigDecimal pricePerSeat = request.totalAmount().divide(BigDecimal.valueOf(seatsToBook.size()), 2, RoundingMode.HALF_UP);
        List<BookingDetail> details = seatsToBook.stream()
                .map(seat -> BookingDetail.builder()
                        .booking(savedBooking)
                        .showtimeSeat(seat)
                        .price(pricePerSeat)
                        .createdAt(OffsetDateTime.now())
                        .build())
                .collect(Collectors.toList());
        bookingDetailRepository.saveAll(details);

        return convertToResponse(savedBooking);
    }

    @Override
    @Transactional
    public BookingResponse updateBooking(Long id, BookingUpdateRequest request) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        if (request.status() != null) {
            booking.setStatus(request.status());
        }

        Booking updatedBooking = bookingRepository.save(booking);
        return convertToResponse(updatedBooking);
    }

    @Override
    @Transactional
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }

    private BookingResponse convertToResponse(Booking booking) {
        return new BookingResponse(
                booking.getBookingId(),
                booking.getUser() != null ? booking.getUser().getUserId() : null,
                booking.getShowtime() != null ? booking.getShowtime().getShowtimeId() : null,
                booking.getBookingCode(),
                booking.getTotalAmount(),
                booking.getStatus(),
                booking.getPaymentMethod(),
                booking.getBookingTime()
        );
    }
}