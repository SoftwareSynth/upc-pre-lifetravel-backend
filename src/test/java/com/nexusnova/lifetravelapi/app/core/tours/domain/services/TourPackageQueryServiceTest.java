package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.repositories.AgencyRepository;
import com.nexusnova.lifetravelapi.app.core.tours.application.TourPackageQueryServiceImpl;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackageByIdQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByPriceQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByRegionQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TourPackageQueryServiceTest {

    private TourPackageQueryService tourPackageQueryService;
    private TourPackageRepository tourPackageRepository;

    @BeforeEach
    void setUp() {
        tourPackageRepository = mock(TourPackageRepository.class);
        AgencyRepository agencyRepository = mock(AgencyRepository.class);
        tourPackageQueryService = new TourPackageQueryServiceImpl(tourPackageRepository, agencyRepository);
    }

    @Test
    void handle_WhenValidPriceRange_ExpectFilteredTourPackages() {
        // Arrange
        BigDecimal minPrice = new BigDecimal("100.0");
        BigDecimal maxPrice = new BigDecimal("500.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(minPrice, maxPrice);
        TourPackage tourPackage1 = new TourPackage();
        TourPackage tourPackage2 = new TourPackage();
        List<TourPackage> expectedTourPackages = Arrays.asList(tourPackage1, tourPackage2);

        when(tourPackageRepository.findByPriceBetween(minPrice, maxPrice)).thenReturn(expectedTourPackages);

        // Act
        List<TourPackage> result = tourPackageQueryService.handle(query);

        // Assert
        assertEquals(expectedTourPackages, result);
    }

    @Test
    void handle_WhenInvalidPriceRange_ExpectIllegalArgumentException() {
        // Arrange
        BigDecimal minPrice = new BigDecimal("500.0");
        BigDecimal maxPrice = new BigDecimal("200.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(minPrice, maxPrice);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenNullMinPrice_ExpectIllegalArgumentException() {
        // Arrange
        BigDecimal maxPrice = new BigDecimal("500.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(null, maxPrice);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenNullMaxPrice_ExpectIllegalArgumentException() {
        // Arrange
        BigDecimal minPrice = new BigDecimal("100.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(minPrice, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenNullPriceRange_ExpectIllegalArgumentException() {
        // Arrange
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(null, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenValidRegionId_ExpectFilteredTourPackages() {
        // Arrange
        Long regionId = 123L;
        GetTourPackagesByRegionQuery query = new GetTourPackagesByRegionQuery(regionId);
        TourPackage tourPackage1 = new TourPackage();
        TourPackage tourPackage2 = new TourPackage();
        List<TourPackage> expectedTourPackages = Arrays.asList(tourPackage1, tourPackage2);

        when(tourPackageRepository.findByRegionId(regionId)).thenReturn(expectedTourPackages);

        // Act
        List<TourPackage> result = tourPackageQueryService.handle(query);

        // Assert
        assertEquals(expectedTourPackages, result);
    }

    @Test
    void handle_WhenNullRegionId_ExpectEmptyList() {
        // Arrange
        GetTourPackagesByRegionQuery query = new GetTourPackagesByRegionQuery(null);

        // Act
        List<TourPackage> result = tourPackageQueryService.handle(query);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void handle_WhenNoMatchingTourPackages_ExpectEmptyList() {
        // Arrange
        Long regionId = 456L;
        GetTourPackagesByRegionQuery query = new GetTourPackagesByRegionQuery(regionId);

        when(tourPackageRepository.findByRegionId(regionId)).thenReturn(List.of());

        // Act
        List<TourPackage> result = tourPackageQueryService.handle(query);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void handle_WhenEmptyTourPackageList_ExpectEmptyList() {
        // Arrange
        Long regionId = 789L;
        GetTourPackagesByRegionQuery query = new GetTourPackagesByRegionQuery(regionId);

        when(tourPackageRepository.findByRegionId(regionId)).thenReturn(Arrays.asList());

        // Act
        List<TourPackage> result = tourPackageQueryService.handle(query);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void handle_WhenWhitespaceRegionId_ExpectEmptyList() {
        // Arrange
        Long regionId = 0L; // Assuming 0 is an invalid regionId
        GetTourPackagesByRegionQuery query = new GetTourPackagesByRegionQuery(regionId);

        // Act
        List<TourPackage> result = tourPackageQueryService.handle(query);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void handle_WhenValidTourPackageId_ExpectTourPackage() {
        // Arrange
        Long tourPackageId = 1L;
        GetTourPackageByIdQuery query = new GetTourPackageByIdQuery(tourPackageId);
        TourPackage expectedTourPackage = new TourPackage(/* provide necessary parameters */);

        when(tourPackageRepository.findById(tourPackageId)).thenReturn(Optional.of(expectedTourPackage));

        // Act
        TourPackage result = tourPackageQueryService.handle(query);

        // Assert
        assertNotNull(result);
        assertEquals(expectedTourPackage, result);
    }

    @Test
    void handle_WhenInvalidTourPackageId_ExpectResourceNotFoundException() {
        // Arrange
        Long tourPackageId = 999L;
        GetTourPackageByIdQuery query = new GetTourPackageByIdQuery(tourPackageId);

        when(tourPackageRepository.findById(tourPackageId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenNullTourPackageId_ExpectResourceNotFoundException() {
        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> tourPackageQueryService.handle(new GetTourPackageByIdQuery(null)));
    }

    @Test
    void handle_WhenNegativeTourPackageId_ExpectResourceNotFoundException() {
        // Arrange
        Long tourPackageId = -1L;
        GetTourPackageByIdQuery query = new GetTourPackageByIdQuery(tourPackageId);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenExceptionThrownByRepository_ExpectRuntimeException() {
        // Arrange
        Long tourPackageId = 1L;
        GetTourPackageByIdQuery query = new GetTourPackageByIdQuery(tourPackageId);

        when(tourPackageRepository.findById(tourPackageId)).thenThrow(new RuntimeException("Repository error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> tourPackageQueryService.handle(query));
    }
}