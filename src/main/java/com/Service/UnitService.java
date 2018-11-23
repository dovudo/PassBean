package com.Service;

import com.Model.Unit;
import com.dao.RepositoryInterface;
import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class UnitService {

    @Autowired
    RepositoryInterface repository;
    @Autowired
    private MailService ms;


    public String getIt(String data_json) {

        Unit unit = new Unit();
        JsonObject json = new Gson().fromJson(data_json, JsonObject.class);
        String token;
        String email;

        if (!json.isJsonNull()) {

            if (json.has("email")) {
                email = json.get("email").getAsString();
                token = new TokenService().gen_token();
                unit.setToken(token);
                unit.setEmail(email);
                unit.setTimestamp(TimeService.get_timestamp_long());
                ms.send_mail(email, token);
                repository.save(unit);
                return HttpStatus.CREATED.toString();
            }

            if (json.has("token")) {
                token = json.get("token").getAsString();
                try {
                    unit = repository.findByToken(token);
                    return new Gson().toJson(unit, Unit.class);
                } catch (EntityNotFoundException e) {
                    return HttpStatus.NOT_FOUND.toString();
                } catch (IllegalArgumentException e) {
                    return HttpStatus.BAD_REQUEST.toString();
                }
            }
        }
        return HttpStatus.I_AM_A_TEAPOT.toString();
    }
}
