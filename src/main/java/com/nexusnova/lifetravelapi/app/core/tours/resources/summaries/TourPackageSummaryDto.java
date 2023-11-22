package com.nexusnova.lifetravelapi.app.core.tours.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Schema(description="Tour Packages (Summary)")
@Getter
@Setter
public class TourPackageSummaryDto {
    @Schema(description="Id del Paquete")
    private String id;
    @Schema(description="Titulo del Paquete")
    private String title;
    @Schema(description="Departamento del Paquete")
    private String destiny;
    @Schema(description="Descripcion del Paquete")
    private String description;
    @Schema(description="Precio del Paquete")
    private BigDecimal price;
    @Schema(description="Rating del Paquete")
    private Float rating;
    @Schema(description="Url de la imagen")
    private String imgUrl;
    @Schema(description="Visible")
    private Boolean visible;
}
