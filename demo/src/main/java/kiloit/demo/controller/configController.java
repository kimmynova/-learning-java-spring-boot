package kiloit.demo.controller;

import kiloit.demo.base.BaseController;
import kiloit.demo.base.StructureRS;
import kiloit.demo.model.to.ConfigTo;
import kiloit.demo.properties.mailConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1.0.0/config")
@RestController
@RequiredArgsConstructor

public class configController extends BaseController {
    private final mailConfig mailConfig;
    @GetMapping
    public ResponseEntity<StructureRS> getConfig(){
        return response(new ConfigTo(this.mailConfig));

    }
    @PostMapping
    public  ResponseEntity<ConfigTo> addConfig(@RequestBody ConfigTo configTo){
//        return ResponseEntity.ok(configTo)
        return null;
    }
}
