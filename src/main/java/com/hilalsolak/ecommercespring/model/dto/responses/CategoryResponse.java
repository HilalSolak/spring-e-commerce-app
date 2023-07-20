package com.hilalsolak.ecommercespring.model.dto.responses;

import java.util.List;
import java.util.UUID;

public record CategoryResponse(UUID id, String name, List<CategoryProductResponse> categoryProductResponse) {


}
