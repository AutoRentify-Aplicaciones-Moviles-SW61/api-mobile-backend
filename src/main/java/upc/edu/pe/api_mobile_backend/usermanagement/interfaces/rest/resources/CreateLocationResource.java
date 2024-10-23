﻿package upc.edu.pe.api_mobile_backend.usermanagement.interfaces.rest.resources;

import java.text.DecimalFormat;

public record CreateLocationResource(Long userid, String address, String city, String country, String locationStatus, DecimalFormat latitude, DecimalFormat longitude) {
}
