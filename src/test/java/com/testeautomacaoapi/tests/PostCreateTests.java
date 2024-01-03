package com.testeautomacaoapi.tests;

import com.testeautomacaoapi.bases.TestBase;
import com.testeautomacaoapi.jsonObjects.UserObject;
import com.testeautomacaoapi.requests.PostCreateRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateTests extends TestBase {
    @Test
    public void criarUsuarioComSucesso(){
        //region Arrange
        String name = "Teste";
        String job = "QA";

        int statusCodeEsperado = HttpStatus.SC_CREATED;
        //endregion

        //region Act
        UserObject userObject = new UserObject(name, job);

        PostCreateRequest postCreateRequest = new PostCreateRequest();
        postCreateRequest.setJsonBody(userObject);

        ValidatableResponse response = postCreateRequest.executeRequest();
        //endregion

        //region Assert
        response.statusCode(statusCodeEsperado);
        response.body("name", equalTo(name),
                 "job", equalTo(job));
        //endregion
    }

    //Foi realizado um cenário de teste alternativo onde está sendo passado um valor em branco dentro de um parâmetro importante e a api está criando o usuário normalmente. Geralmente isto não é permitido.
    @Test
    public void criarUsuarioNameEmBranco(){
        //region Arrange
        String name = "";
        String job = "QA";

        int statusCodeEsperado = HttpStatus.SC_CREATED;
        //endregion

        //region Act
        UserObject userObject = new UserObject(name, job);

        PostCreateRequest postCreateRequest = new PostCreateRequest();
        postCreateRequest.setJsonBody(userObject);

        ValidatableResponse response = postCreateRequest.executeRequest();
        //endregion

        //region Assert
        response.statusCode(statusCodeEsperado);
        //endregion
    }

    //Foi realizado um cenário de teste alternativo onde está sendo passado um valor nulo dentro de um parâmetro importante e a api está criando o usuário normalmente. Geralmente isto não é permitido.
    @Test
    public void criarUsuarioJobValorNulo(){
        //region Arrange
        String name = "Teste";
        String job = null;

        int statusCodeEsperado = HttpStatus.SC_CREATED;
        //endregion

        //region Act
        UserObject userObject = new UserObject(name, job);

        PostCreateRequest postCreateRequest = new PostCreateRequest();
        postCreateRequest.setJsonBody(userObject);

        ValidatableResponse response = postCreateRequest.executeRequest();
        //endregion

        //region Assert
        response.statusCode(statusCodeEsperado);
        //endregion
    }
}
