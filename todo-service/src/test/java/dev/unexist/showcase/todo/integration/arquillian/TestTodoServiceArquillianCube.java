/**
 * @package Showcase
 * @file
 * @copyright 2022 Christoph Kappel <christoph@unexist.dev>
 * @version $Id$
 *
 * This program can be distributed under the terms of the Apache License v2.0.
 * See the file LICENSE for details.
 **/

package dev.unexist.showcase.todo.integration.arquillian;

import org.arquillian.cube.containerobject.Cube;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ArquillianExtension.class)
public class TestTodoServiceArquillianCube {

    @Cube
    IdServiceContainer idServiceContainer;

    @Test
    @RunAsClient
    public void shouldGetNewId() {
        given()
        .when().get("/id")
        .then()
            .statusCode(200);

        assertThat(this.idServiceContainer).isNotNull();
    }
}