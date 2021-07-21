package zw.abn.inventory.resource.generics;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zw.abn.inventory.model.BaseID;
import zw.abn.inventory.service.generics.GenericsServiceClass;

import java.util.List;
import java.util.Optional;

//T = entity
//K = primary id
public class GenericResource<T extends BaseID,K> {

    GenericsServiceClass<T,K> service;

    public GenericResource(GenericsServiceClass<T,K> service) {
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
    public ResponseEntity<T> getOne(@PathVariable("id") K id){
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
    public ResponseEntity<T> delete(@PathVariable("id") K id){
        try {
            Optional<T> optionalT = Optional.of(service.getOne(id).get());
             optionalT.ifPresent(t1 -> service.delete(t1));
             return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T t,@PathVariable("id") K id){
        try {
            return new ResponseEntity<>(service.update(t,id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
