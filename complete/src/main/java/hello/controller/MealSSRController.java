package hello.controller;

import java.util.concurrent.atomic.AtomicLong;

import hello.model.SampleJsonResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealSSRController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(value = "v1/mealssr", method = RequestMethod.POST)
    public ResponseEntity<String> retrieveMealSSR(@RequestBody(required = true) final String requestParams) {

        //1. parse the requestBody

        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        //
        /*
        try {

            File file = ResourceUtils.getFile("classpath:response1.json");

            if(file != null) {
                InputStream in = new FileInputStream(file);

                JSONParser jsonParser = new JSONParser();
                Object parsedObject = jsonParser.parse(new FileReader(file));

                JSONObject jsonObject = (JSONObject) parsedObject;

                return new ResponseEntity<>(jsonObject.toJSONString(), responseHeaders, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("{ \"error\" : \"File not found-1\" }", responseHeaders, HttpStatus.UNAUTHORIZED);
            }



        } catch (FileNotFoundException e) {
            System.out.println("Exception reading JSON file");
            e.printStackTrace();
            return new ResponseEntity<>("{ \"error\" : \"File not found-2\" }", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<>("{ \"error\" : \"File parse error\" }", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("{ \"error\" : \"File IO exception\" }", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        */
        return new ResponseEntity<>(SampleJsonResponse.response2, responseHeaders, HttpStatus.OK);
    }
}
