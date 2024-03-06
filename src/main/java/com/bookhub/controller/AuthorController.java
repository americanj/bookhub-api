package com.bookhub.controller;

import com.bookhub.domain.mapper.AuthorMapper;
import com.bookhub.domain.model.AuthorModel;
import com.bookhub.domain.request.AuthorRequest;
import com.bookhub.domain.response.AuthorResponse;
import com.bookhub.domain.vo.AuthorVo;
import com.bookhub.repository.AuthorRepository;
import com.bookhub.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> getAuthors() {
        List<AuthorVo> authorVos = authorService.getAuthors();
        return authorMapper.vosToResponses(authorVos);

    }

    @GetMapping("/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse getAuthor(@PathVariable Long authorId) {
        AuthorVo authorVo = authorService.getAuthor(authorId);
        return authorMapper.voToResponse(authorVo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponse createAuthor(@RequestBody AuthorRequest authorRequest) {
        AuthorVo authorVo = authorMapper.requestToVo(authorRequest);
        AuthorModel authorModel = authorService.createAuthor(authorVo);
        return authorMapper.modelToResponse(authorModel);
    }

    @PutMapping("/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse updateAuthor(@PathVariable Long authorId, @RequestBody AuthorRequest authorRequest) {
        //authorRepository.findByIdOrThrowException(authorId);
        AuthorVo authorVo = authorMapper.resquestToVo(authorRequest, authorId);
        AuthorModel authorModel = authorService.updateAuthor(authorVo, authorId);
        return authorMapper.modelToResponse(authorModel);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

}