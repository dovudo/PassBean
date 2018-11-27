package com.Service;

import com.Model.Unit;
import com.dao.UnitRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

import static com.Conrollers.ExceptionBrain.STATUS_4;

@Service
public class UnitService {

    @Autowired
    private UnitRepository repository;
    @Autowired
    private MailService ms;
    @Autowired
    TokenService ts;
    private static final Logger log = LoggerFactory.getLogger(UnitService.class);

    /*
    * Check exist email or token in a json object
    * and parse it. If we get email make sending email and
    * adding to database that email with timestamp.
    * If we get token check exist it in the database.
    * all right -> give unit with data as json object
    * not found -> give http status: BAD_REQUEST
    * @see MailService
    * */
    public String ClientAuth(String some_data_json) {

        @Email
        String email;
        Unit unit;
        String token;
        JsonObject json = new Gson().fromJson(some_data_json, JsonObject.class);

        if (!json.isJsonNull()) {

            if (json.has("email")) {
                email = json.get("email").getAsString();
                token = ts.gen_token();
                unit = repository.findByEmail(email);
                if(unit == null) unit = new Unit();
                unit.setToken(token);
                unit.setEmail(email);
                unit.setTimestamp(TimeService.get_timestamp_long());
                ms.send_mail(email, token);
                repository.save(unit);
                return HttpStatus.OK.toString();
            }

            if (json.has("token")) {
                token = json.get("token").getAsString();
                unit = repository.findByToken(token);
                if(unit == null)
                    return STATUS_4;
                unit.setToken(ts.gen_token());
                repository.save(unit);
                return new Gson().toJson(unit,Unit.class);
            }
        }
        return HttpStatus.BAD_REQUEST.toString();
    }

    /*
    * This method get json object
    * parse it, take token, search in data base token
    * if found we save that object
    * @return HttpStatus OK
    * */
    public String save(String unit_json){

        JsonObject json = new Gson().fromJson(unit_json, JsonObject.class);
        String token;
            if (json.has("token")) {
                token = json.get("token").getAsString();
                Unit unit = repository.findByToken(token);
                if(unit == null)
                    return STATUS_4;
                unit.setData(json.get("data").getAsString());
                unit.setTimestamp(TimeService.get_timestamp_long());
                unit.setToken(ts.gen_token());
                repository.save(unit);
                log.info("Saved unit " + unit.toString());
                return new Gson().toJson(unit,Unit.class);
            }
        return STATUS_4;
    }
}
