package de.viadee.api.roundtrip.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.viadee.api.roundtrip.api.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/users")
@Tag(name = "User API", description = "User Management API")
interface UserApi {

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<User> findAll();

  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  User findById(@PathVariable String id);

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  User save(@RequestBody User user);

  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  User update(@PathVariable String id, @RequestBody User user);

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  void delete(@PathVariable String id);
}
