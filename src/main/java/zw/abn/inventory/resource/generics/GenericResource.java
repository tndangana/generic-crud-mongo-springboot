package zw.abn.inventory.resource.generics;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zw.abn.inventory.model.BaseID;
import zw.abn.inventory.service.generics.GenericsServiceClass;

import java.util.List;
import java.util.Optional;


public class GenericResource<T extends BaseID> {

    GenericsServiceClass<T,String> service;

    public GenericResource(GenericsServiceClass<T, String> service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<T> create (@Validated @RequestBody Optional<T> t){
      try {
           T t1 = service.save(t.get());
           return new ResponseEntity<>(t1, HttpStatus.CREATED);
      } catch (Exception e){
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping("/")
    public ResponseEntity<List<T>> getList(){
        try{
          Optional<List<T>> list = service.getList();
            if(list.isPresent()){
                return new ResponseEntity<>(list.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<T> getOne(@PathVariable("id") String id){
        try{
            Optional<T> t = service.getOne(id);
            if(t.isPresent()){
                return new ResponseEntity<>(t.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@RequestBody T t){
        try {
             service.delete(t);
             return new ResponseEntity<T>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T t,@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(service.update(t,id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
