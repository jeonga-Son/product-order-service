package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
 1. productService에 addProduct라는 요청을 보낸다.
 2. productService에서 product를 생성한다.
 3. productPort에게 저장을 하라고 요청한다.
 4. productPort의 구현체인 adapter에서 이 정보를 메모리로 저장한다.
*/

class ProductApiTest extends ApiTest {

    @Test
    void 상품등록() {
        final var request = ProductSteps.상품등록요청_생성();

        // API 요청
        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
