package com.Service;

import com.Model.Unit;
import com.dao.UnitRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class UnitService {

    @Autowired
    UnitRepository repository;
    @Autowired
    private MailService ms;
    private static final Logger log = LoggerFactory.getLogger(UnitService.class);

    public String getIt(String some_data_json) {

        Unit unit;
        JsonObject json = new Gson().fromJson(some_data_json, JsonObject.class);
        String token;
        String email;

        if (!json.isJsonNull()) {

            if (json.has("email")) {
                email = json.get("email").getAsString();
                token = new TokenService().gen_token();
                unit = repository.findByEmail(email);
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
    public String save(String unit_json){

        try{
            Unit unit = new Gson().fromJson(unit_json,Unit.class);
            unit.setTimestamp(TimeService.get_timestamp_long());
            repository.save(unit);
        }
        catch (JsonSyntaxException e){
            log.warn("Json got error syntax ", e.getMessage());
            return HttpStatus.BAD_REQUEST.toString();
        }
        return HttpStatus.OK.toString();
    }
}
